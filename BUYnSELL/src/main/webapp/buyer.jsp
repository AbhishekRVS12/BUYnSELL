<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buyer Dashboard</title>
    <link rel="stylesheet" type="text/css" href="">
    <style>
        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        .navbar {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            border-bottom: 2px solid #0056b3;
            margin-bottom: 20px; /* Add margin below navbar */
        }

        .navbar-logo img {
            width: 100px; /* Set width of logo */
            height: auto; /* Maintain aspect ratio */
        }

        .navbar-links {
            margin-left: auto; /* Push user info and cart to the right */
        }

        .navbar-links a {
            color: white;
            text-decoration: none;
            margin-right: 20px;
            font-weight: bold;
        }

        .car-list {
            display: flex;
            flex-wrap: wrap; /* Allow multiple rows of cars */
            justify-content: space-between;
        }

        .car {
            width: 30%; /* Set width of each car to fit in container */
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            overflow: hidden; /* Prevent image overflow */
        }

        .car img {
            width: 100%; /* Make image fill its container */
            height: auto; /* Maintain aspect ratio */
            border-bottom: 1px solid #ccc; /* Add border below image */
        }

        .car-details {
            padding: 20px;
        }

        .car-details p {
            margin: 5px 0;
        }

        .add-to-cart-btn {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            display: block; /* Make button fill its container */
            margin-top: 10px; /* Add margin on top of button */
        }

        .add-to-cart-btn:hover {
            background-color: #0056b3;
        }
        
        
    </style>
</head>
<body>
    <div class="navbar">
        <div class="navbar-logo">
            <img src="BnS.png" alt="Logo">
        </div>
        <div class="navbar-links">
            <a href="userinfo.jsp"><%= session.getAttribute("username") %></a>
            <a href="#">Cart</a>
            <a href="LogoutServlet">Logout</a>
        </div>
    </div>
    <div class="container">
        <h1>Welcome Buyer!</h1>
        <h2>Available Cars</h2>
        
        <!-- Dummy car data -->
        <%-- Dummy car data --%>
        <%
            String[] carImages = {
                "camary.jpeg", "accord.jpeg", "mustang.jpeg", "x5.jpeg", "a4.jpeg",
                "c-class.jpeg", "tesla.jpeg", "corvet.jpeg", "lexus.jpeg", "elantra.jpeg"
            };

            String[] carIds = {
                "1234", "5678", "91011", "121314", "151617",
                "181920", "212223", "242526", "272829", "303132"
            };

            String[] carModels = {
                "Toyota Camry", "Honda Accord", "Ford Mustang", "BMW X5", "Audi A4",
                "Mercedes-Benz C-Class", "Tesla Model 3", "Chevrolet Corvette", "Lexus RX", "Hyundai Elantra"
            };

            int[] carYears = {
                2018, 2019, 2020, 2017, 2016,
                2021, 2015, 2014, 2013, 2012
            };

            int[] carKilometers = {
                50000, 60000, 70000, 80000, 90000,
                10000, 40000, 30000, 20000, 110000
            };

            double[] carPrices = {
                20000.0, 25000.0, 30000.0, 35000.0, 40000.0,
                45000.0, 50000.0, 55000.0, 60000.0, 65000.0
            };
        %>

        <!-- Display list of cars -->
        <div class="car-list">
            <%
            	String id[] = {};
                for (int i = 0; i < 10; i++) {
            %>
            <div class="car">
                <img src="<%= carImages[i] %>" alt="Car Image">
                <div class="car-details">
                    <p><strong>ID:</strong> <%= carIds[i] %></p>
                    <p><strong>Model:</strong> <%= carModels[i] %></p>
                    <p><strong>Year:</strong> <%= carYears[i] %></p>
                    <p><strong>Kilometers Driven:</strong> <%= carKilometers[i] %> km</p>
                    <p><strong>Price:</strong> $<%= carPrices[i] %></p>
                    <button class="add-to-cart-btn">Add to Cart</button>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>
