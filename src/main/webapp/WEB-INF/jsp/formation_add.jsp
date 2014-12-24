<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="headerresp.jsp"/>


<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">


<div id="page-heading"><h1>Ajouter Formation</h1></div>


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
	
	<form:form  modelAttribute="formation" method="post" action="${pageContext.request.contextPath}/formation/add">
		<!-- start id-form -->
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
		<tr>
			<th  valign="top"><form:label path="titre" class="athf" > <spring:message code="label.formation.titre"/> : </form:label></th>
            <td><form:input class="inp-form" path="titre" /> </td>
            <td><b class="req">*</b></td>			
			<td>
			<c:set var="titreError"><form:errors path="titre"/></c:set>
		    <c:if test="${not empty titreError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="titre"  /></div>
		    </c:if>
			</td>
		</tr>
		<tr>
		
			<th valign="top"><form:label class="athf" path="desc"><spring:message code="label.formation.desc"/> : </form:label></th>
            <td><form:input class="inp-form" path="desc" /> </td>	
            <td><b class="req">*</b></td>		
			<td>
			<c:set var="descError"><form:errors path="desc"/></c:set>
		    <c:if test="${not empty descError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="prenom"  /></div>
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
