<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<section>
<style type="text/css">
.program {
				padding-top: 5px;
				padding-bottom: 12px;
				margin: 0px;
				cursor: pointer;
				border-bottom: 1px solid rgba(0, 0, 0, 0.09);
			}
			body:FIRST-CHILD{
            	padding-top: 0px
            }
			.program a {
				text-decoration: none;
			}
			a {
				color: #009a61;
				text-decoration: none;
			}
			
			.pull-left {
				float: left !important;
				margin-left: 5px;
			}
			
			.program-avatar64 {
				width: 100px;
				height: 100px;
			}
			
			.img-rounded {
				border-radius: 3px;
			}
			.program-content {
				margin-left: 120px;
				height: 100px;
			}
			
			.program-title {
				color: #212121;
				font-size: 18px;
				margin-top: 0;
				margin-bottom: 5px;
				line-height: 22px;
				text-overflow: ellipsis;
				overflow: hidden;
				white-space: nowrap;
			}
			.program-info {
			    color: #999;
			    /*font-size: 13px;*/
			    margin-bottom: 5px;
			    line-height: 18px;
			}
			.program-info span{
				margin-left: 5px;
			}
			.operation{
				margin-right: 10px;
				padding-top: 16px;
			}
			.operation button{
				margin-right: 10px;
			}
			.breadcrumb{
				margin-bottom:8px;
			}
</style>
<script  src="js/moment.min.js"></script>			
  <div id="teachManager">
  	<ol class="breadcrumb">
  	  <li><a href="teacher">Home</a></li>
	  <li class="active">课程管理</li>
	  <!-- <li><a href="#">Library</a></li>
	  <li class="active">Data</li> -->
	  <!-- <li class="active">Data</li> -->
	</ol>
	<div class="panel panel-default">
		<div class="panel-heading">
            <span class="panel-title" >课程管理</span>
            <span class="panel-title pull-right" >
            	<div class="dropdown  ">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">年度选择 <span class="caret"></span></a>
		          <ul class="dropdown-menu dropdown-menu-right">
		            <li v-for="year in years" @click="selectYear(year)"><a href="javascript:;">{{timeFormat(year,'YYYY')}}年度</a></li>
		          </ul>
		        </div>
            </span>
         </div>
        <div class="panel-body">
        <div class="program" v-for="item in classes">
        	<div  style="display:block;"><!-- href="javascript:;"  target="" -->
				<div class="program-avatar pull-left">
					
					<a :href="['viewCourse?classid='+item.classId]" target="_blank">
						<img class="img-rounded program-avatar64" v-bind:src="item.classPoster">
					</a>	
				</div>
				<div class="program-content">
					<h2 class="program-title">
								
                                <object><a :href="['viewCourse?classid='+item.classId]" target="_blank">{{item.courseEntity.courseName}}</a></object>
                            </h2>
					<div class="program-info">
						<span class="fa fa-flask" aria-hidden="true">&thinsp;{{item.classOrder}}班</span>
						<span style="margin-left: 5px;" class="glyphicon glyphicon-time">&thinsp;{{item.period}}课时</span>
						<span style="margin-left: 5px;"><i class="fa fa-calendar" aria-hidden="true"></i>{{timeFormat(item.termStart,'YYYY-MM-DD')}}</span>
						<span class="fa" aria-hidden="true" v-bind:class="[item.class_Over ? endclass : startclass ]" aria-hidden="true">&thinsp;{{item.classOver?'课程已结束':'课程正在进行中'}}</span>
					</div>
					<div class="operation pull-right">
						<button class="btn btn-danger"  @click="viewclass(item.classId)">班级概况</button>
						<button class="btn btn-danger"  @click="courseEdit(item.classId)">备课编辑</button>
						<!-- <a href="courseEdit" style="" class="btn btn-danger">备课编辑</a> -->
						<button class="btn btn-danger" @click="assignHomework">发布作业</button>
						<button class="btn btn-danger" @click="checkHomework">批改作业</button>
						<button class="btn btn-danger" @click="forumn">讨论区</button>
					</div>
				</div>
			</div>
        </div>
		</div>
	</div>
  </div>	


 <script type="text/javascript">
 	var rightside=new Vue({
 		el:'#teachManager',
 		data:{
 			classes:[],
 			years:[],
 			userid:${sessionScope.userid},
 			endclass:'fa-hourglass-end',
 			startclass:'fa-hourglass-start',
 		},
 		methods:{
 			selectYear:function(time){
 				this.classes=[];
 				this.years=[];
				let url='class_t/'+111; 
				var selectedYear =new Date(time);
 	 			$.get(url,function(data){
 	 				//rightside.classes=data;
 	 				for (var i = 0; i < data.length; i++) {
 	 					let year=new Date(data[i].termStart);
 	 					if (year.getFullYear()==selectedYear.getFullYear()){
 							rightside.classes.push(data[i]);
 						}
 	 					rightside.years.push(data[i].termStart);
					}
 	 				rightside.years.sort();
 	 			})
 			},
 			timeAbs:function(timestamp1,timestamp2){
 				return Math.abs(timestamp1-timestamp2);
 			},
 			timeFormat:function(time,format){ 
 				return moment(time).format(format);
 			},
 			getclass:function(){
 				let url='class/'+111;
 				
 	 			$.get(url,function(data){
 	 				rightside.classes=data;
 	 				for (var i = 0; i < data.length; i++) {
 	 					rightside.years.push(data[i].termStart);
					}
 	 				rightside.years.sort();
 	 			})
 			}, 
 			//班级概况
 			viewclass:function(classid){
 				$.ajax({
 					type:'get',
 					data:{
 						classid:classid,
 						teacherid:'${userid}'
 					},
 					url:'viewClass',
 					success:function(data){
 						$('section').replaceWith(data);
 					}
 				})
 			},
 			//教学编辑
 			courseEdit:function(classid){
 				window.open('courseEdit?classid='+classid);
 			},
 			//布置作业
 			assignHomework:function(){
 				
 			},
 			//批改作业
 			checkHomework:function(){
 				
 			},
 			//教学论坛
 			forumn:function(){
 				
 			}
 		},
 		mounted:function(){
 			//this.getclass();
 			var timestampNow = Date.parse(new Date());
 			this.selectYear(timestampNow);
 		}
 	})
 
 </script>	
</section>