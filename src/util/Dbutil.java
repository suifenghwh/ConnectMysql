package util;

import java.sql.*;

public class Dbutil {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/班主任工作管理系统","root","159123");
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if (conn != null) {
                System.out.println("Connected to the database!");
                // 连接成功后，可以在这里执行数据库操作
                conn.close(); // 在使用完连接后，务必关闭连接
            } else {
                System.out.println("Failed to connect to the database");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting to the database");
            e.printStackTrace();
        }
    }

    // 执行查询操作
    public static ResultSet executeQuery(String sql, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
            return rs;
        } finally {
            close(conn, pstmt, rs);
        }
    }

    // 执行更新操作
    public static int executeUpdate(String sql, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeUpdate();
        } finally {
            close(conn, pstmt, null);
        }
    }
    // 执行插入操作
    public static int executeInsert(String sql, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Insert failed, no rows affected.");
            }
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                throw new SQLException("Insert failed, no ID obtained.");
            }
        } finally {
            close(conn, pstmt, rs);
        }
    }

    // 执行删除操作
    public static int executeDelete(String sql, Object... params) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            return pstmt.executeUpdate();
        } finally {
            close(conn, pstmt, null);
        }
    }

    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
