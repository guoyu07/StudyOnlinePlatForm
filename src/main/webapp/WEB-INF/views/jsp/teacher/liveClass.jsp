<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<section>
	<style type="text/css">
		.col-center-block {
				float: none;
				display: block;
				margin-left: auto;
				margin-right: auto;
			}
	</style>
	<link href="css/ystep.css" rel="stylesheet">
	<script  src="js/ystep.js"></script>
	<div id="liveClass">
		<ol class="breadcrumb">
	  	  <li><a href="teacher">Home</a></li>
		  <li class="active">课堂直播</li>
		</ol>
		<div class="row">
			<div class="col-md-12">
				<h3>开播流程</h3>
				  <div class="ystep2 col-center-block" ></div>
				<button class="btn btn-success pull-right" onclick="applyroom()" data-toggle="modal" data-target="#myModal">申请开播</button>  
			</div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">  
			    <div class="modal-dialog" role="document">  
			        <div class="modal-content">  
			            <div class="modal-header">  
			                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span  
			                        aria-hidden="true">×</span></button>  
			                <h4 class="modal-title" id="exampleModalLabel">New message</h4>  
			            </div>  
			            <div class="modal-body">  
			                <form>  
			                    <div class="form-group">  
			                        <label for="recipient-name" class="control-label">Recipient:</label>  
			                        <input type="text" class="form-control" id="recipient-name">  
			                    </div>  
			                    <div class="form-group">  
			                        <label for="message-text" class="control-label">Message:</label>  
			                        <textarea class="form-control" id="message-text"></textarea>  
			                    </div>  
			                </form>  
			            </div>  
			            <div class="modal-footer">  
			                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>  
			                <button type="button" class="btn btn-primary">Send message</button>  
			            </div>  
			        </div>  
			    </div>  
			</div> 
		</div>
	</div>
	<script type="text/javascript">
	$(".ystep2").loadStep({
	      size: "large",
	      color: "green",
	      steps: [{
	        title: "完善信息",
	        content: "需要匹配个人主播信息"
	      },{
	        title: "申请",
	        content: "申请开通直播"
	      },{
	        title: "填写信息",
	        content: "填写直播间相关信息"
	      },{
	        title: "获取房间号",
	        content: "审核通过后会通知主播房间号，每个主播有唯一的房间"
	      },{
	        title: "直播客户端",
	        content: "必须通过电脑的obs直播软件进行直播"
	      },{
		        title: "开始直播",
		        content: "可以进行直播啦！发送推送"
		   }]
	    });
	$(".ystep2").setStep(6);
	function applyroom() {
		
	}
	</script>
</section>