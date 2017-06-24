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
		<meta charset="UTF-8">
		<title>教学内容编辑</title>
		<link rel="stylesheet" href="css/bootstrap.css" />
		<link rel="stylesheet" href="css/fileinput.css" />
		<link rel="stylesheet" href="css/metroStyle/metroStyle.css" />
		<link rel="stylesheet" href="css/summernote.css" />
		<link rel="stylesheet" href="css/course-edit-style.css" />
		<script type="text/javascript" src="js/jquery-2.1.0.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<script type="text/javascript" src="js/fileinput.js" ></script>
		<script type="text/javascript" src="js/zh.js" ></script>
		<script type="text/javascript" src="js/summernote.js" ></script>
		<script type="text/javascript" src="js/summernote-zh-CN.js" ></script>
		<script type="text/javascript" src="js/jquery.ztree.core.js" ></script>
		<script type="text/javascript" src="js/jquery.ztree.excheck.js" ></script>
		<script type="text/javascript" src="js/jquery.ztree.exedit.js" ></script>
		<style type="text/css">
			
		</style>
	</head>
	<body>	
		
		<div class="wrapper">
				<!--
                	作者：979783618@qq.com
                	时间：2016-12-25
                	描述：左侧菜单编辑区
                -->
				<div class="" style=" background-color: ">
							
								<div class="panel-heading side-nav-title">
									<h5 class="panel-title" >编辑目录</h5>
								</div>
							
							<div class="side-nav">
								<ul id="treeDemo" class="ztree "></ul>
							</div>
							<div class="side-nav-savebtn" >
								<button class="btn btn-info btn-block" onclick="viewClass()">预览内容</button>
							</div>
				</div>
				            
               	<div class="panel-heading rightpanel-title" >
					<h5 class="panel-title " id="charpter-title" style="overflow:hidden;white-space:nowrap;text-overflow:ellipsis; color: white;">编辑内容</h5>
				</div>  
				<!--
                	作者：979783618@qq.com
                	时间：2016-12-25
                	描述：右侧内容编辑区
              -->  
				<div class="rightpanel">
					<div class="container-fluid">
						<div class="row">
							<ul id="nodeTabs" class="nav nav-tabs nav-justified  operation-tabs" style="background-color:;">
								<li>
									<a href="#contentEdit-panel" >章节简介<i class="fa fa-edit"></i></a>
								</li>
								<li >
									<a href="#kejian-panel" >添加课件<i class="fa fa-file-powerpoint-o"></i></a>
								</li>
								<li>
									<a href="#shiping-panel" >添加视频<i class="fa fa-video-camera" ></i></a>
								</li>
								<li>
									<a href="#zuoye-panel" >添加作业<i class="fa fa-paper-plane"></i></a>
								</li>
								<li>
									<a href="#ziliao-panel" >添加资料<i class="fa fa-file"></i></a>
								</li>
								<li class="active">
									<a href="#help-panel" data-toggle="tab" >小助手<i class="fa fa-file"></i></a>
								</li>
							</ul>
							<div class="tab-content operation-content" id="tab-content" style="padding-top: 20px;">
							<div class="tab-pane  fade in "  id="contentEdit-panel">							  
				               	 <textarea class="summernote"></textarea>
				               	 <button type="submit" onclick="editSubmit()" class="btn btn-default center-block">提交</button>
							</div>	
							<div class="tab-pane fade "  id="kejian-panel">	
				                <%-- <form enctype="multipart/form-data">					                
					                <input id="kejian" class="projectfile" name="ppt" type="file" >
					            </form>	 --%>
							</div>
							<div id="shiping-panel" class="tab-pane  fade">
								<form enctype="multipart/form-data">					                
					                <input id="shiping" name="video" type="file" >
					            </form>	
							</div>
							<div id="zuoye-panel" class="tab-pane fade">
								作业编辑
							</div>
							<div id="help-panel"  class="tab-pane active fade in">
								帮助内容---》如何编辑---》如何保存
							</div>
							<div id="ziliao-panel" class="tab-pane fade">
								<form enctype="multipart/form-data">					                
					                <input id="ziliao" name="file-fr[]" type="file" multiple>
					            </form>	
							</div>
						</div>
						</div>	
					</div>	
				</div>
		</div>		
		<SCRIPT type="text/javascript">
        
        var setting = {
            view: {
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false,
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: true,
                removeTitle:"删除",
                renameTitle:"重命名",
                
            },
            callback: {
				onClick: zTreeOnClick,
				beforeRemove: zTreeBeforeRemove,
				onRename:zTreeOnRename
				/* onNodeCreated: zTreeOnNodeCreated */
			}
        };
        var nodeinfo={
        		id:null,
        		pId:null,
        		level:null,
        		name:"新章节",
        		classId:${classid},
        		chapterAbstract:null,
        		chapterTest:null,
        		width:null
        };
        var zNodes=${courseTree};
        var editor=null;
        var kejian=null;
        var tabState=null;
        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
           
           
           	
        });
        //处理面板点击事件，对各个面板进行初始化
        $('#nodeTabs a').click(function(e){
      	  e.preventDefault();
      	  tabState=this.hash;
      	  switch (this.hash) {
				case "#kejian-panel":
					$('#kejian-panel').html('');
					$('#kejian-panel').html('<form enctype="multipart/form-data">'+					                
		                '<input id="kejian"  name="ppt" type="file" >'+
		            '</form>');
					$('#kejian').fileinput({
		            	uploadUrl: 'upload_kejian',
				        language : 'zh',
				        maxFileSize : 100000,
				        allowedPreviewTypes:false,
				        uploadExtraData:{nodeid:nodeinfo.id},
				        allowedFileExtensions: ['ppt', 'doc','docx', 'pdf']
		            });
				break;
				case "#shiping-panel":
					$('#shiping-panel').html('');
					$('#shiping-panel').html('<form enctype="multipart/form-data">'+					                
		                '<input id="shiping"  name="video" type="file" >'+
		            '</form>');
					$('#shiping').fileinput({
		            	uploadUrl: 'upload_shipin', 
				        language : 'zh',
				        maxFileSize : 1000000,
				        uploadExtraData:{nodeid:nodeinfo.id},
				        allowedFileExtensions: ['mp4', 'avi','mkv', 'flv']
		            });
				break;	
				case "#zuoye-panel":
					
				break;
				case "#ziliao-panel":
					$('#ziliao').fileinput({
		            	uploadUrl: 'www.baidu.com', 
				        language : 'zh',
		            });
				break;	
				case "#contentEdit-panel":
					var hello='<h1 style="text-align: center;">您可以在这里编辑章节内容介绍</h1>';
					editor = $('.summernote').summernote({
				        height: 350,
				        tabsize: 2,
				        lang: 'zh-CN'
				    });
					if(nodeinfo.chapterAbstract!=null){
						editor.summernote('code',nodeinfo.chapterAbstract);
					}else{
						editor.summernote('code',hello);
					}
		           	
				break;

			default:
				break;
			}
      		$(this).tab('show');
      	})
        function editSubmit() {
        	var editContent=editor.summernote('code');
        	nodeinfo.chapterAbstract=editContent;
        	$.ajax({
            	type:'post',
            	contentType: "application/json; charset=utf-8",
            	data:JSON.stringify(nodeinfo),
            	url:'updateNode',
            	success:function(data){
            		return true;
            	},
            	error:function(){
            		return false;
            	}
            });
			alert(editContent);
		}
        function addHoverDom(treeId, treeNode) {
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='添加章节' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_"+treeNode.tId);
            if (btn) btn.bind("click", function(){
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                //通过ajax保存该节点到数据库，并返回该节点信息
                var nodepost={
                		id:null,
                		pId:treeNode.id,
                		level:treeNode.level,
                		name:"新章节",
                		classId:${classid},
                		chapterAbstract:null,
                		chapterTest:null,
                		width:null	
                }
                
                /* nodeinfo.pId=treeNode.id;
                nodeinfo.level=treeNode.level;
                nodeinfo.name="新章节"; 
                alert(treeNode.id); */
                $.ajax({
                	type:'post',
                	contentType: "application/json; charset=utf-8",
                	data:JSON.stringify(nodepost),
                	url:'courseTreeNode',
                	success:function(data){
                		//alert(JSON.stringify(data));
                		zTree.addNodes(treeNode, data);
                	},
                	error:function(){
                		
                	}
                });
                
                return false;
            });
        };
        function zTreeOnNodeCreated(event, treeId, treeNode) {
            alert(treeNode.tId + ", " + treeNode.name);
        };
        function zTreeBeforeRemove(treeId, treeNode) {
        	if(treeNode.pId==null||treeNode.isParent){
        		return false;
        	}
        	var url='deleteNode/'+treeNode.id;
        	$.get(url,function(data){
        		return true;
        	});
        };
        function removeHoverDom(treeId, treeNode) {
            $("#addBtn_"+treeNode.tId).unbind().remove();
        };
        function updateNodeinfo(treeNode) {
        	nodeinfo.id=treeNode.id;
        	nodeinfo.pId=treeNode.pId;
            nodeinfo.level=treeNode.level;
            nodeinfo.name=treeNode.name;
    		nodeinfo.classId=${classid},
    		nodeinfo.chapterAbstract=treeNode.chapterAbstract,
    		nodeinfo.chapterTest=treeNode.chapterTest,
    		nodeinfo.width=treeNode.width
		}
        function zTreeOnRename(event, treeId, treeNode, isCancel) {
        	//更新节点名称
        	updateNodeinfo(treeNode);
            $.ajax({
            	type:'post',
            	contentType: "application/json; charset=utf-8",
            	data:JSON.stringify(nodeinfo),
            	url:'updateNode',
            	success:function(data){
            		return true;
            	},
            	error:function(){
            		return false;
            	}
            });
        };
        function zTreeOnClick(event, treeId, treeNode) {
        	if(!treeNode.isParent){
		    	updateNodeinfo(treeNode);
		    	//手动触发当前面板点击事件
		    	$('#nodeTabs a[href='+tabState+']').trigger('click');
		   		changeTitle($('#charpter-title'),treeNode.name);
		    }
		};
		function changeTitle($obj,title){
			/*alert(title);*/
			/*$obj.append(title);*/
			var html='<'
			$obj.html("正在编辑:&nbsp;&nbsp; "+title);
		}
		function viewClass(){
			//预览界面跳转
			//window.location="viewCourse?classid="+nodeinfo.classId;
			window.open("viewCourse?classid="+nodeinfo.classId);
		}
   </SCRIPT>
	</body>
	
</html>