<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Recipe Book</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
        }

        header {
            background-color: #007bff;
            color: white;
            text-align: center;
            padding: 20px 0;
        }

        header h1 {
            margin: 0;
            font-size: 2.5em;
        }

        header p {
            margin: 10px 0 20px;
            font-size: 1.2em;
        }

        .container {
            width: 90%;
            margin: 20px auto;
        }

        h2 {
            color: #333;
            margin-top: 40px;
            border-bottom: 2px solid #007bff;
            padding-bottom: 10px;
        }

        .grid-container {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
            gap: 20px;
        }

        .card {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
            overflow: hidden;
            transition: transform 0.2s;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .card img {
            width: 100%;
            height: auto;
            border-bottom: 2px solid #007bff;
        }

        .card h3 {
            margin: 10px;
            font-size: 1.5em;
            color: #333;
            cursor: pointer; /* Make the title clickable */
        }

        .card p {
            margin: 10px;
            color: #555;
        }

        .add-recipe-button {
            background-color: #28a745;
            color: white;
            padding: 10px 15px;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s;
        }

        .add-recipe-button:hover {
            background-color: #218838;
        }

        footer {
            text-align: center;
            padding: 20px 0;
            background-color: #007bff;
            color: white;
            position: relative;
            bottom: 0;
            width: 100%;
        }
    </style>
</head>
<body>

<header>
    <h1>Welcome to Recipe Book</h1>
    <p>Your go-to place for delicious recipes!</p>
    <c:if test="${not empty sessionScope.user}">
        <p>Hello, ${sessionScope.user}!</p>
        <a href="/api/recipes/addRecipe" class="add-recipe-button">Add Recipe</a>
    </c:if>
</header>

<div class="container">
    <h2>Featured Recipes</h2>
    <div class="grid-container">
        <c:forEach var="recipe" items="${recipes}">
            <div class="card">
                <a href="/api/recipes/${recipe.id}"> <!-- Clickable image and title -->
                    <img src="${recipe.photos[0]}" alt="${recipe.title}"> <!-- Use the first photo -->
                    <h3>${recipe.title}</h3> <!-- Clickable title -->
                </a>
            </div>
        </c:forEach>
    </div>

    <h2>Recipe Categories</h2>
<div class="grid-container">
    <c:forEach var="category" items="${categories}">
        <div class="card">
            <h3>${category.name}</h3> <!-- Display category name without link -->
        </div>
    </c:forEach><h2>Recipe Categories</h2>
<div class="grid-container">
    <c:forEach var="category" items="${categories}">
        <div class="card">
            <a href="/api/recipes/category/${category.id}"> <!-- Link to the category recipes -->
                <h3>${category.name}</h3> <!-- Display category name -->
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
