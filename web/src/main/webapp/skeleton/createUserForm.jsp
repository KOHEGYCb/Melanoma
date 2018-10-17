<%-- 
    Document   : createUserForm
    Created on : Oct 16, 2018, 7:11:04 PM
    Author     : Dmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="createUserForm">
    <h3>Please, write your information</h3>
    <form action="createUserForm" method="Post">
        <span>Name: </span>         <input type="text"/>
        <span>Surname: </span>      <input type="text"/>
        <span>Patronymic: </span>   <input type="text"/>
        <span>Birthday: </span>     <input type="date"/>
        <span>Sex: </span>
        <div>
            <select size="1">
                <option>Male</option>
                <option>Female</option>
            </select>
        </div>
        <br>
        <input type="submit" name="createUserForm" value="Save info" />
    </form>
</div>
