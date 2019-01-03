package com;


public class Test {

	public static String converterToPinYin(String chinese) {

		String pinyinString = "";

		/*char[] charArray = chinese.toCharArray();

		// 根据需要定制输出格式，我用默认的即可

		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();

		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);*/

		return pinyinString;

	}
	
	 public static String getName_(String name,int index){
		 String name_[][] = {{"《","<"},{"》",">"},{"（","("},{"）",")"},{"：",":"},{"——","..."},{"－","..."},{"、","o"}};
		 for (int j = 0; j < name_.length; j++) {
			 if(index==1){
				 for (int i = 0; i < 1; i++) {
					name = name.replace(name_[j][i], name_[j][i+1]);
				 }
			 }else if(index==2){
				 for (int i = 1; i > 0; i--) {
					name = name.replace(name_[j][i], name_[j][i-1]);
				 }
			 }
		}
		 return name; 
	 }

	 public static String getNameByChine(String name){
		 return getName_(converterToPinYin(getName_(name,1)),2);
	 }

	/*
	 * public static void main(String[] args) {
	 * 
	 * //输出“hyldNeekedgrbk”
	 * 
	 * System.out.println(converterToPinYin("植物界 动物界"));
	 * 
	 * }
	 */

}
