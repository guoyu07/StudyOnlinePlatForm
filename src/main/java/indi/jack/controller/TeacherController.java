/**
 * 
 */
package indi.jack.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import indi.jack.entity.Class;
import indi.jack.entity.ClassCourseTree;
import indi.jack.entity.StudentClass;
import indi.jack.entity.TeachResource;
import indi.jack.entity.UserPrincipal;
import indi.jack.model.CourseNodeModel;
import indi.jack.service.ClassService;
import indi.jack.service.CourseTreeService;
import indi.jack.service.FileUtil;
import indi.jack.service.TeachResourceService;
import indi.jack.service.UserPrincipalService;
import indi.jack.util.PDFConvertor;

/**
 * <p>Title:TeacherController</p>
 * <p>Description:注意 如果在linux发布时，需要更改相应的文件路径</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月22日 下午11:16:05
 */
@Controller
public class TeacherController {
	//linux上ftp课件上传路径前缀  www.veton.cc/minerOnline/resources/
	private static final String  DEST_FILE_PREFIX="D:\\upload\\";
	private static final String  UPLOAD_FILE_PREFIX="/yjdata/www/www/static/minerOnline/resources/";
	private static final String  DOWNLOAD_FILE_PREFIX="http://www.veton.cc/minerOnline/resources/";
	
	@Inject private ClassService classService;
	@Inject private CourseTreeService courseTreeService;
	@Inject FileUtil fileutil;
	@Inject TeachResourceService teachResourceService; 
	@Resource(name="UserPrincipalServiceImpl")
	UserPrincipalService userPrincipalService;
	@RequestMapping(value="/getTeacherPanel",method=RequestMethod.GET)
	public String getPanel(@RequestParam(value="menu",required=true) String menu,
			Map<String,Object> map,Model model,ModelMap modelMap){
		map.put("names", Arrays.asList("caoyc","zhh","cjx"));
	    model.addAttribute("time", new Date());
		modelMap.addAttribute("city", "ChengDu");
		modelMap.put("gender", "male");
		return "teacher/"+menu;
	}
	@RequestMapping(value="/viewClass",method=RequestMethod.GET)
	public String viewClass(@RequestParam(value="classid",required=true) Integer classid,
			@RequestParam(value="teacherid",required=true) Long teacherid,Map<String, Object> model){
		Class clazz=classService.getOneClass(classid);
		UserPrincipal userPrincipal=userPrincipalService.getUserPrincipalById(teacherid);
		String teacherName=userPrincipal.getAccountInfo().getUser_Name();
		//获取班级人数和信息
		List<StudentClass> studensInClass=(List<StudentClass>) classService.getStudentsByClassId(classid);
		Integer numbers=studensInClass.size();
		System.out.println(clazz.toString());
		model.put("clazz",clazz);
		model.put("name", teacherName);
		model.put("numbers", numbers);
		model.put("students", studensInClass);
		return "teacher/viewClass";
	}
	@RequestMapping(value="/courseEdit",method=RequestMethod.GET)
	public String courseEdit(@RequestParam(value="classid",required=true) Integer classid,Map<String, Object> model){
		Iterable<ClassCourseTree> nodes=courseTreeService.getNodesbyClassId(classid);
		ObjectMapper mapper=new ObjectMapper();
		String courseTree="";
		try {
			courseTree=mapper.writeValueAsString(nodes);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(courseTree);
		model.put("courseTree", courseTree);
		model.put("classid", classid);
		return "teacher/courseEdit";
	}
	@RequestMapping(value="/courseTreeNode",method=RequestMethod.POST)
	@ResponseBody
	public ClassCourseTree saveTreeNode(@RequestBody ClassCourseTree node){
		//为节点手动设置宽度
		Integer width=courseTreeService.getWidthOfTree(node.getClassId(), node.getpId())+1;
		node.setWidth(width.shortValue());
		return courseTreeService.saveNode(node);
	}
	@RequestMapping(value="/updateNode",method=RequestMethod.POST)
	@ResponseBody
	public ClassCourseTree updateTreeNode(@RequestBody ClassCourseTree node){
		return courseTreeService.saveNode(node);
	}
	@RequestMapping(value="/deleteNode/{nodeid:\\d+}",method=RequestMethod.GET)
	@ResponseBody
	public void deleteTreeNode(@PathVariable(value="nodeid") Long nodeid){
		courseTreeService.deleteNode(nodeid);
	}
	@RequestMapping(value = "/upload_kejian", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> uploadKejian(@RequestParam(value="nodeid",required=true) Long nodeid, @RequestParam("ppt") MultipartFile files){
		String filename=files.getOriginalFilename();
		String fileWithSufix=filename.substring(0,filename.lastIndexOf("."));
		String fileType=filename.substring(filename.lastIndexOf(".")+1, filename.length()).toLowerCase();
		if(fileType.contains("doc")){
			fileType="word";
		}
		if (fileType.contains("xls")) {
			fileType="excel";
		}
		if(fileType.contains("ppt")){
			fileType="ppt";
		}
		if(fileType.contains("pdf")){
			fileType="pdf";
		}
		Map<String, String> res=new HashMap<>();
		TeachResource kejian=new TeachResource();
		kejian.setCourseTreeNodeId(nodeid);
		kejian.setResourceName(files.getOriginalFilename());
		kejian.setResourcePath(DOWNLOAD_FILE_PREFIX +files.getOriginalFilename());
		kejian.setResourceType(fileType);
		try {
			//保存文件到本地服务器
			fileutil.saveFile(files, DEST_FILE_PREFIX, files.getOriginalFilename());
			//非pdf格式转换
			if(kejian.getResourceType() != "pdf"){
				//根据返回值判断是否格式转换成功0成功 找不到源文件, 则返回-1 ,异常 1
				int transformState=PDFConvertor.office2PDF(UPLOAD_FILE_PREFIX+files.getOriginalFilename(), UPLOAD_FILE_PREFIX+fileWithSufix+".pdf");
			}
			teachResourceService.saveResource(kejian);
			res.put("OK", "上传成功");
		} catch (Exception e) {
			res.put("ERROR", "上传失败，请重新尝试！");
			e.printStackTrace();
		}
		
		return res;
	}
	@RequestMapping(value = "/upload_shipin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> uploadVideo(@RequestParam(value="nodeid",required=true) Long nodeid, @RequestParam("video") MultipartFile files){
		System.out.println("nodeid="+nodeid);
		String filepath="D:\\upload";
		Map<String, String> res=new HashMap<>();
		TeachResource video=new TeachResource();
		video.setResourceName(files.getOriginalFilename());
		video.setResourcePath("www.veton.cc/minerOnline/resources/"+files.getOriginalFilename());
		video.setResourceType("video");
		video.setCourseTreeNodeId(nodeid);
		try {
			fileutil.saveFile(files, filepath, files.getOriginalFilename());
			teachResourceService.saveResource(video);
			res.put("OK", "上传成功");
		} catch (Exception e) {
			res.put("ERROR", "上传失败，请重新尝试！");
			e.printStackTrace();
		}
		
		return res;
	}
}
