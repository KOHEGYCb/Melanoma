<%-- 
    Document   : user
    Created on : 05.09.2018, 2:42:08
    Author     : dmitry
--%>

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

    <div class="user_fotos_block" id="user_foto_tab"></div>
    <div class="user_fotos_block" id="user_new_foto_tab">
        <%@include file="CreateFotoForm.jsp" %>
    </div>
</div>