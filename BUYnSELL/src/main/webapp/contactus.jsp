<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Contact Us</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
        }

        .form-group {
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="email"],
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 16px;
            margin-top: 5px;
        }

        textarea {
            resize: vertical;
        }

        a.button {
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
            display: inline-block;
            margin-right: 10px;
        }

        a.button:hover {
            background-color: #0056b3;
        }

        .return-link {
            font-size: 16px;
            color: #007bff;
            text-decoration: none;
        }

        .return-link:hover {
            text-decoration: underline;
        }
        
         body {
        background-image: url('BnS.png'); /* Replace 'background.jpg' with the path to your background image */
        background-repeat: repeat; /* Repeat the background image */
        font-family: Arial, sans-serif; /* Set the font family */
        margin: 0; /* Remove default margin */
    }
    </style>
</head>
<body>
    <div class="container">
        <h2>Contact Us</h2>
        <form action="ContactUsServlet" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" maxlength="30" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" maxlength="30" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone Number:</label>
                <input type="text" id="phone" name="phone" maxlength="10" required>
            </div>
            <div class="form-group">
                <label for="comments">Comments (Max 200 Characters):</label>
                <textarea id="comments" name="comments" rows="5" maxlength="200" required></textarea>
            </div>
            <button type="submit">Submit</button>
            <div class="error-message">${errorMessage}</div>
            <div class="success-message">${successMessage}</div>
        </form>
        <a href="login.jsp" class="return-link">Return to Login Page</a>
    </div>
</body>
</html>
