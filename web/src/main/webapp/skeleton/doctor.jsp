<%-- 
    Document   : doctor
    Created on : 05.09.2018, 2:42:17
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.dao.FotoDAO"%>
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
                <td>Full name</td>
                <td>Age</td>
                <td>Gender</td>
                <td>Number of photos</td>
            </tr>
            <%                ArrayList<User> doctorsUsers = UserDAO.INSTANCE.getEntitiesByDoctor((User) session.getAttribute("user"));
                for (int i = 0; i < doctorsUsers.size(); i++) {
            %>
            <tr>
                <td onclick="clickOnElement('loadUser', <%=doctorsUsers.get(i).getId()%>)"><%=(i + 1)%></td>
                <td onclick="clickOnElement('loadUser', <%=doctorsUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getStringFIO(doctorsUsers.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=doctorsUsers.get(i).getId()%>)"><%=UserFormDAO.INSTANCE.getEntityByUser(doctorsUsers.get(i)).getBirthday()%></td>
                <td onclick="clickOnElement('loadUser', <%=doctorsUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getUserGender(doctorsUsers.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=doctorsUsers.get(i).getId()%>)"><%=FotoDAO.INSTANCE.getAmountByUserId(doctorsUsers.get(i))%></td>
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
                <td>Full name</td>
                <td>Age</td>
                <td>Gender</td>
                <td>Number of photos</td>
            </tr>
            <%
                ArrayList<User> freeUsers = UserDAO.INSTANCE.getEntitiesWithoutDoctor();
                for (int i = 0; i < freeUsers.size(); i++) {
                    if (UserFormDAO.INSTANCE.getEntityByUser(freeUsers.get(i)) != null) {
            %>
            <tr>
                <td onclick="clickOnElement('loadUser', <%=freeUsers.get(i).getId()%>)"><%=(i + 1)%></td>
                <td onclick="clickOnElement('loadUser', <%=freeUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getStringFIO(freeUsers.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=freeUsers.get(i).getId()%>)"><%=UserFormDAO.INSTANCE.getEntityByUser(freeUsers.get(i)).getBirthday()%></td>
                <td onclick="clickOnElement('loadUser', <%=freeUsers.get(i).getId()%>)"><%=UserServices.INSTANCE.getUserGender(freeUsers.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=freeUsers.get(i).getId()%>)"><%=FotoDAO.INSTANCE.getAmountByUserId(freeUsers.get(i))%></td>
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
                <td>Full name</td>
                <td>Doctor</td>
                <td>Age</td>
                <td>Gender</td>
                <td>Number of photos</td>
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
                <td onclick="clickOnElement('loadUser', <%=allPacients.get(i).getId()%>)"><%=UserFormDAO.INSTANCE.getEntityByUser(allPacients.get(i)).getBirthday()%></td>
                <td onclick="clickOnElement('loadUser', <%=allPacients.get(i).getId()%>)"><%=UserServices.INSTANCE.getUserGender(allPacients.get(i))%></td>
                <td onclick="clickOnElement('loadUser', <%=allPacients.get(i).getId()%>)"><%=FotoDAO.INSTANCE.getAmountByUserId(allPacients.get(i))%></td>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </div>
    <div id="foto">
    
            <div id="gallery">
            <div id="place"></div>
            <%  ArrayList<Foto> all_foto = FotoDAO.INSTANCE.findAll();
                for (int i = 0; i < all_foto.size(); i++) {
                    Result result = ParseResultsServices.getResult(all_foto.get(i));
                    if (result == null) {
            %>
            <div class="element">
                <img id="image_<%= all_foto.get(i).getId() %>" src="http://192.168.221.79:8084/web/images/dir/<%= all_foto.get(i).getDirectory()%>" onclick="clickOnElement('loadFoto', <%= all_foto.get(i).getId()%>)">
            </div>
            <%
                    } else {
            %>
            <div class="element">
                <img id="image_<%= all_foto.get(i).getId() %>" class="done" src="http://192.168.221.79:8084/web/images/dir/<%= all_foto.get(i).getDirectory()%>" onclick="clickOnElement('loadFoto', <%= all_foto.get(i).getId()%>)">
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
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
<div class="page" id="curent_foto">
    <h1>Foto's parameters</h1>
    <div id="element"></div>
    <div class="button" onclick="clickOnBackButton()">Back</div>
</div>
