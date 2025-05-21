<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="card">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Email: <input type="email" name="email" required><br>
        Password: <input type="password" name="password" required><br>
        <input type="submit" value="Login">
    </form>
    <% if (request.getParameter("error") != null) { %>
    <p style="color:red;">Invalid credentials!</p>
    <% } %>
</div>
</body>
</html>