package work.tempData;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

public class LargeJsonFileWriter {

    public static void main(String[] args) {
        int cnt = 100000;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/MONINGSUN/tempData/20240618000002.json"))) {
            //writer.write("["); // JSON 배열 시작

            for (int i = 0; i < cnt; i++) {
                String accountName = UUID.randomUUID().toString();
                String jsonString = String.format("{\"account_name\":\"%s\",\"metrics\":[{\"code\":\"KC\",\"name\":\"학업성취\",\"child\":[{\"code\":\"KCMATH\",\"name\":\"수학성취\",\"child\":[{\"code\":\"MATH0000001\",\"name\":\"두자리 수의 덧셈\",\"value\":%.1f},{\"code\":\"MATH0000002\",\"name\":\"두자리 수의 곱셈\",\"value\":%.1f}]},{\"code\":\"KCENG\",\"name\":\"영어성취\",\"child\":[{\"code\":\"ENG0000001\",\"name\":\"자기 소개\",\"value\":%.1f},{\"code\":\"ENG0000002\",\"name\":\"인사 하기\",\"value\":%.1f}]}]},{\"code\":\"ATTITUDE\",\"name\":\"학습태도\",\"value\":null,\"child\":[{\"code\":\"ATTENTION\",\"name\":\"수업집중\",\"value\":%.1f,\"child\":[{\"code\":\"LEARNINGCOMPLETE\",\"name\":\"학습완료\",\"value\":%.1f},{\"code\":\"LEARNINGATT\",\"name\":\"수업태도\",\"value\":%.1f}]},{\"code\":\"SELF-DIRECTED\",\"name\":\"자기주도\",\"value\":%.1f,\"child\":[{\"code\":\"HOMEWORK\",\"name\":\"과제수행\",\"value\":%.1f},{\"code\":\"REVIEW\",\"name\":\"완전 학습\",\"value\":%.1f},{\"code\":\"INQUERY\",\"name\":\"학습 탐구\",\"value\":%.1f},{\"code\":\"STUDYTIME\",\"name\":\"학습시간\",\"value\":%.1f},{\"code\":\"ACHIEVEMENT\",\"name\":\"목표 달성\",\"value\":%.1f},{\"code\":\"ACTIVITY\",\"name\":\"활동 참여\",\"value\":%.1f}]}]}]}",
                        accountName,Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random(),Math.random());

                writer.write(jsonString);
                writer.write("\n");

//                if(i == 100000000){
                /*if(i == cnt-1){
//                    System.out.println("1억건");
                    System.out.println("10만건");
                }*/
                System.out.println(i+" 생성");


//                if (i < 200_000_000 - 1) {
//                    //writer.write(","); // 마지막 객체 뒤에는 쉼표를 쓰지 않음
//                }
            }

            //writer.write("]"); // JSON 배열 종료
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
