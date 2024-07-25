package work;

import java.sql.*;
import java.time.LocalDateTime;

public class ConnectDB {
    public static void main(String[] args) {
        System.out.println("ConnectDB run()"+ LocalDateTime.now());

        String url = "jdbc:mysql://localhost:3306/sample_database?serverTimezone=Asia/Seoul";
        String userName = "lms_owner";
        String password = "lms1234!";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            //DB 연결
            conn = DriverManager.getConnection(url,userName,password);

            //쿼리 작성
            String sql = "SELECT * FROM TB_LMS_STDNT";

            //쿼리 담기
            ps = conn.prepareStatement(sql);

            //결과 받기
            rs = ps.executeQuery();

            //결과 데이터 작업
            while (rs.next()) {
                System.out.print(rs.getString("STDNT_ID")+"::");
                System.out.println(rs.getString("LCTR_CD"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(rs != null) rs.close();
                if(ps != null) ps.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("ConnectDB end"+ LocalDateTime.now());
    }
}
