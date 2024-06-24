package work.tempData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

public class NIO {
    public static void main(String[] args) {
        path();
        System.out.println();
        files();
    }

    /*
    JDK7에서 등장

    io.File -> nio.Path
    nio.file.Files 제공
        - file, dir 조작 가능
    nio.FileChannel

    */

    /*

    path에 대한 기능 제공
        - 생성
        - 비교
        - 정보 추출
        - 조작
        - nio.file.Files 에서 Path(생성, 읽기, 쓰기, 복사, 이동 등) 가능

     */
    static void path() {
//        Path path = Paths.get("D:/tempData/");
        Path path = Paths.get("D:/tempData/20240618000001.json");
        System.out.println(path);                   // D:\tempData                              // D:\tempData\20240618000001.json
        System.out.println(path.toAbsolutePath());  // D:\tempData                              // D:\tempData\20240618000001.json
        System.out.println(path.toFile());          // D:\tempData                              // D:\tempData\20240618000001.json
        System.out.println(path.toUri());           // file:///D:/tempData/                     // file:///D:/tempData/20240618000001.json
        System.out.println(path.getFileName());     // tempData                                 // 20240618000001.json
        System.out.println(path.getFileSystem());   // sun.nio.fs.WindowsFileSystem@6d311334    // sun.nio.fs.WindowsFileSystem@6d311334
        System.out.println(path.getRoot());         // D:\                                      // D:\
        System.out.println(path.getParent());       // D:\                                      // D:\tempData
        System.out.println(path.getNameCount());    // 1                                        // 2
        System.out.println(path.normalize());       // D:\tempData                              // D:\tempData\20240618000001.json

        Iterator<Path> iterator = path.iterator();  //root 제외하고 경로가 다 포함
        while (iterator.hasNext()) {
            System.out.print(" "+iterator.next().getFileName());                                //  tempData 20240618000001.json
        }
    }

    static void files() {
        Path path = Paths.get("D:/tempData/20240618000001.json");
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isRegularFile(path));

        try {
            Path newPath = Files.createDirectory(Paths.get("D:/tempData/studyJava"));
            if(Files.exists(newPath)) {
                Path newFilePath = Paths.get("D:/tempData/studyJava/studyFile");
                newFilePath = Files.createFile(newFilePath);
//                System.out.println(newFilePath);

                byte[] content = {0x13, 0x14, 0x15};
                Files.write(newFilePath, content, StandardOpenOption.CREATE);
                Files.writeString(newFilePath, "hello\nhhhhhhhihhhihiiiiiiiiiiii\n\n4번째는 한글이다", StandardOpenOption.APPEND);

               byte[] readContent = Files.readAllBytes(newFilePath);
               System.out.println(readContent.length);
               for(String line : Files.readAllLines(newFilePath)) {
                   System.out.println(line);
               }
//               Files.deleteIfExists(newPath);     // dir 경우 빈 폴더만 삭제 가능

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
