package com.broadwise.watermark;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
 
/**
 * 图片水印
 * @blog http://sjsky.iteye.com
 * @author Michael
 */ 
public class Watermark { 
    /**
     * 给图片添加水印
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     */ 
    public static void markImageByIcon(String iconPath, String srcImgPath, 
            String targerPath,String fg) { 
        markImageByIcon(iconPath, srcImgPath, targerPath, null,fg); 
    } 
 
    /**
     * 给图片添加水印、可设置水印图片旋转角度
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     * @param degree 水印图片旋转角度
     */ 
    public static void markImageByIcon(String iconPath, String srcImgPath, 
            String targerPath, Integer degree,String fg) { 
        OutputStream os = null; 
        try { 
            Image srcImg = ImageIO.read(new File(srcImgPath)); 
 
            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB); 
 
            // 得到画笔对象 
            // Graphics g= buffImg.getGraphics(); 
            Graphics2D g = buffImg.createGraphics(); 
 
            // 设置对线段的锯齿状边缘处理 
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR); 
 
            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null); 
 
            if (null != degree) { 
                // 设置水印旋转 
                g.rotate(Math.toRadians(degree),(double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2); 
            } 
 
            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度 
            ImageIcon imgIcon = new ImageIcon(iconPath); 
 
            // 得到Image对象。 
            Image img = imgIcon.getImage(); 
 
            float alpha = 0.3f; // 透明度 
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha)); 
 
            // 表示水印图片的位置 
            int srcWidth = srcImg.getWidth(null);
            int srcHeight = srcImg.getHeight(null);
            
            Image srcIcon = ImageIO.read(new File(iconPath)); 
            int IconWidth = srcIcon.getWidth(null);
            int IconHeight = srcIcon.getHeight(null);
            
            //中间上（srcWidth / 2-IconWidth/2, srcHeight/6）
            //左下角（srcWidth / 20, srcHeight-IconHeight-50）
            //中间下（srcWidth / 2-IconWidth/2, srcHeight-srcHeight/6）
            if(fg.equalsIgnoreCase("one")){
            	g.drawImage(img, srcWidth / 2-IconWidth/2, srcHeight/7, null);             	
            }else if(fg.equalsIgnoreCase("two")){
            	g.drawImage(img, srcWidth / 20, srcHeight-IconHeight-50, null);  
            }else if(fg.equalsIgnoreCase("three")){
            	g.drawImage(img, srcWidth / 2-IconWidth/2, srcHeight-srcHeight/4, null);  
            }
 
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); 
 
            g.dispose(); 
 
            os = new FileOutputStream(targerPath); 
            
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(buffImg);
            
            float quality=1f;
            jep.setQuality(quality, true);
            encoder.encode(buffImg, jep);
            // 生成图片 
            String refilename = srcImgPath.substring(srcImgPath.lastIndexOf("."));
			if(refilename.equalsIgnoreCase(".jpg")){
				ImageIO.write(buffImg, "jpg", os); 
			}else if(refilename.equalsIgnoreCase(".png")){
				ImageIO.write(buffImg, "png", os); 
			}
            System.out.println("srcImgPath ----- " + srcImgPath); 
            System.out.println("targerPath ----- " + targerPath + " 生成完毕" + "\n"); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            try { 
                if (null != os) 
                    os.close(); 
            } catch (Exception e) { 
                e.printStackTrace(); 
            } 
        } 
    } 
}