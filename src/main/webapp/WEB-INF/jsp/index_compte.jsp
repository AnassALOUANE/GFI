     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
     <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
    
		<jsp:include page="headeradmin.jsp"/>	
 
         
<!-- start content-outer ........................................................................................................................START -->
<div id="content-outer">
<!-- start content -->
<div id="content">

	<!--  start page-heading -->
	<div id="page-heading">
	<!-- ===============================================================here==================================== -->
		<h1>Compte</h1>
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
		
			<!--  start table-content  -->
			<div id="table-content">
			

			

		
	<!--  start colla-table ..................................................................................... -->
				<form id="mainform" action="">
<!-- ############################################=here=############################################### -->
				<c:if test="${not empty comptes}">
<!-- ############################################=END here=############################################### -->			
				<table border="0" width="100%" cellpadding="0" cellspacing="0" id="product-table">
				<tr>
<!-- ############################################=here=############################################### -->
					<th class="table-header-repeat line-left "><a href=""><spring:message code="label.compte.login"/></a>	</th>
					<th class="table-header-repeat line-left "><a href=""><spring:message code="label.compte.password"/></a></th>
					<th class="table-header-repeat line-left"><a href=""><spring:message code="label.compte.active"/></a></th>
					<th class="table-header-repeat line-left"><a href=""><spring:message code="label.nom"/></a></th>
					<th class="table-header-repeat line-left"><a href=""><spring:message code="label.profile"/></a></th>
<!-- ############################################=END here=############################################### -->
					<th class="table-header-options line-left"><a href="">Options</a></th>
				</tr>	       
<!-- ############################################=here=############################################### -->
	            <c:forEach items="${comptes}" var="compte" >
	                <tr style="background-color: white; color: black; text-align: center;" height="40px">
	                    <td>${compte.login}</td>
	                    <td> ${compte.password} </td>
	                    <td> ${compte.active} </td>
	                    <td> ${compte.utilisateur.nom} ${compte.utilisateur.prenom}  </td>
	                    <td> ${compte.utilisateur.profile.titre}  </td>
	                    <td class="options-width">
						<a href="${pageContext.request.contextPath}/compte/update/${compte.id_compte}" title="<spring:message code="label.modifier"/>" class="icon-1 info-tooltip"></a>
						<a href="${pageContext.request.contextPath}/compte/delete/${compte.id_compte}" title="<spring:message code="label.supprimer"/>" class="icon-2 info-tooltip"></a>
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
			
						<!--  start actions-box ............................................... -->
			<div id="actions-box">
				
<!-- ############################################=here=############################################### -->
					<a href="${pageContext.request.contextPath}/compte/add"><img src="<c:url value="/images/table/adduser.png"/>" /></a>
<!-- ############################################=END here=############################################### -->
				
				<div class="clear"></div>
			</div>
			<!-- end actions-box........... -->
        
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
</div>
<!--  end content-outer........................................................END -->

<jsp:include page="footer.jsp"/>