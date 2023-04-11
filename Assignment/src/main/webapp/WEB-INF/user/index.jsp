<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather Information System</title>
<script src="/static/js/validation.js"></script>
</head>
<body>
	<div align="center">
		<h2>Login Here to get Weather Information</h2>
		<form method="post" action="login">
			<table border="0" cellpadding="5">
				<tr>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /> <!-- onclick="ValidateEmail(document.form1.text1)" --> </td>
				</tr>
			</table>
		</form>
		<h3>
			<a href="new">New Registration</a>
		</h3>

	</div>
</body>
</html>