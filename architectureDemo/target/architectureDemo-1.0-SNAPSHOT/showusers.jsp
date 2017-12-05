<%-- 
    Document   : showusers
    Created on : Dec 4, 2017, 6:53:58 PM
    Author     : tha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, entity.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% List<User> users = (List<User>)session.getAttribute("users");%>
        <h3>List of users:</h3>
        <% for(User user: users){
            out.print(user.getName()+"<br/>");%><br/><%
        }%>
    </body>
</html>
