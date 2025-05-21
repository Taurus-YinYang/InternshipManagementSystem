<%@ page import="dao.ApplicationDAO, model.Application, java.util.List, model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"Student".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
    ApplicationDAO dao = new ApplicationDAO();
    List<Application> apps = dao.getApplicationsByStudent(user.getUserId());
%>
<html>
<head><title>Your Applications</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="dashboard">
<h2>Your Applications</h2>
<table>
    <tr><th>ID</th><th>Internship ID</th><th>Status</th></tr>
    <% for (Application app : apps) { %>
    <tr>
        <td><%= app.getId() %></td>
        <td><%= app.getInternshipId() %></td>
        <td><%= app.getStatus() %></td>
    </tr>
    <% } %>
</table>
<a href="dashboardStudent.jsp">Back</a>
</body>
</html>