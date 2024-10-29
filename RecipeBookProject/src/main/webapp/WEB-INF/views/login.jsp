<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-image: url('https://img.freepik.com/free-photo/ingredients-cabbage-carrot-pie-cabbage-carrots-eggs-flour-milk-butter-spices-white-background_127032-2819.jpg?t=st=1729936025~exp=1729939625~hmac=1ef5080e1cab1d43ca869f3a8c895e990b5303541387531df4bb8f3c63fc7d85&w=996');
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: #fff;
        }
        .login-container {
            background: rgba(255, 255, 255, 0.9);
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            width: 400px;
            text-align: center;
        }
        .login-container h2 {
            margin-bottom: 20px;
            font-size: 2.5rem;
            color: #333;
        }
        .login-container p {
            margin-bottom: 30px;
            font-size: 1.2rem;
            font-weight: bold;
            color: #6a11cb;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
        }
        .login-container input {
            width: calc(100% - 20px);
            padding: 15px;
            margin: 10px 0;
            border: 2px solid #007bff;
            border-radius: 5px;
            font-size: 1rem;
            transition: border-color 0.3s;
            box-sizing: border-box;
        }
        .login-container input:focus {
            border-color: #6a11cb;
            outline: none;
        }
        .login-container button {
            width: 100%;
            padding: 15px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1.2rem;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .login-container button:hover {
            background-color: #0056b3;
        }
        .register-button {
            margin-top: 15px;
            background-color: #28a745;
        }
        .register-button:hover {
            background-color: #218838;
        }
        @media (max-width: 480px) {
            .login-container {
                width: 90%;
                padding: 20px;
            }
            .login-container h2 {
                font-size: 2rem;
            }
            .login-container p {
                font-size: 1rem;
            }
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <p>Please log in before exploring our delicious recipes!</p>
    <form action="/api/users/login" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
    <button class="register-button" onclick="location.href='${pageContext.request.contextPath}/register'">Register</button>
</div>
</body>
</html>
