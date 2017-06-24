<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>        
  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.css" rel="stylesheet">
  <!-- <link rel="stylesheet" href="css/font-awesome.css"> -->
  <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
  <link href="https://cdn.bootcss.com/font-awesome-animation/0.0.10/font-awesome-animation.css" rel="stylesheet">
  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">
  <link rel="stylesheet" href="css/element.css">
  <!-- <link rel="stylesheet" href="css/iview.css"> -->
  <!-- Custom styles for this template -->
  <!-- <link href="css/index.css" rel="stylesheet"> -->
  <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
  <!--[if lt IE 9]><script src="../docs/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
  <script src="js/ie-emulation-modes-warning.js"></script>
  <script src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.min.js"></script>
  <script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
  <script src="js/jquery-2.1.0.min.js"></script>
  <script src="js/bootstrap.js"></script>
  <script src="js/vue.js"></script>
  <script src="js/element.js"></script>
  <script src="https://cdn.bootcss.com/echarts/3.5.4/echarts.common.js"></script>
  <!-- <script src="js/iview.js"></script> -->
  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  <style type="text/css">
		
		.navbar-top-links {
			margin-right: 0;
		}
		
		.navbar-top-links li {
			display: inline-block;
		}
		
		.navbar-top-links li:last-child {
			margin-right: 15px;
		}
		
		.navbar-top-links li a {
			padding: 15px;
			min-height: 50px;
		}
		
		.navbar-top-links .dropdown-menu li {
			display: block;
		}
		
		.navbar-top-links .dropdown-menu li:last-child {
			margin-right: 0;
		}
		
		.navbar-top-links .dropdown-menu li a {
			padding: 3px 20px;
			min-height: 0;
		}
		
		.navbar-top-links .dropdown-menu li a div {
			white-space: normal;
		}
		
		.navbar-top-links .dropdown-messages,
		.navbar-top-links .dropdown-tasks,
		.navbar-top-links .dropdown-alerts {
			width: 310px;
			min-width: 0;
		}
		
		.navbar-top-links .dropdown-messages {
			margin-left: 5px;
		}
		
		.navbar-top-links .dropdown-tasks {
			margin-left: -59px;
		}
		
		.navbar-top-links .dropdown-alerts {
			margin-left: -123px;
		}
		
		.navbar-top-links .dropdown-user {
			right: 0;
			left: auto;
		}
		
		@media (min-width: 768px) {
			.sidebar {
				z-index: 1;
				position: absolute;
				width: 250px;
				margin-top: 51px;
			}
			.navbar-top-links .dropdown-messages,
			.navbar-top-links .dropdown-tasks,
			.navbar-top-links .dropdown-alerts {
				margin-left: auto;
			}
		}
	</style>   

	<div id="navigation">
			<!-- Navigation -->
			<nav class="navbar  navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
					<a class="navbar-brand" href="index.html">敏而好学网络在线教育</a>
				</div>
				<!-- /.navbar-header -->
				<ul class="nav navbar-top-links navbar-right">
				  <sec:authorize ifNotGranted="ROLE_TEACHER,ROLE_STUDENT,ROLE_SITE_ADMIN,ROLE_SCHOOL_ADMIN">
					<li class="">
						<a href="login">登录</a>
					</li>
					<li>
						<a href="#">注册</a>
					</li>
				  </sec:authorize>	
				  <sec:authorize ifAnyGranted="ROLE_TEACHER,ROLE_STUDENT,ROLE_SITE_ADMIN,ROLE_SCHOOL_ADMIN">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
							<i class="fa fa-envelope faa-shake animated" style="color: red; font-size: 18px"></i><span class="badge">4</span> <i class="fa fa-caret-down"></i>
						</a>
						<ul class="dropdown-menu dropdown-messages">
							<li>
								<a href="#">
									<div>
										<strong>John Smith</strong>
										<span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
									</div>
									<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#">
									<div>
										<strong>John Smith</strong>
										<span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
									</div>
									<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#">
									<div>
										<strong>John Smith</strong>
										<span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
									</div>
									<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a class="text-center" href="#">
									<strong>Read All Messages</strong>
									<i class="fa fa-angle-right"></i>
								</a>
							</li>
						</ul>
						<!-- /.dropdown-messages -->
					</li>
					<!-- /.dropdown -->
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
							<i class="fa fa-bell faa-ring animated" style="color: red; font-size: 18px"></i><span class="badge">4</span> <i class="fa fa-caret-down"></i>
						</a>
						<ul class="dropdown-menu dropdown-alerts">
							<li>
								<a href="#">
									<div>
										<i class="fa fa-comment fa-fw"></i> New Comment
										<span class="pull-right text-muted small">4 minutes ago</span>
									</div>
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#">
									<div>
										<i class="fa fa-twitter fa-fw"></i> 3 New Followers
										<span class="pull-right text-muted small">12 minutes ago</span>
									</div>
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#">
									<div>
										<i class="fa fa-envelope fa-fw"></i> Message Sent
										<span class="pull-right text-muted small">4 minutes ago</span>
									</div>
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#">
									<div>
										<i class="fa fa-tasks fa-fw"></i> New Task
										<span class="pull-right text-muted small">4 minutes ago</span>
									</div>
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a href="#">
									<div>
										<i class="fa fa-upload fa-fw"></i> Server Rebooted
										<span class="pull-right text-muted small">4 minutes ago</span>
									</div>
								</a>
							</li>
							<li class="divider"></li>
							<li>
								<a class="text-center" href="#">
									<strong>See All Alerts</strong>
									<i class="fa fa-angle-right"></i>
								</a>
							</li>
						</ul>
						<!-- /.dropdown-alerts -->
					</li>
					<!-- /.dropdown -->
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#">
							<i class="fa fa-user fa-fw"></i>${sessionScope.username}<i class="fa fa-caret-down"></i>
						</a>
						<ul class="dropdown-menu dropdown-user">
							<li>
								<a href="#"  onclick="onesub()"><i class="fa fa-user fa-fw"></i>我的资料</a>
							</li>
							<li>
								<sec:authorize ifAnyGranted="ROLE_STUDENT">
					            	<a href="study"><i class="fa fa-gear fa-fw"></i>学习中心</a>
					            </sec:authorize>
					            <sec:authorize ifAnyGranted="ROLE_TEACHER">
					            	<a href="teacher"><i class="fa fa-gear fa-fw"></i>教学中心</a>
					            </sec:authorize>
					            <sec:authorize ifAnyGranted="ROLE_SITE_ADMIN,ROLE_SCHOOL_ADMIN">
					            	<a href="admin"><i class="fa fa-gear fa-fw"></i>管理中心</a>
					            </sec:authorize>
							</li>
							<!-- <li>
								<a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
							</li> -->
							<li class="divider"></li>
							<li>
								<a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
							</li>
						</ul>
						<!-- /.dropdown-user -->
					</li>
					<!-- /.dropdown -->
				  </sec:authorize>	
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="input-group">
                         <input type="text" class="form-control" placeholder="搜索喜欢的课程">
                         <span class="input-group-btn">
                         <button class="btn btn-default" type="button">
                             <i class="fa fa-search"></i>
                         </button>
                         </span>
                   </div>
				</form>
			</nav>
		</div>

