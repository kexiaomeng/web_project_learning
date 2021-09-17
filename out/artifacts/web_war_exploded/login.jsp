<%--
  Created by IntelliJ IDEA.
  com.sun.tracy.User: kexia
  Date: 2020/1/3
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>

    <script>
        window.onload = function(){
            document.getElementById("img").onclick = function(){
                this.src="/checkCodeServlet?time=" + new Date().getTime();
            }


            document.getElementById("form").onsubmit = function(){
                this.src="/checkCodeServlet?time=" + new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: red;
        }

    </style>
</head>
<body>
    <form action="/loginServelet" method="post" id="form">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="userName"></td>
            </tr>

            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>

            <tr>
                <td>验证码</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td colspan="2"><img id="img" src="/checkCodeServlet"></td>
            </tr>
            <tr><td colspan="2"><input type="submit" value="提交"></td></tr>
        </table>
    </form>


    <div><%=request.getAttribute("cc_error") == null ? "" : request.getAttribute("cc_error")%></div>
    <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %></div>
</body>
</html>
