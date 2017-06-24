/**
 * 
 */
package indi.jack.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import indi.jack.entity.Class;
import indi.jack.entity.ClassCourseTree;
import indi.jack.entity.CourseEntity;
import indi.jack.entity.StudentClass;
import indi.jack.entity.UserPrincipal;
import indi.jack.model.TreeModel;
import indi.jack.service.ClassService;
import indi.jack.service.CourseService;
import indi.jack.service.CourseTreeService;
import indi.jack.service.UserPrincipalService;
import indi.jack.util.JsonUtils;

/**
 * <p>Title:CourseController</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月23日 下午9:49:39
 */
@Controller
public class CourseController {
	@Inject CourseService courseService; 
	@Inject ClassService classService;
	@Inject private CourseTreeService courseTreeService;
	@Resource(name="UserPrincipalServiceImpl")
	UserPrincipalService userPrincipalService;
	@RequestMapping(value="/viewCourse",method=RequestMethod.GET)
	public String viewCourse(@RequestParam(value="classid",required=true) Integer classid,Map<String, Object> model){
		Class clazz=classService.getOneClass(classid);
		UserPrincipal userPrincipal=userPrincipalService.getUserPrincipalById(clazz.getTeacherId());
		//教师名称
		String teacherName=userPrincipal.getAccountInfo().getUser_Name();
		//教师自我描述
		String teacherProfile=userPrincipal.getAccountInfo().getProfile();
		//获取班级人数和信息
		List<StudentClass> studensInClass=(List<StudentClass>) classService.getStudentsByClassId(classid);
		Integer numbers=studensInClass.size();
		//课程树
		List<ClassCourseTree> nodes=(List<ClassCourseTree>) courseTreeService.getNodesbyClassId(classid);
		//课程树根节点
		ClassCourseTree root=new ClassCourseTree();
		for(int i=0 ;i<nodes.size();i++){
			if(nodes.get(i).getpId()==null){
				root=nodes.get(i);
			}
		}
		//调用迭代方法
		TreeModel tree=new TreeModel();
		tree.setNode(root);
		JsonUtils utils=new JsonUtils();
		tree.setChildren(utils.treeMenuList(nodes, root.getId()));
		ObjectMapper mapper=new ObjectMapper();
		String classinfo="";
		String courseTree="";
		try {
			classinfo=mapper.writeValueAsString(clazz);
			courseTree=mapper.writeValueAsString(tree);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.put("total", numbers);
		model.put("profile", teacherProfile);
		model.put("classinfo", clazz);
		model.put("teacherName", teacherName);
		model.put("courseTree", courseTree);
		return "course/viewCourse";
	}
	@RequestMapping(value="/courseTree",method=RequestMethod.GET)
	@ResponseBody
	public TreeModel getCourseTree(@RequestParam(value="classid",required=true) Integer classid){
		List<ClassCourseTree> nodes=(List<ClassCourseTree>) courseTreeService.getNodesbyClassId(classid);
		ClassCourseTree root=new ClassCourseTree();
		for(int i=0 ;i<nodes.size();i++){
			if(nodes.get(i).getpId()==null){
				root=nodes.get(i);
			}
		}
		TreeModel tree=new TreeModel();
		tree.setNode(root);
		JsonUtils utils=new JsonUtils();
		tree.setChildren(utils.treeMenuList(nodes, root.getId()));
		return tree;
	}
	@RequestMapping(value="/course",method=RequestMethod.GET)
	@ResponseBody
	public Iterable<CourseEntity> getAllCourse(){
		return courseService.getAllCourse();
	}
	@RequestMapping(value="/nodeinfo",method=RequestMethod.GET)
	@ResponseBody
	public ClassCourseTree getCourseNode(){
		return courseTreeService.getOneNodebyId(22l);
	}
	@RequestMapping(value="/video",method=RequestMethod.GET)
	public String videoPlay(@RequestParam(value="classid",required=true) Integer classid,@RequestParam(value="nodeid",required=true) Long nodeid,
			Map<String, Object> model){
		List<ClassCourseTree> nodes=(List<ClassCourseTree>) courseTreeService.getNodesbyClassId(classid);
		ClassCourseTree node=courseTreeService.getOneNodebyId(nodeid);
		for(int i=0; i<nodes.size(); i++){
			if(nodes.get(i).getId()==node.getId()){
				nodes.remove(i);
			}
		}
		ClassCourseTree root=new ClassCourseTree();
		for(int i=0 ;i<nodes.size();i++){
			if(nodes.get(i).getpId()==null){
				root=nodes.get(i);
			}
		}
		TreeModel tree=new TreeModel();
		tree.setNode(root);
		JsonUtils utils=new JsonUtils();
		tree.setChildren(utils.treeMenuList(nodes, root.getId()));
		
		model.put("classid", classid);
		model.put("leftNodes", tree);
		model.put("node", node);
		return "course/videoPlayer";
	}
	@RequestMapping(value="/liveroom",method=RequestMethod.GET)
	public String liveRoom(@RequestParam(value="roomid",required=true) String roomid,Map<String, Object> model){
		//获取直播间相关信息，标题，公告,用户信息等
		
		model.put("roomid", roomid);
		return "course/liveRoom";
	}
}
