<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频播放</title>
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
 <link rel="stylesheet" href="css/video-js.css">
<script src="js/video.js"></script>
<script src="js/videojs-ie8.js"></script>
<style type="text/css">
	.col-center-block {
				float: none;
				display: block;
				margin-left: auto;
				margin-right: auto;
			}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/jsp/public/Header.jsp"></jsp:include>
	<div class="container">
	<div class="row" style="margin-top: 10px">
		<div class="col-md-12">
				<h3 style="margin-top: 10px">${node.name }</h3>
		</div>
		<div class="col-md-8" >
				<div  style=" background-color: black ; height: 400px; width: 100%;">
					<video  id="videoplayer"  width="640px" height="400px" class="col-center-block video-js  vjs-default-skin vjs-big-play-centered" preload="auto" controls  >
						<!-- <source src="http://opikkf1o0.bkt.clouddn.com/jiuye.mp4" type="video/mp4"> -->
					</video>
				</div>
				<!--章节介绍-->
				<div class="panel panel-default" style="margin-top: 10px;">
				  <div class="panel-heading">
				    <h3 class="panel-title">章节介绍</h3>
				  </div>
				  <div class="panel-body">
				    	${node.chapterAbstract }
				  </div>
				</div>
				<div class="panel panel-default" style="margin-top: 10px;">
				    <div class="panel-heading" role="tab" id="headingOne">
				      <h4 class="panel-title">
				        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				          	<span class="glyphicon glyphicon-chevron-down"></span>相关资料<i class="fa fa-file" aria-hidden="true"></i>
				        </a>
				      </h4>
				    </div>
				    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
				      <div class="panel-body">
				        <div class="row">
                        <div class="col-md-12">
                            <ul class="list-unstyled">
                            	<c:forEach items="${node.resources }" var="resource">
                            		<c:if test="${resource.resourceType=='ppt'}">
                            			<li><i class="fa fa-file-powerpoint-o"></i>${resource.resourceName }
                            			<span class="pull-right">
                            			<a href="${resource.resourcePath }" style="margin-right: 10px;" >下载</a>
                            			<a href="JavaScript:void(0)" onclick='viewKejian("${resource.resourcePath }");'>在线预览</a>
                            			</span>
                                	</li>
                            		</c:if>
                            		<c:if test="${resource.resourceType=='pdf'}">
                            			<li><i class="fa fa-file-pdf-o"></i>${resource.resourceName }
                            			<span class="pull-right">
                            			<a href="${resource.resourcePath }" style="margin-right: 10px;" >下载</a>
                            			<a href="JavaScript:void(0)" onclick='viewKejian("${resource.resourcePath }");'>在线预览</a>
                            			</span>
                            			</li>
                            		</c:if>
                            		<c:if test="${resource.resourceType=='word'}">
                            			<li><i class="fa fa-file-word-o"></i>${resource.resourceName }
                            			<span class="pull-right">
                            			<a href="${resource.resourcePath }" style="margin-right: 10px;" >下载</a>
                            			<a href="JavaScript:void(0)" onclick='viewKejian("${resource.resourcePath }");'>在线预览</a>
                            			</span>
                            			</li>
                            		</c:if>
                            		
                            	</c:forEach>
                            </ul>
                        </div>
                    </div>
				      </div>
				    </div>
				  </div>
                <!-- Blog Comments -->
                <!-- Comments Form -->
                <div class="well">
                    <h4>留下你的精彩评论:</h4>
                    <form role="form">
                        <div class="form-group">
                            <textarea class="form-control" rows="3"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">发送</button>
                    </form>
                </div>

                <hr>

                <!-- Posted Comments -->
                                <!-- Comment -->
                <div class="media">
                    <a class="pull-left" href="#" >
                        <img class="media-object" src="http://placehold.it/64x64" alt="">
                    </a>
                    <div class="media-body">
                        <h4 class="media-heading">张三丰
                            <small>August 25, 2014 at 9:30 PM</small>
                        </h4>
                     	   视频超级棒骄傲io文化怕我I就回家啊啊就好我怕覅啊发发觉
                    </div>
                </div>
                <!-- Comment -->
                <div class="media">
                    <a class="pull-left" href="#">
                        <img class="media-object" src="http://placehold.it/64x64" alt="">
                    </a>
                    <div class="media-body">
                        <h4 class="media-heading">李白
                            <small>August 25, 2014 at 9:30 PM</small>
                        </h4>
                        确实不错啊安静佛额奇偶危机恶化我佩服我就
                        <!-- Nested Comment -->
                        <div class="media">
                            <a class="pull-left" href="#">
                                <img class="media-object" src="http://placehold.it/64x64" alt="">
                            </a>
                            <div class="media-body">
                                <h4 class="media-heading">李小白
                                    <small>August 25, 2014 at 9:30 PM</small>
                                </h4>
                                你愿意跟我一起看吗就哦和我精辟我就怕覅
                            </div>
                        </div>
                        <!-- End Nested Comment -->
                    </div>
                </div>

		</div>
		<div class="col-md-4" style="height: 650px;">
			<!--该章节的相关视频-->
			<div id="selfMedia">
				<h4 style="margin-top: 0px; ">本章视频</h4>
					<c:forEach items="${node.resources }" var="resource">
						<c:if test="${resource.resourceType=='video' }" var="hasvideo">
							<div class="media" style="height: 94px;">
			                    <a class="pull-left" href="JavaScript:void(0)" data-videopath="${resource.resourcePath }" onclick="changeVideo(this.dataset.videopath)">
			                        <img class="media-object" style="width: 169px;height:94px;" src="http://r3.ykimg.com/050E00005840E84667BC3C674900733D" alt="">
			                    </a>
			                    <div class="media-body">
			                        <a href="JavaScript:void(0)" data-videopath="${resource.resourcePath }" onclick="changeVideo(this.dataset.videopath)"><h4 class="media-heading">${resource.resourceName }
			                        </h4></a>
			                        <small>${node.name }</small>
			                    </div>
			            	</div>
						</c:if>
					</c:forEach>
					<c:if test="${!hasvideo }">
						<p>本章没有相关视频，可以看看别的章节哦！</p>
					</c:if>
			</div>
			<!--其他章节相关视频-->
			
			<div id="nextMedia">
				<hr />
				<h4 style="">其他章节视频</h4>
				<c:forEach items="${leftNodes.children }" var="tree">
					
					<c:forEach items="${tree.children }" var="chapters">
						<c:forEach items="${chapters.node.resources }" var="resource">
							<c:if test="${resource.resourceType=='video' }">
							<div class="media" style="height: 94px;">
			                    <a class="pull-left" href='<c:url value="video"><c:param name="classid" value="${classid }"/>
			                    <c:param name="nodeid" value="${resource.courseTreeNodeId }"/></c:url>' >
			                        <img class="media-object" style="width: 169px;height:94px;" src="http://r3.ykimg.com/050E00005840E84667BC3C674900733D" alt="">
			                    </a>
			                    <div class="media-body">
			                        <a href="<c:url value="video"><c:param name="classid" value="${classid }"/>
			                    <c:param name="nodeid" value="${resource.courseTreeNodeId }"/></c:url>" ><h4 class="media-heading">${resource.resourceName }
			                        </h4></a>
			                        <small class="">${chapters.node.name }</small>
			                    </div>
			            	</div>
							</c:if>
							
						</c:forEach>
						
						
					</c:forEach>
				</c:forEach>
			</div>
		</div>
	</div>
	</div>
