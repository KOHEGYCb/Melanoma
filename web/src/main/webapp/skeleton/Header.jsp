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
    <div class="info">Hello, <%=str%></div>
    <div class="logo">M E L A B A S E</div>
    <div class="" id="settings">
        <div class="settings_btn" id="settings_btn" onclick="toogleSettings()"></div>
        <div class="" id="settings_panel">
            <div class="list" id="set_lang">
                <span>Language</span>
                <!--<div id="lang_prev" onclick="changeLang(-1)"></div>-->
                <div class="lang" id="lang_ru" onclick="changeLang(1)">RU</div>
                <div class="lang" id="lang_en" onclick="changeLang(0)">EN</div>
                <!--<div id="lang_next" onclick="changeLang(1)"></div>-->
            </div>
        </div>
    </div>
    <div class="logout">
        <form method="post">
            <input type="button" name="log_out" value="Log Out" onclick="logOut()">
        </form>
    </div>
    <%
        }
    %>
</div>
