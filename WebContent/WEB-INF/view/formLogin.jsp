<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/main" var="linkMainServlet"></c:url>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
        <form action="${linkMainServlet}" method="post">
            <label for="login">Login: </label>
            <input type="text" name="txtLogin" id="login">
            
            <label for="passwd">Password: </label>
            <input type="password" name="txtPassword" id="passwd">
            
            <input type="hidden" name="action" value="Login">
            <input type="submit">
        </form>	
	</body>
</html>