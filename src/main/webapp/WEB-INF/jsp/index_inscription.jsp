<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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

	<c:choose>
		<c:when test="${not empty collaborateurs}">  
		      
	        <h3> veuillez selectionner les collaborateurs que vous voulez inscrire dans cette session de formation :  </h3>
	
	        <form method="post" action="${pageContext.request.contextPath}/${session.id_session}/inscription/add"
	                    onsubmit="return  confirmDelete('${pageContext.request.contextPath}/${formation.id_formation}/session/add')">
	                    
	                    <p> ${errors} </p>
	                    
	            <table>
	            
	   				<tr style="background-color: teal; color: white; text-align: center;" height="40px">
		                <th><spring:message code="label.nom"/></th>
		                <th><spring:message code="label.prenom"/></th>
						<th><spring:message code="label.inscription"/></th>  
		            </tr>
		            
				<c:forEach items="${collaborateurs}" var="c" varStatus="status">
	                <tr style="background-color: white; color: black; text-align: center;" height="40px">
	                    <td> ${c.nom} </td>
	                    <td> ${c.prenom}  </td>
	                    <td>  
	                     <input type="checkbox" name="checkBox_collaborateurs" value="${c.id_u}"> inscrire <br>
	                    </td>
	                </tr>
	                                
		          </c:forEach>
	
	                <tr>
	                    <td></td>
	                    <td><input type="submit" value="inscrire collaborateurs" />
	                    </td>
	                </tr>
	            </table>
	        </form>  
	        
	    </c:when>
	    
		<c:otherwise>
			<h3 style="color:red;"> Tous les collaborateurs sont inscrit dans cette session de formation, Merci</h3>
		</c:otherwise>
		
	</c:choose>  
	      
        
         <h1> #############  Test  Inscription ############# </h1>
         <h2> ${session.formation.titre}, durée :   ${session.date_debut} et ${session.date_fin}  </h2>
         <h2> formateur :  ${session.formateur.nom} ${session.formateur.prenom}  </h2>
		 <c:if test="${not empty session.inscriptions}">
	        <table border="1" style=" margin:0px auto; width:60%;">
	            <tr style="background-color: teal; color: white; text-align: center;" height="40px">
	                <th><spring:message code="label.collaborateur"/></th>
	                <th><spring:message code="label.inscription.confirmer"/></th>
	                
	            </tr>
	            <c:forEach items="${session.inscriptions}" var="insc" >
	                <tr style="background-color: white; color: black; text-align: center;" height="40px">
	                    <td> ${insc.collaborateur.nom} ${insc.collaborateur.prenom}</td>
	                    <c:choose>
						    <c:when test="${insc.confirmer}">
						       	 <td>  oui </td>
						    </c:when>
						    <c:otherwise>
						      <td> non </td>
						    </c:otherwise>
						</c:choose>
	           	       	                   
	                </tr>
	            </c:forEach>
	            
	        </table><br />
        </c:if>
               
			
	</body>
</html>