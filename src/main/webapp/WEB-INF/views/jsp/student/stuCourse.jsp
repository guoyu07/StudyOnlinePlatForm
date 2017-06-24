<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!-- <!DOCTYPE html >
<html>

<body> -->

<div id="stuCourse" class="panel panel-default" >
          <div class="panel-heading">
            <h3 class="panel-title" onclick="test2();">{{course}}</h3>
          </div>
          <div class="panel-body">
			<el-row :gutter="16" id="stuCourse">
		 	 <el-col :span="6" v-for="(o, index) in 4">
			    <el-card :body-style="{ padding: '0px' }">
			      <img class="" src="http://element.eleme.io/static/hamburger.50e4091.png" class="image">
			      <div style="padding: 0px;">
			        <span>好吃的汉堡</span>
			        <div class="bottom clearfix">
			          <time class="time">{{ currentDate }}</time>
			          <el-button type="text" class="button">操作按钮</el-button>
			        </div>
			      </div>
			    </el-card>
		  	 </el-col>
			</el-row>
			<h1>${names }</h1>
          	<h5>测试数据{{testget}}</h5>
          	<el-button type="primary" @click="getdata">测试数据</el-button>
          </div>
</div>



<script type="text/javascript">
	var stuCourse=new Vue({
	    el:'#stuCourse',
	    data:{
	        course:"我的课程",
	        currentDate: new Date(),
	        testget:'${gender}'
	    },
	    methods:{
			getdata(){
				this.testget=$.ajax('roles');
			}
	    }
	})
</script>
<!-- </body>
</html> -->