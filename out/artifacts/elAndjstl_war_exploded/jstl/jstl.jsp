<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sun.tracy.User" %>

<%--
  Created by IntelliJ IDEA.
  com.sun.tracy.User: kexia
  Date: 2020/1/8
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl</title>
</head>
<body>
    <%--
        c:if标签
            1. 属性：test必须 标识是否显示里面的内容
            一般情况下结合sl表达式一起使用
    --%>
    <c:if test="">
        i am true;
    </c:if>


    <%
        List list = new ArrayList();
        list.add(new User("孙萌","18","nanjing"));
        list.add(new User("崔希","20","武汉"));


        request.setAttribute("list",list);
        request.setAttribute("number",3);
        request.setAttribute("week",2);



    %>

    <c:if test="${requestScope.number % 2 !=0}">

        奇数
    </c:if>

    <c:choose>
        <c:when test="${requestScope.week == 1}">
            星期一
        </c:when>
        <c:when test="${requestScope.week == 2}">
            星期二
        </c:when>
        <c:otherwise >
            错误
        </c:otherwise>
    </c:choose>


    <table align="center" border="solid red 1px">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>地址</th>
        </tr>
        <c:forEach items="${requestScope.list}" var="user" varStatus="status">
            <tr>
                <td>${pageScope.status.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.addr}</td>

            </tr>

        </c:forEach>
    </table>



</body>
</html>
