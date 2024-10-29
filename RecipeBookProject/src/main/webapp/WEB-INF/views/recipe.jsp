<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Recipes</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        header {
            background-color: #4CAF50;
            color: white;
            padding: 10px 0;
            text-align: center;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        .grid-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
            gap: 20px;
            margin: 20px 0;
        }
        .card {
            background: white;
            border-radius: 5px;
            overflow: hidden;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            text-align: center;
            cursor: pointer;
        }
        .card img {
            width: 100%;
            height: 200px; 
            object-fit: cover;
        }
        .card h3 {
            margin: 10px 0;
        }
        footer {
            background-color: #4CAF50;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: relative;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

<header>
    <h1>All Recipes</h1>
</header>

<div class="container">
    <h2>Featured Recipes</h2>
    <div class="grid-container">
        <c:forEach var="recipe" items="${recipe}">
            <div class="card">
                <a href="/recipe"> <!-- Adjust link based on your routing -->
                    <img src="${recipe.imageUrl}" alt="${recipe.title}">
                    <h3>${recipe.title}</h3>
                </a>
            </div>
        </c:forEach>
    </div>
</div>

<footer>
    <p>&copy; 2024 Recipe Book. All Rights Reserved.</p>
</footer>

</body>
</html>
