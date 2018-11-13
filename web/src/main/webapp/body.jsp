<%-- 
    Document   : body
    Created on : 05.09.2018, 2:34:15
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.dao.UserFormDAO"%>
<%@page import="by.bntu.dmitry.dao.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="by.bntu.dmitry.entities.User"%>
<%@page import="by.bntu.dmitry.enums.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<div id="preloader"></div>-->
<%
   // User user = ((User) session.getAttribute("user"));                  // не создавать объект user, брать его только из сессии
   // User user = new User("login", "Password", Role.ADMIN, false, false);
    if (((User) session.getAttribute("user")) != null) {
        System.out.println("\n\nUser: " + ((User) session.getAttribute("user")) + "\n\n");
        if (UserFormDAO.INSTANCE.getEntityByUser(((User) session.getAttribute("user"))) != null){
            switch (((User) session.getAttribute("user")).getRole()) {
                case ADMIN:
                    %>
                    <%@include file="skeleton/admin.jsp" %>
                    <%
                    break;
                case DOCTOR:
                    %>
                    <%@include file="skeleton/doctor.jsp" %>
                    <%
                    break;
                case USER:
                    %>
                    <%@include file="skeleton/user.jsp" %>
                    <%
                    break;
            }
        }else{
            %>
            <%@include file="skeleton/createUserForm.jsp" %>
            <%
        }
    }else{
        %>
        <%@include file="login.jsp" %>
        <%
    }
%>
        
        