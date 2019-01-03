package com.toDemoVer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyData {
	public static boolean copyFile(String srcFileName, String destFileName) {
		File srcFile = new File(srcFileName);
		File destFile = new File(destFileName);
		File srcFileY = new File(srcFileName);
		if(srcFileY.exists()){
			createFolder(destFile.getParent());
		}
		int byteread = 0;
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(destFile);
			byte[] buffer = new byte[1024];
			while ((byteread = in.read(buffer)) != -1) {
				out.write(buffer, 0, byteread);
			}
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			return false;
		} finally {
			try {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public static void createFolder(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
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