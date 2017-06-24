<%--@elvariable id="currentUser" type="com.wrox.site.User"--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-bordered table-striped">
	<caption>用户数据</caption>
			<tbody>
			<thead>
				<th>ID</th>
				<th>Username</th>
				<th>Name</th>
			</thead>
				<tr>
					<td>${currentUser.userId}</td>
					<td>${currentUser.username }</td>
					<td>${currentUser.name }</td>
				</tr>
			</tbody>
		</table>
</body>
</html>