package cn.shhuifu.analyse.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FileHelp {
    public static String fileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
    }

    public static String rename(String fileExt) {
        //data/share/1000/2016/05/08/K2016050811070993924.jpg
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
        Calendar nowtime = new GregorianCalendar();
        String fileName = "data/share/1000/" +
                String.format("%04d", nowtime.get(Calendar.YEAR)) + "/" +
                String.format("%02d", nowtime.get(Calendar.MONTH) + 1) + "/" +
                String.format("%02d", nowtime.get(Calendar.DATE)) + "/K" +
                sdf.format(nowtime.getTime()) + "." +
                fileExt;
        return fileName;
    }
}
