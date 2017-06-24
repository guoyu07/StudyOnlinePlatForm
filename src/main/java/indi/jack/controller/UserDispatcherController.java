/**
 * 
 */
package indi.jack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title:UserDispatcherController</p>
 * <p>Description:用户登录成功后页面分发器</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月24日 下午4:37:19
 */
@Controller
public class UserDispatcherController {
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public ModelAndView  adminPage(){
		
		return new ModelAndView("/admin/main");
	}
	@RequestMapping(value="/study",method=RequestMethod.GET)
	public ModelAndView  stuPage(){
		
		return new ModelAndView("/student/main");
	}
	@RequestMapping(value="/teacher",method=RequestMethod.GET)
	public ModelAndView  teachPage(){
		
		return new ModelAndView("/teacher/main");
	}
}
