
package indi.jack.testController;

import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title:HelloController</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月9日 上午9:09:04
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import indi.jack.testservice.GreetingService;


@Controller
public class HelloController
{
    private GreetingService greetingService;

    @ResponseBody
    @RequestMapping(value="/hellogo", produces = "application/json; charset=utf-8")
    public String helloWorld()
    {	
    	
        return "hello程序已启动!";
    }

    @ResponseBody
    @RequestMapping(value = "/hello", params = {"name"})
    public String helloName(@RequestParam("name") String name)
    {
        return this.greetingService.getGreeting(name);
    }

    @Autowired
    public void setGreetingService(GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }
}
