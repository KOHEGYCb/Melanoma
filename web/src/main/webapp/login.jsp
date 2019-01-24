<%-- 
    Document   : login
    Created on : 05.09.2018, 2:29:43
    Author     : dmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="reg">
    <form id="login"  method="post" name="loginForm">
        <span>Логин: </span><input type="text" value="${login}" name="login" /><br/>
        <span>Пароль: </span><input type="password" value="" name="password" /><br/>
        <input type="button" value="Войти" name="log_in" onclick="logIn(1)"/>
        <input type="button" value="Зарегистрироваться" name ="sign_in" onclick="logIn(2)"/>
    </form>
    <span id="#err" class="error">${a}</span>
</div>
<script>

    function logme() {

        var data = {
            log_in: document.loginForm.log_in.value,
            sign_in: document.loginForm.sign_in.value,
            login: document.loginForm.login.value,
            password: document.loginForm.password.value
        };
        
        alert(data.log_in);
        alert(data.sign_in);
        alert(data.login);
        alert(data.password);
        
        var s = window.location.href;
        
        $.ajax({
            type: "POST",
            url: "login",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (response) {
                alert(response);
            }
        });
    }


</script>