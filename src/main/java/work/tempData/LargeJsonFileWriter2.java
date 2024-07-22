package work.tempData;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.UUID;
import java.util.stream.IntStream;

public class LargeJsonFileWriter2 {

    /* 랜덤값 */
    public static double getRandomValue() {
        Random random = new Random();
        double value = 0.1 + (random.nextDouble() * 0.9);
        BigDecimal bd = new BigDecimal(value).setScale(1, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:/tempData/2024/06/21/20240621000001.json"))) {
            writer.write("["); // JSON 배열 시작

            //생성할 학생수
            int  row = 1000;
            String value = "";
            for (int i = 2; i < 500; i++) {
                String value1 = "MATH" + String.format("%07d", i);
                value += ",{\"code\":\""+value1+"\",\"name\":\"분수의계산\",\"value\":"+getRandomValue()+"}";
            }
            String valueENG = "";
            for (int i = 3; i < 500; i++) {
                String value1 = "ENG" + String.format("%07d", i);
                value += ",{\"code\":\""+value1+"\",\"name\":\"주문하기\",\"value\":"+getRandomValue()+"}";
            }
            for (int i = 0; i <  row; i++) {
//                String accountName = UUID.randomUUID().toString();
                String accountName = switch (i) {
                    case 0 -> "aa31ffd7-69f5-4842-a916-a31d10dc678e";
                    case 1 -> "aa32ffd7-69f5-4842-a916-a31d10dc678d";
                    case 2 -> "aa33ffd7-69f5-4842-a916-a31d10dc678c";
                    case 3 -> "aa34ffd7-69f5-4842-a916-a31d10dc678b";
                    default -> UUID.randomUUID().toString();
                };
                String jsonString = String.format("{\"account_name\":\"%s\",\"metrics\":[{\"code\":\"KC\",\"name\":\"학업성취\",\"child\":[{\"code\":\"KCMATH\",\"name\":\"수학성취\"" +
                                ",\"child\"" + ":[" +
                                 "{\"code\":\"MATH0000001\",\"name\":\"두자리 수의 덧셈\",\"value\":0.7}" + value + "]}" +
                                ",{\"code\":\"KCENG\",\"name\":\"영어성취\",\"child\":[{\"code\":\"ENG0000001\",\"name\":\"자기 소개\",\"value\":0.7},{\"code\":\"ENG0000002\",\"name\":\"인사 하기\",\"value\":0.7}"+valueENG+"]}]}," +
                                "{\"code\":\"ATTITUDE\",\"name\":\"학습태도\",\"value\":null,\"child\":[" +
                                "{\"code\":\"ATTENTION\",\"name\":\"수업집중\",\"value\":0.7,\"child\":[{\"code\":\"LEARNINGCOMPLETE\",\"name\":\"학습완료\",\"value\":0.8},{\"code\":\"LEARNINGATT\",\"name\":\"수업태도\",\"value\":0.8}]}," +
                                "{\"code\":\"SELF-DIRECTED\",\"name\":\"자기주도\",\"value\":0.4,\"child\":[{\"code\":\"HOMEWORK\",\"name\":\"과제수행\",\"value\":0.6},{\"code\":\"REVIEW\",\"name\":\"완전 학습\",\"value\":0.5}," +
                                "{\"code\":\"INQUERY\",\"name\":\"학습 탐구\",\"value\":0.5},{\"code\":\"STUDYTIME\",\"name\":\"학습시간\",\"value\":0.5},{\"code\":\"ACHIEVEMENT\",\"name\":\"목표 달성\",\"value\":0.6}," +
                                "{\"code\":\"ACTIVITY\",\"name\":\"활동 참여\",\"value\":0.5}]}]}]}",
                        accountName);
                writer.write(jsonString);
//                writer.write(",");
//                if(i == 100000000){
//                    System.out.println("1억건");
//                }

                if (i < row - 1) {
                    writer.write(",");  // 마지막 객체 뒤에는 쉼표를 쓰지 않음
                }
            }
            writer.write("]"); // JSON 배열 종료
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
