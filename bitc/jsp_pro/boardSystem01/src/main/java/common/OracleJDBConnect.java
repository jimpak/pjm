package common;

import java.sql.*;

public class OracleJDBConnect {
    public Connection conn;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public OracleJDBConnect() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:orcl";
            String id = "pjm";
            String pwd = "1234";
            conn = DriverManager.getConnection(url, id, pwd);

            System.out.println("Oracle JDBC1 Connect!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public OracleJDBConnect(String driver, String url, String id, String pwd) {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, pwd);
            System.out.println("JDBC2 connect!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
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