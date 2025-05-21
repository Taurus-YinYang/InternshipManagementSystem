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
    <title>Apply for Internship</title>
    <script src="js/validations.js"></script>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="card">
    <h2>Apply</h2>
    <form action="ApplicationServlet" method="post">
        <label>Select Internship:</label>
        <select name="internship_id" id="internshipDropdown"></select>
        <input type="submit" value="Apply">
    </form>
    <script>loadInternships();</script>
    <a href="dashboardStudent.jsp">Back</a>
</div>
</body>
</html>