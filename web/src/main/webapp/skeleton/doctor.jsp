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
                <td>№</td>
                <td>FIO</td>
                <td>AGE</td>
                <td>Gender</td>
                <td>NumFoto</td>
            </tr>
            <%                ArrayList<User> doctorsUsers = UserDAO.INSTANCE.getEntitiesByDoctor((User) session.getAttribute("user"));
                for (int i = 0; i < doctorsUsers.size(); i++) {
            %>
            <tr>
                <td onclick="clickOnElement('loadUser', <%=doctorsUsers.get(i).getId()%>)"><%=(i + 1)%></td>
                <td onclick="clickOnElement('loadUser', <%=doctorsUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getStringFIO(doctorsUsers.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=doctorsUsers.get(i).getId()%>)"><%=doctorsUsers.get(i).getRole()%></td>
                <td onclick="clickOnElement('loadUser', <%=doctorsUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getUserGender(doctorsUsers.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=doctorsUsers.get(i).getId()%>)"><%=doctorsUsers.get(i).getId()%></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
    <div id="free_pacient">
        <table>
            <tr>
                <td>№</td>
                <td>FIO</td>
                <td>AGE</td>
                <td>Gender</td>
                <td>NumFoto</td>
            </tr>
            <%
                ArrayList<User> freeUsers = UserDAO.INSTANCE.getEntitiesWithoutDoctor();
                for (int i = 0; i < freeUsers.size(); i++) {
                    if (UserFormDAO.INSTANCE.getEntityByUser(freeUsers.get(i)) != null) {
            %>
            <tr>
                <td onclick="clickOnElement('loadUser', <%=freeUsers.get(i).getId()%>)"><%=(i + 1)%></td>
                <td onclick="clickOnElement('loadUser', <%=freeUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getStringFIO(freeUsers.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=freeUsers.get(i).getId()%>)"><%=freeUsers.get(i).getRole()%></td>
                <td onclick="clickOnElement('loadUser', <%=freeUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getUserGender(freeUsers.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=freeUsers.get(i).getId()%>)"><%=freeUsers.get(i).getId()%></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
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
                ArrayList<User> allPacients = UserDAO.INSTANCE.getAllPacients();
                for (int i = 0; i < allPacients.size(); i++) {
                    if (UserFormDAO.INSTANCE.getEntityByUser(allPacients.get(i)) != null) {
            %>
            <tr>
                <td onclick="clickOnElement('loadUser', <%=allPacients.get(i).getId()%>)"><%=(i + 1)%></td>
                <td onclick="clickOnElement('loadUser', <%=allPacients.get(i).getId()%>)"><%=UserServices.INSTANCE.getStringFIO(allPacients.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=allPacients.get(i).getId()%>)"><%=UserServices.INSTANCE.getUser_sDoctorFIO(allPacients.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=allPacients.get(i).getId()%>)"><%=allPacients.get(i).getRole()%></td>
                <td onclick="clickOnElement('loadUser', <%=allPacients.get(i).getId()%>)"><%=UserServices.INSTANCE.getUserGender(allPacients.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=allPacients.get(i).getId()%>)"><%=allPacients.get(i).getId()%></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
    <div id="foto">table 3</div>
</div>
<div class="page" id="create">
    <%@include file="CreateFakeUserForm.jsp" %>
</div>
<div class="page" id="profile">Profile</div>
<div class="page" id="pacient">
    <h1>Pacient</h1>
    <div id="element"></div>
    <div class="button" onclick="clickOnBackButton()">Back</div>
</div>

