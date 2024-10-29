<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Recipe</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f8f9fa;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input[type="text"], textarea, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type="submit"] {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
        footer {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>

<header>
    <h1>Add a New Recipe</h1>
</header>

<div class="container">
    <form action="/api/recipes/create" method="post">
        <input type="hidden" name="userId" value="${sessionScope.userId}"> <!-- Correctly reference userId -->

        <label for="title">Title:</label>
        <input type="text" name="title" required>

        <label for="description">Description:</label>
        <textarea name="description" required></textarea>

        <label for="cuisine">Cuisine:</label>
        <input type="text" name="cuisine">

        <label for="mealType">Meal Type:</label>
        <input type="text" name="mealType">

        <label for="ingredients">Ingredients (comma-separated):</label>
        <input type="text" name="ingredients" required>

        <label for="instructions">Instructions:</label>
        <textarea name="instructions" required></textarea>

        <label for="photos">Photos (comma-separated URLs):</label>
        <input type="text" name="photos">

        <label for="categoryId">Category:</label>
<select name="categoryId" required>
    <c:choose>
        <c:when test="${empty categories}">
            <option value="">No categories available</option>
        </c:when>
        <c:otherwise>
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</select>

        <input type="submit" value="Add Recipe">
    </form>
</div>

<footer>
    <p>&copy; 2024 Recipe Book. All Rights Reserved.</p>
</footer>

</body>
</html>