</body>
<script type="text/javascript">
	var videoPlayer=null;
	$(document).ready(function() {
		videoInit();
		//模拟点击视频列表第一个
		$($($('#selfMedia').children('div').get(0)).children('a').get(0)).click();
		
		
	})
	function viewKejian(sourcePath) {
		//查看课件
		var namesufix=sourcePath.slice(sourcePath.lastIndexOf('.')+1,-1);
		var nameprefix=sourcePath.slice(0,sourcePath.lastIndexOf('.'));
		if (namesufix !== 'pdf') {
			window.open('http://www.veton.cc/minerOnline/html/web/viewer.html?file='+nameprefix+'.pdf');
		}
		//event.stopPropagation();
	}
	function videoInit() {
		videoPlayer=videojs('videoplayer',{
			//初始化数据
				"techOrder": ["html5","flash"],
			    "autoplay":true,
			    control: {
			        /* captionsButton: true,
			        chaptersButton : true,
			        liveDisplay:true,
			        playbackRateMenuButton: true,
			        subtitlesButton:true */
			      }
			},
			//触发事件
			function(){
				//alert('Good to go!');
				this.on('loadeddata',function(){
			        console.log(this)
			    })
			
			    this.on('ended',function(){
			    	alert("结束");
			         this.pause();
			         this.hide();
			    })
			}
			)
	}
	function changeVideo(href){
		videoPlayer.src(href);
		videoPlayer.poster('http://vjs.zencdn.net/v/oceans.png');
		videoPlayer.load();
	}
</script>
</html>