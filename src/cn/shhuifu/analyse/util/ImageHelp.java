package cn.shhuifu.analyse.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import sun.misc.BASE64Decoder;

public class ImageHelp {
	//对字节数组字符串进行Base64解码并生成图片
	public static boolean GenerateImage(String path, String filename, String imgStr) {
        if (imgStr == null) {
        	//图像数据为空
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {//调整异常数据
                    b[i] += 256;
                }
            }
            //生成图片
            String imgFilePath = path + filename;
            File file = new File(imgFilePath);
            if(!file.getParentFile().exists()){
            	file.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            System.out.println("e:" + e.getMessage());
            return false;
        }
    }
}
