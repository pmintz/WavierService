<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>

<form id="loginForm" action="Login" method="POST">
	<h1>Log In</h1>
	<input type="text" name="username" placeholder="Username" required><br>
	<input type="password" name="password" placeholder ="Password" required><br>
	<input type="submit" value="Login"><br>
	${errorMessage}
</form>
</body>
</html>