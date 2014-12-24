<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<jsp:include page="headerresp.jsp"/>


<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">


<div id="page-heading"><h1>Ajouter une session pour la Formation ${ formation.titre}</h1></div>


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
	
	 <form:form  modelAttribute="sessionf" method="post" action="${pageContext.request.contextPath}/${formation.id_formation}/session/add"
                      >
		<!-- start id-form -->
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
		<tr>
			<th  valign="top"><form:label path="date_debut" class="athf" > <spring:message code="label.session.date_debut"/> : </form:label></th>
            <td><form:input class="inp-form" id="datetimepicker"  path="date_debut" /> </td>
           
            <input id="datetimepicker" type="text" />
            
            <td><b class="req">*</b></td>			
			<td>
			<c:set var="ddError"><form:errors path="date_debut"/></c:set>
		    <c:if test="${not empty ddError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="date_debut"  /></div>
		    </c:if>
			</td>
		</tr>
		
		<tr>
			<th  valign="top"><form:label path="date_fin" class="athf" > <spring:message code="label.session.date_fin"/> : </form:label></th>
            <td><form:input class="inp-form" id="datetimepicker"  path="date_fin" /> </td>
            <td><b class="req">*</b></td>			
			<td>
			<c:set var="dfError"><form:errors path="date_fin"/></c:set>
		    <c:if test="${not empty dfError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="date_fin"  /></div>
		    </c:if>
			</td>
		</tr>
		
		<tr>
		
			<th valign="top"><form:label class="athf" path="formateur.id_u"><spring:message code="label.formateur"/> : </form:label></th>
            <td>
			<form:select class="styledselect_form_1" path="formateur.id_u">				    
							    <c:forEach var="f" items="${formateurs}">
							        <form:option value="${f.id_u}"> <c:out value="${f.nom} ${f.prenom}"/> </form:option>
							    </c:forEach>
			</form:select>
			</td>
			<td><b class="req">*</b></td>
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


<div id="content">

	<!--  start page-heading -->
	<div id="page-heading">
	<!-- ===============================================================here==================================== -->
		<h1>Liste des sessions de la formation ${ formation.titre}</h1>
	<!-- ===============================================================here==================================== -->
		
	</div>
	<!-- end page-heading -->
	
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
		<!--  start content-table-inner ...................................................................... START -->
		<div id="content-table-inner">
		
			


	<!-- ********************************************************************************* -->
				<!--  start table-content  -->
			<div id="table-content">
		
	<!--  start colla-table ..................................................................................... -->
				<form id="mainform" action="">
<!-- ############################################=here=############################################### -->
				<c:if test="${not empty formation.sessions}">
<!-- ############################################=END here=############################################### -->			
				<table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
				<tr>
<!-- ############################################=here=############################################### -->
					<th class="table-header-repeat line-left "><a href=""><spring:message code="label.session.date_debut"/></a>	</th>
					<th class="table-header-repeat line-left "><a href=""><spring:message code="label.session.date_fin"/></a></th>
					<th class="table-header-repeat line-left "><a href=""><spring:message code="label.inscription"/></a></th>
					
	
<!-- ############################################=END here=############################################### -->
					<th class="table-header-options line-left"><a href="">Options</a></th>
				</tr>	       
<!-- ############################################=here=############################################### -->
	             <c:forEach items="${formation.sessions}" var="session" >
	                <tr style="background-color: white; color: black; text-align: center;" height="40px">
	                    <td> ${session.date_debut}</td>
	                    <td> ${session.date_fin} </td>
	                    <td><a href="${pageContext.request.contextPath}/${session.id_session}/inscription/index" title="Inscription" class="icon-7 info-tooltip"></a></td>
	           
	                    <td class="options-width">
							<a href="${pageContext.request.contextPath}/${formation.id_formation}/session/update/${session.id_session}" title="<spring:message code="label.modifier"/>" class="icon-1 info-tooltip"></a>
							<a href="${pageContext.request.contextPath}/${formation.id_formation}/session/delete/${session.id_session}" title="<spring:message code="label.supprimer"/>" class="icon-2 info-tooltip"></a>
							
						</td>
	                    
	                </tr>
	            </c:forEach>
<!-- ############################################=END here=############################################### -->
	           </table>
	           </c:if>
				<!--  end product-table................................... --> 
				</form>
			</div>
			<!--  end content-table  -->
	<!-- ********************************************************************************* -->

						
			
        
       	<!--  start paging..................................................... -->
			<table border="0" cellpadding="0" cellspacing="0" id="paging-table">
			<tr>
			<td>
				<a href="" class="page-far-left"></a>
				<a href="" class="page-left"></a>
				<div id="page-info">Page <strong>1</strong> / 15</div>
				<a href="" class="page-right"></a>
				<a href="" class="page-far-right"></a>
			</td>
			<td>
			<select  class="styledselect_pages">
				<option value="">Number of rows</option>
				<option value="">1</option>
				<option value="">2</option>
				<option value="">3</option>
			</select>
			</td>
			</tr>
			</table>
			<!--  end paging................ -->
			
			<div class="clear"></div>
		 
		</div>
		<!--  end content-table-inner ............................................END  -->
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

<!--  end content-outer........................................................END -->

<jsp:include page="footer.jsp"/>
