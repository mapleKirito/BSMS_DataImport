package com.diagonal.watermark;

import java.io.File;
import java.io.IOException;

public class FirstPicOther_diagonal {
	
	public static void fileTest(File file, String pan,String iconPath,String fg) throws IOException {
		File[] files = file.listFiles(); // 获取文件夹下面的所有文件
		for (File f : files) {
			if (f.isDirectory()) {// 判断是否为文件夹
				String path = f.getAbsolutePath();
				path = pan + ":" + "\\one"+path.substring(path.indexOf("\\"));
				newFolders(path);
				fileTest(f, pan,iconPath,fg); // 如果是文件夹，重新遍历
			
			} else { // 如果是文件 就打印文件的路径
				String targerPath = "";
				String srcImgPath = f.getAbsolutePath();
				       targerPath = pan + ":" + "\\one"+ srcImgPath.substring(srcImgPath.indexOf("\\"));
								
				       newFolders(targerPath.substring(0,targerPath.lastIndexOf("\\")));
				
					/*String refilename = srcImgPath.substring(srcImgPath.lastIndexOf("."));
					if(refilename.equalsIgnoreCase(".jpg")){*/
				        // 给图片添加水印 
				        Watermark_diagonal.markImageByIcon(iconPath, srcImgPath, targerPath,fg); 
					/*}*/
				
			}
		}
	}

	public static void newFolders(String folderPath) {
		String filePath = folderPath;
		filePath = filePath.toString();
		java.io.File myFilePath = new java.io.File(filePath);
		try {
			// 文件夹是否已存在，不可使用exists()方法
			if (myFilePath.isDirectory()) {
				// System.out.println("the directory is exists!（文件夹已存在！）");
			} else {
				myFilePath.mkdirs();// 创建文件夹，mkdirs可创建多级文件夹，如：D:/abcds/aaa/bbb,或D:/abcds等
			}
		} catch (Exception e) {
			System.out.println("新建目录操作出错");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		File onefile = new File("D:/新建文件夹");
		try {
			FirstPicOther_diagonal.fileTest(onefile,"D","D:/水印图片/history_linktones.png","one");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		/*File twofile = new File("D:/历史观项目形成前数据/数据");
		try {
			SecondtPicOther_diagonal.fileTest(twofile,"G","D:/水印图片/history_linktones.png","two");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
}
