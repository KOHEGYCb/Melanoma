<%-- 
    Document   : footer
    Created on : 05.09.2018, 2:30:45
    Author     : dmitry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script>
    translatePage();
    switch (cur_lang) {
        case 0:
            document.getElementById('lang_en').classList.add("lang_current");
            break;
        case 1:
            document.getElementById('lang_ru').classList.add("lang_current");
            break;
    }
</script>
    </body>
</html>
