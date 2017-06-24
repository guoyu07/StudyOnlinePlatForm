<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="css/video-js.css" />
		<!-- If you'd like to support IE8 -->
		<script src="http://vjs.zencdn.net/ie8/1.1.1/videojs-ie8.min.js"></script>
		<script type="text/javascript" src="js/video.js" ></script>
		<link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css" rel="stylesheet">
		<jsp:include page="/WEB-INF/views/jsp/public/Header.jsp"></jsp:include>
		<style>
			.col-center-block {
				float: none;
				display: block;
				margin-left: auto;
				margin-right: auto;
			}
			.tab-content>.active{
				    border: 1px solid #ddd;
				    height: 360px;
				    /*border-top: none;*/
				    overflow: auto;
			}
			.nav-pills>li>a {
    				border-radius: 0px;
			}
			#chatinput .form-control{
				border-radius: 0px;
			}
			#chatinput .btn{
				border-radius: 0px;
			}
			.anchorNotice{
				width: 15px;
				font-size: 15px;
				word-wrap: break-word;
				letter-spacing: 0px;
				margin-left: 20px;
				color: red;
			}
		</style>
	</head>
	<body>
		<div class="container" id="chatroom">
			<div class="row">
				
			</div>
			<div class="row" >
				<div class="col-md-12" style="margin-bottom: 10px;">
					<!--标题区域-->
					<div class="col-md-8" style="height: 80px;padding-left: 0px;background-color: beige;">
						<div>
							<img class="img-responsive" style="width: 80px;height:80px; float: left;" src="http://r3.ykimg.com/050E00005840E84667BC3C674900733D" alt="">
							<h3 style="margin-left: 15px;margin-top: 10px; float: left;">直播标题</h3>
						</div>
					</div>
					<!--公告区域-->
					<div class="col-md-4" style="height: 80px; background-color: #C4E3F3;" >
						<h3 class="anchorNotice" style="margin-top: 0px; float: left;"><i class="fa fa-bell" aria-hidden="true"></i>主播公告</h3>
						<div style="float: left; padding: 10px;">直播时间，上午9.30-下午3.30左右。</div>
					</div>
				</div>
				<!--
                	作者：979783618@qq.com
                	时间：2017-05-14
                	描述：左侧栏目开始
                -->
				<div class="col-md-8" >
					<div  style=" background-color: black ; height: 439px; width: 100%;">
						<video  id="videoplayer"  width="640px" height="439px" class="col-center-block video-js  vjs-default-skin vjs-big-play-centered" preload="auto" controls  >
							<!-- <source src="rtmp://www.veton.cc/live/jack"  type="rtmp/flv"></source> -->
							<source v-bind:src="rtmpSource"  type="rtmp/flv"></source>
						</video>
					</div>
				</div>
				<!--
                	作者：979783618@qq.com
                	时间：2017-05-14
                	描述：左侧栏目结束
                -->
                <!--
                	作者：979783618@qq.com
                	时间：2017-05-14
                	描述：右侧讨论区开始
                -->
				<div class="col-md-4" >
					<!--tabs-->
					<ul id="menuTabs" class="nav nav-pills nav-justified">
						<li class="active">
							<a href="#discussion" data-toggle="tab"><i class="fa fa-tree"></i>互动聊天</a>
						</li>
						<li>
							<a href="#members" data-toggle="tab"><i class="fa fa-tree"></i>现场嘉宾</a>
						</li>
					</ul>
					<!--内容滚动区域开始-->
					<div id="tabContent" class="tab-content">
						<div class="tab-pane fade active in" id="discussion" style="padding:10px;">
							<div style="" v-for="message in messages">
								<span style="color: cornflowerblue;">{{message.msg_from}}:</span>
								<span>{{message.msg}}</span>
							</div>
						</div>
						<!--内容滚动区域结束-->
						<!--现场观众统计开始-->
						<div class="tab-pane fade in" style="padding-top: 10px;" id="members">
							现场嘉宾afaefwa					
						</div>
						<!--现场观众统计结束-->
					</div>
					<div id="chatinput" class="input-group" style="margin-top: 5px;">
				      <input  type="text" class="form-control" v-model="messageinput" @keyup.13="sendMessage" placeholder="参与话题讨论">
				      <span class="input-group-btn">
				        	<button  class="btn btn-success" type="button"  @click="sendMessage">发送!</button>
				      </span>
				      
				    </div>
				</div>
				<!--
                	作者：979783618@qq.com
                	时间：2017-05-14
                	描述：右侧讨论区结束
                -->
			</div>
			<div class="row">
	            <div class="col-md-12">
	                <h2 class="page-header">直播推荐
	                </h2>
	            </div>
			<div class="col-md-4 img-portfolio">
	            <a href="portfolio-item.html">
	                <img class="img-responsive img-hover" src="http://f10.baidu.com/it/u=2700840885,2086663524&fm=170&s=82A243A3CF71B5CA1C51449D0300E082&w=640&h=347&img.PNG&access=215967316" alt="">
	            </a>
	            <div>
	            	<p style="margin-top: 5px; font-size: 16px;">恭喜WE战胜SKT！MSI冠军赛重播
