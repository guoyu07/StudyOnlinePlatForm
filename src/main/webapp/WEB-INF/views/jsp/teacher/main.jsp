<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%-- <%@include  file="/WEB-INF/views/jsp/public/Header.jsp"%> --%>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
	<title>教师界面</title>
	<style>
		html,body{
		    height: 100%;
		    background-color: #f8f8f8;
		}
		#wrap {
		    min-height: 100%;
		    height: auto !important;
		    margin: 0 auto -200px;
		}
		#push{
		   height: 200px;
		 }
		#leftMenu{
			margin-top: 10px
		}
		#rightPanel{
			margin-top: 10px
		}
	</style>
</head>
<body>
	<div id="wrap">
	<jsp:include page="/WEB-INF/views/jsp/public/Header.jsp"></jsp:include>
	<!--主界面开始-->
	  	<div class="container" id="container">
		    <div class="row">
			    <div id="leftMenu" class="col-md-2">
				    <div class="list-group" >
		                    <a v-for="item in menus"  @click="handleSelect($event,item)"  v-bind:href="item.href" class="list-group-item" >{{item.name}}</a>
		            </div>
		        </div>
		        
		        <div id="rightPanel" class="col-md-10">
		        </div>
		    </div>
		    <div id="push"></div>
	    </div>
    </div>
	<jsp:include page="/WEB-INF/views/jsp/public/Footer.jsp"></jsp:include>
</body>
	<script type="text/javascript">
	var main=new Vue({
        el: '#container',
        data: {
        	active:'',
        	menus:[
        	   {href:'notice',name:'消息通知'},
        	   {href:"teachManager",name:"授课管理"},
        	   {href:"homeworkManager",name:"作业管理"},
        	   {href:"questionBank",name:"我的题库"},
        	   {href:"stuMonitor",name:"学生监察"},
        	   {href:"cloudStorage",name:"学校云盘"},
        	   {href:"liveClass",name:"课堂直播"},
        	   {href:"privateLetter",name:"我的私信"}
        	],
        	content:'加载中...',
        },
        methods: {
            getView:function(name){
                $.ajax({
                    type:'GET',
                    url:'getTeacherPanel',
                    data:{
                        menu:name
                    },
                    success:function(msg){
                    	main.content=msg;
                        $('#rightPanel').html(main.content);
                    }
                });
            },
            handleSelect:function(event,item){
                /* this.getView(name) */
                event.preventDefault();
                /* if(item.href===this.active){
            		return false;
            	} */
                this.getView(item.href);
                
            }
        },
        mounted:function(){
        	this.getView("teachManager");
        }
    })
	</script>
</html>