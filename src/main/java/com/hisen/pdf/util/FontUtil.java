package com.hisen.pdf.util;

public class FontUtil {


    public static String getFontPath(String fontName){
        String calsspath=FontUtil.class.getClassLoader().getResource("").getPath();
        return calsspath+"/fonts/"+fontName;
    }
}
