<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <p>
	  <a href="/mySpringMvcTestProj/accounts/add">Add New Account</a>
	  <a href="/mySpringMvcTestProj/">Home</a>
	</p>
	<br/>
	<h3>Accounts Details:</h3>
	<hr size="4" color="gray" />
	<table>
	    <tr>
	       <th>Account Id</th>
	       <th>Username</th>
	       <th>Password</th>
	    </tr>
		<c:forEach items="${accounts}" var="account">
			<tr>
				<td><c:out value="${account.id}" /></td>
				<td><c:out value="${account.username}" /></td>
				<td><c:out value="${account.password}" /></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>