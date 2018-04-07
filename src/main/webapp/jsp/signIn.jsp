<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign In</title>
    <link href="/css/formStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-6">
    <form method="post" action="signIn">
        <label for="login"> Login
            <input type="text" id="login" name="login">
        </label>
        <label for="password"> Password
            <input type="password" id="password" name="password">
        </label>
        <input type="submit" value="Sign In">
    </form>
    <a href="/signUp">Sign Up</a>
</div>
</body>
</html>
