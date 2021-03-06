<%--
  Created by IntelliJ IDEA.
  User: kexia
  Date: 2020/1/11
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>


       function delete1(id){
           if(confirm("您确定要删除吗？")){
               location.href="${pageContext.request.contextPath}/deleteServelet?id="+id;
           }
       }

       function find(id,name) {
           location.href="${pageContext.request.contextPath}/findServelet?id="+id;

       }


       window.onload = function () {
            document.getElementById("deleteSelected").onclick = function () {
                if (confirm("是否删除选中的数据？")) {
                    var ids = document.getElementsByName("uid");
                    var flag = false;
                    for (var i = 0; i < ids.length; i++) {
                        if (ids[i].checked) {
                            flag = true;
                            break;
                        }

                    }
                    if (flag) {
                        document.getElementById("fff").submit();
                    }
                }

            }

           document.getElementById("firstCb").onclick = function () {
               var ids = document.getElementsByName("uid");
               for (var i = 0; i < ids.length; i++) {
                    ids[i].checked = this.checked;
               }
           }
       }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;">

        <form class="form-inline" action="${pageContext.request.contextPath}/pageServelet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">姓名</label>
                <input type="text" class="form-control" name="name" value="${requestScope.condition.name[0]}" id="exampleInputName2" >
            </div>
            <div class="form-group">
                <label for="exampleInputName3">籍贯</label>
                <input type="text" class="form-control" name="address"  value="${requestScope.condition.address[0]}" id="exampleInputName3" >
            </div>

            <div class="form-group">
                <label for="exampleInputEmail2">邮箱</label>
                <input type="email" class="form-control" name="email" value="${requestScope.condition.email[0]}" id="exampleInputEmail2"  >
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="deleteSelected">删除选中</a>

    </div>
    <form id="fff" action="${pageContext.request.contextPath}/deleteSelectServelet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <td><input type="checkbox" id="firstCb"></td>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${requestScope.pageMsg.msgs}" var="user" varStatus="s">

                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.address}</td>
                    <td>${user.qq}</td>
                    <td>${user.email}</td>
                    <td></td>
                    <td><a id="modify" class="btn btn-default btn-sm" href="javascript:find(${user.id});">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:delete1(${user.id});">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="${pageContext.request.contextPath}/pageServelet?currentPage=${requestScope.pageMsg.currentPage-1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin = "1" var="i" end="${requestScope.pageMsg.totalPage}">
                    <c:if test="${requestScope.pageMsg.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/pageServelet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${requestScope.pageMsg.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/pageServelet?currentPage=${i}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>

                <li>
                    <a href="${pageContext.request.contextPath}/pageServelet?currentPage=${requestScope.pageMsg.currentPage + 1}&rows=5&name=${condition.name[0]}&address=${condition.address[0]}&email=${condition.email[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
                    共${requestScope.pageMsg.totalCount}条记录，共${requestScope.pageMsg.totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>



