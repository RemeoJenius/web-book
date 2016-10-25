package com.jenius.web.util;

import java.io.File;

public class DeleteImage {
	public static boolean deleteFile(String fileName) {
		String sPath = "/Volumes/资源/workspace/web-book/src/main/webapp/"+fileName;
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	}  
}
