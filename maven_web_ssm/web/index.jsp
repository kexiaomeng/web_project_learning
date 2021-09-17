<%--
  Created by IntelliJ IDEA.
  User: kexia
  Date: 2021/1/20
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SSM整合例子</title>
    <script src="jquery/jquery-3.3.1.js"></script>
  </head>
  <body>
    <div align="center">
      <table>
        <tr>
          <td>浏览用户</td>
          <td>添加用户</td>
        </tr>
        <tr>
          <td><a href="${pageContext.request.contextPath}/queryUser.jsp">浏览用户</a></td>
          <td><a href="${pageContext.request.contextPath}/user/addUser.do">添加用户</a></td>
        </tr>
      </table>
    </div>

  </body>
</html>
