<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Info</title>
    <link rel="stylesheet" type="text/css" href="infostyle.css">
    <style>
    body {
        background-image: url('cars.jpeg'); /* Replace 'background.jpg' with the path to your background image */
        background-repeat: repeat; /* Repeat the background image */
        font-family: Arial, sans-serif; /* Set the font family */
        margin: 0; /* Remove default margin */
    }
</style>
</head>
<body>
    <nav class="navbar">
        <div class="navbar-logo">
            <a href="buyer.jsp">Home</a>
        </div>
        <div class="navbar-links">
            <a href="#">Cart</a>
            <a href="LogoutServlet">Logout</a>
        </div>
    </nav>
    <div class="container">
        <h1>User Info</h1>
        <p>Username: <%= session.getAttribute("username") %></p>
        <p>Email: <%= session.getAttribute("email") %></p>
        <p>Phone: <%= session.getAttribute("phone") %></p>
        <form action="changepwd.jsp" method="post">
            <button type="submit">Change Password</button>
        </form>
    </div>
</body>
</html>
