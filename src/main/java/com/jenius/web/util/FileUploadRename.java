package com.jenius.web.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUploadRename {
    public static String fileRename(String str){
         
        String formatDate = new SimpleDateFormat("yyMMddHHmmss")
        .format(new Date());
        int last = str.lastIndexOf(".");
        int i = (int) (Math.random()*1000);
        String str_head = str.substring(0,last);
         
        String str_type = str.substring(last);
         
        str = str_head+formatDate+i+str_type;
        return str;
    }
}
