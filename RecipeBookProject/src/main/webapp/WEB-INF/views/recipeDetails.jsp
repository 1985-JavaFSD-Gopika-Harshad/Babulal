<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${recipe.title}</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f8f9fa;
            color: #333;
        }
        h1 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 20px;
        }
        img {
            max-width: 100%;
            height: auto;
            display: block;
            margin: 0 auto 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        p {
            font-size: 1.1em;
            line-height: 1.6;
            margin: 10px 0;
        }
        strong {
            color: #e74c3c;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            background: #ecf0f1;
            margin: 5px 0;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        ol {
            margin: 20px 0;
            padding-left: 20px;
        }
        footer {
            text-align: center;
            margin-top: 20px;
            font-size: 0.9em;
            color: #7f8c8d;
        }
    </style>
</head>
<body>
<h1>${recipe.title}</h1>
<img src="${recipe.photos[0]}" alt="${recipe.title}">
<p><strong>Cuisine:</strong> ${recipe.cuisine}</p>
<p><strong>Meal Type:</strong> ${recipe.mealType}</p>
<p><strong>Description:</strong> ${recipe.description}</p>
<p><strong>Ingredients:</strong></p>
<ul>
    <c:forEach var="ingredient" items="${recipe.ingredients}">
        <li>${ingredient}</li>
    </c:forEach>
</ul>
<p><strong>Instructions:</strong></p>
<ol>
    <c:forEach var="step" items="${recipe.instructions}">
        <li>${step}</li>
    </c:forEach>
</ol>
<p><strong>Rating:</strong> ${recipe.rating}</p>
<footer>
    <p>Recipe created with love!</p>
</footer>
</body>
</html>
