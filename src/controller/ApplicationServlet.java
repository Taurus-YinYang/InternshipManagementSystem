package controller;

import dao.ApplicationDAO;
import model.Application;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ApplicationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int internshipId = Integer.parseInt(request.getParameter("internship_id"));

        HttpSession session = request.getSession();
        User student = (User) session.getAttribute("user");

        Application app = new Application();
        app.setInternshipId(internshipId);
        app.setStudentId(student.getUserId());

        ApplicationDAO dao = new ApplicationDAO();
        dao.apply(app);
        response.sendRedirect("dashboardStudent.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int appId = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

        ApplicationDAO dao = new ApplicationDAO();
        dao.updateStatus(appId, status);

        response.sendRedirect("dashboardAdmin.jsp");
    }
}
