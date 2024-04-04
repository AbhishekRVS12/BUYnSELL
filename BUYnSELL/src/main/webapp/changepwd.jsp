<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change Password</title>
    <link rel="stylesheet" type="text/css" href="changepwdstyle.css">
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
    <div class="container">
        <h1>Change Password</h1>
        <p>Welcome <%= session.getAttribute("username") %>!</p>
        <form action="UpdatePasswordServlet" method="post">
            <label for="oldpassword">Old Password:</label>
            <input type="password" id="oldpassword" name="oldpassword" maxlength="30" required><br><br>
            <label for="newpassword">New Password:</label>
            <input type="password" id="newpassword" name="newpassword" maxlength="30" required><br><br>
            
            <label for="newpassword">Enter New Password Again:</label>
            <input type="password" id="newpassword1" name="newpassword1" maxlength="30" required><br><br>
            
            <button type="submit">Update Password</button>
            
            <div class="error-message">${errorMessage}</div>
            <div class="success-message">${successMessage}</div>
            
        </form>
    </div>
</body>
</html>
