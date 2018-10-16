<%-- 
    Document   : header
    Created on : 05.09.2018, 2:30:37
    Author     : dmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet/less" type="text/css" href="css/styles.less" />
        <script src="less.js" type="text/javascript"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            $(document).on("submit", "#login", function (event){
                var $form = $(this);
                $form.
                $.post($form.attr("action"), $form.serialize(), function (response){
                    $("#err").text(response)
                });
//                $.get("someservlet", function (text){
//                    $("#somediv").text(text);
//                });
                
            });
        </script>
        <title>JSP Page</title>
    </head>
    <body>