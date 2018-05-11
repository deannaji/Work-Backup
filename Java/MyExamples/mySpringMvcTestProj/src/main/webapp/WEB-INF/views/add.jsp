<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <p>
    <a href="/mySpringMvcTestProj/">Home</a>
  </p>
  <br/>
  <form name="form1" action="/mySpringMvcTestProj/accounts/add" method="post">
     <input type="text" name="id"/><br/><br/>
     <input type="text" name="username"/><br/><br/>
     <input type="text" name="password"/><br/><br/><br/>
     <input type="submit" name="submitButton"/>
  </form>
</body>
</html>