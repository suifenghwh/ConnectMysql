package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HomeVisit;
import model.StudentComment;

import java.sql.Date;

public class HomeVisitDao extends BaseDao {

    public HomeVisitDao() {
        super(); // 调用父类的构造方法，初始化连接对象
    }

    // 添加家访记录
    public static boolean addHomeVisit(HomeVisit homeVisit) {
        String sql = "INSERT INTO 家访记录表 (家访ID, 学生学号, 家访地址, 家访内容, 家访时间) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, homeVisit.getHomeVisitID());
            pstmt.setInt(2, homeVisit.getStudentID());
            pstmt.setString(3, homeVisit.getAddress());
            pstmt.setString(4, homeVisit.getContent());
            pstmt.setDate(5, homeVisit.getDate());
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 根据学生学号查询家访记录列表
    public List<HomeVisit> searchHomeVisitByStudentID(int studentID) {
        List<HomeVisit> homeVisitList = new ArrayList<>();
        String sql = "SELECT * FROM 家访记录表 WHERE 学生学号 = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 设置查询参数
            pstmt.setInt(1, studentID);

            // 执行查询
            ResultSet rs = pstmt.executeQuery();

            // 遍历结果集，构建家访记录对象并添加到列表中
            while (rs.next()) {
                int homeVisitId = rs.getInt("家访ID");
                int studentId = rs.getInt("学生学号");
                String address = rs.getString("家访地址");
                String content = rs.getString("家访内容");
                java.sql.Date visitDate = rs.getDate("家访时间");

                HomeVisit homeVisit = new HomeVisit(homeVisitId, studentId, address, content, visitDate);
                homeVisitList.add(homeVisit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homeVisitList;
    }

    // 删除家访记录
    public boolean deleteHomeVisit(int homeVisitId) {
        String sql = "DELETE FROM 家访记录表 WHERE 家访ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, homeVisitId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 更新
    public boolean updateHomeVisit(HomeVisit homeVisit) {
        String sql = "UPDATE 家访记录表 SET 家访地址=?, 家访内容=?,家访时间=? WHERE 家访ID=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, homeVisit.getAddress());
            pstmt.setString(2, homeVisit.getContent());
            pstmt.setDate(3, new java.sql.Date(homeVisit.getDate().getTime())); // 将java.util.Date转换为java.sql.Date
            pstmt.setInt(4, homeVisit.getHomeVisitID());

            int rowsAffected = pstmt.executeUpdate();
            pstmt.close();

            // 如果影响的行数大于0，表示更新成功
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            // 更新失败
            return false;
        }
    }

    public List<HomeVisit> getHomeVisitList(HomeVisit homeVisit) {
        List<HomeVisit> homeVisitList = new ArrayList<>();
        String sql = "SELECT * FROM 家访记录表 WHERE 1=1"; // 初始查询语句
        List<Object> parameters = new ArrayList<>(); // 用于存储参数值

        // 根据传入的 HomeVisit 对象的属性值设置查询条件
        if (homeVisit.getStudentID() != 0) {
            sql += " AND 学生学号 = ?";
            parameters.add(homeVisit.getStudentID());
        }

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 设置参数值
            for (int i = 0; i < parameters.size(); i++) {
                pstmt.setObject(i + 1, parameters.get(i));
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int homeVisitId = rs.getInt("家访ID");
                int studentId = rs.getInt("学生学号");
                String address = rs.getString("家访地址");
                String content = rs.getString("家访内容");
                java.sql.Date homeVisitDate = rs.getDate("家访时间");

                HomeVisit homevisit = new HomeVisit(homeVisitId, studentId, address, content, homeVisitDate);
                homeVisitList.add(homevisit);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return homeVisitList;
    }


   /* // 获取家访记录列表
    public List<HomeVisit> getHomeVisitList() {
        List<HomeVisit> homeVisitList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM 家访记录表";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // 从结果集中获取每条家访记录的信息
                int homeVisitId = rs.getInt("家访ID");
                int studentId = rs.getInt("学生学号");
                String address = rs.getString("家访地址");
                String content = rs.getString("家访内容");
                Date visitDate = rs.getDate("家访时间");

                // 创建一个 HomeVisit 对象，并将家访记录信息添加到列表中
                HomeVisit homeVisit = new HomeVisit(homeVisitId, studentId, address, content, visitDate);
                homeVisitList.add(homeVisit);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return homeVisitList;
    }*/
}

