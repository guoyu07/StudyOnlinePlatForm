<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">测试视图解析器</h1>
	<fmt:setLocale value="ch-ZN"/>
	<h3>当前时间是<fmt:formatDate value="${date }"/></h3>
	<button class="btn btn-default">按钮</button>
</body>
</html>