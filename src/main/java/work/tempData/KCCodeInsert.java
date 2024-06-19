package work.tempData;

public class KCCodeInsert {
    public static void main(String[] args) {
        String sbjCode = "";
        String sbjName = "MATH";
        String sql="INSERT INTO TB_LMS_KC_OBJECT(SUBJECT_CODE,SUBJECT_NAME,CODE,NAME) VALUES ";
        for (int i = 1; i <= 500; i++) {
            sbjCode = sbjName + String.format("%07d",i);
            sql += "('"+sbjName+"','수학','"+sbjCode+"','나눗셈'),";
        }
        System.out.println(sql);

        sbjName = "ENG";
        sql = "INSERT INTO TB_LMS_KC_OBJECT(SUBJECT_CODE,SUBJECT_NAME,CODE,NAME) VALUES ";
        for (int i = 1; i <= 500; i++) {
            sbjCode = sbjName + String.format("%07d",i);
            sql += "('"+sbjName+"','영어','"+sbjCode+"','길찾기'),";
        }
        System.out.println(sql);
    }
}
