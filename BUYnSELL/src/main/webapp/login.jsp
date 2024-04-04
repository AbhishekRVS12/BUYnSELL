<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    // Check if a session exists
    HttpSession s = request.getSession(false);
    if (s != null && session.getAttribute("username") != null) {
        // If session exists and the user is logged in, redirect to buyer.jsp
        response.sendRedirect("buyer.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="loginstyle.css">
<style>
    body {
        background-image: url('BnS.png'); /* Replace 'background.jpg' with the path to your background image */
        background-repeat: repeat; /* Repeat the background image */
        font-family: Arial, sans-serif; /* Set the font family */
        margin: 0; /* Remove default margin */
    }
</style>
</head>
<body>
<body background="covert.jpeg">
<% if ("true".equals(request.getParameter("logout"))) { %>
    <div class="login-container">
        <p>Successfully logged out!</p>
    </div>
<% } %>

<div class="login-container">
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <div class="input-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" maxlength="30" required>
        </div>
        <div class="input-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" maxlength="30" required>
        </div>
        <div class="input-group">
            <button type="submit">Login</button>
        </div>
    </form>
    <div class="error-message">${errorMessage}</div>
    <div class="input-group">
        <button type="button" onclick="window.location.href='registeruser.jsp'">Register</button>
    </div>
    <!-- Contact Us button -->
    <div class="input-group">
        <button type="button" class="contact-us-btn" onclick="window.location.href='contactus.jsp'">Contact Us</button>
    </div>
</div>
</body>
</html>
