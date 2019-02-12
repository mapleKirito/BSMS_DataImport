package com.maple;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.*;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import test.db.DBConn;

public class ExcelTest3_4 {
	//生成sql文件
	public static void main(String[] args) {
		String xslFile="I:/临时/20181228/2019年历史馆升级资源/res_exhibition.xls";
		String sqlPath="I:/临时/20181228/2019年历史馆升级资源/res_exhibition_update.sql";
		File f=new File(sqlPath);
		PrintWriter out=null;
		jxl.Workbook rwb = null;
		try {
			f.createNewFile();
			out=new PrintWriter(f);
			InputStream is = new FileInputStream(xslFile);
			rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(1);
			int rsColumns = rs.getColumns();
			int rsRows = rs.getRows();
			for (int i = 0; i < rsRows; i++) {
				
				
				String sql="update res_exhibition_room set ER_Total='春秋战国时期',ER_TotalID='62' where ER_Code=";
				//String sql="insert into res_resource(RR_ResourceType,RR_ResourceID,RR_Name,RR_Thumbnail,RR_InThum,RR_Upload,RR_FileSwf,RR_Type,RR_IsShare) ";
				//String sqlVal="select 'exhibition',er_id,er_name,ER_Thumbnail,ER_InThum,ER_Upload,'',ER_Type,'1' from res_exhibition_room where ER_Code=";
				//String sqlVal="select 'observation',or_id,or_name,oR_Thumbnail,oR_InThum,oR_Upload,OR_FileSwf,oR_Type,'1' from res_observation_room where OR_NO=";
				//String sqlVal="select 'projection',pr_id,pr_name,pR_Thumbnail,pR_InThum,pR_Upload,pR_FileSwf,pR_Type,'1' from res_projection_room where PR_No=";
				String sqlVal="";
				for(int j=0;j<rsColumns;j++){
					sqlVal+="'"+rs.getCell(j, i).getContents()+"',";
				}
				sqlVal=sqlVal.substring(0, sqlVal.lastIndexOf(","));
				sqlVal+=";";
				System.out.println(sql+sqlVal);
				out.println(sql+sqlVal);
				out.flush();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}