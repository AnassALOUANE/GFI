<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value="/css/validator.css" />" rel="stylesheet">
        <link href="<c:url value="/css/genaral.css" />" rel="stylesheet">
        <script src="<c:url value="/js/confirmation.js" />"></script>
        <title> <spring:message code="label.title"/> </title>
	</head>
	<body>
<%-- 	 <a href="${pageContext.request.contextPath}/{idInsc}/confirmation_insc/{idC}/confirm"></a> --%>
	
		<p> Monsieur, ${collaborateur.nom} ${collaborateur.prenom} </p>
		 <p> ${msg_confirm} </p> <br/>
		 
		 <p> merci pour votre réponse.	</p>
			
	
	</body>
</html>