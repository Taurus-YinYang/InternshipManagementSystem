package dao;

import model.Application;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {

    public boolean apply(Application app) {
        String sql = "INSERT INTO applications(internship_id, student_id) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, app.getInternshipId());
            ps.setInt(2, app.getStudentId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Application> getApplicationsByStudent(int studentId) {
        List<Application> list = new ArrayList<>();
        String sql = "SELECT * FROM applications WHERE student_id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Application app = new Application();
                app.setId(rs.getInt("id"));
                app.setInternshipId(rs.getInt("internship_id"));
                app.setStudentId(rs.getInt("student_id"));
                app.setStatus(rs.getString("status"));
                list.add(app);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean updateStatus(int appId, String status) {
        String sql = "UPDATE applications SET status = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, appId);

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
