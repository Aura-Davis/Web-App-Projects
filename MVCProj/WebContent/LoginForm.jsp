<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="style.css">
</head>

<header>
	<h1>Aura Sample Database Website</h1>
	</header>

<body>

	
	
	<form action="ValidateUser" method="post">
		<table>
			<tr>
				<td>Enter Username: </td>
				<td><input type="text" name="username" /></td>
			</tr>
			
			<tr>
				<td>Enter Password: </td>
				<td><input type="password" name="password" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Login" name="login"/></td>
				<td></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript" src="js/Jquery.jsp"></script>
	<script type="text/javascript" src="js/LoginJs.jsp"></script>
</body>
</html>