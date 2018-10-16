<%-- 
    Document   : Header
    Created on : 05.10.2018, 16:18:33
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="header">
    <%
    User user_ = (User) session.getAttribute("user");
    if (user_ != null){
    %>
            <div class="info">Hello <%=user_.getLogin() %></div>
            <div class="logo">M E L A N O M A</div>
            <div class="logout">
                <form action="logout" method="post">
                    <input type="submit" name="log_out" value="Log Out">
                </form>
            </div>
    <%
        }
    %>
        </div>
