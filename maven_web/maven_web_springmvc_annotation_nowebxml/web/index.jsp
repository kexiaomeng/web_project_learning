<%--
  Created by IntelliJ IDEA.
  User: kexia
  Date: 2021/1/19
  Time: 1:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <base href="http://localhost:8080/nowebxml/" />
    <title>$Title$</title>
  </head>
  <body>
  111
  <a href="hello/h1">get请求</a>

  <%--<a href="${pageContext.request.contextPath}/hello/h1">get请求</a>--%>
  <a href="hello/h3">post请求</a>


  <form action="datadeal/h2" method="post">

    <input type="text" id="username" name="name" placeholder="请输入用户名">
    <span id="s_username"></span>
    <br>
    <input type="text" name="age" placeholder="请输入密码"><br>
    <input type="submit" value="注册"><br>

  </form>


  <form action="hello/h2" method="post">

    <input type="text"  name="username" placeholder="请输入用户名">
    <br>
    <input type="text" name="age" placeholder="请输入密码"><br>
    <input type="submit" value="注册"><br>

  </form>
  </body>
</html>
