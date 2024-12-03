package test;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtilsMain {
    public static void main(String[] args) {
        fn1();
    }

    public static void fn1() {
        File origin = new File("D:\\2024\\temp\\20240718.PNG");
        String copyPath = "D:/2024/temp/"+origin.getName().substring(0,6);
        File copy = new File(copyPath+"/"+origin.getName());
        try {
            FileUtils.moveFile(origin,copy);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}