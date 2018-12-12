<%-- 
    Document   : user
    Created on : 05.09.2018, 2:42:08
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.services.logsServices.ParseResultsServices"%>
<%@page import="by.bntu.dmitry.entities.Result"%>
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
        <li><a href="#foto">Фотографии</a></li>
    </ul>
</div>
<div class="page" id="foto">
    <input type="radio" name="inset" value="" id="user_fotos" checked>
    <label for="user_fotos">Мои фотографии</label>
    <input type="radio" name="inset" value="" id="user_new_foto">
    <label for="user_new_foto">Добавить фотографию</label>

    <div class="user_fotos_block" id="user_foto_tab">
        <div id="gallery">
            <div id="place"></div>
            <%  ArrayList<Foto> fotos = FotoDAO.INSTANCE.getEntitiesByUser((User) session.getAttribute("user"));
                for (int i = 0; i < fotos.size(); i++) {
                    Result result = ParseResultsServices.getResult(fotos.get(i));
                    if (result == null) {
            %>
            <div class="element">
                <img id="image_<%= fotos.get(i).getId() %>" src="http://80.94.168.91:8080/melanoma/images/dir/<%= fotos.get(i).getDirectory()%>" onclick="clickOnElement('loadFoto', <%= fotos.get(i).getId()%>)">
            </div>
            <%
                    } else {
            %>
            <div class="element">
                <img id="image_<%= fotos.get(i).getId() %>" class="done" src="http://80.94.168.91:8080/melanoma/images/dir/<%= fotos.get(i).getDirectory()%>" onclick="clickOnElement('loadFoto', <%= fotos.get(i).getId()%>)">
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
    <div class="user_fotos_block" id="user_new_foto_tab">
        <%@include file="CreateFotoForm.jsp" %>
    </div>
</div>
<div class="page" id="curent_foto">
    <h1>Параметры фотографии</h1>
    <div id="element"></div>
    <div class="button" onclick="clickOnBackButton()">Назад</div>
</div>