<%-- 
    Document   : user
    Created on : 05.09.2018, 2:42:08
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.dao.FotoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="by.bntu.dmitry.entities.Foto"%>
<%@page import="by.bntu.dmitry.entities.UserForm"%>
<%@page import="by.bntu.dmitry.dao.UserFormDAO"%>
<%@page import="by.bntu.dmitry.entities.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>    

<div class="menu">
    <ul>
        <li><a href="#foto">Fotos</a></li>
    </ul>
</div>
<div class="page" id="foto">
    <input type="radio" name="inset" value="" id="user_fotos" checked>
    <label for="user_fotos">My fotos</label>
    <input type="radio" name="inset" value="" id="user_new_foto">
    <label for="user_new_foto">Add new foto</label>

    <div class="user_fotos_block" id="user_foto_tab">
        <div id="gallery">
            <div id="place"></div>
            <%  ArrayList<Foto> fotos = FotoDAO.INSTANCE.getEntityByUser((User) session.getAttribute("user"));
                for (int i = 0; i < fotos.size(); i++) {
            %>
            <div class="element">
                <img src="http://192.168.222.22:8084/web/images/dir/<%= fotos.get(i).getDirectory()%>" onclick="loadImageInfo(<%= fotos.get(i).getId()%>)">
            </div>
            <%
                }
            %>
        </div>
    </div>
    <div class="user_fotos_block" id="user_new_foto_tab">
        <%@include file="CreateFotoForm.jsp" %>
    </div>
</div>
<div class="page" id="curent_foto">
    <h1>Foto's parameters</h1>
    <div id="bl1"></div>
    <div onclick="loadImageInfo(-1)">Back</div>
</div>