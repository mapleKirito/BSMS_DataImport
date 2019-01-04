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

public class ExcelTest3 {
	//生成sql文件
	public static void main(String[] args) {
		String xslFile="I:/临时/20181228/2019年历史馆升级资源/近代重大事件.xls";
		String sqlPath="I:/临时/20181228/2019年历史馆升级资源/近代重大事件.sql";
		File f=new File(sqlPath);
		PrintWriter out=null;
		jxl.Workbook rwb = null;
		try {
			f.createNewFile();
			out=new PrintWriter(f);
			InputStream is = new FileInputStream(xslFile);
			rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(0);
			int rsColumns = rs.getColumns();
			int rsRows = rs.getRows();
			for (int i = 0; i < rsRows; i++) {
				String sql="insert into res_projection_room(PR_No,PR_Char,PR_Name,PR_Keywords,PR_Type,PR_Upload,PR_FileSwf,PR_Thumbnail,PR_InThum,PR_Category,PR_Category_Name,PR_CateTwLevel,PR_CateTwLevel_Name) ";
				String sqlVal="VALUES(";
				for(int j=0;j<rsColumns;j++){
					sqlVal+="'"+rs.getCell(j, i).getContents()+"',";
				}
				sqlVal=sqlVal.substring(0, sqlVal.lastIndexOf(","));
				sqlVal+=");";
				System.out.println(sql+sqlVal);
				out.println(sql+sqlVal);
				out.flush();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}