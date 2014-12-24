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
	
		<h2>Bienvenue ${sessionScope['user']} 
<%--          <security:authentication property="name" />  --%>
         </h2>
	
		<h3><a href="<c:url value="/j_spring_security_logout" />">Logout</a><h3>
        
         <h1> #############  Test Assigner profiles à des actions ############# </h1>
		 <c:if test="${not empty actions}">
	        <table border="1">
	            <tr style="background-color: teal; color: white; text-align: center;" height="40px">
	                <th><spring:message code="label.action.libelle"/></th>
	                <th><spring:message code="label.profile"/></th>
	                <th><spring:message code="label.action.desc"/></th>
	                <th><spring:message code="label.modifier"/></th>
	                <th><spring:message code="label.supprimer"/></th>
	                
	            </tr>
	            <c:forEach items="${actions}" var="a" >
	                <tr style="background-color: white; color: black; text-align: center;" height="40px">
	                    <td>${a.libelle}</td>
	                    <td> ${a.profile.titre} </td>
	                    <td> ${a.desc} </td>
	                    <td><a href="${pageContext.request.contextPath}/action/update/${a.id_action}"><spring:message code="label.modifier"/></a></td>
	                    <td><a href="${pageContext.request.contextPath}/action/delete/${a.id_action}" onclick="return  confirmDelete(this, '${pageContext.request.contextPath}/action/delete/${a.id_action}')"> <spring:message code="label.supprimer"/></a></td>
<%-- 	               	onclick="return  confirmDelete(this, '${pageContext.request.contextPath}/users/c/delete/${c.id_u}')" --%>
	                </tr>
	            </c:forEach>
	            
	        </table><br />
        </c:if>
               <h3> <a href="${pageContext.request.contextPath}/action/add"> <spring:message code="label.ajouter"/> </a> </h3>
	
	</body>
</html>