<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	
		<h1> Modifier les actions d'un profile   </h1>
        
        <form:form  modelAttribute="action" method="post" action="${pageContext.request.contextPath}/action/update/${action.id_action}"
                    onsubmit="return  confirmDelete('${pageContext.request.contextPath}/action/update/${action.id_action}')">
           
            <form:errors path="*" cssClass="errorblock" element="div" />
           
            <table width="600" height="150px">
                <tr>
                    <td><form:label path="libelle"> <spring:message code="label.action.libelle"/> : </form:label></td>
                    <td>
                    	<form:select path="libelle">
						   <form:option value="" label="--- ACTION ---"/>
						   <form:options items="${actions}" />
						</form:select>
                    </td>
                     <td><form:errors path="libelle" cssClass="error" /></td>
                </tr>
                
                <tr>
                    <td><form:label path="profile"> <spring:message code="label.profile"/> : </form:label></td>
                    <td>
                    	<form:select path="profile">
						   <form:option value="" label="--- PROFILE ---"/>
						   <form:options items="${profiles}" itemValue="id_profile" itemLabel="titre" />
						</form:select>
                    </td>
                    <td><form:errors path="profile" cssClass="error" /></td>
                </tr>
                
                <tr>
                    <td><form:label path="desc"> <spring:message code="label.action.desc"/> : </form:label></td>
                    <td><form:textarea path="desc"  value="${action.desc}" rows="5" cols="30" /></td>
                    <td><form:errors path="desc" cssClass="error" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="attribuer l'action au profile" />
                    </td>
                </tr>
            </table>
        </form:form>
	
	</body>
</html>