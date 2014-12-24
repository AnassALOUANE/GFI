<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="headeradmin.jsp"/>


<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">


<div id="page-heading"><h1>Modifier Compte</h1></div>


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
	
	<form:form  modelAttribute="compte" method="post" action="${pageContext.request.contextPath}/compte/update/${compte.id_compte}">
		<!-- start id-form -->
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
		<tr>
             <th valign="top"><form:label class="athf" path="utilisateur.id_u"><spring:message code="label.utilisateur"/> : </form:label></th>               	
             <td>  ${compte.utilisateur.nom} ${compte.utilisateur.prenom}</td>
        </tr>
        <tr>
             <th valign="top"><form:label class="athf" path="utilisateur.profile.titre"><spring:message code="label.profile"/> : </form:label></th>               	
             <td>  ${compte.utilisateur.profile.titre}</td>
        </tr>
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
            <form:radiobutton path="active"  value="1" /> OUI
			<form:radiobutton path="active" value="0"/> NON 
			</td>	
            <td><b class="req">*</b></td>		
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
