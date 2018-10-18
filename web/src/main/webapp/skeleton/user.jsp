<%-- 
    Document   : user
    Created on : 05.09.2018, 2:42:08
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.entities.UserForm"%>
<%@page import="by.bntu.dmitry.dao.UserFormDAO"%>
<%@page import="by.bntu.dmitry.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <%
        UserForm uf = UserFormDAO.INSTANCE.getEntityByUser((User) session.getAttribute("user"));
    %>
    
    <div class="info">Hello <%= uf.getName() %></div>
    <div class="logo">M E L A N O M A</div>
    <div class="logout">
        <form action="logout" method="post">
            <input type="submit" name="log_out" value="Log Out">
        </form>
    </div>  
</div>