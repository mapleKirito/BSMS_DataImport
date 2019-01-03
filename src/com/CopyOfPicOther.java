package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class CopyOfPicOther {
	static Map<String,String> map = new HashMap<String, String>();
	static long maxcateidlong=0l;
	static String p = "";
	
	public static void main(String[] args) {
		handleByFolder();
	}
	
	@SuppressWarnings("unchecked")
	public static void handleByExcel(){
		Map<String,String> map = new HashMap<String, String>();
		List<HashMap<String, String>>  list = readRes("C:\\Users\\Administrator\\Desktop\\地理动物.xls",FieldArray);
		for(Object o : list){
			map = (HashMap<String, String>)o;
			String c = map.get("name");
			p += " or ER_Name = '" + c + "'";
		}
		System.out.println(p.replaceFirst("or", "")); 
	}
	
	public static void handleByFolder(){
		File file = new File("C:/Users/Administrator/Desktop/更新的/地理馆/音频");
		try {
			System.out.println(fileTest(file));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static String fileTest(File file) throws IOException {
		File[] files = file.listFiles(); 
		for (File f : files) {
			if (f.isDirectory()) {
				fileTest(f); 
			} else {
				String pathfile = f.getAbsolutePath();
				String refilename = pathfile.substring(pathfile.lastIndexOf("."));
				if(!refilename.equalsIgnoreCase(".db")){	
					
					String c = pathfile.substring(pathfile.lastIndexOf("\\")+1,pathfile.lastIndexOf("."));
					System.out.println(c);
					p += " or ER_Code = '" + c + "'";
				}
			}			
		}
		return p.replaceFirst("or", "");
	}
	
	static String[] FieldArray = { "Code","shuziname","name"} ;

	public static List<HashMap<String, String>> readRes(String xslFile, String[] fieldArray) {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>() ;
		jxl.Workbook rwb = null;
		try{
			InputStream is = new FileInputStream(xslFile);
			rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(1);
			int rsColumns = rs.getColumns();
			if(rsColumns != fieldArray.length) {
				System.out.println("Excel中与参数中对应的字段不一致！");
				return list	 ;
			}
			int rsRows = rs.getRows();
			for (int i = 1; i < rsRows; i++) {
				HashMap<String, String> map	= new HashMap<String, String>() ;
				for (int j = 0; j < rsColumns; j++) {
					Cell cell = rs.getCell(j, i);
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