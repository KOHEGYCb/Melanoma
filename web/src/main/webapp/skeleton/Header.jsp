<%-- 
    Document   : Header
    Created on : 05.10.2018, 16:18:33
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.enums.Role"%>
<%@page import="by.bntu.dmitry.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <%
        //User user_ = (User) session.getAttribute("user");             // не создавать объект user, брать его только из сессии
        if ((User) session.getAttribute("user") != null) {
    %>
    <div class="info">Hello <%=((User) session.getAttribute("user")).getLogin()%></div>
    <div class="logo">M E L A N O M A - T E S T E D</div>
    <div class="logout">
        <form method="post">
            <input type="button" name="log_out" value="Log Out" onclick="logOut()">
        </form>
    </div>
    <%
        }
    %>
</div>
