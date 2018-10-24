<%-- 
    Document   : admin
    Created on : 05.09.2018, 2:42:24
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.dao.LogsDAO"%>
<%@page import="by.bntu.dmitry.entities.Logs"%>
<%@page import="by.bntu.dmitry.services.logsServices.UserServices"%>
<%@page import="by.bntu.dmitry.dao.UserFormDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="by.bntu.dmitry.dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="Header.jsp" %>    

<div class="menu">
    <ul>
        <li><a href="#logs">Logs</a></li>
        <li><a href="#users">User table</a></li>
    </ul>
</div>

<div class="page" id="logs">
    <table>
            <tr>
                <td>№</td>
                <td>FIO</td>
                <td>Role</td>
                <td>Date</td>
                <td>Action</td>
            </tr>
            <%                
                ArrayList<Logs> allLogs = LogsDAO.INSTANCE.findAll();
                for (int i = 0; i < allLogs.size(); i++) {
                   
            %>
                <td><%=i%></td>
                <td><%=UserServices.INSTANCE.getStringFIO(allLogs.get(i).getUser())%></td>
                <td><%=allLogs.get(i).getUser().getRole() %></td>
                <td><%=allLogs.get(i).getDate() %></td>
                <td><%=allLogs.get(i).getAction() %></td>
            <%
                    
                }
            %>
        </table>
</div>
<div class="page" id="users">
    <div id="all_pacient">
        <table>
            <tr>
                <td>№</td>
                <td>FIO</td>
                <td>Doctor</td>
                <td>AGE</td>
                <td>Gender</td>
                <td>NumFoto</td>
            </tr>
            <%                
                ArrayList<User> allUsers = UserDAO.INSTANCE.findAll();
                for (int i = 0; i < allUsers.size(); i++) {
                    if (UserFormDAO.INSTANCE.getEntityByUser(allUsers.get(i)) != null) {
            %>
                <td onclick="test(<%=allUsers.get(i).getId()%>)"><%=i%></td>
                <td onclick="test(<%=allUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getStringFIO(allUsers.get(i))%></td>
                <td onclick="test(<%=allUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getUser_sDoctorFIO(allUsers.get(i))%></td>
                <td onclick="test(<%=allUsers.get(i).getId()%>)"><%=allUsers.get(i).getRole()%></td>
                <td onclick="test(<%=allUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getUserGender(allUsers.get(i))%></td>
                <td onclick="test(<%=allUsers.get(i).getId()%>)"><%=allUsers.get(i).getId()%></td>
            <%
                    }
                }
            %>
        </table>
    </div>
