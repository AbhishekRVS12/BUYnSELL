<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" type="text/css" href="registerstyle.css">
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
	<div class="register-container">
    <h2>Register</h2>
    <%-- Display success message if available --%>
    <% if (request.getAttribute("successMessage") != null) { %>
        <div class="success-message">
            <%= request.getAttribute("successMessage") %>
        </div>
    <% } %>
    <form action="RegisterServlet" method="post">
        <div class="input-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" maxlength="30" required>
        </div>
        <div class="input-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" maxlength="30" required>
        </div>
        <div class="input-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" maxlength="30" required>
        </div>
        <div class="input-group">
            <label for="phone">Phone:</label>
            <input type="text" id="phone" name="phone" maxlength="10" required>
        </div>
        <div class="input-group">
            <label for="role">Role:</label>
            <select id="role" name="role" required>
                <option value="buyer">Buyer</option>
                <option value="seller">Seller</option>
            </select>
        </div>
        <div class="input-group">
            <button type="submit">Register</button>
        </div>
    </form>
</div>
</body>
</html>