MSI冠军赛MSI冠军赛</p>
					<div id="">
						<span>张雪峰老师</span><span class="pull-right"><i class="fa fa-users" aria-hidden="true"></i>1.1万</span>
					</div>
	            </div>
            </div>
            <div class="col-md-4 img-portfolio">
	            <a href="portfolio-item.html">
	                <img class="img-responsive img-hover" src="http://f10.baidu.com/it/u=2700840885,2086663524&fm=170&s=82A243A3CF71B5CA1C51449D0300E082&w=640&h=347&img.PNG&access=215967316" alt="">
	            </a>
	            <div>
	            	<p style="margin-top: 5px; font-size: 16px;">恭喜WE战胜SKT！MSI冠军赛重播
MSI冠军赛MSI冠军赛</p>
					<div id="">
						<span>张雪峰老师</span><span class="pull-right"><i class="fa fa-users" aria-hidden="true"></i>1.1万</span>
					</div>
	            </div>
            </div>
            <div class="col-md-4 img-portfolio">
	            <a href="#">
	                <img class="img-responsive img-hover" src="http://f10.baidu.com/it/u=2700840885,2086663524&fm=170&s=82A243A3CF71B5CA1C51449D0300E082&w=640&h=347&img.PNG&access=215967316" alt="">
	            </a>
	            <div>
	            	<p style="margin-top: 5px; font-size: 16px;">恭喜WE战胜SKT！MSI冠军赛重播
MSI冠军赛MSI冠军赛</p>
					<div id="">
						<span>张雪峰老师</span><span class="pull-right"><i class="fa fa-users" aria-hidden="true"></i>1.1万</span>
						
					</div>
	            </div>
            </div>
			</div>
		</div>
	</body>
	<script>
	var chatroom=new Vue({
		el:'#chatroom',
		data:{
			roomid:${roomid},
			userid:'${sessionScope.userid}', 
			username:'${sessionScope.username}',
			stompClient:null,
			messages:[],
			messageinput:null,
			rtmpSource:null,
		},
		methods:{
			connecttosocket:function(){
	            var socket = new SockJS("/SpringConfig/notice");
	            this.stompClient=Stomp.over(socket);
	            this.stompClient.connect({}, function(frame) {
	                /* console.log('Connected: ' + frame); */
	            	//接收聊天室消息
	                chatroom.stompClient.subscribe('/chatroom/live/'+chatroom.roomid, function(msg){
	                    chatroom.messages.push(JSON.parse(msg.body).message);
	                });
	            });
	        },
	        sendMessage:function(){
	        	if(chatroom.messageinput!=null&&chatroom.userid!=''){
	        		this.stompClient.send("/minersocket/chat/"+this.roomid, {atytopic:"chatroom"},
		        			JSON.stringify(
		        					{ 'msg':chatroom.messageinput,'msg_from':chatroom.username }
		        				));
	        		this.messageinput=null;
		        }else if(chatroom.messageinput == null){
		        	chatroom.messageinput="请输入内容!!!";
				}else if(chatroom.userid ==''||chatroom.userid==null||chatroom.userid==undefined ){
					chatroom.messageinput="请先登录哦~~~";
				}
	        	
	        	
	        }
	        	
		},
		mounted:function(){
			this.connecttosocket();
			this.rtmpSource='rtmp://www.veton.cc/live/'+this.roomid;
		}
		});
		var videoPlayer=null;
		$(document).ready(function() {
			videoInit();
		})
		
		function videoInit() {
		videoPlayer=videojs('videoplayer',{
			//初始化数据
				"techOrder": ["html5","flash"],
			    "autoplay":true,
			    control: {
			        captionsButton: true,
			        chaptersButton : true,
			        liveDisplay:true,
			        playbackRateMenuButton: true,
			        subtitlesButton:true
			      }
			},
			//触发事件
			function(){
				//alert('Good to go!');
				this.on('loadeddata',function(){
			        console.log(this)
			    })
			
			    this.on('ended',function(){
			    	/* alert("播放结束");
			         this.pause();
			         this.hide(); */
			    })
			}
			)
	}
	</script>
</html>
