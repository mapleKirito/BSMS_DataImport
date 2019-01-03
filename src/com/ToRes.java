package com;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.db.DBConn;

public class ToRes {
	public static void main(String[] args) {
		handleObservation();
		//UpdateObservation_Zip();
		//handleExhibition();
		/*handleProjection();
		handleLaboratory();
		handleExpand();
		selectCha();*/
	}
	@SuppressWarnings("unchecked")
	public static void handleExpand(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String erName = "",erType = "",erThumbnail = "",erInThum = "",erUpload = "",erFileSwf = ""; 
		long erID = 0l,index = 11201/*Long.parseLong(dbConn.selectOne("SELECT MAX(RR_ID) FROM res_resource").get("MAX(RR_ID)"))*/;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM res_expand_room WHERE ER_ID NOT IN (SELECT RR_ResourceID FROM res_resource WHERE RR_ResourceType = 'expand');");
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
		long prID = 0l,index = 12349/*Long.parseLong(dbConn.selectOne("SELECT MAX(RR_ID) FROM res_resource").get("MAX(RR_ID)"))*/;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM res_projection_room WHERE PR_ID NOT IN (SELECT RR_ResourceID FROM res_resource WHERE RR_ResourceType = 'projection');");
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
		List<HashMap<String, String>>  list = dbConn.select("select * from res_laboratory_room");
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
		long erID = 0l,index = 41377;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM res_exhibition_room WHERE ER_ID = 38604 OR ER_ID = 50000 OR ER_ID = 50001 OR ER_ID = 50002 OR ER_ID = 50003 OR ER_ID = 50004 OR ER_ID = 50005 OR ER_ID = 50006 OR ER_ID = 50007 OR ER_ID = 50008 OR ER_ID = 50009 OR ER_ID = 50010 OR ER_ID = 50011 OR ER_ID = 50012 OR ER_ID = 50013 OR ER_ID = 50014 OR ER_ID = 50015 OR ER_ID = 50016 OR ER_ID = 50017 OR ER_ID = 50018 OR ER_ID = 50019 OR ER_ID = 50020 OR ER_ID = 50021 OR ER_ID = 50022 OR ER_ID = 50023 OR ER_ID = 50024 OR ER_ID = 50025 OR ER_ID = 50026 OR ER_ID = 50027 OR ER_ID = 50028 OR ER_ID = 50029 OR ER_ID = 50030 OR ER_ID = 50031 OR ER_ID = 50032 OR ER_ID = 50033 OR ER_ID = 50034 OR ER_ID = 50035 OR ER_ID = 50036 OR ER_ID = 50037 OR ER_ID = 50038 OR ER_ID = 50039 OR ER_ID = 50040 OR ER_ID = 50041 OR ER_ID = 50042 OR ER_ID = 50043 OR ER_ID = 50044 OR ER_ID = 50045 OR ER_ID = 50046 OR ER_ID = 50047 OR ER_ID = 50048 OR ER_ID = 50049 OR ER_ID = 50050 OR ER_ID = 50051 OR ER_ID = 50052 OR ER_ID = 50053 OR ER_ID = 50054 OR ER_ID = 50055 OR ER_ID = 50056 OR ER_ID = 50057 OR ER_ID = 50058 OR ER_ID = 50059 OR ER_ID = 50060 OR ER_ID = 50061 OR ER_ID = 50062 OR ER_ID = 50063 OR ER_ID = 50064 OR ER_ID = 50065 OR ER_ID = 50066 OR ER_ID = 50067 OR ER_ID = 50068 OR ER_ID = 50069 OR ER_ID = 50070 OR ER_ID = 50071 OR ER_ID = 50072 OR ER_ID = 50073 OR ER_ID = 50074 OR ER_ID = 50075 OR ER_ID = 50076 OR ER_ID = 50077 OR ER_ID = 50078 OR ER_ID = 50079 OR ER_ID = 50080 OR ER_ID = 50081 OR ER_ID = 50082 OR ER_ID = 50083 OR ER_ID = 50084 OR ER_ID = 50085 OR ER_ID = 50086 OR ER_ID = 50087 OR ER_ID = 50088 OR ER_ID = 50089 OR ER_ID = 50090 OR ER_ID = 50091 OR ER_ID = 50092 OR ER_ID = 50093 OR ER_ID = 50094 OR ER_ID = 50095 OR ER_ID = 50096 OR ER_ID = 50097 OR ER_ID = 50098 OR ER_ID = 50099 OR ER_ID = 50100 OR ER_ID = 50101 OR ER_ID = 50102 OR ER_ID = 50103 OR ER_ID = 50104 OR ER_ID = 50105 OR ER_ID = 50106 OR ER_ID = 50107 OR ER_ID = 50108 OR ER_ID = 50109 OR ER_ID = 50110 OR ER_ID = 50111 OR ER_ID = 50112 OR ER_ID = 50113 OR ER_ID = 50114 OR ER_ID = 50115 OR ER_ID = 50116 OR ER_ID = 50117 OR ER_ID = 50118 OR ER_ID = 50119 OR ER_ID = 50120 OR ER_ID = 50121 OR ER_ID = 50122 OR ER_ID = 50123 OR ER_ID = 50124 OR ER_ID = 50125 OR ER_ID = 50126 OR ER_ID = 50127 OR ER_ID = 50128 OR ER_ID = 50129 OR ER_ID = 50130 OR ER_ID = 50131 OR ER_ID = 50132 OR ER_ID = 50133 OR ER_ID = 50134 OR ER_ID = 50135 OR ER_ID = 50136 OR ER_ID = 50137 OR ER_ID = 50138 OR ER_ID = 50139 OR ER_ID = 50140 OR ER_ID = 50141 OR ER_ID = 50142 OR ER_ID = 50143 OR ER_ID = 50144 OR ER_ID = 50145 OR ER_ID = 50146 OR ER_ID = 50147 OR ER_ID = 50148 OR ER_ID = 50149 OR ER_ID = 50150 OR ER_ID = 50151 OR ER_ID = 50152 OR ER_ID = 50153 OR ER_ID = 50154 OR ER_ID = 50155 OR ER_ID = 50156 OR ER_ID = 50157 OR ER_ID = 50158 OR ER_ID = 50159 OR ER_ID = 50160 OR ER_ID = 50161 OR ER_ID = 50162 OR ER_ID = 50163 OR ER_ID = 50164 OR ER_ID = 50165 OR ER_ID = 50166 OR ER_ID = 50167 OR ER_ID = 50168 OR ER_ID = 50169 OR ER_ID = 50170 OR ER_ID = 50171 OR ER_ID = 50172 OR ER_ID = 50173 OR ER_ID = 50174 OR ER_ID = 50175 OR ER_ID = 50176 OR ER_ID = 50177 OR ER_ID = 50178 OR ER_ID = 50179 OR ER_ID = 50180 OR ER_ID = 50181 OR ER_ID = 50182 OR ER_ID = 50183 OR ER_ID = 50184 OR ER_ID = 50185 OR ER_ID = 50186 OR ER_ID = 50187 OR ER_ID = 50188 OR ER_ID = 50189 OR ER_ID = 50190 OR ER_ID = 50191 OR ER_ID = 50192 OR ER_ID = 50193 OR ER_ID = 50194 OR ER_ID = 50195 OR ER_ID = 50196 OR ER_ID = 50197 OR ER_ID = 50198 OR ER_ID = 50199 OR ER_ID = 50200 OR ER_ID = 50201 OR ER_ID = 50202 OR ER_ID = 50203 OR ER_ID = 50204 OR ER_ID = 50205 OR ER_ID = 50206 OR ER_ID = 50207 OR ER_ID = 50208 OR ER_ID = 50209 OR ER_ID = 50210 OR ER_ID = 50211 OR ER_ID = 50212 OR ER_ID = 50213 OR ER_ID = 50214 OR ER_ID = 50215 OR ER_ID = 50216 OR ER_ID = 50217 OR ER_ID = 50218 OR ER_ID = 50219 OR ER_ID = 50220 OR ER_ID = 50221 OR ER_ID = 50222 OR ER_ID = 50223 OR ER_ID = 50224 OR ER_ID = 50225 OR ER_ID = 50226 OR ER_ID = 50227 OR ER_ID = 50228 OR ER_ID = 50229 OR ER_ID = 50230 OR ER_ID = 50231 OR ER_ID = 50232 OR ER_ID = 50233 OR ER_ID = 50234 OR ER_ID = 50235 OR ER_ID = 50236 OR ER_ID = 50237 OR ER_ID = 50238 OR ER_ID = 50239 OR ER_ID = 50240 OR ER_ID = 50241 OR ER_ID = 50242 OR ER_ID = 50243 OR ER_ID = 50244 OR ER_ID = 50245 OR ER_ID = 50246 OR ER_ID = 50247 OR ER_ID = 50248 OR ER_ID = 50249 OR ER_ID = 50250 OR ER_ID = 50251 OR ER_ID = 50252 OR ER_ID = 50253 OR ER_ID = 50254 OR ER_ID = 50255 OR ER_ID = 50256 OR ER_ID = 50257 OR ER_ID = 50258 OR ER_ID = 50259 OR ER_ID = 50260 OR ER_ID = 50261 OR ER_ID = 50262 OR ER_ID = 50263 OR ER_ID = 50264 OR ER_ID = 50265 OR ER_ID = 50266 OR ER_ID = 50267 OR ER_ID = 50268 OR ER_ID = 50269 OR ER_ID = 50270 OR ER_ID = 50271 OR ER_ID = 50272 OR ER_ID = 50273 OR ER_ID = 50274 OR ER_ID = 50275 OR ER_ID = 50276 OR ER_ID = 50277 OR ER_ID = 50278 OR ER_ID = 50279 OR ER_ID = 50280 OR ER_ID = 50281 OR ER_ID = 50282 OR ER_ID = 50283 OR ER_ID = 50284 OR ER_ID = 50285 OR ER_ID = 50286 OR ER_ID = 50287 OR ER_ID = 50288 OR ER_ID = 50289 OR ER_ID = 50290 OR ER_ID = 50291 OR ER_ID = 50292 OR ER_ID = 50293 OR ER_ID = 50294 OR ER_ID = 50295 OR ER_ID = 50296 OR ER_ID = 50297 OR ER_ID = 50298 OR ER_ID = 50299 OR ER_ID = 50300 OR ER_ID = 50301 OR ER_ID = 50302 OR ER_ID = 50303 OR ER_ID = 50304 OR ER_ID = 50305 OR ER_ID = 50306 OR ER_ID = 50307 OR ER_ID = 50308 OR ER_ID = 50309 OR ER_ID = 50310 OR ER_ID = 50311 OR ER_ID = 50312 OR ER_ID = 50313 OR ER_ID = 50314 OR ER_ID = 50315 OR ER_ID = 50316 OR ER_ID = 50317 OR ER_ID = 50318 OR ER_ID = 50319 OR ER_ID = 50320 OR ER_ID = 50321 OR ER_ID = 50322 OR ER_ID = 50323 OR ER_ID = 50324 OR ER_ID = 50325 OR ER_ID = 50326 OR ER_ID = 50327 OR ER_ID = 50328 OR ER_ID = 50329 OR ER_ID = 50330 OR ER_ID = 50331 OR ER_ID = 50332 OR ER_ID = 50333 OR ER_ID = 50334 OR ER_ID = 50335 OR ER_ID = 50336 OR ER_ID = 50337 OR ER_ID = 50338 OR ER_ID = 50339 OR ER_ID = 50340 OR ER_ID = 50341 OR ER_ID = 50342 OR ER_ID = 50343 OR ER_ID = 50344 OR ER_ID = 50345 OR ER_ID = 50346 OR ER_ID = 50347 OR ER_ID = 50348 OR ER_ID = 50349 OR ER_ID = 50350 OR ER_ID = 50351 OR ER_ID = 50352 OR ER_ID = 50353 OR ER_ID = 50354 OR ER_ID = 50355 OR ER_ID = 50356 OR ER_ID = 50357 OR ER_ID = 50358 OR ER_ID = 50359 OR ER_ID = 50360 OR ER_ID = 50361 OR ER_ID = 50362 OR ER_ID = 50363 OR ER_ID = 50364 OR ER_ID = 50365 OR ER_ID = 50366 OR ER_ID = 50367 OR ER_ID = 50368 OR ER_ID = 50369 OR ER_ID = 50370 OR ER_ID = 50371 OR ER_ID = 50372 OR ER_ID = 50373 OR ER_ID = 50374 OR ER_ID = 50375 OR ER_ID = 50376 OR ER_ID = 50377 OR ER_ID = 50378 OR ER_ID = 50379 OR ER_ID = 50380 OR ER_ID = 50381 OR ER_ID = 50382 OR ER_ID = 50383 OR ER_ID = 50384 OR ER_ID = 50385 OR ER_ID = 50386 OR ER_ID = 50387 OR ER_ID = 50388 OR ER_ID = 50389 OR ER_ID = 50390 OR ER_ID = 50391 OR ER_ID = 50392 OR ER_ID = 50393 OR ER_ID = 50394 OR ER_ID = 50395 OR ER_ID = 50396 OR ER_ID = 50397 OR ER_ID = 50398 OR ER_ID = 50399 OR ER_ID = 50400 OR ER_ID = 50401 OR ER_ID = 50402 OR ER_ID = 50403 OR ER_ID = 50404 OR ER_ID = 50405 OR ER_ID = 50406 OR ER_ID = 50407 OR ER_ID = 50408 OR ER_ID = 50409 OR ER_ID = 50410 OR ER_ID = 50411 OR ER_ID = 50412 OR ER_ID = 50413 OR ER_ID = 50414 OR ER_ID = 50415 OR ER_ID = 50416 OR ER_ID = 50417 OR ER_ID = 50418 OR ER_ID = 50419 OR ER_ID = 50420 OR ER_ID = 50421 OR ER_ID = 50422 OR ER_ID = 50423 OR ER_ID = 50424 OR ER_ID = 50425 OR ER_ID = 50426 OR ER_ID = 50427 OR ER_ID = 50428 OR ER_ID = 50429 OR ER_ID = 50430 OR ER_ID = 50431 OR ER_ID = 50432 OR ER_ID = 50433 OR ER_ID = 50434 OR ER_ID = 50435 OR ER_ID = 50436 OR ER_ID = 50437 OR ER_ID = 50438 OR ER_ID = 50439 OR ER_ID = 50440 OR ER_ID = 50441 OR ER_ID = 50442 OR ER_ID = 50443 OR ER_ID = 50444 OR ER_ID = 50445 OR ER_ID = 50446 OR ER_ID = 50447 OR ER_ID = 50448 OR ER_ID = 50449 OR ER_ID = 50450 OR ER_ID = 50451 OR ER_ID = 50452 OR ER_ID = 50453 OR ER_ID = 50454 OR ER_ID = 50455 OR ER_ID = 50456 OR ER_ID = 50457 OR ER_ID = 50458 OR ER_ID = 50459 OR ER_ID = 50460 OR ER_ID = 50461 OR ER_ID = 50462 OR ER_ID = 50463 OR ER_ID = 50464 OR ER_ID = 50465 OR ER_ID = 50466 OR ER_ID = 50467 OR ER_ID = 50468 OR ER_ID = 50469 OR ER_ID = 50470 OR ER_ID = 50471 OR ER_ID = 50472 OR ER_ID = 50473 OR ER_ID = 50474 OR ER_ID = 50475 OR ER_ID = 50476 OR ER_ID = 50477 OR ER_ID = 50478 OR ER_ID = 50479 OR ER_ID = 50480 OR ER_ID = 50481 OR ER_ID = 50482 OR ER_ID = 50483 OR ER_ID = 50484 OR ER_ID = 50485 OR ER_ID = 50486 OR ER_ID = 50487 OR ER_ID = 50488 OR ER_ID = 50489 OR ER_ID = 50490 OR ER_ID = 50491 OR ER_ID = 50492 OR ER_ID = 50493 OR ER_ID = 50494 OR ER_ID = 50495 OR ER_ID = 50496 OR ER_ID = 50497 OR ER_ID = 50498 OR ER_ID = 50499 OR ER_ID = 50500 OR ER_ID = 50501 OR ER_ID = 50502 OR ER_ID = 50503 OR ER_ID = 50504 OR ER_ID = 50505 OR ER_ID = 50506 OR ER_ID = 50507 OR ER_ID = 50508 OR ER_ID = 50509 OR ER_ID = 50510 OR ER_ID = 50511 OR ER_ID = 50512 OR ER_ID = 50513 OR ER_ID = 50514 OR ER_ID = 50515 OR ER_ID = 50516 OR ER_ID = 50517 OR ER_ID = 50518 OR ER_ID = 50519 OR ER_ID = 50520 OR ER_ID = 50521 OR ER_ID = 50522 OR ER_ID = 50523 OR ER_ID = 50524 OR ER_ID = 50525 OR ER_ID = 50526 OR ER_ID = 50527 OR ER_ID = 50528 OR ER_ID = 50529 OR ER_ID = 50530 OR ER_ID = 50531 OR ER_ID = 50532 OR ER_ID = 50533 OR ER_ID = 50534 OR ER_ID = 50535 OR ER_ID = 50536 OR ER_ID = 50537 OR ER_ID = 50538 OR ER_ID = 50539 OR ER_ID = 50540 OR ER_ID = 50541 OR ER_ID = 50542 OR ER_ID = 50543 OR ER_ID = 50544 OR ER_ID = 50545 OR ER_ID = 50546 OR ER_ID = 50547 OR ER_ID = 50548 OR ER_ID = 50549 OR ER_ID = 50550 OR ER_ID = 50551 OR ER_ID = 50552 OR ER_ID = 50553 OR ER_ID = 50554 OR ER_ID = 50555 OR ER_ID = 50556 OR ER_ID = 50557 OR ER_ID = 50558 OR ER_ID = 50559 OR ER_ID = 50560 OR ER_ID = 50561 OR ER_ID = 50562 OR ER_ID = 50563 OR ER_ID = 50564 OR ER_ID = 50565 OR ER_ID = 50566 OR ER_ID = 50567 OR ER_ID = 50568 OR ER_ID = 50569 OR ER_ID = 50570 OR ER_ID = 50571 OR ER_ID = 50572 OR ER_ID = 50573 OR ER_ID = 50574 OR ER_ID = 50575 OR ER_ID = 50576 OR ER_ID = 50577 OR ER_ID = 50578 OR ER_ID = 50579 OR ER_ID = 50580 OR ER_ID = 50581 OR ER_ID = 50582 OR ER_ID = 50583 OR ER_ID = 50584 OR ER_ID = 50585 OR ER_ID = 50586 OR ER_ID = 50587 OR ER_ID = 50588 OR ER_ID = 50589 OR ER_ID = 50590 OR ER_ID = 50591 OR ER_ID = 50592 OR ER_ID = 50593 OR ER_ID = 50594 OR ER_ID = 50595 OR ER_ID = 50596 OR ER_ID = 50597 OR ER_ID = 50598 OR ER_ID = 50599 OR ER_ID = 50600 OR ER_ID = 50601 OR ER_ID = 50602 OR ER_ID = 50603 OR ER_ID = 50604 OR ER_ID = 50605 OR ER_ID = 50606 OR ER_ID = 50607 OR ER_ID = 50608 OR ER_ID = 50609 OR ER_ID = 50610 OR ER_ID = 50611 OR ER_ID = 50612 OR ER_ID = 50613 OR ER_ID = 50614 OR ER_ID = 50615 OR ER_ID = 50616 OR ER_ID = 50617 OR ER_ID = 50618 OR ER_ID = 50619 OR ER_ID = 50620 OR ER_ID = 50621 OR ER_ID = 50622 OR ER_ID = 50623 OR ER_ID = 50624 OR ER_ID = 50625 OR ER_ID = 50626 OR ER_ID = 50627 OR ER_ID = 50628 OR ER_ID = 50629 OR ER_ID = 50630 OR ER_ID = 50631 OR ER_ID = 50632 OR ER_ID = 50633 OR ER_ID = 50634 OR ER_ID = 50635 OR ER_ID = 50636 OR ER_ID = 50637 OR ER_ID = 50638 OR ER_ID = 50639 OR ER_ID = 50640 OR ER_ID = 50641 OR ER_ID = 50642 OR ER_ID = 50643 OR ER_ID = 50644 OR ER_ID = 50645 OR ER_ID = 50646 OR ER_ID = 50647 OR ER_ID = 50648 OR ER_ID = 50649 OR ER_ID = 50650 OR ER_ID = 50651 OR ER_ID = 50652 OR ER_ID = 50653 OR ER_ID = 50654 OR ER_ID = 50655 OR ER_ID = 50656 OR ER_ID = 50657 OR ER_ID = 50658 OR ER_ID = 50659 OR ER_ID = 50660 OR ER_ID = 50661 OR ER_ID = 50662 OR ER_ID = 50663 OR ER_ID = 50664 OR ER_ID = 50665 OR ER_ID = 50666 OR ER_ID = 50667 OR ER_ID = 50668 OR ER_ID = 50669 OR ER_ID = 50670 OR ER_ID = 50671 OR ER_ID = 50672 OR ER_ID = 50673 OR ER_ID = 50674 OR ER_ID = 50675 OR ER_ID = 50676 OR ER_ID = 50677 OR ER_ID = 50678 OR ER_ID = 50679 OR ER_ID = 50680 OR ER_ID = 50681 OR ER_ID = 50682 OR ER_ID = 50683 OR ER_ID = 50684 OR ER_ID = 50685 OR ER_ID = 50686 OR ER_ID = 50687 OR ER_ID = 50688 OR ER_ID = 50689 OR ER_ID = 50690 OR ER_ID = 50691 OR ER_ID = 50692 OR ER_ID = 50693 OR ER_ID = 50694 OR ER_ID = 50695 OR ER_ID = 50696 OR ER_ID = 50697 OR ER_ID = 50698 OR ER_ID = 50699 OR ER_ID = 50700 OR ER_ID = 50701 OR ER_ID = 50702 OR ER_ID = 50703 OR ER_ID = 50704 OR ER_ID = 50705 OR ER_ID = 50706 OR ER_ID = 50707 OR ER_ID = 50708 OR ER_ID = 50709 OR ER_ID = 50710 OR ER_ID = 50711 OR ER_ID = 50712 OR ER_ID = 50713 OR ER_ID = 50714 OR ER_ID = 50715 OR ER_ID = 50716 OR ER_ID = 50717 OR ER_ID = 50718 OR ER_ID = 50719 OR ER_ID = 50720 OR ER_ID = 50721 OR ER_ID = 50722 OR ER_ID = 50723 OR ER_ID = 50724 OR ER_ID = 50725 OR ER_ID = 50726 OR ER_ID = 50727 OR ER_ID = 50728 OR ER_ID = 50729 OR ER_ID = 50730 OR ER_ID = 50731 OR ER_ID = 50732 OR ER_ID = 50733 OR ER_ID = 50734 OR ER_ID = 50735 OR ER_ID = 50736 OR ER_ID = 50737 OR ER_ID = 50738 OR ER_ID = 50739 OR ER_ID = 50740 OR ER_ID = 50741 OR ER_ID = 50742 OR ER_ID = 50743 OR ER_ID = 50744 OR ER_ID = 50745 OR ER_ID = 50746 OR ER_ID = 50747 OR ER_ID = 50748 OR ER_ID = 50749 OR ER_ID = 50750 OR ER_ID = 50751 OR ER_ID = 50752 OR ER_ID = 50753 OR ER_ID = 50754 OR ER_ID = 50755 OR ER_ID = 50756 OR ER_ID = 50757 OR ER_ID = 50758 OR ER_ID = 50759 OR ER_ID = 50760 OR ER_ID = 50761 OR ER_ID = 50762 OR ER_ID = 50763 OR ER_ID = 50764 OR ER_ID = 50765 OR ER_ID = 50766 OR ER_ID = 50767 OR ER_ID = 50768 OR ER_ID = 50769 OR ER_ID = 50770 OR ER_ID = 50771 OR ER_ID = 50772 OR ER_ID = 50773 OR ER_ID = 50774 OR ER_ID = 50775 OR ER_ID = 50776 OR ER_ID = 50777 OR ER_ID = 50778 OR ER_ID = 50779 OR ER_ID = 50780 OR ER_ID = 50781 OR ER_ID = 50782 OR ER_ID = 50783 OR ER_ID = 50784 OR ER_ID = 50785 OR ER_ID = 50786 OR ER_ID = 50787 OR ER_ID = 50788 OR ER_ID = 50789 OR ER_ID = 50790 OR ER_ID = 50791 OR ER_ID = 50792 OR ER_ID = 50793 OR ER_ID = 50794 OR ER_ID = 50795 OR ER_ID = 50796 OR ER_ID = 50797 OR ER_ID = 50798 OR ER_ID = 50799 OR ER_ID = 50800 OR ER_ID = 50801 OR ER_ID = 50802 OR ER_ID = 50803 OR ER_ID = 50804 OR ER_ID = 50805 OR ER_ID = 50806 OR ER_ID = 50807 OR ER_ID = 50808 OR ER_ID = 50809 OR ER_ID = 50810 OR ER_ID = 50811 OR ER_ID = 50812 OR ER_ID = 50813 OR ER_ID = 50814 OR ER_ID = 50815 OR ER_ID = 50816 OR ER_ID = 50817 OR ER_ID = 50818 OR ER_ID = 50819 OR ER_ID = 50820 OR ER_ID = 50821 OR ER_ID = 50822 OR ER_ID = 50823 OR ER_ID = 50824 OR ER_ID = 50825 OR ER_ID = 50826 OR ER_ID = 50827 OR ER_ID = 50828 OR ER_ID = 50829 OR ER_ID = 50830 OR ER_ID = 50831 OR ER_ID = 50832 OR ER_ID = 50833 OR ER_ID = 50834 OR ER_ID = 50835 OR ER_ID = 50836 OR ER_ID = 50837 OR ER_ID = 50838 OR ER_ID = 50839 OR ER_ID = 50840 OR ER_ID = 50841 OR ER_ID = 50842 OR ER_ID = 50843 OR ER_ID = 50844 OR ER_ID = 50845 OR ER_ID = 50846 OR ER_ID = 50847 OR ER_ID = 50848 OR ER_ID = 50849 OR ER_ID = 50850 OR ER_ID = 50851 OR ER_ID = 50852 OR ER_ID = 50853 OR ER_ID = 50854 OR ER_ID = 50855 OR ER_ID = 50856 OR ER_ID = 50857 OR ER_ID = 50858 OR ER_ID = 50859 OR ER_ID = 50860 OR ER_ID = 50861 OR ER_ID = 50862 OR ER_ID = 50863 OR ER_ID = 50864 OR ER_ID = 50865 OR ER_ID = 50866 OR ER_ID = 50867 OR ER_ID = 50868 OR ER_ID = 50869 OR ER_ID = 50870 OR ER_ID = 50871 OR ER_ID = 50872 OR ER_ID = 50873 OR ER_ID = 50874 OR ER_ID = 50875 OR ER_ID = 50876 OR ER_ID = 50877 OR ER_ID = 50878 OR ER_ID = 50879 OR ER_ID = 50880 OR ER_ID = 50881 OR ER_ID = 50882 OR ER_ID = 50883 OR ER_ID = 50884 OR ER_ID = 50885 OR ER_ID = 50886 OR ER_ID = 50887 OR ER_ID = 50888 OR ER_ID = 50889 OR ER_ID = 50890 OR ER_ID = 50891 OR ER_ID = 50892 OR ER_ID = 50893 OR ER_ID = 50894 OR ER_ID = 50895 OR ER_ID = 50896 OR ER_ID = 50897 OR ER_ID = 50898 OR ER_ID = 50899 OR ER_ID = 50900 OR ER_ID = 50901 OR ER_ID = 50902 OR ER_ID = 50903 OR ER_ID = 50904 OR ER_ID = 50905 OR ER_ID = 50906 OR ER_ID = 50907 OR ER_ID = 50908 OR ER_ID = 50909 OR ER_ID = 50910 OR ER_ID = 50911 OR ER_ID = 50912 OR ER_ID = 50913 OR ER_ID = 50914 OR ER_ID = 50915 OR ER_ID = 50916 OR ER_ID = 50917 OR ER_ID = 50918 OR ER_ID = 50919 OR ER_ID = 50920 OR ER_ID = 50921 OR ER_ID = 50922 OR ER_ID = 50923 OR ER_ID = 50924 OR ER_ID = 50925 OR ER_ID = 50926 OR ER_ID = 50927 OR ER_ID = 50928 OR ER_ID = 50929 OR ER_ID = 50930 OR ER_ID = 50931 OR ER_ID = 50932 OR ER_ID = 50933 OR ER_ID = 50934 OR ER_ID = 50935 OR ER_ID = 50936 OR ER_ID = 50937 OR ER_ID = 50938 OR ER_ID = 50939 OR ER_ID = 50940 OR ER_ID = 50941 OR ER_ID = 50942 OR ER_ID = 50943 OR ER_ID = 50944 OR ER_ID = 50945 OR ER_ID = 50946 OR ER_ID = 50947 OR ER_ID = 50948 OR ER_ID = 50949 OR ER_ID = 50950 OR ER_ID = 50951 OR ER_ID = 50952 OR ER_ID = 50953 OR ER_ID = 50954 OR ER_ID = 50955 OR ER_ID = 50956 OR ER_ID = 50957 OR ER_ID = 50958 OR ER_ID = 50959 OR ER_ID = 50960 OR ER_ID = 50961 OR ER_ID = 50962 OR ER_ID = 50963 OR ER_ID = 50964 OR ER_ID = 50965 OR ER_ID = 50966 OR ER_ID = 50967 OR ER_ID = 50968 OR ER_ID = 50969 OR ER_ID = 50970 OR ER_ID = 50971 OR ER_ID = 50972 OR ER_ID = 50973 OR ER_ID = 50974 OR ER_ID = 50975 OR ER_ID = 50976 OR ER_ID = 50977 OR ER_ID = 50978 OR ER_ID = 50979 OR ER_ID = 50980 OR ER_ID = 50981 OR ER_ID = 50982 OR ER_ID = 50983 OR ER_ID = 50984 OR ER_ID = 50985 OR ER_ID = 50986 OR ER_ID = 50987 OR ER_ID = 50988 OR ER_ID = 50989 OR ER_ID = 50990 OR ER_ID = 50991 OR ER_ID = 50992 OR ER_ID = 50993 OR ER_ID = 50994 OR ER_ID = 50995 OR ER_ID = 50996 OR ER_ID = 50997 OR ER_ID = 50998 OR ER_ID = 50999 OR ER_ID = 51000 OR ER_ID = 51001 OR ER_ID = 51002 OR ER_ID = 51003 OR ER_ID = 51004 OR ER_ID = 51005 OR ER_ID = 51006 OR ER_ID = 51007 OR ER_ID = 51008 OR ER_ID = 51009 OR ER_ID = 51010 OR ER_ID = 51011 OR ER_ID = 51012 OR ER_ID = 51013 OR ER_ID = 51014 OR ER_ID = 51015 OR ER_ID = 51016 OR ER_ID = 51017 OR ER_ID = 51018 OR ER_ID = 51019 OR ER_ID = 51020 OR ER_ID = 51021 OR ER_ID = 51022 OR ER_ID = 51023 OR ER_ID = 51024 OR ER_ID = 51025 OR ER_ID = 51026 OR ER_ID = 51027 OR ER_ID = 51028 OR ER_ID = 51029 OR ER_ID = 51030 OR ER_ID = 51031 OR ER_ID = 51032 OR ER_ID = 51033 OR ER_ID = 51034 OR ER_ID = 51035 OR ER_ID = 51036 OR ER_ID = 51037 OR ER_ID = 51038 OR ER_ID = 51039 OR ER_ID = 51040 OR ER_ID = 51041 OR ER_ID = 51042 OR ER_ID = 51043 OR ER_ID = 51044 OR ER_ID = 51045 OR ER_ID = 51046 OR ER_ID = 51047 OR ER_ID = 51048 OR ER_ID = 51049 OR ER_ID = 51050 OR ER_ID = 51051 OR ER_ID = 51052 OR ER_ID = 51053 OR ER_ID = 51054 OR ER_ID = 51055 OR ER_ID = 51056 OR ER_ID = 51057 OR ER_ID = 51058 OR ER_ID = 51059 OR ER_ID = 51060 OR ER_ID = 51061 OR ER_ID = 51062 OR ER_ID = 51063 OR ER_ID = 51064 OR ER_ID = 51065 OR ER_ID = 51066 OR ER_ID = 51067 OR ER_ID = 51068 OR ER_ID = 51069 OR ER_ID = 51070 OR ER_ID = 51071 OR ER_ID = 51072 OR ER_ID = 51073 OR ER_ID = 51074 OR ER_ID = 51075 OR ER_ID = 51076 OR ER_ID = 51077 OR ER_ID = 51078 OR ER_ID = 51079 OR ER_ID = 51080 OR ER_ID = 51081 OR ER_ID = 51082 OR ER_ID = 51083 OR ER_ID = 51084 OR ER_ID = 51085 OR ER_ID = 51086 OR ER_ID = 51087 OR ER_ID = 51088 OR ER_ID = 51089 OR ER_ID = 51090 OR ER_ID = 51091 OR ER_ID = 51092 OR ER_ID = 51093 OR ER_ID = 51094 OR ER_ID = 51095 OR ER_ID = 51096 OR ER_ID = 51097 OR ER_ID = 51098 OR ER_ID = 51099 OR ER_ID = 51100 OR ER_ID = 51101 OR ER_ID = 51102 OR ER_ID = 51103 OR ER_ID = 51104 OR ER_ID = 51105 OR ER_ID = 51106 OR ER_ID = 51107 OR ER_ID = 51108 OR ER_ID = 51109 OR ER_ID = 51110 OR ER_ID = 51111 OR ER_ID = 51112 OR ER_ID = 51113 OR ER_ID = 51114 OR ER_ID = 51115 OR ER_ID = 51116 OR ER_ID = 51117 OR ER_ID = 51118 OR ER_ID = 51119 OR ER_ID = 51120 OR ER_ID = 51121 OR ER_ID = 51122 OR ER_ID = 51123 OR ER_ID = 51124 OR ER_ID = 51125 OR ER_ID = 51126 OR ER_ID = 51127 OR ER_ID = 51128 OR ER_ID = 51129 OR ER_ID = 51130 OR ER_ID = 51131 OR ER_ID = 51132 OR ER_ID = 51133 OR ER_ID = 51134 OR ER_ID = 51135 OR ER_ID = 51136 OR ER_ID = 51137 OR ER_ID = 51138 OR ER_ID = 51139 OR ER_ID = 51140 OR ER_ID = 51141 OR ER_ID = 51142 OR ER_ID = 51143 OR ER_ID = 51144 OR ER_ID = 51145 OR ER_ID = 51146 OR ER_ID = 51147 OR ER_ID = 51148 OR ER_ID = 51149 OR ER_ID = 51150 OR ER_ID = 51151 OR ER_ID = 51152 OR ER_ID = 51153 OR ER_ID = 51154 OR ER_ID = 51155 OR ER_ID = 51156 OR ER_ID = 51157 OR ER_ID = 51158 OR ER_ID = 51159 OR ER_ID = 51160 OR ER_ID = 51161 OR ER_ID = 51162 OR ER_ID = 51163 OR ER_ID = 51164 OR ER_ID = 51165 OR ER_ID = 51166 OR ER_ID = 51167 OR ER_ID = 51168 OR ER_ID = 51169 OR ER_ID = 51170 OR ER_ID = 51171 OR ER_ID = 51172 OR ER_ID = 51173 OR ER_ID = 51174 OR ER_ID = 51175 OR ER_ID = 51176 OR ER_ID = 51177 OR ER_ID = 51178 OR ER_ID = 51179 OR ER_ID = 51180 OR ER_ID = 51181 OR ER_ID = 51182 OR ER_ID = 51183 OR ER_ID = 51184 OR ER_ID = 51185 OR ER_ID = 51186 OR ER_ID = 51187 OR ER_ID = 51188 OR ER_ID = 51189 OR ER_ID = 51190 OR ER_ID = 51191 OR ER_ID = 51192 OR ER_ID = 51193 OR ER_ID = 51194 OR ER_ID = 51195 OR ER_ID = 51196 OR ER_ID = 51197 OR ER_ID = 51198 OR ER_ID = 51199 OR ER_ID = 51200 OR ER_ID = 51201 OR ER_ID = 51202 OR ER_ID = 51203 OR ER_ID = 51204 OR ER_ID = 51205 OR ER_ID = 51206 OR ER_ID = 51207 OR ER_ID = 51208 OR ER_ID = 51209 OR ER_ID = 51214 OR ER_ID = 51215 OR ER_ID = 51216 OR ER_ID = 51217 OR ER_ID = 51218 OR ER_ID = 51219 OR ER_ID = 51220 OR ER_ID = 51221 OR ER_ID = 51222 OR ER_ID = 51223 OR ER_ID = 51224 OR ER_ID = 51225 OR ER_ID = 51226 OR ER_ID = 51227 OR ER_ID = 51228 OR ER_ID = 51229 OR ER_ID = 51230 OR ER_ID = 51231 OR ER_ID = 51232 OR ER_ID = 51233 OR ER_ID = 51234 OR ER_ID = 51235 OR ER_ID = 51236 OR ER_ID = 51237 OR ER_ID = 51238 OR ER_ID = 51239 OR ER_ID = 51240 OR ER_ID = 51241 OR ER_ID = 51242 OR ER_ID = 51243 OR ER_ID = 51244 OR ER_ID = 51245 OR ER_ID = 51246 OR ER_ID = 51247 OR ER_ID = 51248 OR ER_ID = 51249 OR ER_ID = 51250 OR ER_ID = 51251 OR ER_ID = 51252 OR ER_ID = 51253 OR ER_ID = 51254 OR ER_ID = 51255 OR ER_ID = 51256 OR ER_ID = 51257 OR ER_ID = 51258 OR ER_ID = 51259 OR ER_ID = 51260 OR ER_ID = 51261 OR ER_ID = 51262 OR ER_ID = 51263 OR ER_ID = 51264 OR ER_ID = 51265 OR ER_ID = 51266 OR ER_ID = 51267 OR ER_ID = 51268 OR ER_ID = 51269 OR ER_ID = 51270 OR ER_ID = 51271 OR ER_ID = 51272 OR ER_ID = 51273 OR ER_ID = 51274 OR ER_ID = 51275 OR ER_ID = 51276 OR ER_ID = 51277 OR ER_ID = 51278 OR ER_ID = 51279 OR ER_ID = 51280 OR ER_ID = 51281 OR ER_ID = 51282 OR ER_ID = 51283 OR ER_ID = 51284 OR ER_ID = 51285 OR ER_ID = 51286 OR ER_ID = 51287 OR ER_ID = 51288 OR ER_ID = 51289 OR ER_ID = 51290 OR ER_ID = 51291 OR ER_ID = 51292 OR ER_ID = 51293 OR ER_ID = 51294 OR ER_ID = 51295 OR ER_ID = 51296 OR ER_ID = 51297 OR ER_ID = 51298 OR ER_ID = 51299 OR ER_ID = 51300 OR ER_ID = 51301 OR ER_ID = 51302 OR ER_ID = 51303 OR ER_ID = 51304 OR ER_ID = 51305 OR ER_ID = 51306 OR ER_ID = 51307 OR ER_ID = 51308 OR ER_ID = 51309 OR ER_ID = 51310 OR ER_ID = 51311 OR ER_ID = 51312 OR ER_ID = 51313 OR ER_ID = 51314 OR ER_ID = 51315 OR ER_ID = 51316 OR ER_ID = 51317 OR ER_ID = 51318 OR ER_ID = 51319 OR ER_ID = 51320 OR ER_ID = 51321 OR ER_ID = 51322;");
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
		long orID = 0l,modell = 0l,index = 42697/*Long.parseLong(dbConn.selectOne("SELECT MAX(RR_ID) FROM res_resource").get("MAX(RR_ID)"))*/;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM res_observation_room WHERE (OR_ID>=873 AND OR_ID<=892) OR (OR_ID>=1000 AND OR_ID<=1058);");
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
	@SuppressWarnings("unchecked")
	public static void UpdateObservation_Zip(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String orZip = "", orModel = ""; 
		long orID = 0l;
		List<HashMap<String, String>>  list = dbConn.select("select * from res_observation_room fe WHERE fe.`OR_Type` = '4033';");
		for(Object o : list){
			map = (HashMap<String, String>)o;
			orID = Long.parseLong(map.get("OR_ID"));
			orZip = map.get("OR_Zip");
			orModel = map.get("OR_Model");
			
			String sql1 = "update res_resource set RR_Zip = '"+orZip+"' ,RR_Model = '"+orModel+"' where RR_ResourceType = 'observation' and RR_ResourceID = " + orID;
			String sql2 = "";
			
			dbConn.update(sql1 + sql2);
			System.out.println(sql1 + sql2);
			
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void selectCha(){
		DBConn dbConn = DBConn.getInstance() ;
		Map<String,String> map = new HashMap<String, String>();
		String orZip = ""; 
		long orID = 0l,index = 0;
		List<HashMap<String, String>>  list = dbConn.select("SELECT * FROM res_exhibition_room WHERE ER_ID>=38478;");
		for(Object o : list){
			index++;
			map = (HashMap<String, String>)o;
			orID = Long.parseLong(map.get("ER_ID"));
			String sql1 = "select * from res_resource where RR_ResourceID = " + orID + " and RR_ResourceType = 'exhibition'";
			HashMap pp = dbConn.selectOne(sql1);
			if(pp==null){
				orZip += " or ER_ID = " + orID;
			}
			System.out.println(index);
		}
		orZip = orZip.replaceFirst("or", "");
		System.out.println(orZip);
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