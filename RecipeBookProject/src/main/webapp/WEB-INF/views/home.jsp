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
            cursor: pointer; /* Indicate it's clickable */
        }
        .card img {
            width: 100%;
            height: 200px; /* Set a fixed height for uniformity */
            object-fit: cover; /* Maintain aspect ratio while covering the space */
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
    <h1>Welcome to Gourmet Guide !!</h1>
    <p>Your go-to place for delicious recipes!</p>
    <c:if test="${not empty sessionScope.user}">
        <p>Hello, ${sessionScope.user}!</p>
    </c:if>
</header>

<div class="container">
    <h2>Featured Recipes</h2>
    <div class="grid-container">
        <div class="card">
            <a href="/login">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKmAY4hlgX5xDgeyoB7iQ_jR9yjBo4bcYIxg&s" alt="Recipe 1">
                <h3>Spaghetti Carbonara</h3>
            </a>
        </div>
        <div class="card">
            <a href="/login">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSE_jxW7GIhqQ5V_bI-IGjkGeFhIBjHOsPuUg&s" alt="Recipe 2">
                <h3>Chicken Tikka Masala</h3>
            </a>
        </div>
        <div class="card">
            <a href="/login">
                <img src="https://images.themodernproper.com/billowy-turkey/production/posts/VegetableStirFry_9.jpg?w=1200&q=82&auto=format&fit=crop&dm=1703377301&s=27a8577bc7f666190301a03fdf06584c" alt="Recipe 3">
                <h3>Vegetable Stir Fry</h3>
            </a>
        </div>
        <div class="card">
            <a href="/login">
                <img src="https://sallysbakingaddiction.com/wp-content/uploads/2013/04/triple-chocolate-cake-4.jpg" alt="Recipe 4">
                <h3>Chocolate Cake</h3>
            </a>
        </div>
    </div>

    <h2>Recipe Categories</h2>
    <div class="grid-container">
        <div class="card">
            <a href="/login">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUvsKaj3T9QM2Vew6zplc6l6psaaS3v5trfg&s" alt="Category 1">
                <h3>Vegetarian</h3>
            </a>
        </div>
        <div class="card">
            <a href="/login">
                <img src="https://cdn.loveandlemons.com/wp-content/uploads/2021/06/summer-desserts.jpg" alt="Category 2">
                <h3>Desserts</h3>
            </a>
        </div>
        <div class="card">
            <a href="/login">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ645AOjMNWzCr1Ep8JbaMZuHXhIn0GV1abdA&s" alt="Category 3">
                <h3>Italian</h3>
            </a>
        </div>
        <div class="card">
            <a href="/login">
                <img src="https://www.seriouseats.com/thmb/hNRbkk73__n9bqJru8k1F7IsI6I=/390x260/filters:no_upscale():max_bytes(150000):strip_icc()/20210909-SAMOSAS-ANDREWJANJIGIAN-90-04d516f897f94a608d85fde225e54d55.jpg" alt="Category 4">
                <h3>Asian</h3>
            </a>
        </div>
    </div>
</div>

<footer>
    <p>&copy; 2024 Recipe Book. All Rights Reserved.</p>
</footer>

</body>
</html>
