<%-- 
    Document   : body
    Created on : 05.09.2018, 2:34:15
    Author     : dmitry
--%>

<%@page import="by.bntu.dmitry.dao.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="by.bntu.dmitry.entities.User"%>
<%@page import="by.bntu.dmitry.enums.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    User user = (User) session.getAttribute("user");
    if (user != null) {
        switch (user.getRole()) {
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
        <%@include file="login.jsp" %>
        <%
    }
%>
<script>
            
            function test (a){
                alert(a);
            }
            
        </script>
        
        