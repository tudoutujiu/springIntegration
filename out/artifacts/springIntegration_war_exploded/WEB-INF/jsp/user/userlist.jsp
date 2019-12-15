<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/8 0008
  Time: 下午 4:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <c:forEach items="${list}" var="user">
        <p>${user.id}</p>
        <p>${user.lv}</p>
        <p>${user.username}</p>
        <p>${user.password}</p>
        <p>${user.email}</p>
    </c:forEach>
</body>
</html>
