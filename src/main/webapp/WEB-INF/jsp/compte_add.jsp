<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="headeradmin.jsp"/>


<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">


<div id="page-heading"><h1>Ajouter Compte</h1></div>


<table border="0" width="100%" cellpadding="0" cellspacing="0" id="content-table">
<tr>
	<th rowspan="3" class="sized"><img src="<c:url value="/images/shared/side_shadowleft.jpg"/>" width="20" height="300" alt="" /></th>
	<th class="topleft"></th>
	<td id="tbl-border-top">&nbsp;</td>
	<th class="topright"></th>
	<th rowspan="3" class="sized"><img src="<c:url value="/images/shared/side_shadowright.jpg"/>" width="20" height="300" alt="" /></th>
</tr>
<tr>
	<td id="tbl-border-left"></td>
	<td>
	<!--  start content-table-inner -->
	<div id="content-table-inner">
	
	<table border="0" width="100%" cellpadding="0" cellspacing="0">
	<tr valign="top">
	<td>
	<c:choose>
		<c:when test="${not empty utilisateurs}">
	<form:form  modelAttribute="compte" method="post" action="${pageContext.request.contextPath}/compte/add">
		<!-- start id-form -->
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
		<tr>
               <th valign="top"><form:label class="athf" path="utilisateur.id_u"><spring:message code="label.utilisateur"/> : </form:label></th>
                  <td>
                    	<form:select class="styledselect_form_1" path="utilisateur.id_u">
						   <c:forEach var="user" items="${utilisateurs}">
							        <form:option value="${user.id_u}"> <c:out value="${user.nom} ${user.prenom}"/> </form:option>
						   </c:forEach>
						</form:select>
						
                   </td>
                   <td><b class="req">*</b></td>
                    <td>
					<c:set var="utilisateurError"><form:errors path="utilisateur.id_u"/></c:set>
				    <c:if test="${not empty utilisateurError}">
				    	<div class="error-left"></div>
						<div class="error-inner"><form:errors path="utilisateur.id_u"  /></div>
				    </c:if>
					</td>
                </tr>
		<tr>
		<tr>
		
			<th valign="top"><form:label class="athf" path="login"><spring:message code="label.compte.login"/> : </form:label></th>
            <td><form:input class="inp-form" path="login" /> </td>	
            <td><b class="req">*</b></td>		
			<td>
			<c:set var="loginError"><form:errors path="login"/></c:set>
		    <c:if test="${not empty loginError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="login"  /></div>
		    </c:if>
			</td>
		</tr>
		<tr>
		
			<th valign="top"><form:label class="athf" path="password"><spring:message code="label.compte.password"/> : </form:label></th>
            <td><form:password class="inp-form" path="password" /> </td>
            <td><b class="req">*</b></td>			
			<td>
				<c:set var="passwordError"><form:errors path="password"/></c:set>
		    <c:if test="${not empty passwordError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="password"  /></div>
		    </c:if>
			</td>
		</tr>
		<tr>
		
			<th valign="top"><form:label class="athf" path="active"><spring:message code="label.compte.active"/> : </form:label></th>
            <td>
            <form:select class="styledselect_form_1" path="active">
            <form:option value="1">OUI</form:option>
            <form:option value="0">NON</form:option>
            </form:select>
			</td>	
            <td></td>		
			<td>
			<c:set var="activeError"><form:errors path="active"/></c:set>
		    <c:if test="${not empty activeError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="active"  /></div>
		    </c:if>
			</td>
		</tr>
				

	<tr>
		<th>&nbsp;</th>
		<td valign="top">
			<input type="submit" value="" class="form-submit" />
			<input type="reset" value="" class="form-reset"  />
		</td>
		<td></td>
	</tr>
	</table>
	</form:form>
	<!-- end id-form  -->
	
	</c:when>
	
		<c:otherwise>
		<!--  start message-yellow -->
				<div id="message-yellow">
				<table border="0" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<td class="yellow-left">Tout les utilisateurs ont un compte associé. veuillez<a href="${pageContext.request.contextPath}/users/c/index"> crée une nouveau utilisateur.</a></td>
					<td class="yellow-right"><a class="close-yellow"><img src="<c:url value="/images/table/icon_close_yellow.gif" />"  alt="" /></a></td>
				</tr>
				</table>
				</div>
		<!--  end message-yellow -->			
		</c:otherwise>
	</c:choose>
	

	</td>
	<td>


</tr>
<tr>
<td><img src="<c:url value="/images/shared/blank.gif"/>" width="695" height="1" alt="blank" /></td>
<td></td>
</tr>
</table>
 
<div class="clear"></div>
 

</div>
<!--  end content-table-inner  -->
</td>
<td id="tbl-border-right"></td>
</tr>
<tr>
	<th class="sized bottomleft"></th>
	<td id="tbl-border-bottom">&nbsp;</td>
	<th class="sized bottomright"></th>
</tr>
</table>

<div class="clear">&nbsp;</div>

</div>
<!--  end content -->
<div class="clear">&nbsp;</div>
</div>
<!--  end content-outer -->

 

<div class="clear">&nbsp;</div>


<jsp:include page="footer.jsp"/>
