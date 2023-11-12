package common;

import jakarta.servlet.ServletContext;

import java.sql.*;

public class JDBConnect {
    public Connection conn;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;


    public JDBConnect() {
        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB에 연결
            String url = "jdbc:mysql://localhost:3306/boarddb?useSSL=false&serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
            String userid = "pjm";
            String userpw = "1234";
            conn = DriverManager.getConnection(url, userid, userpw);

            System.out.println("DB connection success (defalut constructor)!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JDBConnect(String driver, String url, String id, String pwd) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, pwd);
            System.out.println("JDBC2 connect!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JDBConnect(ServletContext application) {
        try {
            String dirver = application.getInitParameter("MySQLDriver");
            Class.forName(dirver);
            String url = application.getInitParameter("MySQLURL");
            String id = application.getInitParameter("MySQLId");
            String pwd = application.getInitParameter("MySQLPwd");
            System.out.println("JDBC3 sucess!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {

        }
    }
}