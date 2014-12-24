<%-- 
    Document   : index
    Created on : 14 nov. 2014, 21:08:59
    Author     : karim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> ####################   Welcome : ${user}   ################# </h1>
        <table border="1">
            <tr style="background-color: teal; color: white; text-align: center;" height="40px">
                <th>nom</th>
                <th>prenom</th>
                <th>adress</th>
                <th>email</th>
                <th>telephone</th>
                <th></th>
                <th> </th>
                
            </tr>
            <c:forEach items="${utilisateurs}" var="u">
                <tr style="background-color: white; color: black; text-align: center;" height="40px">
                    <td>${u.nom}</td>
                    <td>${u.prenom}</td>
                    <td>${u.adresse}</td>
                    <td>${u.email}</td>
                    <td>${u.tel}</td>
                    <td><a href="edit?id=${u.id_u}">Edit</a></td>
                    <td><a href="delete?id=${u.id_u}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
     </body>
</html>
