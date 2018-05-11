<%@ page language="java" contentType="text/html;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- This tag below solved the problem of Spring java configuration cannot send the model to JSTL jsp page. -->
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="<c:url value="/resources/static/styles/styles.css" />" rel="stylesheet">
</head>

<body>
   <h1>Employees:</h1>
    <table class="employeesTbl">
	    <thead>
	    <tr>
	       <th>First Name</th>
	       <th>Last Name</th>
	       <th>Salary</th>
	    </tr>
	    </thead>
	    <tbody>
		    <c:forEach items="${employeesList}" var="element">
		       <tr>
		         <td>${element.firstName}</td>
		         <td>${element.lastName}</td>
		         <td>$ ${element.salary}</td>
		       </tr>
		    </c:forEach>
	    </tbody>
    </table>
</body>
</html>