<%-- 
    Document   : CreateFakeUserForm
    Created on : Nov 16, 2018, 1:15:49 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="createUserForm">
    <h3>Please, write your information</h3>
    <form name="createUserForm" method="Post">
        <span>Name: </span>         <input type="text" name="name"        value="${name}"/>
        <span>Surname: </span>      <input type="text" name="surname"     value="${surname}"/>
        <span>Patronymic: </span>   <input type="text" name="patronymic"  value="${patronymic}"/>
        <span>Birthday: </span>     <input type="date" name="birthday"    value="${birthday}"/>
        <span>Gender: </span>
        <div>
            <select size="1"  name="gender" value="${gender}">
                <option name="male">Male</option>
                <option name="female">Female</option>
            </select>
        </div>
        <br>
        <input type="button" name="createUserForm" value="Save info" onclick="createFakeUserF()"/>
    </form>
</div>
