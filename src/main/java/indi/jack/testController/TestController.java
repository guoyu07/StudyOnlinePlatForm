package indi.jack.testController;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import indi.jack.dao.AccountInfoDao;
import indi.jack.dao.RoleAuthorityDao;
import indi.jack.dao.UserPrincipalDao;
import indi.jack.entity.AccountInfo;
import indi.jack.entity.ApplyClassEntity;
import indi.jack.entity.RoleAuthority;
import indi.jack.entity.RoleEntity;
import indi.jack.entity.UserPrincipal;
import indi.jack.model.BatchRegisterModel;
import indi.jack.service.AccountInfoService;
import indi.jack.service.ClassService;
import indi.jack.service.FileUtil;
import indi.jack.service.UserPrincipalService;
import indi.jack.testEntity.User;
import indi.jack.testservice.AsyncMethod;
import indi.jack.testservice.SchedulerMethod;
import indi.jack.util.FileUtil1;
import indi.jack.util.ReadFile;
/**
 * <p>Title:TestController</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月9日 上午9:36:08
 */
@Controller
public class TestController {
	@Inject AsyncMethod asyncMethod;
	@Inject SchedulerMethod schedulerMethod;
	@Inject UserPrincipalDao uppd;
	@Inject RoleAuthorityDao roleAuthorityDao;
	@Inject FileUtil fileutil;
	@Inject AccountInfoService accountInfoService;
	@Inject AccountInfoDao accountInfoDao;
	/*@Inject RoleDaoHibernate roleDaoHibernate;*/
	@Resource(name="UserPrincipalServiceImpl")
	UserPrincipalService userPrincipalService;
	@Autowired RedisTemplate redisTemplate;
	@Autowired RedisTemplate<String, ApplyClassEntity> redisTemplate2;
	
	@Inject ClassService classService;
	@RequestMapping(value="/redistemp1")
	@ResponseBody
	public List<ApplyClassEntity> testredis2(){
		ApplyClassEntity model=new ApplyClassEntity();
		model.setApplicantId(132l);
		model.setClass_Introduce("班级介绍".getBytes());
		model.setClass_Poster("图片地址");
		model.setCourse_Name("大学英语");
		model.setCourseCategory(1);
		model.setPeriod(48);
		model.setTarget_User("面向大一学生");
		model.setApplyTime(new Date());
		classService.applyNewClass(model);
		return classService.getAllApplicant();
	}
	
	@RequestMapping(value="/redistemp")
	@ResponseBody
	public void testredistemp(){
		HashOperations<String, String, ApplyClassEntity> hashOperations=redisTemplate2.opsForHash();
		//BoundHashOperations<String, Object, Object> boundHashOperations=redisTemplate.boundHashOps("key");
		ApplyClassEntity model=new ApplyClassEntity();
		model.setApplicantId(12232l);
		model.setClass_Introduce("班级介绍".getBytes());
		model.setClass_Poster("图片地址");
		model.setCourse_Name("大学英语");
		model.setCourseCategory(1);
		model.setPeriod(48);
		model.setTarget_User("面向大一学生");
		//ValueOperations<String, ApplyClassModel> valueOperations=redisTemplate.opsForValue();
		//valueOperations.set(model.getObjectKey()+":"+model.getKey(), model);
		//System.out.println(valueOperations.get(model.getObjectKey()+":"+model.getKey()).getCourse_Name());
		ValueOperations<String, Object> value=redisTemplate.opsForValue();
		value.set("key1", "valueoper");
		System.out.println("从数据库获取key1="+value.get("key1"));
		//添加 一个 hash集合
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name", "lp");
        map.put("age", "26");
        hash.putAll("lpMap", map);
        //获取 map
        System.out.println(hash.entries("lpMap"));
        //添加 一个 list 列表
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush("lpList", "lp");
        list.rightPush("lpList", "26");
        //输出 list
        System.out.println(list.range("lpList", 0, 1));
        //添加 一个 set 集合
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add("lpSet", "lp");
        set.add("lpSet", "26");
        set.add("lpSet", "178cm");
        //输出 set 集合
        System.out.println(set.members("lpSet"));
        //添加有序的 set 集合
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add("lpZset", "lp", 0);
        zset.add("lpZset", "26", 1);
        zset.add("lpZset", "178cm", 2);
        //输出有序 set 集合
        System.out.println(zset.rangeByScore("lpZset", 0, 2));
	}
	@RequestMapping(value="/websocket")
	public String testsocket(){
		return "socket";
	}
	@RequestMapping(value="/websocket2")
	public String testsocket2(){
		return "socket2";
	}
	@RequestMapping(value="/testhibernate")
	@ResponseBody
	public List<RoleEntity> getallrole(){
		//return roleDaoHibernate.getRoles();
		return null;
	}
	/*@RequestMapping(value="/testaccount")
	@ResponseBody
	public Map<String, Iterable<AccountInfo>> findallAccout(){
		AccountInfo accountInfo=new AccountInfo();
		accountInfo.setAddress("云南大理");
		accountInfo.setAvatar("葛炳生的头像");
		accountInfo.setBirthDay(new Date(1995, 5, 30));
		accountInfo.setEmail("9797856546@qq.com");
		accountInfo.setGender("男");
		accountInfo.setPhoneNum("4989756516");
		accountInfo.setProfile("我是胡上杰");
		accountInfo.setSchoolName("南昌大学");
		accountInfo.setUser_Name("葛炳生");
		accountInfoDao.save(accountInfo);
		Map<String, Iterable<AccountInfo>> info=new HashMap<>();
		info.put("allaccount", null);
		return info ;
		
	}*/
	
