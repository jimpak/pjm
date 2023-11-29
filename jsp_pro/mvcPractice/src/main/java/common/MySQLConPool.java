package common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConPool {
    public Connection conn = null;
    public Statement stmt = null;
    public PreparedStatement pstmt = null;
    public ResultSet rs = null;

    public MySQLConPool() {
        try {
            Context initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource)envContext.lookup("dbcp_mysql");
            conn = ds.getConnection();
            System.out.println("MySQL DB ConnectPool Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
