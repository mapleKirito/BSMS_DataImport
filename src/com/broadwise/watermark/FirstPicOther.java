package com.broadwise.watermark;

import java.io.File;
import java.io.IOException;

public class FirstPicOther {
	//加水印
	private static long index = 0;
	
	public static void fileTest(File file, String pan,String iconPath,String fg) throws IOException {
		File[] files = file.listFiles(); // 获取文件夹下面的所有文件
		for (File f : files) {
			if (f.isDirectory()) {// 判断是否为文件夹
				String path = f.getAbsolutePath();
				path = pan + ":" + "\\xx\\one"+path.substring(path.indexOf("\\"));
				newFolders(path);
				fileTest(f, pan,iconPath,fg); // 如果是文件夹，重新遍历
			
			} else { // 如果是文件 就打印文件的路径
				String targerPath = "";
				String srcImgPath = f.getAbsolutePath();
				       targerPath = pan + ":" + "\\xx\\one"+ srcImgPath.substring(srcImgPath.indexOf("\\"));
								
				       newFolders(targerPath.substring(0,targerPath.lastIndexOf("\\")));
				
					String refilename = srcImgPath.substring(srcImgPath.lastIndexOf("."));
					if(refilename.equalsIgnoreCase(".jpg") || refilename.equalsIgnoreCase(".png")){
				        // 给图片添加水印 
				        Watermark.markImageByIcon(iconPath, srcImgPath, targerPath,fg);
				        index++;
				        System.out.println(index);
					}
				
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
		
		
		//中间上
		
		/*File onefile = new File("I:/临时/20181228/2019年历史馆升级资源/tmp");
		try {
			FirstPicOther.fileTest(onefile,"I","E:/水印图片/育龙标志.png","one");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("中间上完毕"+"/n");*/
		System.out.println("左下角开始");
		//左下角
		File twofile = new File("I:/临时/20181228/2019年历史馆升级资源/update/upload");
		try {
			SecondtPicOther.fileTest(twofile,"I","E:/水印图片/育龙标志.png","two");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("左下角完毕"+"/n");
		/*System.out.println("中间下开始");
		//中加下
		//File threefile = new File("D:/xx/one/20141218dgmupdate/图片");
		File threefile = new File("I:/临时/20181228/2019年历史馆升级资源/tmp");
		try {
			ThreePicOther.fileTest(threefile,"I","E:/水印图片/育龙标志.png","one");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("中间下完毕");*/
	}
}