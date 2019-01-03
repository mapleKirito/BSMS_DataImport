package com.toisshow;

import java.util.HashMap;
import java.util.List;
import test.db.DBConn;

public class ToCategoryis {
	static DBConn dbConn = DBConn.getInstance() ;
	
	public static void main(String[] args) {
		String roomname[] = {"exhibition","observation","laboratory","projection","expand"};
		String exhi[] = {"ER_JieID","ER_ChorID","ER_GangID","ER_OrderID","ER_Category"};
		String obse[] = {"OR_Category","OR_CateTwLevel"};
		String labo[] = {"LR_Category","LR_CateTwLevel"};
		String proj[] = {"PR_Category","PR_CateTwLevel"};
		String expa[] = {"ER_ResType","ER_CateTwLevel"};
		
		dbConn.update("UPDATE res_category SET CATE_IsChild = 0  WHERE CATE_Level IN (5)");
		dbConn.update("update res_category set CATE_Status = 0,CATE_IsChild = 0  where CATE_Level in (6,7,8) ");
		dbConn.update("UPDATE res_category SET CATE_Status = 0 WHERE CATE_Level NOT IN (1,2)");
		
		String[][] to_data = {exhi,obse,labo,proj,expa};
		for(int i = 0;i < to_data.length;i++){
			for (int j = 0; j < to_data[i].length; j++) {
				handleCategoryTo(roomname[i],to_data[i][j]);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void handleCategoryTo(String resType,String handle){
		long index = 0l;
		HashMap<String,String> map = new HashMap<String, String>();
		List<HashMap<String, String>>  list = dbConn.select("select "+handle+" from res_"+resType+"_room group by " + handle);
		for(Object o : list){
			index++;
			System.out.println(index + " -- " + handle);
			map = (HashMap<String, String>)o;
			modifyCategoryStatus(map,resType);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void modifyCategoryStatus(HashMap mapTo,String resType) {
		String resCateHideID = "",resCateShowID = "" ;
		try{
			if("exhibition".equals(resType)) {
				String jieID = (String)(mapTo.get("ER_JieID"));
				if(jieID != null) {
					Integer jieCount = (Integer)dbConn.selectCount("select count(*) from res_exhibition_room exhibition where exhibition.ER_JieID = " + jieID) ;
					if(jieCount == 0) {
						resCateHideID += "," + jieID ;
					}else{
						resCateShowID += "," + jieID ;
					}
				}
				
				String erChorID = (String)(mapTo.get("ER_ChorID"));
				if(erChorID != null) {
					Integer jieCount = (Integer)dbConn.selectCount("select count(*) from res_exhibition_room exhibition where exhibition.ER_ChorID = " + erChorID) ;
					if(jieCount == 0) {
						resCateHideID += "," + erChorID ;
					}else{
						resCateShowID += "," + erChorID ;
					}
				}

				String erGangID = (String)(mapTo.get("ER_GangID"));
				if(erGangID != null) {
					Integer jieCount = (Integer)dbConn.selectCount("select count(*) from res_exhibition_room exhibition where exhibition.ER_GangID = " + erGangID) ;
					if(jieCount == 0) {
						resCateHideID += "," + erGangID ;
					}else{
						resCateShowID += "," + erGangID ;
					}
				}

				String erOrderID = (String)(mapTo.get("ER_OrderID"));
				if(erOrderID != null) {
					Integer jieCount = (Integer)dbConn.selectCount("select count(*) from res_exhibition_room exhibition where exhibition.ER_OrderID = " + erOrderID) ;
					if(jieCount == 0) {
						resCateHideID += "," + erOrderID ;
					}else{
						resCateShowID += "," + erOrderID ;
					}
				}

				String erCategory = (String)(mapTo.get("ER_Category")) ;
				if(erCategory != null) {
					Integer jieCount = (Integer)dbConn.selectCount("select count(*) from res_exhibition_room exhibition where exhibition.ER_Category = " + erCategory) ;
					if(jieCount == 0) {
						resCateHideID += "," + erCategory ;
					}else{
						resCateShowID += "," + erCategory ;
					}
				}
			}else if("observation".equals(resType)) {
				String orCategory = (String)(mapTo.get("OR_Category")) ;
				if(orCategory != null) {
					Integer resCount = (Integer)dbConn.selectCount("select count(*) from res_observation_room observation where observation.OR_Category = " + orCategory) ;
					if(resCount == 0) {
						resCateHideID += "," + orCategory ;
					}else{
						resCateShowID += "," + orCategory ;
					}
				}
				
				String orCateTwLevel = (String)(mapTo.get("OR_CateTwLevel") );
				if(orCateTwLevel != null) {
					Integer resCount = (Integer)dbConn.selectCount("select count(*) from res_observation_room observation where observation.OR_CateTwLevel = " + orCateTwLevel) ;
					if(resCount == 0) {
						resCateHideID += "," + orCateTwLevel ;
					}else{
						resCateShowID += "," + orCateTwLevel ;
					}
				}				
			}else if("laboratory".equals(resType)) {
				String lrCategory = (String)(mapTo.get("LR_Category")) ;
				if(lrCategory != null) {
					Integer resCount = (Integer)dbConn.selectCount("select count(*) from res_laboratory_room laboratory where laboratory.LR_Category = " + lrCategory) ;
					if(resCount == 0) {
						resCateHideID += "," + lrCategory ;
					}else{
						resCateShowID += "," + lrCategory ;
					}
				}
				
				String lrCateTwLevel = (String)(mapTo.get("LR_CateTwLevel")) ;
				if(lrCateTwLevel != null) {
					Integer resCount = (Integer)dbConn.selectCount("select count(*) from res_laboratory_room laboratory where laboratory.LR_CateTwLevel = " + lrCateTwLevel) ;
					if(resCount == 0) {
						resCateHideID += "," + lrCateTwLevel ;
					}else{
						resCateShowID += "," + lrCateTwLevel ;
					}
				}
			}else if("projection".equals(resType)) {
				String prCategory = (String)(mapTo.get("PR_Category") );
				if(prCategory != null) {
					Integer resCount = (Integer)dbConn.selectCount("select count(*) from res_projection_room projection where projection.PR_Category = " + prCategory) ;
					if(resCount == 0) {
						resCateHideID += "," + prCategory ;
					}else{
						resCateShowID += "," + prCategory ;
					}
				}
				
				String prCateTwLevel = (String)(mapTo.get("PR_CateTwLevel")) ;
				if(prCateTwLevel != null) {
					Integer resCount = (Integer)dbConn.selectCount("select count(*) from res_projection_room projection where projection.PR_CateTwLevel = " + prCateTwLevel) ;
					if(resCount == 0) {
						resCateHideID += "," + prCateTwLevel ;
					}else{
						resCateShowID += "," + prCateTwLevel ;
					}
				}	
				
			}else if("expand".equals(resType)) {
				String erResType = (String)(mapTo.get("ER_ResType") );
				if(erResType != null) {
					Integer resCount = (Integer)dbConn.selectCount("select count(*) from res_expand_room expand where expand.ER_ResType = " + erResType) ;
					if(resCount == 0) {
						resCateHideID += "," + erResType ;
					}else{
						resCateShowID += "," + erResType ;
					}
				}
				
				String erCateTwLevel = (String)(mapTo.get("ER_CateTwLevel"));
				if(erCateTwLevel != null) {
					Integer resCount = (Integer)dbConn.selectCount("select count(*) from res_expand_room expand where expand.ER_CateTwLevel = " + erCateTwLevel) ;
					if(resCount == 0) {
						resCateHideID += "," + erCateTwLevel ;
					}else{
						resCateShowID += "," + erCateTwLevel ;
					}
				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String[] cateHideID = resCateHideID.split(",") ;
		for(int i = 0; i < cateHideID.length; i ++) {
			handleCategoryHide(cateHideID[i]) ;
		}
		
		String[] cateShowID = resCateShowID.split(",") ;
		for(int i = 0; i < cateShowID.length; i ++) {
			handleCategoryShow(cateShowID[i]) ;
		}
		
		
	}

	public static void handleCategoryHide(String cateID) {
		if(cateID != null && !"".equals(cateID)) {
			dbConn.update("update res_category set CATE_Status=0 where CATE_ID = " + cateID);
		}
	}
	
	public static void handleCategoryShow(String cateID) {
		if(cateID != null && !"".equals(cateID)) {
			dbConn.update("update res_category set CATE_Status=1 where CATE_ID = " + cateID);
		}
	}
}