package com.pdfToImage;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

public class PdfToJpgTest {
    public static void setup() throws IOException {
    	File file = new File("C:\\Users\\zhangyingli\\Desktop\\123123\\新建文件夹 (5)\\1362470981031.pdf");
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        FileChannel channel = raf.getChannel();
        ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        PDFFile pdffile = new PDFFile(buf);
        String getPdfFilePath = System.getProperty("user.dir") + "\\pdfPicFile";

        for (int i = 1; i <= pdffile.getNumPages(); i++) {
            // draw the first page to an image
            PDFPage page = pdffile.getPage(i);

            // get the width and height for the doc at the default zoom
            Rectangle rect = new Rectangle(0, 0, (int) page.getBBox().getWidth(), (int) page.getBBox().getHeight());

            // generate the image
            Image img = page.getImage(rect.width, rect.height, rect, null, true, true );

            BufferedImage tag = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(img, 0, 0, rect.width, rect.height, null);

            // 输出到文件流
            FileOutputStream out = new FileOutputStream(getPdfFilePath + "\\" + i + ".jpg");
            System.out.println("成功保存图片到:" + getPdfFilePath + "\\" + i + ".jpg");

            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
            JPEGEncodeParam param2 = encoder.getDefaultJPEGEncodeParam(tag);
            param2.setQuality(1f, false);// 1f是提高生成的图片质量
            encoder.setJPEGEncodeParam(param2);
            encoder.encode(tag); // JPEG编码
            out.close();

        }
    }

    public static void main(final String[] args) {      
        try {
            PdfToJpgTest.setup();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