<script>
	var header=new Vue({
		el:'#navigation',
		data:{
			
		},
		methods:{
			connecttosocket:function(){
	            const socket = new SockJS("/SpringConfig/notice");
	            const stompClient=Stomp.over(socket);
	            stompClient.connect({}, function(frame) {
	                /* console.log('Connected: ' + frame); */
	            	//任何人都可订阅学校的通知
	                stompClient.subscribe('/topic/schoolnews', function(news){
	                	header.$notify({
	                        title: '学校通知',
	                        message: '五一请大家注意安全！',
	                        type: 'success'
	                      });
	                    console.log(JSON.parse(news.body).content);
	                });
	                //只有学生可以订阅老师的通知
	                stompClient.subscribe('/topic/classnews/2', function(news){
	                	header.$notify({
	                        title: '课程通知',
	                        message: '下周课请来w201上课！',
	                        type: 'info',
	                        offset:45,
	                        duration:0
	                      });
	                	console.log(JSON.parse(news.body).content);
	                });
	                //用户订阅别人回复消息的通知(精准推送)
	                stompClient.subscribe('/discuss/replymesg/666666',function(data){
	                	console.log(data);
	                	//console.log(JSON.parse(message.body).content);
	                });
	            });
	            
	        }
		},
		mounted:function(){
			this.connecttosocket()
		}
	})
        /* $(document).ready(function(){
            //连接websocket服务器
        	connect();
            //checkoutUserlist();
        }); */
       /* var stompClient = null;
        
        function onesub() {
        	let datenow=new Date();
            stompClient.send("/minersocket/schoolnotice",{atytopic:"topic"}, JSON.stringify({ 'createdTime':datenow,'msg':'学校通知','msg_to':'全体学生','msg_from':'来自教务处' }));
            stompClient.send("/minersocket/classnotice/2", {atytopic:"topic"}, JSON.stringify({ 'createdTime':datenow,'msg':'班级通知','msg_to':'2班学生','msg_from':'来自李老师' }));
            stompClient.send("/minersocket/userreply/666666", {atytopic:"discuss"}, JSON.stringify({ 'createdTime':datenow,'msg':'有人回复你啦','msg_to':'666666','msg_from':'2' }));
        } */

</script>
