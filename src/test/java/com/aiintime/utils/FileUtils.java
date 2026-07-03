package com.aiintime.utils;

public class FileUtils {

    public static String getFilePath(String fileName) {
        return System.getProperty("user.dir")
                + "/src/test/resources/TestFiles/" + fileName;
    }
   
}
