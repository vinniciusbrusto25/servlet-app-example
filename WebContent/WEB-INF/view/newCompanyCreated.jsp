<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%--${ company } finds an attribute called company in the request--%>
		
		<c:if test="${not empty company}">
			<p>The company ${ company } was registered with success!</p>
		</c:if>
		
		<c:if test="${empty company}">
			<p>There is no one company to be created!</p>
		</c:if>
		
	</body>
</html>