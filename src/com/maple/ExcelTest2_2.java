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

public class ExcelTest2_2 {
	//批量改名
	public static void main(String[] args) {
		String xslFile="I:/临时/20181228/2019年历史馆升级资源/Book.xls";
		String dirPath="I:/临时/20181228/2019年历史馆升级资源/YDS/0/2019/000/000";
		File f=new File(dirPath);
		File[] files=f.listFiles();
		jxl.Workbook rwb = null;
		try {
			InputStream is = new FileInputStream(xslFile);
			rwb = Workbook.getWorkbook(is);
			Sheet rs = rwb.getSheet(11);
			int rsColumns = rs.getColumns();
			int i=0;
			for(File file : files){
				System.out.println(rs.getCell(0, i).getContents()+"==="+rs.getCell(1, i).getContents());
				//Label lable=new Label(1, i, file.getName());
				//System.out.println(file.getName().substring(0,file.getName().lastIndexOf(".")));
				//sheet.addCell(lable);
				String fileName=file.getName().substring(0,file.getName().lastIndexOf("."));
				if(fileName.substring(0,6).equals(rs.getCell(0, i).getContents())){
					//System.out.println(file.getAbsolutePath().substring(0,file.getAbsolutePath().lastIndexOf("\\")+1));
					file.renameTo(new File(file.getAbsolutePath().substring(0,file.getAbsolutePath().lastIndexOf("\\")+1)+rs.getCell(1, i).getContents()+".jpg"));
				}
				
				i++;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}