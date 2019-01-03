package com.torestograde;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.db.DBConn;

public class ToGrade {
	public static void main(String[] args) {
		handleExpand();
	}
	@SuppressWarnings("unchecked")
	public static void handleExpand(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String grade = "",name = "",audio = "",thum = "",inthum = "",upload = "",type = "";
		long index = 11066l,erID = 0l;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM res_projection_room a WHERE a.`PR_Category_Name` LIKE '地理%'");
		for(Object o : list){
			map = (HashMap<String, String>)o;
			
			
			erID = Long.parseLong((String)map.get("PR_ID"));
			grade = (String)map.get("PR_Grade");
			name = (String)map.get("PR_Name");
			
		//	audio = (String)map.get("PR_Audio");
			thum = (String)map.get("PR_Thumbnail");
			inthum = (String)map.get("PR_InThum");
			upload = (String)map.get("PR_Upload");
			
			type = (String)map.get("PR_Type");
			
			if(grade!=null && !grade.equals("")){
				String grades[] = grade.split(",");
				for(Object g : grades){
					index++;
					long g1 = Long.parseLong(((String)g).trim());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String sdfdate = sdf.format(new Date());
					
					String sql1 = "insert into res_grade_relationship(GR_ID,GR_Grade,GR_Audio,GR_ResourceType,GR_ResourceID,GR_Name,GR_Thumbnail,GR_InThum,GR_Upload,GR_Type,GR_UserID,GR_UserAccount,GR_OperateTime,GR_CreateTime,GR_Creator)";
					String sql2 = " values("+index+",'"+g1+"','"+audio+"','projection',"+erID+",'"+name+"','"+thum+"','"+inthum+"','"+upload+"','"+type+"',4,'admin','"+sdfdate+"','"+sdfdate+"','admin')";
					
					System.out.println(sql1 + sql2);
					dbConn.insert(sql1 + sql2);
				}
			}
			
			
			
			
			
		
			
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