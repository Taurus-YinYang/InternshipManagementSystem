package controller;

import dao.UserDAO;
import model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO dao = new UserDAO();
        User user = dao.login(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            switch (user.getRole()) {
                case "Student":
                    response.sendRedirect("dashboardStudent.jsp");
                    break;
                case "Company":
                    response.sendRedirect("dashboardCompany.jsp");
                    break;
                case "Admin":
                    response.sendRedirect("dashboardAdmin.jsp");
                    break;
            }
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
