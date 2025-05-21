<%@ page import="dao.ApplicationDAO, java.util.List, model.Application" %>
<%
    ApplicationDAO dao = new ApplicationDAO();
    List<Application> apps = dao.getApplicationsByStudent(0); // Admin sees all
%>
<html>
<head><title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="dashboard">
<h2>All Applications</h2>
<table>
    <tr><th>ID</th><th>Internship ID</th><th>Student ID</th><th>Status</th><th>Action</th></tr>
    <% for (Application app : apps) { %>
    <tr>
        <td><%= app.getId() %></td>
        <td><%= app.getInternshipId() %></td>
        <td><%= app.getStudentId() %></td>
        <td><%= app.getStatus() %></td>
        <td>
            <a href="ApplicationServlet?id=<%=app.getId()%>&status=Approved">Approve</a> |
            <a href="ApplicationServlet?id=<%=app.getId()%>&status=Rejected">Reject</a>
        </td>
    </tr>
    <% } %>
</table>
<a href="LogoutServlet">Logout</a>
</body>
</html>