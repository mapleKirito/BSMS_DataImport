package com;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import test.db.DBConn;

public class TestModify {
	
	public static void main(String[] args) {
		updatRoomProjec();
	}
	@SuppressWarnings("unchecked")
	public static void updatRoomProjec(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		List<HashMap<String, String>>  list = dbConn.select("select * from res_grade_relationship where GR_ResourceType='projection'");
		int index = 0;
		
		for(Object o : list){
			map = (HashMap<String, String>)o;
			String GR_Upload = map.get("GR_Upload").trim();
					GR_Upload = GR_Upload.replace("FYS30000", "").replace("0100", "0000");
			
			/*String PR_FileSwf = map.get("PR_FileSwf").trim();	   
					PR_FileSwf = PR_FileSwf.replace("FYS30000", "").replace("0100", "0000");*/
				   
			long GR_ID = Long.parseLong(map.get("GR_ID").trim());
			
			String sql1 = "update res_grade_relationship set GR_Upload ='"+GR_Upload+"' where GR_ResourceType='projection' and GR_ID="+GR_ID;
			System.out.println(sql1+"\n");
			dbConn.update(sql1);
		}
		System.out.println(" --- " + index);
    }
	@SuppressWarnings("unchecked")
	public static void updatRoomRecomObser(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		List<HashMap<String, String>>  list = dbConn.select("select * from res_observation_room where OR_Type = 1084 and OR_ID>=794");
		int index = 0;
		
		for(Object o : list){
			map = (HashMap<String, String>)o;
			String OR_Upload = map.get("OR_Upload").trim();
				   OR_Upload = OR_Upload.replace("GCS30000", "");
			
			String OR_FileSwf = map.get("OR_FileSwf").trim();	   
				   OR_FileSwf = OR_FileSwf.replace("GCS30000", "");
				   
			long OR_ID = Long.parseLong(map.get("OR_ID").trim());
			
			String sql = "update res_observation_room set OR_Upload='"+OR_Upload+"',OR_FileSwf='"+OR_FileSwf+"' where OR_ID="+OR_ID;
			String sql1 = "update res_resource set RR_Upload='"+OR_Upload+"',RR_FileSwf='"+OR_FileSwf+"' where RR_ResourceType = 'observation' and RR_ResourceID = "+OR_ID;
			System.out.println(sql);
			System.out.println(sql1+"\n");
			dbConn.update(sql);
			dbConn.update(sql1);
		}
		System.out.println(" --- " + index);
    }
	@SuppressWarnings("unchecked")
	public static void updatRoomRecom(String room){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		List<HashMap<String, String>>  list = dbConn.select("select * from res_laboratory_room where LR_ID<=16");
		int index = 0;
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			String LR_Upload = map.get("LR_Upload").trim();
			String LR_FileSwfPath = map.get("LR_FileSwfPath").trim();
			String LR_NO = map.get("LR_NO").trim();
			long RE_RecommendID = Long.parseLong(map.get("LR_ID").trim());
			
				LR_NO = LR_NO.replace("SYS3000001", "SYS0000000");
				LR_Upload = LR_Upload.replace("SYS3000001", "00");
				LR_FileSwfPath = LR_FileSwfPath.replace("SYS3000001", "00");
				
				
			String sql = "update res_laboratory_room set LR_NO='"+LR_NO+"', LR_Upload='"+LR_Upload+"', LR_FileSwfPath = '"+LR_FileSwfPath+"' where LR_ID = " + RE_RecommendID;
			String sql1 = "update res_resource set RR_Upload='"+LR_Upload+"' where RR_ResourceType = 'laboratory' and RR_ResourceID = " + RE_RecommendID;
			System.out.println(sql);
			System.out.println(sql1+"\n");
			dbConn.update(sql);
			dbConn.update(sql1);
		}
		System.out.println(room+" --- " + index);
    }
	public static String reResAbbreviated(String resType) {
    	if("exhibition".equals(resType)) {
			return "er" ;
		}else if("observation".equals(resType)) {
			return "or" ;
		}else if("laboratory".equals(resType)) {
			return "lr" ;
		}else if("projection".equals(resType)) {
			return "pr" ;
		}else if("expand".equals(resType)) {
			return "er" ;
		}
    	return resType ;
    }
}