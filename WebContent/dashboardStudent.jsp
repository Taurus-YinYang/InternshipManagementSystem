<%@ page import="model.User" %>
<%@ page session="true" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"Student".equals(user.getRole())) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="dashboard">
<h2>Welcome, <%= user.getName() %></h2>
<a href="applyInternship.jsp">Apply for Internship</a><br>
<a href="viewApplications.jsp">View My Applications</a><br>
<a href="LogoutServlet">Logout</a>
</body>
</html>