package com.maple;

import java.io.File;
import java.util.ArrayList;

import com.broadwise.watermark.Watermark;

public class ScreenShotMain {
	static ArrayList<ScreenshotUtil> SSU_list=new ArrayList<ScreenshotUtil>();
	public static void main(String[] args) {
		
		String videoPath="I:/临时/20181228/2019年历史馆升级资源/tmp/0";
		work(new File(videoPath));
	}
	
	public static void work(File file){
		File[] files = file.listFiles(); // 获取文件夹下面的所有文件
		for (File f : files) {
			if (f.isDirectory()) {// 判断是否为文件夹
				work(f); // 如果是文件夹，重新遍历
			} else { // 如果是文件
				String fileAbsPath = f.getAbsolutePath();
				String refilename = fileAbsPath.substring(fileAbsPath.lastIndexOf("."));
				if(refilename.equalsIgnoreCase(".mp4")){
			        // 添加到列表
					ScreenshotUtil ssu=new ScreenshotUtil(fileAbsPath, fileAbsPath.substring(0, fileAbsPath.lastIndexOf("."))+".jpg");
			        ssu.run();
				}
			}
		}
	}
}
