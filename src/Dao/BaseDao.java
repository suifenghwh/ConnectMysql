package Dao;

import java.sql.*;
import util.Dbutil;

public class BaseDao {
    protected static Connection conn;

    public BaseDao(){
        try {
            conn=Dbutil.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while closing the database connection");
            e.printStackTrace();
        }
    }
}
