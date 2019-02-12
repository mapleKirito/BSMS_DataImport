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

public class ExcelTest3_2 {
	//生成sql文件
	public static void main(String[] args) {
		String xslFile="I:/临时/20181228/2019年历史馆升级资源/文物博览室_汉画像石整理.xls";
		String sqlPath="I:/临时/20181228/2019年历史馆升级资源/文物博览室_汉画像石整理.sql";
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
				String sql="insert into res_exhibition_room(ER_Code,ER_Char,ER_Name,ER_Keywords,ER_Type,ER_Upload,ER_Thumbnail,ER_InThum,ER_TotalID,ER_Total,ER_JieID,ER_Jie,ER_ChorID,ER_Chor,ER_GangID,ER_Gang,ER_Country,ER_Province,ER_City,ER_PlaceName,ER_Remarks,ER_IsShare) ";
				String sqlVal="VALUES(";
				for(int j=0;j<rsColumns;j++){
					sqlVal+="'"+rs.getCell(j, i).getContents()+"',";
				}
				sqlVal=sqlVal.substring(0, sqlVal.lastIndexOf(","));
				sqlVal+=",'1');";
				System.out.println(sql+sqlVal);
				out.println(sql+sqlVal);
				out.flush();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}