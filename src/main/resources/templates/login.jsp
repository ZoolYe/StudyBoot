<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<form action="/complaint/index">
    用户名：<input type="text" name="username">
    密码：<input type="password" name="password">
    <input type="submit" value="提交">

    <input name="_csrf" type="hidden" value="">

</form>

</body>
</html>