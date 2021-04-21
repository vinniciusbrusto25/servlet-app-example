<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/main" var="linkMainServlet"></c:url>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
        <c:import url="logoutButton.jsp"></c:import>
        
        <form action="${linkMainServlet}" method="post">
            <label for="name">Name: </label>
            <input type="text" name="txtName" id="name" value="${company.name}">
            
            <label for="idDateEntry">Date entry: </label>
            <input type="text" name="txtDateEntry" id="idDateEntry" value="<fmt:formatDate value="${company.dateEntry}" pattern="dd/MM/yyyy"/>">
            
            <input type="hidden" name="txtIdCompny" value="${company.idCompany}">
            <input type="hidden" name="action" value="EditCompany">
            
            <input type="submit">
        </form>	
	</body>
</html>