<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="/WEB-INF/views/jsp/public/Header.jsp"></jsp:include>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/font-awesome.css" />
<link rel="stylesheet" href="css/viewCourse.css">
<title>课程概览</title>
<style>
	.panel-group{
		margin-bottom: 1px;
	}
	
</style>
</head>
<body>

	<div class="container" id="viewCourse">
		<!-- Intro Content -->
		<div class="row" style="margin-top: 8px">
			<div class="col-md-6">
				<img class="img-responsive" src="${classinfo.classPoster }"
					style="width: 550px; height: 350px;" alt="">
			</div>
			<div class="col-md-6" style="">
				<h2>${classinfo.courseEntity.courseName }</h2>
				<p>
					<span class="glyphicon glyphicon-user">${total }</span> <span
						class="glyphicon glyphicon-time">${classinfo.period }</span>
				</p>
				<p>
					<br>
					<!-- <span class="price " style="color: red;">￥:<sup></sup>19.<sup>99</sup></span> -->
				</p>
				<p>
					课程简介: <span>${classinfo.briefIntroduce }</span>
				</p>
				<br />
				<p>自报班之日起12个月有效期</p>
				<div style="">
					<a href="#" class="btn btn-danger">立即报名</a>
				</div>
			</div>

		</div>

		<!-- Service Tabs -->
		<div class="row" style="margin-top: 10px;">

			<div class="col-md-9">

				<ul id="myTab" class="nav nav-tabs">
					<li class=""><a href="#" data-toggle="tab"><i
							class="fa fa-tree"></i>课程介绍</a></li>
					<li class="active"><a href="#service-one" data-toggle="tab"><i
							class="fa fa-tree"></i> 课程目录</a></li>
					<li class=""><a href="#service-two" data-toggle="tab"><i
							class="fa fa-car"></i>讨论区</a></li>
					<li class=""><a href="#service-three" data-toggle="tab"><i
							class="fa fa-support"></i> 任课老师</a></li>
					<li class=""><a href="#service-four" data-toggle="tab"><i
							class="fa fa-database"></i> 资料下载</a></li>
				</ul>

				<div id="myTabContent" class="tab-content" style="padding-top: 8px;">
					<div class="tab-pane fade active in" id="service-one">
						<div class="panel-group" v-for="menu in nodes" 
							role="tablist" aria-multiselectable="true">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab">
									<h4 class="panel-title">
										<a role="button" data-toggle="collapse"
											 v-bind:href="'#'+menu.node.id"
											aria-expanded="true" :aria-controls="menu.node.id"> <span
											class="glyphicon glyphicon-chevron-down">{{menu.node.name}}</span>
										</a>
									</h4>
								</div>
								<div :id="menu.node.id" class="panel-collapse collapse in"
									role="tabpanel" aria-labelledby="headingOne">
									<div class="">
										<div class="list-group">
											<!--<div>-->
											<a href="JavaScript:void(0)" @click="goVideo(item.node.id)" class="list-group-item"
												v-for="(item,index) in menu.children">
														{{index+1}}<span>:&nbsp;</span>
														{{item.node.name}}
													<object style="height:0px;">
													 	<a href="JavaScript:void(0)" @click.stop="viewKejian(resource.resourcePath)" v-for="resource in item.node.resources">
														 	<span
																v-bind:class="getIcon(resource.resourceType)" 
																style="margin-right: 10px; color: green;" :title="resource.resourceName"  aria-hidden="true">
															</span>
														</a>
													</object>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
					<div class="tab-pane fade" id="service-two">
						<h4>Service Two</h4>
					</div>
					<div class="tab-pane fade" id="service-three">
						<h4>Service Three</h4>
					</div>
					<div class="tab-pane fade" id="service-four">
						<h4>Service Four</h4>
					</div>
				</div>

			</div>
			<div class="col-md-3">
				<div class="" style="text-align: center;">
					<img src="images/loginback1.jpg" width="80px" height="80px"
						class="img-circle" />
				</div>
				<div style="text-align: center;">
					<h4>${teacherName}</h4>
					<p>任课老师信息描述:${teacherProfile }</p>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/jsp/public/Footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
	var viewCourse=new Vue({
		el:'#viewCourse',
		data:{
			classid:${classinfo.classId},
			nodes:[],
			getIcon:function(type){
				switch (type) {
				case 'ppt':
					return 'fa  pull-right fa-file-powerpoint-o';
					break;
				case 'word':
					return 'fa  pull-right fa-file-word-o';
					break;
				case 'pdf':
					return 'fa  pull-right fa-file-pdf-o';
					break;
				case 'video':
					return 'fa  pull-right fa-file-video-o';
					break;
				default:
					break;
				}
			}
		},
		methods:{
			goVideo:function(nodeid){
				 //进入视频频道(需要发送节点id,和班级id)
				window.open('video?classid='+viewCourse.classid+'&nodeid='+nodeid);
			},
			viewKejian:function(sourcePath){
				//查看课件
				var namesufix=sourcePath.slice(sourcePath.lastIndexOf('.')+1,-1);
				var nameprefix=sourcePath.slice(0,sourcePath.lastIndexOf('.'));
				if (namesufix !== 'pdf') {
					window.open('http://www.veton.cc/minerOnline/html/web/viewer.html?file='+nameprefix+'.pdf');
				}
			},
			setHref:function(data){
				return "#"+data;
			},
			getTree:function(classid){
				$.ajax({
					type:'get',
 					data:{
 						classid:classid,
 					},
 					url:'courseTree',
 					success:function(data){
 						/* zNodes=data; */
 						viewCourse.nodes=data.children;
 						console.log(viewCourse.nodes[1].children[0].node);
 					}
				})
			}
		},
		mounted:function(){
			//alert(this.nodes);
			this.getTree(this.classid);
		}
		
	})
	/* function treeMenu(a) {
		this.tree = a || [];
		this.groups = {};
	};
	treeMenu.prototype = {
		init: function(pid) {
			this.group();
			return this.getDom(this.groups[pid]);
		},
		group: function() {
			for(var i = 0; i < this.tree.length; i++) {
				if(this.groups[this.tree[i].pId]) {
					this.groups[this.tree[i].pId].push(this.tree[i]);
				} else {
					this.groups[this.tree[i].pId] = [];
					this.groups[this.tree[i].pId].push(this.tree[i]);
				}
			}
		},
		getDom: function(a) {
			if(!a) { return '' }
			var html = '\n<ul >\n';
			for(var i = 0; i < a.length; i++) {
				html += '<li><a href="#">' + a[i].name + '</a>';
				html += this.getDom(this.groups[a[i].id]);
				html += '</li>\n';
			};
			html += '</ul>\n';
			return html;
		}
	};
	var html = new treeMenu(zNodes).init(0);
	alert(zNodes);
	document.write(html); */
</script>

</html>