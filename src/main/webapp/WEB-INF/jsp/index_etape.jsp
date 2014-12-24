<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="headerresp.jsp"/>


<!-- start content-outer -->
<div id="content-outer">
<!-- start content -->
<div id="content">


<div id="page-heading"><h1>Ajouter une étape pour la Formation ${ formation.titre}</h1></div>


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
	
	 <form:form  modelAttribute="etape" method="post" action="${pageContext.request.contextPath}/${formation.id_formation}/etape/add"
                      >
		<!-- start id-form -->
		<table border="0" cellpadding="0" cellspacing="0"  id="id-form">
		<tr>
			<th  valign="top"><form:label path="libelle" class="athf" > <spring:message code="label.etape.libelle"/> : </form:label></th>
            <td><form:input class="inp-form" path="libelle" /> </td>
            <td><b class="req">*</b></td>			
			<td>
			<c:set var="mError"><form:errors path="libelle"/></c:set>
		    <c:if test="${not empty mError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="libelle"  /></div>
		    </c:if>
			</td>
		</tr>
		
		<tr>
		
			<th valign="top"><form:label class="athf" path="desc"><spring:message code="label.etape.desc"/> : </form:label></th>
            <td><form:textarea  class="form-textarea" path="desc" rows="5" cols="30" /></td>			
			<td>
				<c:set var="descError"><form:errors path="desc"/></c:set>
		    <c:if test="${not empty descError}">
		    	<div class="error-left"></div>
				<div class="error-inner"><form:errors path="desc"  /></div>
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


<div id="content">

	<!--  start page-heading -->
	<div id="page-heading">
	<!-- ===============================================================here==================================== -->
		<h1>Liste des étapes de la formation ${ formation.titre}</h1>
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
				<c:if test="${not empty formation.etapes}">
<!-- ############################################=END here=############################################### -->			
				<table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
				<tr>
<!-- ############################################=here=############################################### -->
					<th class="table-header-repeat line-left "><a href=""><spring:message code="label.etape.libelle"/></a>	</th>
					<th class="table-header-repeat line-left "><a href=""><spring:message code="label.etape.desc"/></a></th>
					
	
<!-- ############################################=END here=############################################### -->
					<th class="table-header-options line-left"><a href="">Options</a></th>
				</tr>	       
<!-- ############################################=here=############################################### -->
	             <c:forEach items="${formation.etapes}" var="etape" >
	                <tr style="background-color: white; color: black; text-align: center;" height="40px">
	                    <td> ${etape.libelle}</td>
	                    <td> ${etape.desc} </td>
	                    
	           
	                    <td class="options-width">
						<a href="${pageContext.request.contextPath}/${formation.id_formation}/etape/update/${etape.id_etape}" title="<spring:message code="label.modifier"/>" class="icon-1 info-tooltip"></a>
						<a href="${pageContext.request.contextPath}/${formation.id_formation}/etape/delete/${etape.id_etape}" title="<spring:message code="label.supprimer"/>" class="icon-2 info-tooltip"></a>
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
