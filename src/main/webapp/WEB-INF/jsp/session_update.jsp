<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	
			<h2>Bienvenue  ${sessionScope['user']}  </h2>
                
        <h3><a href="<c:url value="/j_spring_security_logout" />">Déconnexion</a></h3>
        <hr/>
        
         <h3> veuillez saisir les nouvelles informations de la session de formation :  </h3>
         
        
        <form:form  modelAttribute="sessionf" method="post" action="${pageContext.request.contextPath}/${sessionf.formation.id_formation}/session/update/${sessionf.id_session}"
                    onsubmit="return  confirmDelete('${pageContext.request.contextPath}/${formation.id_formation}/session/update/${sessionf.id_session}')">
                    
                    <form:errors path="*" cssClass="errorblock" element="div" />
                    
            <table>
   
                <tr>
                    <td><form:label path="date_debut"> <spring:message code="label.session.date_debut"/> : </form:label></td>
                    <td><form:input path="date_debut" placeholder="yyyy-MM-dd" value="${sessionf.date_debut}"/></td>
                    <td><form:errors path="date_debut" cssClass="error" /></td>
                </tr>
                 <tr>
                    <td><form:label path="date_fin"> <spring:message code="label.session.date_fin"/> : </form:label></td>
                    <td><form:input path="date_fin" placeholder="yyyy-MM-dd"  value="${sessionf.date_fin}"/></td>
                    <td><form:errors path="date_fin" cssClass="error" /></td>
                </tr>                
            	 <tr>
	                 <td><form:label path="formateur.id_u"><spring:message code="label.formateur"/> : </form:label></td>
	                 <td>
	                    	<form:select path="formateur.id_u">				    
							    <c:forEach var="f" items="${formateurs}">
							        <form:option value="${f.id_u}"> <c:out value="${f.nom} ${f.prenom}"/> </form:option>
							    </c:forEach>
							</form:select>
							
						</td>
	                 </tr>
                
                
                <tr>
                    <td></td>
                    <td><input type="submit" value="valider" />
                    </td>
                </tr>
            </table>
        </form:form>
	
	</body>
	</html>