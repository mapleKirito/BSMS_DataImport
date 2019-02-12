package com.zhuanPIC.thumbnail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ThumbnailPic2 {
	//预览图
	static boolean flag;
	public static void fileTest(File file, String pan) throws IOException {
		File[] files = file.listFiles(); // 获取文件夹下面的所有文件
		int a = 0;
		for (File f : files) {
			if (f.isDirectory()) {// 判断是否为文件夹
				String path = f.getAbsolutePath();
				path = pan + ":" + path.substring(path.indexOf("\\"));
				newFolders(path);
				fileTest(f, pan); // 如果是文件夹，重新遍历
				flag = true;
			} else { // 如果是文件 就打印文件的路径
				String xin = "";
				String pathfile = f.getAbsolutePath();
						xin = pan + ":" + "\\xx_inthum" +pathfile.substring(pathfile.indexOf("\\"));
				String refilename = pathfile.substring(pathfile.lastIndexOf("."));
				
				
				File fi = new File(pathfile);
				newFolders(new File(xin).getParent());
				InputStream file1 = new FileInputStream(fi);
				/*BufferedImage srcFile = ImageIO.read(file1);
				int w = srcFile.getWidth();
     			int h = srcFile.getHeight();*/

				if(!refilename.equalsIgnoreCase(".xlsx") && !refilename.equalsIgnoreCase(".xls") &&!refilename.equalsIgnoreCase(".db") && !refilename.equalsIgnoreCase(".rar")&& !refilename.equalsIgnoreCase(".mp4")&& !refilename.equalsIgnoreCase(".mov")){
					a++;
					ThumbnailAndPic ps = new ThumbnailAndPic();
					ps.proce1(pathfile,1280, 760, 1f,xin);
					System.out.println(pathfile);
				}
			}
		}
		System.out.println(a);
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
		File onefile = new File("I:/临时/20181228/2019年历史馆升级资源/update/upload");
		try {
			fileTest(onefile,"I");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
