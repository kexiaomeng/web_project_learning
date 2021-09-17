<%--
  Created by IntelliJ IDEA.
  com.sun.tracy.User: kexia
  Date: 2020/1/7
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>el表达式获取域对象中的值</title>
</head>
<body>
    <%
        request.setAttribute("name","张三");
        session.setAttribute("name","cuixi");
    %>

    <h3>el获取值</h3>
    ${ requestScope.name}<br>l
    ${ sessionScope.name}<br>

</body>
</html>
