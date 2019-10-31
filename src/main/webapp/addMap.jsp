<%--
  Created by IntelliJ IDEA.
  User: wwwww
  Date: 2019/10/30
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/data/map" method="post">
    用户1编号：<input type="text" name="users[a].id" /><br/>
    用户1名称：<input type="text" name="users[a].name"/><br/>
    用户2编号：<input type="text" name="users[b].id" /><br/>
    用户2名称：<input type="text" name="users[b].name"/><br/>
    <input type="submit" value="map提交"/>
</form>

</body>
</html>
