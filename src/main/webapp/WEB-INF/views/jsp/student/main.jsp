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
<!-- 引入样式 -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生界面</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/jsp/public/Header.jsp"></jsp:include>    
	<!--学生主界面开始-->
  <div class="container">
    <div class="row">
      <!--左侧菜单栏开始-->
      <div class="col-md-2" id="leftMenu">
        <div class="list-group">
          <a href="#" class="list-group-item ">
            <h4 class="list-group-item-heading">
              操作菜单
            </h4>
          </a>
          <a href="stuCourse" class="list-group-item active">
            <h4 class="list-group-item-heading">
              我的课程
            </h4>
          </a>
          <a href="homeWork"  class="list-group-item">
            <h4 class="list-group-item-heading">
              我的作业
            </h4>
          </a>
          <a href="#" class="list-group-item">
            <h4 class="list-group-item-heading">
              学习资料
            </h4>
          </a>
          <a href="#" class="list-group-item">
            <h4 class="list-group-item-heading">
              我的笔记
            </h4>
          </a>
          <a href="#" class="list-group-item">
            <h4 class="list-group-item-heading">
              我的问答
            </h4>
          </a>
          <a href="#" class="list-group-item">
            <h4 class="list-group-item-heading">
              我的收藏
            </h4>
          </a>
          <a href="#" class="list-group-item">
            <h4 class="list-group-item-heading">
              我的好友
            </h4>
          </a>
          <a href="#" class="list-group-item">
            <h4 class="list-group-item-heading">
              咨询帮助
            </h4>
          </a>
        </div>
      </div>
      <!--左侧菜单栏结束-->
      <!--右侧操作面板开始-->
      <div class="col-md-10" id="StudentPanel">
          <jsp:include page="/WEB-INF/views/jsp/student/stuCourse.jsp"></jsp:include>
      </div>
      <!--右侧操作面板结束-->
    </div>
  </div>
  
  <!--学生主界面结束-->
<jsp:include page="/WEB-INF/views/jsp/public/Footer.jsp"></jsp:include>    
</body>

<script type="text/javascript">
   $(function() {
		  console.log("dom准备完毕");  
	      $("#leftMenu a").click(function (event) {
	    	  console.log("点击");
	          event.preventDefault();
	          var menu=$(this).attr('href');
	          getPanel(menu);
	      });
	      var testmain="jack";
	      function getPanel(menu) {
	        return $.ajax({
	        	type:'GET',
	        	url:'getPanel', 
	        	data:{
	        		menu:menu
	        	},
	        	success:function(msg){
	        		/* alert(msg); */
	        		$('#StudentPanel').html(msg);
	        	}
	        	});
	        }
	});
	 

</script>
</html>