package com;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import test.db.DBConn;

public class CopyOfTxt {

	public static void main(String[] args) {
		CateUpdate("C:\\Users\\Administrator\\Desktop\\地理动物.xls");
	}
	@SuppressWarnings("unchecked")
	public static void CateUpdate(String filepath){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		long index = 92985;
		List<HashMap<String, String>>  list = readRes(filepath,FieldArray);
		for(Object o : list){
			map = (HashMap<String, String>)o;
		
			String Code = map.get("Code");
			HashMap<String,String> getid = dbConn.selectOne("SELECT * FROM res_exhibition_room WHERE ER_Code = '"+Code+"'");
			if(getid!=null){
				String AreaResID = getid.get("ER_ID");
				String ER_Name = getid.get("ER_Name");
			
				HashMap<String,String> getidnum = dbConn.selectOne("SELECT * FROM sys_areadistri WHERE AreaDistri_ResID = "+AreaResID);
				
				if(getidnum==null){
					for(int i = 1;i<=48;i++){
						String Coordi_1 = "",Coordi_2 = "";
						String Distri = map.get("Distri_"+i);
						String Coordi = map.get("Coordi_"+i);
						if(Coordi!=null && !"".equals(Coordi)){
							index++;
							Coordi_1 = Coordi.split("/")[0];
							Coordi_2 = Coordi.split("/")[1];
							
							String sql1 = "INSERT INTO sys_areadistri(AreaDistriID,AreaDistri_ResCode,AreaDistri_ResID,AreaDistri_ResName,AreaDistri_Name,AreaDistri_Longitude,AreaDistri_Latitude) ";
							String sql2 = " VALUES("+index+",'"+Code+"',"+AreaResID+",'"+ER_Name+"','"+Distri+"',"+Coordi_1+","+Coordi_2+")"; 
								
							dbConn.insert(sql1 + sql2);
							System.out.println(Code);
						}else{
							break;
						}
					}
				}
				
			}
		}
	}
	static String[] FieldArray = {
		/*"Code","Name","climate","a","b","c","d","e","f","Distri_1","Coordi_1","Distri_2","Coordi_2","Distri_3","Coordi_3","Distri_4","Coordi_4","Distri_5","Coordi_5"
		,"Distri_6","Coordi_6","Distri_7","Coordi_7","Distri_8","Coordi_8","Distri_9","Coordi_9","Distri_10","Coordi_10","Distri_11","Coordi_11","Distri_12","Coordi_12","Distri_13","Coordi_13"
		,"Distri_14","Coordi_14","Distri_15","Coordi_15","Distri_16","Coordi_16","Distri_17","Coordi_17","Distri_18","Coordi_18","Distri_19","Coordi_19","Distri_20","Coordi_20","Distri_21","Coordi_21","Distri_22","Coordi_22"
		,"Distri_23","Coordi_23","Distri_24","Coordi_24","Distri_25","Coordi_25","Distri_26","Coordi_26","Distri_27","Coordi_27","Distri_28","Coordi_28","Distri_29","Coordi_29"
		,"Distri_30","Coordi_30","Distri_31","Coordi_31","Distri_32","Coordi_32","Distri_33","Coordi_33","Distri_34","Coordi_34","Distri_35","Coordi_35","Distri_36","Coordi_36"
		,"Distri_37","Coordi_37","Distri_38","Coordi_38","Distri_39","Coordi_39","Distri_40","Coordi_40","Distri_41","Coordi_41","Distri_42","Coordi_42","Distri_43","Coordi_43","Distri_44","Coordi_44","Distri_45","Coordi_45","Distri_46","Coordi_46"
		,"Distri_47","Coordi_47","Distri_48","Coordi_48","Distri_49","Coordi_49"*/
		"Code","shuziName","Name","Distri_1","Coordi_1","Distri_2","Coordi_2","Distri_3","Coordi_3"
	} ;

	public static List<HashMap<String, String>> readRes(String xslFile, String[] fieldArray) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>() ;
		jxl.Workbook rwb = null;
		try{
			//构建Workbook对象, 只读Workbook对象
			//直接从本地文件创建Workbook
			//从输入流创建Workbook
			InputStream is = new FileInputStream(xslFile);
			rwb = Workbook.getWorkbook(is);
			// 获取第一张Sheet表
			Sheet rs = rwb.getSheet(1);
			// 获取Sheet表中所包含的总列数
			int rsColumns = rs.getColumns();
			System.out.println(rsColumns);
			if(rsColumns != fieldArray.length) {
				System.out.println("Excel中与参数中对应的字段不一致！");
				return list	 ;
			}
			// 获取Sheet表中所包含的总行数
			int rsRows = rs.getRows();
			// 获取指定单元格的对象引用
			for (int i = 1; i < rsRows; i++) {
				HashMap<String, String> map	= new HashMap<String, String>() ;
				for (int j = 0; j < rsColumns; j++) {
					Cell cell = rs.getCell(j, i);
					//System.out.println(cell.getContents());
					map.put(fieldArray[j], cell.getContents()) ;
				}
				list.add(map) ;				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}