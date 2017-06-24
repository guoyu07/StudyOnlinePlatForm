/**
 * 
 */
package indi.jack.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import indi.jack.entity.AccountInfo;
import indi.jack.entity.UserInfoEntitySearchable;
import indi.jack.entity.UserPrincipal;
import indi.jack.model.SearchResult;
import indi.jack.service.AccountInfoService;
import indi.jack.service.UserPrincipalService;

/**
 * <p>Title:UserInfoController</p>
 * <p>Description:用户详细信息控制器</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月11日 下午3:53:26
 */
@Controller()
@RequestMapping(value="/userinfo")
public class UserInfoController {
	private static final Logger log=LogManager.getLogger();
	
	@Autowired AccountInfoService accountInfoService;
	@Resource(name="UserPrincipalServiceImpl")
	UserPrincipalService userPrincipalService;
	//获取用户信息不分页
	@RequestMapping(value="",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, List<UserInfoEntitySearchable>> getAccountInfoList(){
		Map<String , List<UserInfoEntitySearchable>> userInfoList=new HashMap<>();
		userInfoList.put("userInfoList", (List<UserInfoEntitySearchable>) accountInfoService.getAllUserInfoNoPages());
		return userInfoList;
		
	}
	//获取用户信息分页
	@RequestMapping(value="/page",method=RequestMethod.GET)
	@ResponseBody
	public Page<UserInfoEntitySearchable> getUserinfowithPage(@PageableDefault() Pageable pageable){
		
		return accountInfoService.getAllUserInfo(pageable);
	}
	@RequestMapping(value="/{userId:\\d+}",method=RequestMethod.GET)
	@ResponseBody
	public UserInfoEntitySearchable getOneAccountInfo(@PathVariable("userId") Long userId){
		
		return accountInfoService.getInfoByUserId(userId);
		
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public <T> Map<String, T> save(@RequestBody AccountInfo accountInfo,
			@RequestParam(required=true,value="userid") Long userid){
		Map<String, T> feedback=new HashMap<>();
		AccountInfo feedbackEntity=new AccountInfo();
		UserPrincipal user=userPrincipalService.getUserPrincipalById(userid);
		//获取用户信息表的id
		Long account_Info_Id=user.getAccountInfo().getAccount_Info_Id();
		if(account_Info_Id!=null){
			//非第一次添加信息，必须填写id
			accountInfo.setAccount_Info_Id(account_Info_Id);
		}
		user.setAccountInfo(accountInfo);
		feedbackEntity=userPrincipalService.saveUserPrincipal(user).getAccountInfo();
		try {
			feedback.put("SAVE_OK", (T) feedbackEntity);
		} catch (Exception e) {
			feedback.put("SAVE_ERROR", (T) "用户信息已存在");
		}
		return feedback;
		
	}
	
	//搜索用户信息
	@RequestMapping(value="/search",method=RequestMethod.GET)
	@ResponseBody
	public Page<UserInfoEntitySearchable> searchInfo(Pageable pageable,@RequestParam(value="query",required=true) String query){
		return accountInfoService.search(query, pageable);
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public <T> Map<String, T> update(@RequestBody AccountInfo accountInfo){
		//bean验证保证user_info_id不为空
		Map<String, T> feedback=new HashMap<>();
		AccountInfo feedbackEntity=new AccountInfo();
		try {
			feedbackEntity=accountInfoService.save(accountInfo);
			feedback.put("UPDATE_OK", (T) feedbackEntity);
		} catch (Exception e) {
			feedback.put("UPDATE_ERROR", (T) "更新失败用户信息已存在");
		}
		
		return feedback;
	
	}
	@RequestMapping(value="/{accountInfoId:\\d+}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String, String> deletebyAid(@PathVariable("accountInfoId") Long accountInfoId){
		Map<String, String> res=new HashMap<>();
		try {
			accountInfoService.deleteByUser_Info_Id(accountInfoId);
			res.put("DELETE_OK", "");
		} catch (Exception e) {
			res.put("DELETE_ERROR", "用户信息不存在");
		}
		return res;
	}
}