	@RequestMapping(value="/testsaveUserprincipal")
	@ResponseBody
	public UserPrincipal saveUserPrincipal(){
		UserPrincipal principal=new UserPrincipal();
		principal.setUserid(33333553l);
		principal.setRoleid(1);
		principal.setLastLoggedTime(new Date());
		principal.setHashPassword("oiooo".getBytes());
		
		AccountInfo accountInfo=new AccountInfo();
		//accountInfo.setAccount_Info_Id(principal.getAccountInfo().getAccount_Info_Id());
		accountInfo.setAddress("云南大理");
		accountInfo.setAvatar("葛炳生的头像");
		accountInfo.setBirthDay(new Date(1995, 5, 30));
		accountInfo.setEmail("9797856546@qq.com");
		accountInfo.setGender("男");
		accountInfo.setPhoneNum("4989756516");
		accountInfo.setProfile("我是葛炳生");
		accountInfo.setSchoolName("财经大学");
		accountInfo.setUser_Name("胡上杰");
		principal.setAccountInfo(accountInfo);
		/*principal.setAccountNonExpired(true);
		principal.setAccountNonLocked(true);
		principal.setCredentialsNonExpired(true);
		principal.setEnabled(true);*/
		UserPrincipal saveduser=uppd.save(principal);
		System.out.println("最后登录的时间"+saveduser.getLastLoggedTime());
		return saveduser;
	}
	@RequestMapping(value="/testpageandsort")
	@ResponseBody
	public Page<UserPrincipal> getuserbyPage(@PageableDefault(value = 15, sort = { "userid" }, direction = Sort.Direction.DESC) 
    Pageable pageable){
		System.out.println("要查询的页码="+pageable.getPageNumber()+"每页大小"+pageable.getPageSize());
		return uppd.findAll(pageable);
		
	}
	@ResponseBody
	@RequestMapping(value="/test_multipal_entity")
	public List<UserPrincipal> testSavemultieneities(){
		String pwd="123456";
		List<UserPrincipal> entities=new ArrayList<>();
		UserPrincipal userPrincipal1=new UserPrincipal();
		userPrincipal1.setHashPassword(pwd.getBytes());
		userPrincipal1.setRoleid(1);
		userPrincipal1.setUserid(466666l);
		entities.add(userPrincipal1);
		UserPrincipal userPrincipal2=new UserPrincipal();
		userPrincipal2.setHashPassword(pwd.getBytes());
		userPrincipal2.setRoleid(1);
		userPrincipal2.setUserid(455555l);
		entities.add(userPrincipal2);
		List<UserPrincipal> users=new ArrayList<>();
		users=(List<UserPrincipal>) uppd.saveNonentity(entities);
		/*UserPrincipal user_return=uppd.save(userPrincipal1);*/
		return users;
	}
	@ResponseBody
	@RequestMapping(value="/upload_file")
	public String handleUpload1(){
		//异步方法必须是spring管理的bean
		FileUtil1 fileUtil1=new FileUtil1();
		fileUtil1.Save();
		return "异步执行";
	}
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> handleFormUpload1(@RequestParam("ppt") MultipartFile files){
		String filepath="D:\\upload";
		fileutil.saveFile(files, filepath, files.getOriginalFilename());
		Map<String, String> res=new HashMap<>();
		res.put("OK", "上传成功");
		return res;
	}
	@ResponseBody
	@RequestMapping(value = "/uploadtest", method = RequestMethod.POST)
    public List<UserPrincipal> handleFormUpload(@RequestParam(value="roleid",required=true) Integer roleid,@RequestParam(value="pwdSchema",required=true)
    		String pwdSchema,@RequestParam("registerExcel") MultipartFile file) {
		List<UserPrincipal> userPrincipals=new ArrayList<>();
		List<UserPrincipal> registeredusers=new ArrayList<>();
		BatchRegisterModel batchRegisterModel=new BatchRegisterModel();
		batchRegisterModel.setRoleid(1);
		batchRegisterModel.setUsernameCol("姓名");
		batchRegisterModel.setAddressCol("地址");
		batchRegisterModel.setEmailCol("邮箱");
		batchRegisterModel.setPhoneNumCol("联系方式");
		try {
			//ReadFile readFile = new ReadFile(file.getInputStream());
			userPrincipals=ReadFile.readExcel(file.getInputStream(), batchRegisterModel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		registeredusers=(List<UserPrincipal>) userPrincipalService.saveUserPrincipals(userPrincipals, pwdSchema);
		System.out.println("注册成功的个数="+registeredusers.size());
        return registeredusers;
    }
	
	@ResponseBody
	@RequestMapping(value={"test","tes"}
			)
	public String hello(){	
		String meString="测试成功!";
		return "测试成功";
	}
	@ResponseBody
	@RequestMapping(
			value={"testparam"},
			params={"exist","name=jack"}
			)
	
	public String testParam(HttpServletRequest request){
		Enumeration<String> contenttype=request.getHeaderNames();
		StringBuffer acceptinfo=new StringBuffer();
		while (contenttype.hasMoreElements()) {
			acceptinfo.append(contenttype.nextElement());
		}
		return "testparam oaak!+accept=="+acceptinfo;
		
	}
	@RequestMapping("/gobaidu")
	public View baidu(Map<String, Object> model){
		model.put("url", "index.jsp");
		return new RedirectView("/{url}",true);
	}
	@RequestMapping("testviewresolver")
	public String viewresolver(Map<String, Object> model){
		model.put("name", "jack");
		model.put("date", new Date());
		return "testviewresolver";
	}
	@RequestMapping(value="/home/getuser",method=RequestMethod.GET)
	/*@ModelAttribute("currentUser")*/
	@ResponseBody
	public User userhome(){
		User user=new User();
		user.setUserId(1255555l);
		user.setUsername("jack");
		user.setName("胡上杰");
		return user;
	}
	@RequestMapping(value="/testAsync")	
	@ResponseBody
	public String testAsync(){
		String ok="测试异步";
		asyncMethod.sayHello5slater();
		return ok;
	}
	@RequestMapping(value="/testScheduled")	
	@ResponseBody
	public String testScheduled(){
		String ok="测试计划任务";
		schedulerMethod.testScheduler();
		return ok;
	}
	@RequestMapping(value="/testUserprincipalDao")
	@ResponseBody
	public UserPrincipal testGetUser(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Long userid=Long.parseLong(authentication.getName());
		System.out.println("用户id=="+userid);
		UserPrincipal jack=uppd.findOne(userid);
		return jack;
	}
	@RequestMapping(value="/testRoleAuthorityDao")
	@ResponseBody
	public Set<RoleAuthority> testRoleAuthorityDao(){
		
		
		Set ras=roleAuthorityDao.getByRoleId(1);
		/*Set<AuthorityEntity> authorityEntities=ra.getAuthorities();*/
		System.out.println("获取所有的权限的大小"+ras.size());
		return ras;
	}
	@RequestMapping(value="/testGetAuthority")
	@ResponseBody
	public String testGetAuthority(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("认证是否通过"+authentication.isAuthenticated());
		
		return "认证信息"+authentication.getPrincipal();
	}
  
}
