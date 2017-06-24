/**
 * 
 */
package indi.jack.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title:StudentController</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月19日 下午4:23:25
 */
@Controller
public class StudentController {
	@RequestMapping(value="/getPanel",method=RequestMethod.GET)
	public String getPanel(@RequestParam(value="menu",required=true) String menu,
			Map<String,Object> map,Model model,ModelMap modelMap){
		map.put("names", Arrays.asList("caoyc","zhh","cjx"));
	    model.addAttribute("time", new Date());
		modelMap.addAttribute("city", "ChengDu");
		modelMap.put("gender", "male");
		return "student/"+menu;
	}
}
