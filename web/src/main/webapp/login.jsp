<%-- 
    Document   : login
    Created on : 05.09.2018, 2:29:43
    Author     : dmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="reg">
    <form id="login"  method="post" name="loginForm">
        <span>Login: </span><input type="text" value="${login}" name="login" /><br/>
        <span>Password: </span><input type="password" value="" name="password" /><br/>
        <input type="button" value="Log In" name="log_in" onclick="logIn(1)"/>
        <input type="button" value="Sign In" name ="sign_in" onclick="logIn(2)"/>
    </form>
    <span id="#err" class="error">${a}</span>
</div>