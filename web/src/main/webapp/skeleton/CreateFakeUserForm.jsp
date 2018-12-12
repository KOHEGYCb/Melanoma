<%-- 
    Document   : CreateFakeUserForm
    Created on : Nov 16, 2018, 1:15:49 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="createUserForm">
    <h3>Пожалуйста, заполните следующие поля</h3>
    <form name="createUserForm" method="Post">
        <span>Имя: </span>         <input type="text" name="name"        value="${name}"/>
        <span>Фамилия: </span>      <input type="text" name="surname"     value="${surname}"/>
        <span>Отчество: </span>   <input type="text" name="patronymic"  value="${patronymic}"/>
        <span>Дата рождения: </span>     <input type="date" name="birthday"    value="${birthday}" onclick="setMaxDate()" id="foto_date"  min='1899-01-01' max='2000-01-01' placeholder="YYYY-MM-DD" data-date-split-input="true" required />
        <span>Пол: </span>
        <div>
            <select size="1"  name="gender" value="${gender}">
                <option name="male">Мужской</option>
                <option name="female">Женский</option>
            </select>
        </div>
        <br>
        <input type="button" name="createUserForm" value="Сохранить" onclick="createFakeUserF()"/>
    </form>
</div>
