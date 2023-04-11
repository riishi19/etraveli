<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Weather Information System</title>
</head>
<body>
	<div align="center">
		<h2>User Home Page</h2>
		<form:form method="get" action="logout" modelAttribute="user">

			<input type="submit" value="Logout" />

			<h3>Your Details</h3>
			<table border="1" cellpadding="5">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>E-mail</th>
					<th>Address</th>
					<th>Age</th>
					<th>Mobile</th>
					<th>Edit City</th>
				</tr>
				<tr>
					<td>${user.userid}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.address}</td>
					<td>${user.age}</td>
					<td>${user.mobile}</td>
					<td><a href="edit?userid=1">Pune</a></td>

				</tr>
				<c:forEach items="${user}" var="user">
					<tr>
						<td>${user.userid}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>${user.address}</td>
						<td>${user.age}</td>
						<td>${user.mobile}</td>
						<td><a href="edit?city=${user.city}">${user.city}</a></td>

					</tr>
				</c:forEach>
				<tr>
					<td>hello <c:forEach items="${map}" var="entry" varStatus="i">hi
                    <c:set var="editedfieldkey" value="${entry.key}New" />
							<tr>
								<td>has -- ${entry.key}</td>


								<c:forEach items="${entry.value}" var="user" varStatus="j">
									<c:if test="${user ne null }">
										<td>Value: ${user}
										<td>
										<td>Edited Value ${map[editedfieldkey][j.index]}</td>
									</c:if>
								</c:forEach>
							</tr>
						</c:forEach>
					</td>

				</tr>




				<!-- <c:forEach items="${list}" var="map">
				<tr>
					<c:forEach items="${map}" var="entry">

						<td>${entry.value}</td>

					</c:forEach>
				</tr>
			</c:forEach>-->

			</table>
		</form:form>
	</div>
</body>
</html>