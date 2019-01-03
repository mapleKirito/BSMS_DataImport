package com.toisshow;

import java.util.HashMap;
import java.util.List;

import test.db.DBConn;

public class ToAreais {
	static DBConn dbConn = DBConn.getInstance() ;
	
	public static void main(String[] args) {
		dbConn.update("update sys_area set AREA_IsShow = 0");
		String exhiArea[] = {"ER_City","ER_Province","ER_Country"};
		for(int i = 0;i < exhiArea.length;i++){
			handleCategoryTo(exhiArea[i]);
		}
		dbConn.update("update sys_area set AREA_IsChild = 0 where AREA_Level = 3 and AREA_IsShow = 1");
	}
	
	@SuppressWarnings("unchecked")
	public static void handleCategoryTo(String handle){
		HashMap<String,String> map = new HashMap<String, String>();
		List<HashMap<String, String>>  list = dbConn.select("select "+handle+" from res_exhibition_room group by " + handle);
		for(Object o : list){
			map = (HashMap<String, String>)o;
			handleArea(map.get(handle),handle);
		}
	}
	
	public static void handleArea(String ID,String handle) {
		if(findResByAreaCount(handle, ID) == 0) {
			updateAreaIsShow(ID, 0) ;
		}else {
			updateAreaIsShow(ID, 1) ;
		}
	}

	public static int findResByAreaCount(String fieldName, String areaID) {
		int count = 0 ;
		if(areaID!= null && !"".equals(areaID)){
			count = (Integer)dbConn.selectCount("select count(*) from res_exhibition_room exhibition left join res_category c on c.CATE_ID = exhibition.ER_Category where exhibition."+fieldName+" in ("+areaID+")") ;
		}
		return count ;
	}

	public static void updateAreaIsShow(String areaID, int areaIsShow) {
		if(areaID != null && !"".equals(areaID)) {
			dbConn.update("update sys_area set AREA_IsShow= " + areaIsShow + " where AREA_ID in (" + areaID+")");
			System.out.println(areaID + " -- " + areaIsShow);
		}
	}
}