<%-- 
    Document   : login
    Created on : 05.09.2018, 2:29:43
    Author     : dmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="reg">
    <form id="login" action="login" method="post">
        <span>Login: </span><input type="text" value="" name="login" /><br/>
        <span>Password: </span><input type="text" value="" name="password" /><br/>
        <input type="submit" value="Log In" name="log_in"/>
        <input type="submit" value="Sign In" name ="sign_in"/>
    </form>
    <span id="#err" class="error">${a}</span>
</div>