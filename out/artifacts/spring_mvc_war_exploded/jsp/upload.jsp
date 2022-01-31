<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2022/1/15
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/test/slow17" method="post" enctype="multipart/form-data">
    名称<input type="text" name="username"><br/>
    文件<input type="file" name="uploadFile1"><br/>
    文件<input type="file" name="uploadFile2"><br/>
    <input type="submit" value="submit">
</form>
</body>
</html>
