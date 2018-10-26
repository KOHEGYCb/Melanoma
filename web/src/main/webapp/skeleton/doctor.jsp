<%-- 
    Document   : doctor
    Created on : 05.09.2018, 2:42:17
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.dao.UserFormDAO"%>
<%@page import="by.bntu.dmitry.services.logsServices.UserServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="by.bntu.dmitry.entities.User"%>
<%@page import="by.bntu.dmitry.dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="Header.jsp" %>    

<div class="menu">
    <ul>
        <li><a href="#profile">Profile</a></li>
        <li><a href="#create">Create user</a></li>
        <li><a href="#tables">Check tables</a></li>
    </ul>
</div>
<div class="page" id="tables">
    <input type="radio" name="inset" value="" id="tab_my_pacient" checked>
    <label for="tab_my_pacient">My pacients</label>
    <input type="radio" name="inset" value="" id="tab_free_pacient">
    <label for="tab_free_pacient">Free pacients</label>
    <input type="radio" name="inset" value="" id="tab_all_pacient">
    <label for="tab_all_pacient">All pacients</label>
    <input type="radio" name="inset" value="" id="tab_foto">
    <label for="tab_foto">Fotos</label>

    <div id="my_pacient">
        <table>
            <tr>
                <td onclick="pushMe()">№</td>
                <td>FIO</td>
                <td>AGE</td>
                <td>Gender</td>
                <td>NumFoto</td>
            </tr>
        </table>
    </div>
    <div id="foto">table 3</div>
</div>
<div class="page" id="create">Create</div>
<div class="page" id="profile">Profile</div>
<div class="page" id="pacient">
    Pacient
    <div onclick="pushMe()">Back</div>
</div>


<script>
    function pushMe() {

        var s = window.location.href;
//        location.replace(s.substr(0,s.indexOf("#")+1) + "pacient"); 
//        alert(s.substr(s.indexOf("#")));
        if (s.substr(s.indexOf("#")) ===  "#tables"){
            window.location.href = "#pacient";
        }else{
            window.location.href = "#tables";
        }
        
    }
</script>

