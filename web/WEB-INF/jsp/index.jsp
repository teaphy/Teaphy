<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/6/7
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/operatePerson/register" method="post">

    <p>
        <label>
            ID：
            <input type="text" name="id">
        </label>
    </p>

    <p>
        <label>
            用户名：
            <input type="text" name="name">
        </label>
    </p>
    <p>
        <label>
            密码：
            <input type="password" name="pwd">
        </label>
    </p>
    <p>
        <span><input type="submit" value="登录"></span>
</form>

<form action="${pageContext.request.contextPath}/operatePerson/queryPersons" method="get">
    <p>
        <span><input type="submit" value="用户信息"></span>
    </p>
</form>

<form action="${pageContext.request.contextPath}/operatePerson/queryScore/1" method="get">
    <p>
        <label>
            用户名：
            <input type="text" path="name">
        </label>
    </p>
    <p>
        <span><input type="submit" value="成绩查询"></span>
    </p>
</form>

<form action="${pageContext.request.contextPath}/operatePerson/uploadFile" method="post" enctype="multipart/form-data">
    <p>
        <label>
            用户名:
            <input type="text" name="name">
        </label>
    </p>
    <p>
        上传附件：<input type="file" name="upfile">
    </p>
    <p>
        <input type="submit" value="上传">
    </p>
</form>
</body>
</html>
