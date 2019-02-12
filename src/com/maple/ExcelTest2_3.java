package com.maple;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
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

public class ExcelTest2_3 {
	//批量改名
	public static void main(String[] args) {
		String xslFile="I:/临时/20181228/2019年历史馆升级资源/Book2.xls";
		String dirPath="I:/临时/20181228/2019年历史馆升级资源/BLS/0/2019/000/000";
		File f=new File(dirPath);
		File[] files=f.listFiles();
		jxl.Workbook rwb = null;
		try {
			InputStream is = new FileInputStream(xslFile);
			rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(2);
			int rsRows = rs.getRows();
			for(int i=0;i<rsRows;i++){
				String str=rs.getCell(0, i).getContents();
				str=str.replaceAll("、", "_").replaceAll("？", "_").replaceAll("《", "_").replaceAll("》", "_");
				//System.out.println(str);
				System.out.println("BLS_"+Tools.ToPinyin(str));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}