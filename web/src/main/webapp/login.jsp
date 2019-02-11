<%-- 
    Document   : login
    Created on : 05.09.2018, 2:29:43
    Author     : dmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="reg">
    <div class="login_lang">
        <div class="lang_btn" id="lang_ru" onclick="changeLang(1)"><span>RU</span></div>
        <div class="lang_btn" id="lang_en" onclick="changeLang(0)"><span>EN</span></div>
    </div>
    <form id="login"  method="post" name="loginForm">
        <span>Login: </span><input type="text" value="${login}" name="login" /><br/>
        <span>Password: </span><input type="password" value="" name="password" /><br/>
        <input type="button" value="Log in" name="log_in" onclick="logIn(1)"/>
        <input type="button" value="Sign in" name ="sign_in" onclick="logIn(2)"/>
    </form>
    <span id="#err" class="error">${a}</span>
</div>