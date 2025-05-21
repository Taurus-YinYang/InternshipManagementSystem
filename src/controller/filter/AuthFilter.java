package controller.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String path = request.getRequestURI();

        if ((path.contains("dashboardAdmin") && (session == null || !"Admin".equals(session.getAttribute("role")))) ||
                (path.contains("dashboardStudent") && (session == null || !"Student".equals(session.getAttribute("role")))) ||
                (path.contains("dashboardCompany") && (session == null || !"Company".equals(session.getAttribute("role"))))) {
            response.sendRedirect("error.jsp");
            return;
        }

        chain.doFilter(req, res);
    }
}
