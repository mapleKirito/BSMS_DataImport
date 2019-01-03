package com.torestograde;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.db.DBConn;

public class ToRes {
	public static void main(String[] args) {
		/*handleLaboratory();*/
		/*handleExhibition();*/
		/*handleObservation();
		handleExpand();*/
		handleProjection();
	}
	@SuppressWarnings("unchecked")
	public static void handleExpand(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String erName = "",erType = "",erThumbnail = "",erInThum = "",erUpload = "",erFileSwf = ""; 
		long erID = 0l,index = Long.parseLong(dbConn.selectOne("SELECT MAX(RR_ID) FROM res_resource").get("MAX(RR_ID)"));
		List<HashMap<String, String>>  list = dbConn.select("select * from res_expand_room");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			erName = map.get("ER_Name");
			
			erID = Long.parseLong(map.get("ER_ID"));
			erUpload = map.get("ER_Upload");
			erThumbnail = map.get("ER_Thumbnail");
			erInThum = map.get("ER_InThum");
			
			erFileSwf = map.get("ER_FileSwf");
			erType = map.get("ER_Type");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sdfdate = sdf.format(new Date());
			
			String sql1 = "insert into  res_resource(RR_ID,RR_FileSwf,RR_ResourceType,RR_ResourceID,RR_Name,RR_Thumbnail,RR_InThum,RR_Upload,RR_Type,RR_UserID,RR_UserAccount,RR_OperateTime,RR_CreateTime,RR_Creator)";
			String sql2 = " values("+index+",'"+erFileSwf+"','expand','"+erID+"','"+erName+"','"+erThumbnail+"','"+erInThum+"','"+erUpload+"','"+erType+"',4,'admin','"+sdfdate+"','"+sdfdate+"','admin')";
			
			dbConn.insert(sql1 + sql2);
			System.out.println(sql1 + sql2);
			
		}
	}
	@SuppressWarnings("unchecked")
	public static void handleProjection(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String prName = "",prType = "",prThumbnail = "",prInThum = "",prUpload = "",prFileSwf = ""; 
		long prID = 0l,index = Long.parseLong(dbConn.selectOne("SELECT MAX(RR_ID) FROM res_resource").get("MAX(RR_ID)"));
		List<HashMap<String, String>>  list = dbConn.select("select * from res_projection_room where PR_ID>=386");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			prName = map.get("PR_Name");
			
			prID = Long.parseLong(map.get("PR_ID"));
			prUpload = map.get("PR_Upload");
			prThumbnail = map.get("PR_Thumbnail");
			prInThum = map.get("PR_InThum");
			
			prFileSwf = map.get("PR_FileSwf");
			prType = map.get("PR_Type");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sdfdate = sdf.format(new Date());
			
			String sql1 = "insert into  res_resource(RR_ID,RR_FileSwf,RR_ResourceType,RR_ResourceID,RR_Name,RR_Thumbnail,RR_InThum,RR_Upload,RR_Type,RR_UserID,RR_UserAccount,RR_OperateTime,RR_CreateTime,RR_Creator)";
			String sql2 = " values("+index+",'"+prFileSwf+"','projection','"+prID+"','"+prName+"','"+prThumbnail+"','"+prInThum+"','"+prUpload+"','"+prType+"',4,'admin','"+sdfdate+"','"+sdfdate+"','admin')";
			
			dbConn.insert(sql1 + sql2);
			System.out.println(sql1 + sql2);
			
		}
	}
	@SuppressWarnings("unchecked")
	public static void handleLaboratory(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String lrName = "",lrType = "",lrThumbnail = "",lrInThum = "",lrUpload = "",lrFileSwf = "",lrFileSwfPath = ""; 
		long lrID = 0l,index = Long.parseLong(dbConn.selectOne("SELECT MAX(RR_ID) FROM res_resource").get("MAX(RR_ID)"));
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM res_laboratory_room a WHERE a.`LR_ID` = 11;");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			lrName = map.get("LR_Name");
			
			lrID = Long.parseLong(map.get("LR_ID"));
			lrUpload = map.get("LR_Upload");
			lrThumbnail = map.get("LR_Thumbnail");
			lrInThum = map.get("LR_InThum");
			
			lrFileSwf = map.get("LR_FileSwf");
			lrType = map.get("LR_Type");
			lrFileSwfPath = map.get("LR_FileSwfPath");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sdfdate = sdf.format(new Date());
			
			String sql1 = "insert into  res_resource(RR_ID,RR_FileSwf,RR_FileSwfPath,RR_ResourceType,RR_ResourceID,RR_Name,RR_Thumbnail,RR_InThum,RR_Upload,RR_Type,RR_UserID,RR_UserAccount,RR_OperateTime,RR_CreateTime,RR_Creator)";
			String sql2 = " values("+index+",'"+lrFileSwf+"','"+lrFileSwfPath+"','laboratory','"+lrID+"','"+lrName+"','"+lrThumbnail+"','"+lrInThum+"','"+lrUpload+"','"+lrType+"',4,'admin','"+sdfdate+"','"+sdfdate+"','admin')";
			
			dbConn.insert(sql1 + sql2);
			System.out.println(sql1 + sql2);
			
		}
	}
	@SuppressWarnings("unchecked")
	public static void handleExhibition(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String erName = "",erThumbnail = "",erInThum = "",erUpload = "",erAudio = ""; 
		long erID = 0l,index = 12797;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM res_exhibition_room a WHERE a.`ER_ID`>=55588;");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			erName = map.get("ER_Name");
			
			erID = Long.parseLong(map.get("ER_ID"));
			erUpload = map.get("ER_Upload");
			erThumbnail = map.get("ER_Thumbnail");
			erInThum = map.get("ER_InThum");
			erAudio = map.get("ER_Audio") == null? "" : map.get("ER_Audio");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sdfdate = sdf.format(new Date());
			
			String sql1 = "insert into  res_resource(RR_ID,RR_ResourceType,RR_ResourceID,RR_Name,RR_Thumbnail,RR_InThum,RR_Upload,RR_Type,RR_UserID,RR_UserAccount,RR_OperateTime,RR_CreateTime,RR_Creator,RR_Audio)";
			String sql2 = " values("+index+",'exhibition','"+erID+"','"+erName+"','"+erThumbnail+"','"+erInThum+"','"+erUpload+"','1011',4,'admin','"+sdfdate+"','"+sdfdate+"','admin','"+erAudio+"')";
			
			dbConn.insert(sql1 + sql2);
			System.out.println(sql1 + sql2);
			
		}
	}
	@SuppressWarnings("unchecked")
	public static void handleObservation(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String orName = "",orType = "",orThumbnail = "",orInThum = "",orUpload = "",orZip = "", orModel = "",orFileSwf = ""; 
		long orID = 0l,modell = 0l,index = Long.parseLong(dbConn.selectOne("SELECT MAX(RR_ID) FROM res_resource").get("MAX(RR_ID)"));
		List<HashMap<String, String>>  list = dbConn.select("select * from res_observation_room");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			orName = map.get("OR_Name");
			
			orID = Long.parseLong(map.get("OR_ID"));
			orUpload = map.get("OR_Upload");
			orThumbnail = map.get("OR_Thumbnail");
			orInThum = map.get("OR_InThum");
			
			orType = map.get("OR_Type");
			
			orZip = map.get("OR_Zip");
			orModel = map.get("OR_Model") == null ?"":map.get("OR_Model");
			if(!orModel.equals("")){
				modell = Long.parseLong(orModel);
			}
			
			orFileSwf = map.get("OR_FileSwf");
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sdfdate = sdf.format(new Date());
			
			String sql1 = "insert into  res_resource(RR_ID,RR_FileSwf,RR_ResourceType,RR_ResourceID,RR_Name,RR_Thumbnail,RR_InThum,RR_Upload,RR_Type,RR_UserID,RR_UserAccount,RR_OperateTime,RR_CreateTime,RR_Creator)";
			String sql2 = " values("+index+",'"+orFileSwf+"','observation','"+orID+"','"+orName+"','"+orThumbnail+"','"+orInThum+"','"+orUpload+"','"+orType+"',4,'admin','"+sdfdate+"','"+sdfdate+"','admin')";
			
			dbConn.insert(sql1 + sql2);
			System.out.println(sql1 + sql2);
			
		}
	}
	public static String reResTypeThum(String resType) {
    	if("exhibition".equals(resType)) {
			return "CLS" ;
		}else if("observation".equals(resType)) {
			return "GCS" ;
		}else if("laboratory".equals(resType)) {
			return "SYS" ;
		}else if("projection".equals(resType)) {
			return "FYS" ;
		}else if("expand".equals(resType)) {
			return "TZS" ;
		}
    	return resType ;
    }
	public static String getAfter(String nameCol){
		return nameCol.substring(nameCol.lastIndexOf("/"));
	}
}