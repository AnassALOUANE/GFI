<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="headeradmin.jsp"/>


<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">


<div id="page-heading"><h1>Ajouter Responsable Formation</h1></div>


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
	
	<form:form  modelAttribute="responsableformation" method="post"  action="${pageContext.request.contextPath}/users/resp_f/update/${responsableformation.id_u}">
		<!-- start id-form -->
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
		<tr>
			<th  valign="top"><form:label path="nom" class="athf" > <spring:message code="label.nom"/> : </form:label></th>
            <td><form:input class="inp-form" path="nom" /> </td>
            <td><b class="req">*</b></td>			
			<td>
			<c:set var="nomError"><form:errors path="nom"/></c:set>
		    <c:if test="${not empty nomError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="nom"  /></div>
		    </c:if>
			</td>
		</tr>
		<tr>
		
			<th valign="top"><form:label class="athf" path="prenom"><spring:message code="label.prenom"/> : </form:label></th>
            <td><form:input class="inp-form" path="prenom" /> </td>	
            <td><b class="req">*</b></td>		
			<td>
			<c:set var="prenomError"><form:errors path="prenom"/></c:set>
		    <c:if test="${not empty prenomError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="prenom"  /></div>
		    </c:if>
			</td>
		</tr>
		<tr>
		
			<th valign="top"><form:label class="athf" path="adresse"><spring:message code="label.adresse"/> : </form:label></th>
            <td><form:input class="inp-form" path="adresse" /> </td>
            <td><b class="req">*</b></td>			
			<td>
				<c:set var="adresseError"><form:errors path="adresse"/></c:set>
		    <c:if test="${not empty adresseError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="adresse"  /></div>
		    </c:if>
			</td>
		</tr>
		<tr>
		
			<th valign="top"><form:label class="athf" path="email"><spring:message code="label.email"/> : </form:label></th>
            <td><form:input class="inp-form" path="email" /> </td>	
            <td><b class="req">*</b></td>		
			<td>
			<c:set var="emailError"><form:errors path="email"/></c:set>
		    <c:if test="${not empty emailError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="email"  /></div>
		    </c:if>
			</td>
		</tr>
		<tr>
		 
			<th valign="top"><form:label class="athf" path="tel"><spring:message code="label.tel"/> : </form:label></th>
            <td><form:input class="inp-form" path="tel" /> </td>	
            <td><b class="req">*</b></td>		
			<td>
			<c:set var="telError"><form:errors path="tel"/></c:set>
		    <c:if test="${not empty telError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="tel"  /></div>
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
