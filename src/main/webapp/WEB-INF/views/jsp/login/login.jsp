<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="css/bootstrap.css" />
        <script type="text/javascript" src="js/jquery-2.1.0.min.js" ></script>
         <script type="text/javascript" src="js/bootstrap.js" ></script>
         <script type="text/javascript" src="js/vue.js" ></script>
        
       
        <title>用户登录</title>
        <style>
        	@import url(https://fonts.googleapis.com/css?family=Roboto:300);
        	.login-page {
        		width: 360px;
        		padding: 6% 0 0;
        		margin: auto;
        	}
        	
        	.form {
        		position: relative;
        		z-index: 1;
        		background: #FFFFFF;
        		max-width: 360px;
        		margin: 0 auto 100px;
        		padding: 45px;
        		text-align: center;
        		box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        	}
        	
        	.form input {
        		font-family: "Roboto", sans-serif;
        		outline: 0;
        		background: #f2f2f2;
        		width: 100%;
        		border: 0;
        		margin: 0 0 15px;
        		padding: 15px;
        		box-sizing: border-box;
        		font-size: 14px;
        	}
        	.form select{
        		/*padding: 15px;*/
        		margin: 0 0 15px;
        	}
        	.form button {
        		font-family: "Roboto", sans-serif;
        		text-transform: uppercase;
        		outline: 0;
        		background: #4CAF50;
        		width: 100%;
        		border: 0;
        		padding: 15px;
        		color: #FFFFFF;
        		font-size: 14px;
        		-webkit-transition: all 0.3 ease;
        		transition: all 0.3 ease;
        		cursor: pointer;
        	}
        	
        	.form button:hover,
        	.form button:active,
        	.form button:focus {
        		background: #43A047;
        	}
        	
        	.form .message {
        		margin: 15px 0 0;
        		color: #b3b3b3;
        		font-size: 12px;
        	}
        	
        	.form .message a {
        		color: #4CAF50;
        		text-decoration: none;
        	}
        	
        	.form .register-form {
        		display: none;
        	}
        	
        	.container {
        		position: relative;
        		z-index: 1;
        		max-width: 300px;
        		margin: 0 auto;
        	}
        	
        	.container:before,
        	.container:after {
        		content: "";
        		display: block;
        		clear: both;
        	}
        	
        	.container .info {
        		margin: 50px auto;
        		text-align: center;
        	}
        	
        	.container .info h1 {
        		margin: 0 0 15px;
        		padding: 0;
        		font-size: 36px;
        		font-weight: 300;
        		color: #1a1a1a;
        	}
        	
        	.container .info span {
        		color: #4d4d4d;
        		font-size: 12px;
        	}
        	
        	.container .info span a {
        		color: #000000;
        		text-decoration: none;
        	}
        	
        	.container .info span .fa {
        		color: #EF3B3A;
        	}
        	
        	body {
        		background: #76b852;
        		/* fallback for old browsers */
        		background: -webkit-linear-gradient(right, #76b852, #8DC26F);
        		background: -moz-linear-gradient(right, #76b852, #8DC26F);
        		background: -o-linear-gradient(right, #76b852, #8DC26F);
        		background: linear-gradient(to left, #76b852, #8DC26F);
        		font-family: "Roboto", sans-serif;
        		-webkit-font-smoothing: antialiased;
        		-moz-osx-font-smoothing: grayscale;
        		text-align: center;
        	}
        </style>
    </head>
    <body>
    <h1 style="color:white; text-shadow: 0px 1px 0px #e5e5ee;">敏而在线教学平台</h1>
    
  	<div class="login-page">
		<div class="form">
			<form:form cssClass="register-form" servletRelativeAction="/register" method="post" modelAttribute="registerForm">
				<form:input path="userId" autocomplete="off" placeholder="用户名"/>
				<form:password  path="password" autocomplete="off" placeholder="用户名"/>
				<form:select path="roleid" cssClass="form-control" >
						<c:forEach items="${roles }" var="role">
			         	<option name="roleid" value="${role.roleId}">${role.roleName}${role.description }
			         	</option>
			         	</c:forEach>
				</form:select>
				<form:button type="submit">注册</form:button>
				<p class="message">已经有账号?
					<a href="#">登录</a>
				</p>
			</form:form>
			<!--
            	作者：979783618@qq.com
            	时间：2017-03-24
            	描述：注册成功模态框
            -->
			<!--<div id="register_success" class="modal  fade in">
				<div class="modal-header">
					<a class="close" data-dismiss="modal"></a>
					<h3	>注册提示</h3>
				</div>
				<div class="modal-body">
					<h4> 恭喜您注册成功</h3>
					<p>赶快去登录吧！</p>
				</div>
				<div class="modal-footer"> 
					<a href="#" class="btn btn-success">去登录</a>
					<a href="#" class="btn " data-dismiss="modal">取消</a>
				</div>
			</div>-->
			
			<form:form  cssClass="login-form" servletRelativeAction="login_process"  autocomplete="false" modelAttribute="user">
				<form:input  path="username" autocomplete="off" placeholder="用户名" required="required"  />	
				<form:errors path="username" cssStyle="color:crimson"/>		
				<form:password path="password" autocomplete="off" placeholder="密码" required="required"/>
				<form:errors path="password" cssStyle="color:crimson"/>	
				<button type="submit">登录 ${param.register}</button>
				<p class="message">没有账号?
					<a href="#">注册账号</a>
				</p>
				<c:if test="${param.containsKey('error')}"><p style="color:crimson">${param.error}</p></c:if>
			</form:form>
		</div>
	</div>
 	</body>
 	
 	<script type="text/javascript">
 		 
 		 $(document).ready(function(){
 		 	//登录注册切换
 		 	$('.message a').click(function() {
 		 		$('form').animate({ height: "toggle", opacity: "toggle" }, "slow");
			});
 		 	var register_state="${param.register}";
 		 	
 		 	//注册成功模态框
 		 	/*if(register_state=="success"){
 		 		alert("注册状态值=="+register_state);
 		 		$('#register_success').modal();
 		 	} ;*/

 		 });
 		 
 	</script>
</html>