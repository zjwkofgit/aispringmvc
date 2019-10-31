<%--
  Created by IntelliJ IDEA.
  User: wwwww
  Date: 2019/10/30
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function () {
           // alert(123);
            var user={
                "id":1,
                "name":"张三"
            };
            $.ajax({
                url:"/data/json",
                data:JSON.stringify(user), //把user数据转换成json格式
                type:"POST",
                contentType:"application/json;charset=UTF-8", //设置编码
                dataType:"JSON", //返回的也是json格式
                success:function (data) {
                    alert(data.id+"---"+data.name)

                }

            })

        });
    </script>
</head>
<body>

</body>
</html>
