<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to right, #74ebd5, #acb6e5);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            color: #333;
        }
        .registration-container {
            background: white;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            width: 100%;
            text-align: center;
        }
        .registration-container h2 {
            margin-bottom: 20px;
            font-size: 2.2rem;
            color: #007bff;
        }
        .registration-container input {
            width: calc(100% - 20px);
            padding: 15px;
            margin: 10px 0;
            border: 2px solid #007bff;
            border-radius: 5px;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }
        .registration-container input:focus {
            border-color: #0056b3;
            outline: none;
        }
        .registration-container button {
            width: 100%;
            padding: 15px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1.2rem;
            transition: background-color 0.3s;
        }
        .registration-container button:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            margin-top: 10px;
            font-weight: bold;
        }
        .success {
            color: green;
            margin-top: 10px;
            font-weight: bold;
        }
        .footer {
            margin-top: 20px;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>

<div class="registration-container">
    <h2>User Registration</h2>
    <form action="${pageContext.request.contextPath}/api/users" method="post">
        <input type="text" name="username" placeholder="Username" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Register</button>
    </form>

    <c:if test="${not empty param.success}">
        <div class="success">${param.success}</div>
    </c:if>

    <c:if test="${not empty param.error}">
        <div class="error">${param.error}</div>
    </c:if>

    <div class="footer">
        Already have an account? <a href="${pageContext.request.contextPath}/login" style="color: #007bff; text-decoration: none;">Login here</a>.
    </div>
</div>

</body>
</html>
