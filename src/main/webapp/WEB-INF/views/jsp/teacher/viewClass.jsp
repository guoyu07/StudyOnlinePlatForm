<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section>
<style>
.breadcrumb {
	margin-bottom: 8px;
}
</style>
	<div id="viewClass">
		<ol class="breadcrumb">
			<li><a href="teacher">Home</a></li>
			<li><a href="#courseManager" @click="navto()">课程管理</a></li>
			<li class="active">班级概览</li>
		</ol>
		<div class="panel panel-default" style="margin-bottom: 10px !important;">
			<div class="panel-heading">
				<span style="font-weight: bold;">班级信息表</span>
			</div>
			<table class="table table-bordered ">
				<tbody>
					<tr>
						<td align="right">班号:</td>
						<td align="center">${clazz.classOrder}</td>
						<td align="right">任课老师:</td>
						<td align="center">${name }</td>
						<td align="right">课程名称:</td>
						<td align="center">${clazz.courseEntity.courseName }</td>
					</tr>
					<tr>
						<td align="right">学员总数:</td>
						<td align="center">${numbers }</td>
						<td align="right">开班日期:</td>
						<td align="center">${clazz.termStart }</td>
						<td align="right">总课时:</td>
						<td align="center">${clazz.period }</td>
					</tr>
					<tr>
						<td align="right">课程类别:</td>
						<td align="center">${clazz.courseEntity.type.course_Type_Name }</td>
						<td align="right">课程科目:</td>
						<td align="center">${clazz.courseEntity.category.category_Name }</td>
						<td align="right">面向对象:</td>
						<td align="center">${clazz.courseEntity.targetUser }</td>
						
						
					</tr>
					<tr>
						
						<td align="right">课程海报:</td>
						<td align="center">
							<img class="img-response" style="height: 80px;" alt="" src="${clazz.classPoster }">
						</td>
						<td align="right">课程简介:</td>
						<td  colspan="4">${clazz.briefIntroduce }</td>
					</tr>
				</tbody>
			</table>
			<div class="panel-footer"> 
				<button class="btn btn-info" @click="editClass()">编辑</button>
			</div>
		</div>
		<el-dialog title="编辑班级信息" v-model="editClassForm" :close-on-click-modal="false">
            <el-form :model="editForm" label-width="80px"  :rules="editFormRules" ref="editForm">
                <el-form-item label="权限ID" prop="permissionId">
                    <el-input v-model="editForm.permissionId" :disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="权限名称" prop="authority">
                    <el-input v-model="editForm.authority"></el-input>
                </el-form-item>
                <el-form-item label="权限描述" prop="description">
                    <el-input v-model="editForm.description" ></el-input>
                </el-form-item>

            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click.native="editClassForm = false">取消</el-button>
                <el-button type="primary" @click="editSubmit()" :loading="editLoading">提交</el-button>
            </div>
        </el-dialog>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span style="font-weight: bold;">学生信息表</span>
			</div>
			<div class="panel-body" style="padding: 0px">
				<table class="table table-bordered table-hover table-striped table-condensed ">
					<thead>
						<td>学号</td>
						<td>姓名</td>
						<td>性别</td>
						<td>学院</td>
						<td>手机号</td>
						<td>邮箱</td>
						<td>上次登录时间</td>
						<td>学习时长</td>
						
					</thead>
					<tr>
					<c:forEach items="${students}" var="student">
						<td>${student.studentinfo.userid }</td>
						<td>${student.studentinfo.accountInfo.user_Name }</td>
						<td>${student.studentinfo.accountInfo.gender }</td>
						<td>${student.studentinfo.accountInfo.schoolName }</td>
						<td>${student.studentinfo.accountInfo.phoneNum }</td>
						<td>${student.studentinfo.accountInfo.email }</td>
						<td>${student.studentinfo.lastLoggedTime }</td>
						<td>学习时长</td>
					</c:forEach>
					</tr>
				</table>
				<!-- <el-table ref="singleTable" :data="tableData" highlight-current-row
					style="width: 100%"> <el-table-column type="index"
					width="50"> </el-table-column> <el-table-column property="date"
					label="日期" width="120"> </el-table-column> <el-table-column
					property="name" label="姓名" width="120"> </el-table-column> <el-table-column
					property="address" label="地址"> </el-table-column> </el-table> -->
					
			</div>
		</div>

	</div>

	<script>

var viewClass=new Vue({
	el:"#viewClass",
	data:{
		editLoading:false,
		editClassForm:false,
		editForm:{
            roleId:'',
            roleName:'',
            description:''
        },
        editFormRules:{
            permissionId:[
                {required: true, message: '请输入ID'}
            ],
            authority:[
                {required: true, message: '请输入一个权限名称'}
            ],
            description:[
                {required: true, message: '请输入描述字符'}
            ]
        },
		members:null,
	    currentRow: null
	},
	methods:{
		navto:function(){
			$.ajax({
                type:'GET',
                url:'getTeacherPanel',
                data:{
                    menu:'teachManager'
                },
                success:function(msg){
                    $('section').replaceWith(msg);
                    $("script[src='js/viewClass.js']").remove;
                }
            });
		},
		editClass:function(){
			this.editClassForm=true;
		},
		editSubmit:function(){
			
		}
	},
	mounted:function(){
		
	}
	})
</script>
</section>