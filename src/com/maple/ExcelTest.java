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

public class ExcelTest {
	//提取目录原始文件名
	public static void main(String[] args) {
		String xslFile="I:/临时/20181228/2019年历史馆升级资源/Book2.xls";
		String dirPath="I:/临时/20181228/2019年历史馆升级资源/ZLS/0/2019/000/001";
		File f=new File(dirPath);
		File[] files=f.listFiles();
		try {
			//File tmpf=new File(xslFile);
			//WritableWorkbook wwb = Workbook.createWorkbook(tmpf);
			//WritableSheet sheet=wwb.createSheet("fff", 0);
			//int m=wwb.getNumberOfSheets();
			//WritableSheet sheet = wwb.getSheet(0);
			int i=1;
			for(File file : files){
				//Label lable=new Label(1, i, file.getName());
				System.out.println(file.getName().substring(0,file.getName().lastIndexOf(".")));
				//sheet.addCell(lable);
				i++;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}