package controller;

import dao.InternshipDAO;
import model.Internship;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class InternshipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String deadline = request.getParameter("deadline");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        Internship i = new Internship();
        i.setTitle(title);
        i.setDescription(description);
        i.setDeadline(deadline);
        i.setCompanyId(user.getUserId());

        InternshipDAO dao = new InternshipDAO();
        dao.addInternship(i);
        response.sendRedirect("dashboardCompany.jsp");
    }
}
