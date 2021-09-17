<%--
  Created by IntelliJ IDEA.
  User: kexia
  Date: 2021/1/21
  Time: 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询userajax</title>
    <script src="jquery/jquery-3.3.1.js"></script>
    <script>    
        $(function () {
            loaduser()
            $("#loaddata").click(function () {
                loaduser()
            })
        })

        function loaduser() {
            $.ajax({
                url:"${pageContext.request.contextPath}/user/findAllUser.do",
                type:"get",
                dataType:"json",
                success:function (data) {
                    // 清除旧的数据
                    $("#info").html("");
                    //增加新的数据
                    $.each(data, function(i, n){
                        $("#info").append("<tr>")
                            .append("<td>"+n.name+"<td>")
                            .append("<td>"+n.age+"<td>")
                            .append("<td>"+n.address+"<td>")
                            .append("<tr>");

                    })
                }}


            )
        }
        
    </script>

</head>
<body>
    <div align="center">
        <table>
            <thead>
                <tr>
                    <td>姓名</td>
                    <td>年龄</td>
                    <td>地址</td>
                </tr>
            </thead>
            <tbody id="info">

            </tbody>
            <input type="button" id="loaddata" value="查询数据">
        </table>
    </div>
</body>
</html>
