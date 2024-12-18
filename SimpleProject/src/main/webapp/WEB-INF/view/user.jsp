<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="/api/user/create" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required /><br/>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required /><br/>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required /><br/>

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName" required /><br/>

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName" required /><br/>

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required /><br/>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" required /><br/>

        <input type="submit" value="Register" />
    </form>
</body>
</html>
