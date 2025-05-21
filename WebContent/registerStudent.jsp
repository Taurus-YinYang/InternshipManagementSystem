<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Register Student</title>
    <script src="js/validations.js"></script>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<div class="card">
    <h2>Register</h2>
    <form action="RegisterServlet" method="post" onsubmit="return validateRegistration()">
        Name: <input type="text" name="name" id="name"><br>
        Email: <input type="email" name="email" id="email"><br>
        Password: <input type="password" name="password"><br>
        <input type="hidden" name="role" value="Student">
        <input type="submit" value="Register">
    </form>
</div>
</body>
</html>