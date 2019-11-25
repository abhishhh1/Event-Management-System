/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event_manager;

import java.sql.*;
import java.util.ArrayList;
import javafx.scene.control.Label;


/**
 *
 * @author abhishhh1
 */
public class FoundationDayDatabase {
    public static Connection conn;
    public static PerformanceTable pt;
    public static JudgeTable jt;
    public Label messageLabel;

    static {
        String url = "jdbc:mysql://localhost:3306/soe_lab_3";
        String userName = "root";
        String password = "123456";
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static class JudgeTable {
        private static Object messageLabel;

        public static void addJudge(String loginId, String password) throws SQLException {
            String query = "insert into soe_lab_3.judge(login_id, password) value (?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, loginId);
            pst.setString(2, password);
            pst.executeUpdate();
        }

        public static Judge getJudge(String loginId) throws SQLException {
            String query = "select * from soe_lab_3.judge where login_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, loginId);
            ResultSet rs = pst.executeQuery();
            Judge j = null;
            if (rs.next())
                j = new Judge(rs.getString(1), rs.getString(2));
            return j;
        }

        public static boolean checkJudge(String loginId, String password) throws SQLException {
            try{
                Judge j = getJudge(loginId);
                return j != null && password.equals(j.getPassword());
            }catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }

    }

    public static class PerformanceTable {

        public static Performance getPerformance(String performanceId) throws SQLException {
            String query = "select * from soe_lab_3.performance where performance_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, performanceId);
            ResultSet rs = pst.executeQuery();
            Performance p = null;
            if (rs.next())
                p = new Performance(rs.getString(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
            return p;
        }

        public static ArrayList<Performance> getAllPerformance() throws SQLException {
            String query = "select * from soe_lab_3.performance";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            ArrayList<Performance> arr = new ArrayList<Performance>();
            while (rs.next()) {
                Performance p = new Performance(rs.getString(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
                arr.add(p);
            }
            return arr;
        }

        public static void addPerformance(String performanceId, int noOfMembers, int batchYear, String performanceType) throws SQLException {
            String query = "insert into soe_lab_3.performance(performance_id, no_of_members, batch_year, performance_type) value (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, performanceId);
            pst.setInt(2, noOfMembers);
            pst.setInt(3, batchYear);
            pst.setString(4, performanceType);
            pst.executeUpdate();
        }

        public static void updateNoOfMembers(String performanceId, int noOfMembers) throws SQLException {
            String query = "update soe_lab_3.performance set no_of_members = ? where performance_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, noOfMembers);
            pst.setString(2, performanceId);
            pst.executeUpdate();
        }

        public static void updateBatchYear(String performanceId, int batchYear) throws SQLException {
            String query = "update soe_lab_3.performance set batch_year = ? where performance_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, batchYear);
            pst.setString(2, performanceId);
            pst.executeUpdate();
        }

        public static void updatePerformanceType(String performanceId, String performanceType) throws SQLException {
            String query = "update soe_lab_3.performance set performance_type = ? where performance_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, performanceType);
            pst.setString(2, performanceId);
            pst.executeUpdate();
        }

        public static void updateMarks(String performanceId, int marks1, int marks2, int marks3) throws SQLException {
            String query = "update soe_lab_3.performance set marks_1 = ? , marks_2 = ? , marks_3 = ? where performance_id = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, marks1);
            pst.setInt(2, marks2);
            pst.setInt(3, marks3);
            pst.setString(4, performanceId);
            pst.executeUpdate();
        }

    }

}

