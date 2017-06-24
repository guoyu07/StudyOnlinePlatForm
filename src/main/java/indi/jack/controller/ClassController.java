/**
 * 
 */
package indi.jack.controller;

import java.lang.reflect.Method;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import indi.jack.entity.Class;
import indi.jack.entity.CourseEntity;
import indi.jack.service.ClassService;
import indi.jack.service.CourseService;
import indi.jack.service.CourseTreeService;

/**
 * <p>Title:ClassController</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月1日 下午10:04:32
 */
@Controller
public class ClassController {
	@Inject private ClassService classService;
	@Inject private CourseService courseService;
	@RequestMapping(value="/class_p/{teacherId:\\d+}")
	@ResponseBody
	public Page<Class> getClassesByTid(@PathVariable(value="teacherId") Long id,@PageableDefault() Pageable pageable){
		return classService.getClassByTeaId(id, pageable);
	}
	@RequestMapping(value="/class_t/{teacherId:\\d+}",method=RequestMethod.GET)
	@ResponseBody
	public Iterable<Class> getClassByTid(@PathVariable(value="teacherId") Long id){
		return classService.getAllClass();
	}
	@RequestMapping(value="/class_c/{classId:\\d+}",method=RequestMethod.GET)
	@ResponseBody
	public Class getClassByid(@PathVariable(value="classId") Integer id){
		return classService.getOneClass(id);
	}
	@RequestMapping(value="/class",method=RequestMethod.GET)
	@ResponseBody
	public Class saveOneclass(){
		Class clazz=new Class();
		clazz.setBriefIntroduce("课程介绍");
		clazz.setClassOrder(4);
		clazz.setClassOver(false);
		clazz.setClassPoster("海报地址");
		clazz.setCourseEntity(courseService.getOneCourseByid(1));
		clazz.setPeriod(48);
		clazz.setTeacherId(111l);
		clazz.setTermEnd(new Date());
		clazz.setTermStart(new Date());
		return classService.saveOneClass(clazz);
	}
	@RequestMapping(value="/liveClass",method=RequestMethod.GET)
	public String liveClass(){
		return "teacher/liveClass";
	}
}
