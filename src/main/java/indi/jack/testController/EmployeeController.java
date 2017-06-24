package indi.jack.testController;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import indi.jack.testEntity.Employee;
import indi.jack.testEntity.EmployeeForm;
import indi.jack.testservice.EmployeeService;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class EmployeeController
{
    @Inject EmployeeService employeeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listEmployees(Map<String, Object> model)
    {	
    	try {
    		model.put("employees", this.employeeService.getAllEmployees());
		} catch (ConstraintViolationException e) {
			for(ConstraintViolation violation:e.getConstraintViolations())
			{
				System.out.println(violation.getMessageTemplate());
			}	
		}
        
        return "employee/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createEmployee(Map<String, Object> model)
    {
        model.put("employeeForm", new EmployeeForm());
        return "employee/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView createEmployee(Map<String, Object> model,
                                       @Valid EmployeeForm form, Errors errors)
    {
        if(errors.hasErrors()){
        	for(ObjectError error:errors.getAllErrors()){
        		
        		System.out.println("错误=="+error.getDefaultMessage()+"错误名称"+error.getObjectName()+"错误码"
        		+error.getCode()+"错误参数"+error.getArguments());
        	}
        	
            return new ModelAndView("employee/create");
        }
        Employee employee = new Employee();
        employee.setFirstName(form.getFirstName());
        employee.setLastName(form.getLastName());
        employee.setMiddleName(form.getMiddleName());

        try
        {
            this.employeeService.saveEmployee(employee);
        }
        catch(ConstraintViolationException e)
        {
            model.put("validationErrors", e.getConstraintViolations());
            return new ModelAndView("employee/create");
        }

        return new ModelAndView(new RedirectView("/", true, false));
    }
}
