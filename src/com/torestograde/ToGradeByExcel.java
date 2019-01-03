package com.torestograde;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import test.db.DBConn;

public class ToGradeByExcel {
	public static void main(String[] args) {
		handExhibition("C:/Users/Administrator/Desktop/地理交互系统名目/陈列室.xls");
		handObservation("C:/Users/Administrator/Desktop/地理交互系统名目/观察室.xls");
		handLaboratory("C:/Users/Administrator/Desktop/地理交互系统名目/实验室.xls");
		handProjection("C:/Users/Administrator/Desktop/地理交互系统名目/放映室.xls");
		handExpand("C:/Users/Administrator/Desktop/地理交互系统名目/拓展室.xls");
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void handExpand(String filepath){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String grade = "",name = "",thum = "",inthum = "",upload = "",type = "",code = "",fileSwfPath = "",fileSwf = "";
		String roomtype = "expand";
		long index = Long.parseLong(dbConn.selectOne("SELECT MAX(GR_ID) FROM res_grade_relationship").get("MAX(GR_ID)")),erID = 0l;
		List<HashMap<String, String>>  list = readRes(filepath,expandFieldArray);
		for(Object o : list){
			map = (HashMap<String, String>)o;
			code = (String)map.get("code");
			grade = (String)map.get("grade1");
			
			if(map.get("grade2")!=null && !map.get("grade2").equals("")){
				grade += ","+(String)map.get("grade2"); 
			}
			
			HashMap m = dbConn.selectOne("select * from res_"+roomtype+"_room where "+reResAbbreviated(roomtype)+"_"+reResCodeName(roomtype)+" = '"+code+"'");
			if(m!=null){
				erID = Long.parseLong((String)m.get(reResAbbreviated(roomtype)+"_ID"));
				name = (String)m.get(reResAbbreviated(roomtype)+"_Name");
				thum = (String)m.get(reResAbbreviated(roomtype)+"_Thumbnail");
				inthum = (String)m.get(reResAbbreviated(roomtype)+"_InThum") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_InThum");
				upload = (String)m.get(reResAbbreviated(roomtype)+"_Upload");
				type = (String)m.get(reResAbbreviated(roomtype)+"_Type");
				
				fileSwf = (String)m.get(reResAbbreviated(roomtype)+"_FileSwf") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_FileSwf");
				fileSwfPath = (String)m.get(reResAbbreviated(roomtype)+"_FileSwfPath") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_FileSwfPath");
				
				String grades[] = grade.split(",");
				for(Object g : grades){
					index++;
					if(!((String)g).equals("")){
						g = reGradeByChina((String)g);
						long g1 = Long.parseLong(((String)g).trim());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String sdfdate = sdf.format(new Date());
						
						String sql1 = "insert into res_grade_relationship(GR_ID,GR_Grade,GR_ResourceType,GR_ResourceID,GR_Name,GR_Thumbnail,GR_InThum,GR_Upload,GR_Type,GR_UserID,GR_UserAccount,GR_OperateTime,GR_CreateTime,GR_Creator,GR_FileSwfPath,GR_FileSwf)";
						String sql2 = " values("+index+",'"+g1+"','"+roomtype+"',"+erID+",'"+name+"','"+thum+"','"+inthum+"','"+upload+"','"+type+"',4,'admin','"+sdfdate+"','"+sdfdate+"','admin','"+fileSwfPath+"','"+fileSwf+"')";
						
						System.out.println(sql1 + sql2);
						dbConn.insert(sql1 + sql2);
					}
				}
			}
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void handProjection(String filepath){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String grade = "",name = "",thum = "",inthum = "",upload = "",type = "",code = "",fileSwfPath = "",fileSwf = "";
		String roomtype = "projection";
		long index = Long.parseLong(dbConn.selectOne("SELECT MAX(GR_ID) FROM res_grade_relationship").get("MAX(GR_ID)")),erID = 0l;
		List<HashMap<String, String>>  list = readRes(filepath,projectionFieldArray);
		for(Object o : list){
			map = (HashMap<String, String>)o;
			code = (String)map.get("code");
			grade = (String)map.get("grade1");
			
			if(map.get("grade2")!=null && !map.get("grade2").equals("")){
				grade += ","+(String)map.get("grade2"); 
			}
			
			HashMap m = dbConn.selectOne("select * from res_"+roomtype+"_room where "+reResAbbreviated(roomtype)+"_"+reResCodeName(roomtype)+" = '"+code+"'");
			if(m!=null){
				erID = Long.parseLong((String)m.get(reResAbbreviated(roomtype)+"_ID"));
				name = (String)m.get(reResAbbreviated(roomtype)+"_Name");
				thum = (String)m.get(reResAbbreviated(roomtype)+"_Thumbnail");
				inthum = (String)m.get(reResAbbreviated(roomtype)+"_InThum") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_InThum");
				upload = (String)m.get(reResAbbreviated(roomtype)+"_Upload");
				type = (String)m.get(reResAbbreviated(roomtype)+"_Type");
				
				fileSwf = (String)m.get(reResAbbreviated(roomtype)+"_FileSwf") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_FileSwf");
				fileSwfPath = (String)m.get(reResAbbreviated(roomtype)+"_FileSwfPath") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_FileSwfPath");
				
				String grades[] = grade.split(",");
				for(Object g : grades){
					index++;
					if(!((String)g).equals("")){
						g = reGradeByChina((String)g);
						long g1 = Long.parseLong(((String)g).trim());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String sdfdate = sdf.format(new Date());
						
						String sql1 = "insert into res_grade_relationship(GR_ID,GR_Grade,GR_ResourceType,GR_ResourceID,GR_Name,GR_Thumbnail,GR_InThum,GR_Upload,GR_Type,GR_UserID,GR_UserAccount,GR_OperateTime,GR_CreateTime,GR_Creator,GR_FileSwfPath,GR_FileSwf)";
						String sql2 = " values("+index+",'"+g1+"','"+roomtype+"',"+erID+",'"+name+"','"+thum+"','"+inthum+"','"+upload+"','"+type+"',4,'admin','"+sdfdate+"','"+sdfdate+"','admin','"+fileSwfPath+"','"+fileSwf+"')";
						
						System.out.println(sql1 + sql2);
						dbConn.insert(sql1 + sql2);
					}
				}
			}
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void handLaboratory(String filepath){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String grade = "",name = "",thum = "",inthum = "",upload = "",type = "",code = "",fileSwfPath = "",fileSwf = "";
		String roomtype = "laboratory";
		long index = Long.parseLong(dbConn.selectOne("SELECT MAX(GR_ID) FROM res_grade_relationship").get("MAX(GR_ID)")),erID = 0l;
		List<HashMap<String, String>>  list = readRes(filepath,laboratoryFieldArray);
		for(Object o : list){
			map = (HashMap<String, String>)o;
			code = (String)map.get("code");
			grade = (String)map.get("grade1");
			
			if(map.get("grade2")!=null && !map.get("grade2").equals("")){
				grade += ","+(String)map.get("grade2"); 
			}
			
			HashMap m = dbConn.selectOne("select * from res_"+roomtype+"_room where "+reResAbbreviated(roomtype)+"_"+reResCodeName(roomtype)+" = '"+code+"'");
			if(m!=null){
				erID = Long.parseLong((String)m.get(reResAbbreviated(roomtype)+"_ID"));
				name = (String)m.get(reResAbbreviated(roomtype)+"_Name");
				thum = (String)m.get(reResAbbreviated(roomtype)+"_Thumbnail");
				inthum = (String)m.get(reResAbbreviated(roomtype)+"_InThum") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_InThum");
				upload = (String)m.get(reResAbbreviated(roomtype)+"_Upload");
				type = (String)m.get(reResAbbreviated(roomtype)+"_Type");
				
				fileSwf = (String)m.get(reResAbbreviated(roomtype)+"_FileSwf") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_FileSwf");
				fileSwfPath = (String)m.get(reResAbbreviated(roomtype)+"_FileSwfPath") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_FileSwfPath");
				
				String grades[] = grade.split(",");
				for(Object g : grades){
					index++;
					if(!((String)g).equals("")){
						g = reGradeByChina((String)g);
						long g1 = Long.parseLong(((String)g).trim());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String sdfdate = sdf.format(new Date());
						
						String sql1 = "insert into res_grade_relationship(GR_ID,GR_Grade,GR_ResourceType,GR_ResourceID,GR_Name,GR_Thumbnail,GR_InThum,GR_Upload,GR_Type,GR_UserID,GR_UserAccount,GR_OperateTime,GR_CreateTime,GR_Creator,GR_FileSwfPath,GR_FileSwf)";
						String sql2 = " values("+index+",'"+g1+"','"+roomtype+"',"+erID+",'"+name+"','"+thum+"','"+inthum+"','"+upload+"','"+type+"',4,'admin','"+sdfdate+"','"+sdfdate+"','admin','"+fileSwfPath+"','"+fileSwf+"')";
						
						System.out.println(sql1 + sql2);
						dbConn.insert(sql1 + sql2);
					}
				}
			}
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void handObservation(String filepath){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String grade = "",name = "",thum = "",inthum = "",upload = "",type = "",code = "",fileSwfPath = "",fileSwf = "";
		String roomtype = "observation";
		long index = Long.parseLong(dbConn.selectOne("SELECT MAX(GR_ID) FROM res_grade_relationship").get("MAX(GR_ID)")),erID = 0l;
		List<HashMap<String, String>>  list = readRes(filepath,observationFieldArray);
		for(Object o : list){
			map = (HashMap<String, String>)o;
			code = (String)map.get("code");
			grade = (String)map.get("grade1");
			
			if(map.get("grade2")!=null && !map.get("grade2").equals("")){
				grade += ","+(String)map.get("grade2"); 
			}
			
			HashMap m = dbConn.selectOne("select * from res_"+roomtype+"_room where "+reResAbbreviated(roomtype)+"_"+reResCodeName(roomtype)+" = '"+code+"'");
			if(m!=null){
				erID = Long.parseLong((String)m.get(reResAbbreviated(roomtype)+"_ID"));
				name = (String)m.get(reResAbbreviated(roomtype)+"_Name");
				thum = (String)m.get(reResAbbreviated(roomtype)+"_Thumbnail");
				inthum = (String)m.get(reResAbbreviated(roomtype)+"_InThum") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_InThum");
				upload = (String)m.get(reResAbbreviated(roomtype)+"_Upload");
				type = (String)m.get(reResAbbreviated(roomtype)+"_Type");
				
				fileSwf = (String)m.get(reResAbbreviated(roomtype)+"_FileSwf") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_FileSwf");
				fileSwfPath = (String)m.get(reResAbbreviated(roomtype)+"_FileSwfPath") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_FileSwfPath");
				
				String grades[] = grade.split(",");
				for(Object g : grades){
					index++;
					if(!((String)g).equals("")){
						g = reGradeByChina((String)g);
						long g1 = Long.parseLong(((String)g).trim());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String sdfdate = sdf.format(new Date());
						
						String sql1 = "insert into res_grade_relationship(GR_ID,GR_Grade,GR_ResourceType,GR_ResourceID,GR_Name,GR_Thumbnail,GR_InThum,GR_Upload,GR_Type,GR_UserID,GR_UserAccount,GR_OperateTime,GR_CreateTime,GR_Creator,GR_FileSwfPath,GR_FileSwf)";
						String sql2 = " values("+index+",'"+g1+"','"+roomtype+"',"+erID+",'"+name+"','"+thum+"','"+inthum+"','"+upload+"','"+type+"',4,'admin','"+sdfdate+"','"+sdfdate+"','admin','"+fileSwfPath+"','"+fileSwf+"')";
						
						System.out.println(sql1 + sql2);
						dbConn.insert(sql1 + sql2);
					}
				}
			}
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void handExhibition(String filepath){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String grade = "",name = "",audio = "",thum = "",inthum = "",upload = "",type = "",code = "";
		String roomtype = "exhibition";
		long index = 0l,erID = 0l;
		List<HashMap<String, String>>  list = readRes(filepath,exhibitionFieldArray);
		for(Object o : list){
			map = (HashMap<String, String>)o;
			code = (String)map.get("code").trim();
			grade = (String)map.get("grade1");
			
			if(map.get("grade2")!=null && !map.get("grade2").equals("")){
				grade += ","+(String)map.get("grade2"); 
			}
			
			HashMap m = dbConn.selectOne("select * from res_"+roomtype+"_room where "+reResAbbreviated(roomtype)+"_"+reResCodeName(roomtype)+" = '"+code+"'");
			
			if(m!=null){
				erID = Long.parseLong((String)m.get(reResAbbreviated(roomtype)+"_ID"));
				name = (String)m.get(reResAbbreviated(roomtype)+"_Name");
				audio = (String)m.get(reResAbbreviated(roomtype)+"_Audio") == null ? "" : (String)m.get(reResAbbreviated(roomtype)+"_Audio");
				thum = (String)m.get(reResAbbreviated(roomtype)+"_Thumbnail");
				inthum = (String)m.get(reResAbbreviated(roomtype)+"_InThum");
				upload = (String)m.get(reResAbbreviated(roomtype)+"_Upload");
				type = (String)m.get(reResAbbreviated(roomtype)+"_Type");
				
				String grades[] = grade.split(",");
				for(Object g : grades){
					index++;
					if(!((String)g).equals("")){
						g = reGradeByChina((String)g);
						long g1 = Long.parseLong(((String)g).trim());
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String sdfdate = sdf.format(new Date());
						
						String sql1 = "insert into res_grade_relationship(GR_ID,GR_Grade,GR_ResourceType,GR_ResourceID,GR_Name,GR_Thumbnail,GR_InThum,GR_Upload,GR_Type,GR_UserID,GR_UserAccount,GR_OperateTime,GR_CreateTime,GR_Creator,GR_Audio)";
						String sql2 = " values("+index+",'"+g1+"','"+roomtype+"',"+erID+",'"+name+"','"+thum+"','"+inthum+"','"+upload+"','"+type+"',4,'admin','"+sdfdate+"','"+sdfdate+"','admin','"+audio+"')";
						
						System.out.println(sql1 + sql2);
						dbConn.insert(sql1 + sql2);
					}
				}
			}
		}
	}
	
	public static String reResAbbreviated(String resType) {
		if ("exhibition".equals(resType)) {
			return "er".toUpperCase();
		} else if ("observation".equals(resType)) {
			return "or".toUpperCase();
		} else if ("laboratory".equals(resType)) {
			return "lr".toUpperCase();
		} else if ("projection".equals(resType)) {
			return "pr".toUpperCase();
		} else if ("expand".equals(resType)) {
			return "er".toUpperCase();
		}
		return resType.toUpperCase();
    }
	
	public static String reResCodeName(String resType) {
		if ("exhibition".equals(resType)) {
			return "Code";
		} else if ("observation".equals(resType)) {
			return "NO";
		} else if ("laboratory".equals(resType)) {
			return "NO";
		} else if ("projection".equals(resType)) {
			return "No";
		} else if ("expand".equals(resType)) {
			return "No";
		}
		return resType;
    }
	
	public static String reResTypeThum(String resType) {
		if ("exhibition".equals(resType)) {
			return "CLS";
		} else if ("observation".equals(resType)) {
			return "GCS";
		} else if ("laboratory".equals(resType)) {
			return "SYS";
		} else if ("projection".equals(resType)) {
			return "FYS";
		} else if ("expand".equals(resType)) {
			return "TZS";
		}
		return resType;
    }
	
	public static String reGradeByChina(String resType) {
		if ("一年级".equals(resType)) {
			return "301";
		} else if ("二年级".equals(resType)) {
			return "303";
		} else if ("三年级".equals(resType)) {
			return "303";
		} else if ("四年级".equals(resType)) {
			return "304";
		} else if ("五年级".equals(resType)) {
			return "305";
		} else if ("六年级".equals(resType)) {
			return "306";
		} else if ("七年级".equals(resType)) {
			return "311";
		} else if ("八年级".equals(resType)) {
			return "312";
		} else if ("九年级".equals(resType)) {
			return "313";
		} else if ("必修一".equals(resType)) {
			return "321";
		} else if ("必修二".equals(resType)) {
			return "322";
		} else if ("必修三".equals(resType)) {
			return "323";
		} else if ("选修一".equals(resType)) {
			return "331";
		} else if ("选修二".equals(resType)) {
			return "332";
		} else if ("选修三".equals(resType)) {
			return "333";
		} else if ("选修四".equals(resType)) {
			return "334";
		} else if ("选修五".equals(resType)) {
			return "335";
		} else if ("选修六".equals(resType)) {
			return "336";
		} else if ("选修七".equals(resType)) {
			return "337";
		}
		return "";
    }
	
	static String[] exhibitionFieldArray = { "code", "grade1", "grade2" };
	static String[] observationFieldArray = { "code", "grade1" };
	static String[] laboratoryFieldArray = { "code", "grade1", "grade2" };
	static String[] projectionFieldArray = { "code", "grade1", "grade2" };
	static String[] expandFieldArray = { "code", "grade1" };
	
	public static List < HashMap < String, String >> readRes(String xslFile, String[] fieldArray) {
		List < HashMap < String, String >> list = new ArrayList < HashMap < String, String >> ();
		jxl.Workbook rwb = null;
		try {
			InputStream is = new FileInputStream(xslFile);
			rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0);
			int rsColumns = rs.getColumns();
			if (rsColumns != fieldArray.length) {
				System.out.println("Excel\u4E2D\u4E0E\u53C2\u6570\u4E2D\u5BF9\u5E94\u7684\u5B57\u6BB5\u4E0D\u4E00\u81F4\uFF01");
				return list;
			}
			int rsRows = rs.getRows();
			for (int i = 0; i < rsRows; i++) {
				HashMap < String,
				String > map = new HashMap < String, String > ();
				for (int j = 0; j < rsColumns; j++) {
					Cell cell = rs.getCell(j, i);
					map.put(fieldArray[j], cell.getContents());
				}
				list.add(map);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static String getAfter(String nameCol) {
		return nameCol.substring(nameCol.lastIndexOf("/"));
	}
	
}