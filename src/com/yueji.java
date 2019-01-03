package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import test.db.DBConn;

public class yueji {

	public static void main(String[] args) {
		CateUpdateexhi("C:/Users/Administrator/Desktop/20140122完成2.xls");
	}
	@SuppressWarnings("unchecked")
	public static void CateUpdateLab(String filepath){
		//DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		long index = 39l;
		String sindex = "";
		List<HashMap<String, String>>  list = readRes(filepath,FieldArray);
		for(Object o : list){
			
			index++;
			map = (HashMap<String, String>)o;
			
			String Code = map.get("Code");
			String Name = map.get("Name");
			
			String ER_Code = map.get("Code").replace(".WMV", ".WMV");
			String code = "SYS00002"+Code.replace(".WMV", "").replace(".mp4", "");
			
			String upload = "upload/SYS/0/0002/"+ER_Code;
			String thum = "upload/SYS/s_sys/0/0002/"+ER_Code.replace(".WMV", ".JPG");
			String fileswf = upload.replace(".WMV", "_LD.mp4");
			
			try {
				Name = new String(Name.toString().getBytes("gb2312"),"iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
		
			String sql1 = "INSERT INTO res_laboratory_room(`LR_ID`,`LR_NO`,`LR_Name`,`LR_Type`,`LR_Upload`,`LR_FileSwf`,`LR_FileSwfPath`,`LR_Thumbnail`,`LR_InThum`)";
			String sql2 = " values("+index+",'"+code+"','"+Name+"','1084','"+upload+"','"+fileswf+"','images/resImage/file_type_08.jpg','"+thum+"','images/resImage/file_type_08.jpg');";
			
			System.out.println(sql1+sql2);
			sindex+=sql1+sql2+"\r\n";
		}
		try {
			ClassFile(sindex,"D:\\a.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void deleteExhi(String filepath){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		List<HashMap<String, String>>  list = readRes(filepath,FieldArray);
		long index = 0l;
		for(Object o : list){
			map = (HashMap<String, String>)o;
			index++;
			String Code = map.get("Code");
			String orderid = map.get("q3");
			String cateid = map.get("q5");
		
			HashMap ma = dbConn.selectOne("select * from res_exhibition_room where ER_Code = '"+Code+"'");
			String erID = (String)ma.get("ER_ID");
			
			String sql2 = "UPDATE res_exhibition_room a set a.`ER_OrderID` = "+orderid+",a.`ER_Category` = "+cateid+" WHERE a.`ER_ID` = " + erID;
			
			dbConn.update(sql2);
			System.out.println(index);
		}
	}
	@SuppressWarnings("unchecked")
	public static void Audio(String filepath){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		List<HashMap<String, String>>  list = readRes(filepath,FieldArray);
		long index = 0l;
		for(Object o : list){
			map = (HashMap<String, String>)o;
			index++;
			String Code = map.get("Code");
		
			String sql1 = "update res_exhibition_room set ER_Audio = 'upload/CLS/0/0001/"+Code+".mp3' where ER_Code = '"+Code+"'";
			
			HashMap ma = dbConn.selectOne("select * from res_exhibition_room where ER_Code = '"+Code+"'");
			String erID = (String)ma.get("ER_ID");
			
			String sql2 = "UPDATE res_resource SET RR_Audio = 'upload/CLS/0/0001/"+Code+".mp3' WHERE RR_ResourceID = "+erID+" AND RR_ResourceType = 'exhibition';";
			
			dbConn.update(sql1);
			dbConn.update(sql2);
			System.out.println(index);
		}
	}
	@SuppressWarnings("unchecked")
	public static void CateUpdateProjec(String filepath){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		long index = 585;
		String sindex = "";
		List<HashMap<String, String>>  list = readRes(filepath,FieldArray);
		for(Object o : list){
			
			index++;
			map = (HashMap<String, String>)o;
			
			String Code = map.get("Code");
			String Name = map.get("Name");
			String fenlei1 = map.get("q1");
			String fenlei2 = map.get("q2");
			//String fenlei3 = map.get("fenlei3");
			
			String ER_Code = map.get("Code").replace(".mp4", ".mp4");
			String code = "FYS00006"+Code.replace(".mp4", "").replace(".mp4", "").replace(".mp4", "");
			
			String upload = "upload/FYS/0/0006/000/000/"+ER_Code;
			String thum = "upload/FYS/s_cls/0/0006/000/000/"+ER_Code.replace(".mp4", ".JPG").replace(".mp4", ".JPG");
			//String inthum = "upload/FYS/s_Inthum/0/0000/000/000/"+ER_Code;
			String fileswf = upload.replace(".mp4", "_LD.mp4");
			
			try {
				//Name = new String(Name.toString().getBytes("gb2312"),"iso-8859-1");
				fenlei1 = new String(fenlei1.toString().getBytes("gb2312"),"iso-8859-1");
				//fenlei2 = new String(fenlei2.toString().getBytes("gb2312"),"iso-8859-1");
				//fenlei3 = new String(fenlei3.toString().getBytes("gb2312"),"iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
		
			String sql1 = "INSERT INTO `res_projection_room`(`PR_ID`,`PR_No`,`PR_Name`,`PR_Type`,`PR_Upload`,`PR_FileSwf`,`PR_Thumbnail`,`PR_Category_Name`)";
			String sql2 = " values("+index+",'"+code+"','"+Name+"','1084','"+upload+"','"+fileswf+"','"+thum+"','"+fenlei2+"');";
			
			//dbConn.insert(sql2+sql2);
			System.out.println(sql1+sql2);
			sindex+=sql1+sql2+"\r\n";
		}
		try {
			ClassFile(sindex,"D:\\a.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void CateUpdateObservation(String filepath){
		//DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		long index = 117l;
		String sindex = "";
		List<HashMap<String, String>>  list = readRes(filepath,FieldArray);
		for(Object o : list){
			
			index++;
			map = (HashMap<String, String>)o;
			
			String Code = map.get("Code");
			String Name = map.get("Name");
			String fenlei1 = map.get("fenlei1");
			//String fenlei2 = map.get("fenlei2");
			//String fenlei3 = map.get("fenlei3");
			
			String ER_Code = map.get("Code").replace(".zip", ".zip");
			String code = "GCS00002"+Code.replace(".zip", "").replace(".wmv", "").replace(".mp4", "").replace(".JPG", "");
			
			String upload = "upload/GCS/0/0002/000/000/"+ER_Code;
			String thum = "upload/GCS/s_gcs/0/0002/000/000/"+ER_Code.replace(".zip", ".JPG").replace(".mp4", ".JPG");
			//String inthum = "upload/FYS/s_Inthum/0/0000/000/000/"+ER_Code;
			//String fileswf = upload.replace(".mp4", "_LD.mp4").replace(".WMV", "_LD.mp4");
			
			try {
				Name = new String(Name.toString().getBytes("gb2312"),"iso-8859-1");
				fenlei1 = new String(fenlei1.toString().getBytes("gb2312"),"iso-8859-1");
				//fenlei2 = new String(fenlei2.toString().getBytes("gb2312"),"iso-8859-1");
				//fenlei3 = new String(fenlei3.toString().getBytes("gb2312"),"iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
		
			String sql1 = "INSERT INTO res_observation_room(`OR_ID`,`OR_NO`,`OR_Name`,`OR_Type`,`OR_Upload`,`OR_Thumbnail`,`OR_CategoryName`)";
			String sql2 = " values("+index+",'"+code+"','"+Name+"','1084','"+upload+"','"+thum+"','"+fenlei1+"');";
			
			//dbConn.insert(sql2+sql2);
			System.out.println(sql1+sql2);
			sindex+=sql1+sql2+"\r\n";
		}
		try {
			ClassFile(sindex,"D:\\a.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unchecked")
	public static void CateUpdateexpand(String filepath){
		//DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		long index = 100l;
		String sindex = "";
		List<HashMap<String, String>>  list = readRes(filepath,FieldArray);
		for(Object o : list){
			
			index++;
			map = (HashMap<String, String>)o;
			
			String Code = map.get("Code");
			String Name = map.get("Name");
			String fenlei1 = map.get("fenlei1");
			
			String ER_Code = map.get("Code").replace(".WMV", ".WMV");
			String code = "TZS00002"+Code.replace(".WMV", "").replace(".mp4", "");
			
			String upload = "upload/TZS/0/0002/000/000/"+ER_Code;
			String thum = "upload/TZS/s_tzs/0/0002/000/000/"+ER_Code.replace(".WMV", ".JPG");
			String fileswf = upload.replace(".WMV", "_LD.mp4");
			
			try {
				Name = new String(Name.toString().getBytes("gb2312"),"iso-8859-1");
				fenlei1 = new String(fenlei1.toString().getBytes("gb2312"),"iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
		
			String sql1 = "INSERT INTO res_expand_room(`ER_ID`,ER_No,`ER_Name`,`ER_Type`,`ER_Upload`,`ER_FileSwf`,`ER_Thumbnail`,`ER_ResTypeName`)";
			String sql2 = " values("+index+",'"+code+"','"+Name+"','1084','"+upload+"','"+fileswf+"','"+thum+"','"+fenlei1+"');";
			
			System.out.println(sql1+sql2);
			sindex+=sql1+sql2+"\r\n";
		}
		try {
			ClassFile(sindex,"D:\\a.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void CateUpdateexhi(String filepath){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		long index = 1336;
		String sindex = "";
		List<HashMap<String, String>>  list = readRes(filepath,FieldArray);
		for(Object o : list){
			
			index++;
			map = (HashMap<String, String>)o;
			
			String Code = map.get("Code");
			if(!Code.equals("")){
				String Name = map.get("Name");
				String guanjianci = map.get("guanjianci");
				
				String fenlei1 = map.get("q1");
				String fenlei2 = map.get("q2");
				String fenlei3 = map.get("q3");
				String fenlei4 = map.get("q4");
				String fenlei5 = map.get("q5");
				
				String xinagxi = map.get("xinagxi");
				String nianji = map.get("nianji");
				
				String two = map.get("two");
				String thr = map.get("thr");
				String four = map.get("four");
				
				//String ER_Code = map.get("Code").replace(".jpg", ".JPG");
				String code = "CLS02000"+Code.replace(".JPG", "").replace(".jpg", "").replace(".mp4", "");
				
				String upload = map.get("upload") + "/" + Code;
				String thum = upload.replace("upload/BLS","upload/BLS/s_thum");
				String inthum = upload.replace("upload/BLS","upload/BLS/s_inthum");
				
				String fenleiid[] = {fenlei1,fenlei2,fenlei3,fenlei4,fenlei5}; String fenleiid_[] = new String[5];
				for(int i = 0;i<fenleiid.length;i++){
					HashMap selectmap = dbConn.selectOne("SELECT * FROM res_category a WHERE a.`CATE_Name` = '"+fenleiid[i]+"';");
					if(selectmap != null){
						fenleiid_[i] = (String)selectmap.get("CATE_ID");		
					}	
				}
				
				String areaid[] = {two,thr}; String areaid_[] = new String[2];
				for(int i = 0;i<areaid.length;i++){
					HashMap selectmap = dbConn.selectOne("SELECT * FROM sys_area a WHERE a.`AREA_Name` = '"+areaid[i]+"';");
					if(selectmap != null){
						areaid_[i] = (String)selectmap.get("AREA_ID");		
					}	
				}
				
				String njchar = "";
				if(!nianji.equals("")){
					String nj[] = nianji.split("/");
					for(int i = 0;i<nj.length;i++){
						if(nj[i].equals("七年级")){
							njchar += ",311";
						}else if(nj[i].equals("八年级")){
							njchar += ",312";
						}else if(nj[i].equals("必修一")){
							njchar += ",321";
						}else if(nj[i].equals("必修二")){
							njchar += ",322";
						}else if(nj[i].equals("必修三")){
							njchar += ",323";
						}
					}
				}
				njchar = njchar.replaceFirst(",", "");
				
				/*try {
					Name = new String(Name.toString().getBytes("gb2312"),"iso-8859-1");
					fenlei1 = new String(fenlei1.toString().getBytes("gb2312"),"iso-8859-1");
					fenlei2 = new String(fenlei2.toString().getBytes("gb2312"),"iso-8859-1");
					fenlei3 = new String(fenlei3.toString().getBytes("gb2312"),"iso-8859-1");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} */
			
				String sql1 = "INSERT INTO res_exhibition_room(`ER_ID`,`ER_Code`,`ER_Name`,`ER_Keywords`,`ER_Type`,`ER_Upload`,`ER_Thumbnail`,`ER_InThum`,`ER_TotalID`,`ER_Total`,`ER_JieID`,`ER_Jie`,`ER_ChorID`,`ER_Chor`,`ER_GangID`,`ER_Gang`,`ER_OrderID`,`ER_Order`,`ER_Remarks`,`ER_Grade`,`ER_Province`,`ER_City`,`ER_PlaceName`)";
				String sql2 = " values("+index+",'"+code+"','"+Name+"','"+guanjianci+"','1011','"+upload+"','"+thum+"','"+inthum+"',"+fenleiid_[0]+",'"+fenlei1+"',"+fenleiid_[1]+",'"+fenlei2+"',"+fenleiid_[2]+",'"+fenlei3+"',"+fenleiid_[3]+",'"+fenlei4+"',"+fenleiid_[4]+",'"+fenlei5+"','"+xinagxi+"','"+njchar+"','"+areaid_[0]+"','"+areaid_[1]+"','"+four+"');";
				
				dbConn.insert(sql1+sql2);
				
				System.out.println(sql1+sql2);
				sindex+=sql1+sql2+"\r\n";
			}
		}
		try {
			ClassFile(sindex,"D:\\a.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	static String[] FieldArray = {
		"upload","Code","q1","q2","q3","q4","q5","Name","guanjianci","xinagxi","nianji","one","two","thr","four"
	} ;
	public static void ClassFile(String newStr,String path) throws IOException{
		String filein = newStr;
        RandomAccessFile mm = null;
        try {
            mm = new RandomAccessFile(new File(path), "rw");
            mm.writeBytes(filein);
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            if (mm != null) {
                try {
                    mm.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }
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
			Sheet rs = rwb.getSheet(2);
			// 获取Sheet表中所包含的总列数
			int rsColumns = rs.getColumns();
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