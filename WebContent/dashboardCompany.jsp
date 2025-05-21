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
<head><title>Company Dashboard</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body class="dashboard">
<h2>Welcome, <%= user.getName() %></h2>
<a href="postInternship.jsp">Post Internship</a><br>
<a href="LogoutServlet">Logout</a>
</body>
</html>