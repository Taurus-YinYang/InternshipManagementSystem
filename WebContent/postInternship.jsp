<%@ page import="model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"Company".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head><title>Post Internship</title></head>
<body>
<h2>Post New Internship</h2>
<form action="InternshipServlet" method="post">
    Title: <input type="text" name="title" required><br>
    Description: <textarea name="description" required></textarea><br>
    Deadline: <input type="date" name="deadline" required><br>
    <input type="submit" value="Post Internship">
</form>
<a href="dashboardCompany.jsp">Back to Dashboard</a>
</body>
</html>
