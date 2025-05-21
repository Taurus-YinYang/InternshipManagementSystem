package dao;

import model.Internship;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InternshipDAO {

    public boolean addInternship(Internship internship) {
        String sql = "INSERT INTO internships(title, description, company_id, deadline) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, internship.getTitle());
            ps.setString(2, internship.getDescription());
            ps.setInt(3, internship.getCompanyId());
            ps.setString(4, internship.getDeadline());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Internship> getAllInternships() {
        List<Internship> list = new ArrayList<>();
        String sql = "SELECT * FROM internships";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Internship i = new Internship();
                i.setId(rs.getInt("id"));
                i.setTitle(rs.getString("title"));
                i.setDescription(rs.getString("description"));
                i.setCompanyId(rs.getInt("company_id"));
                i.setDeadline(rs.getString("deadline"));
                list.add(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
