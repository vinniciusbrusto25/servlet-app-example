<%@ page import="br.com.servletappexample.model.Company"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/main?action=ViewCompany&id=" var="linkViewCompany"></c:url>
<c:url value="/main?action=RemoveCompany&id=" var="linkRemoveCompany"></c:url>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>List of companies</title>
	</head>
	<body>
		<p>User: ${userLogged.login} </p>
		
		<c:if test="${not empty company}">
			<p>The company ${ company } was registered with success!</p>
		</c:if>
	
		<p>List of companies:</p>
		<br><br>
		<ul>
			<c:forEach items="${listOfCompanies}" var="countCompany">
				<li>
					${countCompany.name} - <fmt:formatDate value="${countCompany.dateEntry}" pattern="dd/MM/yyyy"/>
					<a href="${linkViewCompany}${countCompany.idCompany}">Edit</a>
					<a href="${linkRemoveCompany}${countCompany.idCompany}">Remove</a>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>