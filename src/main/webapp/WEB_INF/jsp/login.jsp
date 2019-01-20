<%--
  Created by IntelliJ IDEA.
  User: zhangbin
  Date: 2019-01-20
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/user/login" method="get">
        用户名：<input type="text" name="name"/><br/>
        密码： <input type="text" name="ped"/>
        <input type="submit" name="login"/>
    </form>

</body>
</html>
