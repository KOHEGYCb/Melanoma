<%-- 
    Document   : doctor
    Created on : 05.09.2018, 2:42:17
    Author     : dmitry
--%>

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
                        <td>№</td>
                        <td>FIO</td>
                        <td>AGE</td>
                        <td>SEX</td>
                        <td>NumFoto</td>
                    </tr>
                    <tr>
                        <td onclick="test(1)">1</td>
                        <td onclick="test(1)">Иванов Иван Иванович</td>
                        <td onclick="test(1)">16</td>
                        <td onclick="test(1)">Мужской</td>
                        <td onclick="test(1)">7</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Федоров Федор Федорович</td>
                        <td>32</td>
                        <td>Мужской</td>
                        <td>15</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Иванов Федор Иванович</td>
                        <td>64</td>
                        <td>Мужской</td>
                        <td>1</td>
                    </tr>
                    <%
                            ArrayList <User> users = UserDAO.INSTANCE.findAll();
                            for (int i = 0; i < users.size(); i++){
                        %>
                    <tr>
                        
                        <td onclick="test(<%=users.get(i).getId() %>)"><%=users.get(i).getId() %></td>
                        <td onclick="test(<%=users.get(i).getId() %>)"><%=users.get(i).getLogin() %></td>
                        <td onclick="test(<%=users.get(i).getId() %>)"><%=users.get(i).getRole() %></td>
                        <td onclick="test(<%=users.get(i).getId() %>)"><%=users.get(i).getId() %></td>
                        <td onclick="test(<%=users.get(i).getId() %>)"><%=users.get(i).getId() %></td>
                        
                        
                    </tr>
                    <%
                            }
                        %>
                </table>

            </div>
            <div id="free_pacient">table 2</div>
            <div id="all_pacient"></div>
            <div id="foto">table 3</div>
        </div>
        <div class="page" id="create">Create</div>
        <div class="page" id="profile">Profile</div>
        
