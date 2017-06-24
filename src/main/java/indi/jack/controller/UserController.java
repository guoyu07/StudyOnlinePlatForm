/**
 * 
 */
package indi.jack.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PageableDefaults;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;
import indi.jack.entity.RoleEntity;
import indi.jack.entity.UserInfoEntitySearchable;
import indi.jack.entity.UserPrincipal;
import indi.jack.model.BatchRegisterModel;
import indi.jack.model.ChangePwdModel;
import indi.jack.model.LoginForm;
import indi.jack.model.RegisterModel;
import indi.jack.model.ResultModel;
import indi.jack.service.AccountInfoService;
import indi.jack.service.RoleService;
import indi.jack.service.UserPrincipalService;
import indi.jack.util.ReadFile;

/**
 * <p>Title:UserController</p>
 * <p>Description:用户控制器</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月22日 下午7:23:00
 */
@Controller
public class UserController {
	
	@Inject RoleService roleSevice;
	@Resource(name="UserPrincipalServiceImpl")
	UserPrincipalService userPrincipalService;
	@Inject AccountInfoService accountInfoService;
	
	/**
	 * 登录视图转发，用于配合spring security进行验证
	 * 所以不需要手动验证用户
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView loginPage(Map<String, Object> model){
		//如果以认证过直接跳转
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null&&
			    !authentication.getPrincipal().equals("anonymousUser")&&
			    authentication.isAuthenticated()){
			return new ModelAndView(new RedirectView("/testUserprincipalDao",true,false));
		}
		//将所有角色发送给登录和注册页面
		Iterable<RoleEntity> roles=roleSevice.getAllRoles();
		model.put("roles", roles);
		model.put("user", new LoginForm());
		model.put("registerForm", new RegisterModel());
		return new ModelAndView("login/login");
	}
	//该方法不会执行post提交处理交给springsecurity处理
	@RequestMapping(value="/login_process",method=RequestMethod.GET)
	public String loginProcess(){
		System.out.println("进入loginprocess");
		return "/";
	}
	//退出登录==》不会处理交给spring security
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logoutProcess(){
		System.out.println("进入logoutProcess");
		return "/";
	}
	//spring mvc的控制器
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public View register(RegisterModel user){
		System.out.println("上传的数据=="+user.getUserId()+user.getRoleid()+"=="+user.getPassword());
		UserPrincipal userPrincipal=new UserPrincipal();
		userPrincipal.setUserid(user.getUserId());
		userPrincipal.setRoleid(user.getRoleid());
		//System.out.println("注册时间"+userPrincipal.getRegisterTime()+"布尔值"+userPrincipal.isAccountNonExpired());
		userPrincipalService.saveUserPrincipal(userPrincipal, user.getPassword());
		return new RedirectView("/login?register=success",true,false);
	}
	//restweb的注册控制器
	@RequestMapping(value="/register_r",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> register_r(@RequestBody @Valid RegisterModel user,Errors errors){
		/*Map<String, ResultModel<UserPrincipal> > result=new HashMap<>();
		ResultModel<UserPrincipal> resultModel=new ResultModel<>();*/
		Map<String, String> res=new HashMap<>();
		if(errors.hasErrors()){
			System.out.println("进入了验证");
			List<ObjectError> errors2=errors.getAllErrors();
			Iterator<ObjectError> iterator= errors2.iterator();
			while (iterator.hasNext()) {
				ObjectError objectError = (ObjectError) iterator.next();
				System.out.println(objectError.getDefaultMessage());
			}
			/*resultModel.setOperation_res(false);
			resultModel.setOperation_res_details("填写的注册信息不正确，请按规则注册");
			result.put("result", resultModel);*/
			res.put("res", "ERROR");
			res.put("info", "填写的注册信息不正确，请按规则注册");
		}
		UserPrincipal userPrincipal=new UserPrincipal();
		userPrincipal.setUserid(user.getUserId());
		userPrincipal.setRoleid(user.getRoleid());
		userPrincipal.setAccountInfo(user.getAccountInfo());
		UserPrincipal registeredUser=userPrincipalService.saveUserPrincipal(userPrincipal, user.getPassword());
		if(registeredUser==null){
			/*resultModel.setOperation_res(false);
			resultModel.setOperation_res_details("该用户账号已被注册");
			resultModel.setDatamodel(registeredUser);
			result.put("result", resultModel);*/
			
			res.put("res", "ERROR");
			res.put("info", "该用户账号已被注册");
		}else{
			res.put("res", "OK");
			res.put("info", "");
		}
		/*resultModel.setOperation_res(true);
		resultModel.setOperation_res_details("注册成功");
		resultModel.setDatamodel(registeredUser);
		result.put("result", resultModel);*/
		return res;
	}
	/*@RequestMapping(value="/roles")
	@ResponseBody
	public Iterable<RoleEntity> getRoleName(){
		Iterable<RoleEntity> roleEntities=roleSevice.getAllRoles();
		return roleEntities;
	}*/
	//删除用户
	@RequestMapping(value="/delete/{userId:\\d+}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String, String> deleteUser(@PathVariable("userId") Long userId){
		Map<String, String> res=new HashMap<>();
		try {
			userPrincipalService.deleteUserPrincipalByid(userId);
			res.put("DELETE_OK", "");
		} catch (Exception e) {
			res.put("DELETE_ERROR", "用户信息不存在");
		}
		return res;
	}
	//批量注册
	@RequestMapping(value="/batch_register",method=RequestMethod.POST)
	@ResponseBody
	public void batchRegister(BatchRegisterModel batchRegisterModel){
		List<MultipartFile> files=batchRegisterModel.getFiles();
		Integer roleid= batchRegisterModel.getRoleid();
		//判断上传的文件不为空
		if(roleid!=null&&!files.isEmpty()){
			 for(MultipartFile file : files){
				 try {
					ReadFile.readExcel(file.getInputStream(), batchRegisterModel);
				} catch (IOException e) {
					e.printStackTrace();
				}
			 }
		}
	}
	//修改密码
	@RequestMapping(value="/changepwd",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> changePassword(ChangePwdModel model,Errors errors){
		Map<String , String> res=new HashMap<>();
		if(errors.hasErrors()){
			//bean验证错误
			res.put("CHANGE_ERROR", "上传的信息不正确");
		}else{
			
			UserPrincipal user=userPrincipalService.getUserPrincipalById(model.getUserid());
			if(user!=null){
				//获取spring security 的身份验证信息
				Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
				if(authentication!=null&&
					    !authentication.getPrincipal().equals("anonymousUser")&&
					    authentication.isAuthenticated()){
					//说明用户已经登录
					if(authentication.getName().equals(String.valueOf(user.getUserid()))){
						//当前登录用户=要修改密码的用户
						user.setHashPassword(null);
						UserPrincipal changedUser=userPrincipalService.mergeUserPrincipal(user, model.getNewPwd());
						if(changedUser!=null){
							res.put("CHANGE_SUCCESS", "VVV");
							res.put("NEW_PASSWORD", String.valueOf(model.getNewPwd()));
						}
					}
				}
			}
		}
		return res;
	}
	/*//获取所有用户
	@RequestMapping(value="/user_all",method=RequestMethod.GET)
	@ResponseBody
	public Iterable<UserInfoEntitySearchable> getAllUser(){
		return accountInfoService.getAllUserInfoNoPages();
	}
	//获取用户信息（分页）
	@RequestMapping(value="/user",method=RequestMethod.GET)
	@ResponseBody Page<UserInfoEntitySearchable> getUserBypage(@PageableDefault(value = 15, sort = { "userid" },
	direction = Sort.Direction.DESC) Pageable pageable){
		return accountInfoService.getAllUserInfo(pageable);
	}*/
	
}
