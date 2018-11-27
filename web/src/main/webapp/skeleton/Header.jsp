<%-- 
    Document   : Header
    Created on : 05.10.2018, 16:18:33
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.entities.UserForm"%>
<%@page import="by.bntu.dmitry.dao.UserFormDAO"%>
<%@page import="by.bntu.dmitry.enums.Role"%>
<%@page import="by.bntu.dmitry.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <%
        //User user_ = (User) session.getAttribute("user");             // не создавать объект user, брать его только из сессии
        if ((User) session.getAttribute("user") != null) {
            UserForm uf = UserFormDAO.INSTANCE.getEntityByUser((User) session.getAttribute("user"));
            String str = "";
            if (!uf.getPatronymic().equals("")) {
                str = uf.getSurname() + " " + uf.getName().charAt(0) + ". " + uf.getPatronymic().charAt(0) + ".";
            } else {
                str = uf.getSurname() + " " + uf.getName().charAt(0) + ".";
            }
    %>
    <div class="info">Hello <%=str%></div>
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
