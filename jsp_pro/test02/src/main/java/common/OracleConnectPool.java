package common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OracleConnectPool {
    public Connection conn;
    public Statement stmt;
    public PreparedStatement pstmt;
    public ResultSet rs;

    public OracleConnectPool() {
        try {
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("dbcp_oracle");
            conn = ds.getConnection();
            //etc.
            System.out.println("Oracle DB ConnectPool Success!!!!!!!!!!!!!!!!!!");
        } catch (Exception e) {
            System.out.println("Oracle DB ConnectPool Fail");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close(); // 자동으로 커넥션풀로 반납

            System.out.println("Oracle DB connect pool resource release");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
