/**
 * 
 */
package indi.jack.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import indi.jack.entity.AuthorityEntity;
import indi.jack.entity.RoleAuthority;
import indi.jack.entity.RoleEntity;
import indi.jack.service.RoleService;

/**
 * <p>Title:RoleController</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月16日 上午10:51:46
 */
@Controller
@RequestMapping(value="/roles")
public class RoleController {
	 @Inject RoleService roleService;
	 @RequestMapping(value="",method=RequestMethod.GET)
	 @ResponseBody
	 public Iterable<RoleEntity> getAll(){
		 System.out.println("所有角色"+roleService.getAllRoles());
		 return roleService.getAllRoles();
	 }
	 @RequestMapping(value="/{roleId:\\d+}",method=RequestMethod.DELETE)
	 @ResponseBody
	 public Map<String, String> deleteOne(@PathVariable(value="roleId") Integer roleId){
		 Map<String, String> res=new HashMap<>();
			try {
				if(roleId!=null){
					System.out.println("roleid="+roleId);
					roleService.deleteRole(roleId);
					res.put("result", "OK");
				}else {
					res.put("result", "ERROR");
					res.put("info", "请输入ID");
				}
			} catch (Exception e) {
				e.printStackTrace();
				res.put("result", "ERROR");
				res.put("info", "角色不存在，删除失败");
			}
			return res;
		 
	 }
	 @RequestMapping(value="",method=RequestMethod.POST)
	 @ResponseBody
	 public HashMap<String,String> saveOne(@RequestBody(required=true) RoleEntity roleEntity){
		 HashMap<String, String> res=new HashMap<>();
		 RoleEntity entity=new RoleEntity();
			try {
				entity=roleService.saveRole(roleEntity);
				if(entity!=null){
					res.put("result", "OK");
					res.put("info", entity.toString());
				}else {
					res.put("result", "ERROR");
					res.put("info", "角色不存在");
				}
			} catch (Exception e) {
				res.put("result", "ERROR");
				res.put("info", "角色已存在");
			}
			return res;
	 }
	 @RequestMapping(value="",method=RequestMethod.PUT)
	 @ResponseBody
	 public HashMap<String,String> update(@RequestBody(required=true) RoleEntity roleEntity){
		 HashMap<String, String> res=new HashMap<>();
		 RoleEntity entity=new RoleEntity();
			try {
				if(roleEntity.getRoleId()==null){
					res.put("result", "ERROR");
					res.put("info", "请输入ID");
				}else{
					entity=roleService.saveRole(roleEntity);
					if(entity!=null){
						res.put("result", "OK");
						res.put("info", entity.toString());
					}else {
						res.put("result", "ERROR");
						res.put("info", "更新失败，角色不存在");
					}
				}
			} catch (Exception e) {
				res.put("result", "ERROR");
			}
			return res;
	 }
	 @RequestMapping(value="/authorities",method=RequestMethod.GET)
	 @ResponseBody
	 public Set<RoleAuthority> getAuthoritiesByroleid(@RequestParam(required=true,value="roleid") Integer roleid){
		 return roleService.getPermissions(roleid);
	 }
	 
	 @RequestMapping(value="/authorities/{perId:\\d+}",method=RequestMethod.DELETE)
	 @ResponseBody
	 public Map<String, String> deletePerById(@PathVariable(value="perId") Integer perId){
		 Map<String, String> res=new HashMap<>();
			try {
				if(perId!=null){
					String result=roleService.deleteOnePermission(perId);
					if(result.equals("OK")){
						res.put("result", "OK");
					}else {
						res.put("result", "ERROR");
						res.put("info", "权限不存在");
					}
					
				}else {
					res.put("result", "ERROR");
					res.put("info", "请输入ID");
				}
			} catch (Exception e) {
				e.printStackTrace();
				res.put("result", "ERROR");
				res.put("info", "内部异常");
			}
			return res;
	 }
	 @RequestMapping(value="/authorities/{roleid:\\d+}",method=RequestMethod.POST)
	 @ResponseBody
	 public Map<String, String> addPermissions(@PathVariable(value="roleid") Integer roleid,
			 @RequestBody(required=false) Set<AuthorityEntity> authorityEntities){
		 Map<String, String> res=new HashMap<>();
		 try {
			 if(!authorityEntities.isEmpty()){
				 Set<RoleAuthority> roleAuthorities=new HashSet<>();
				 authorityEntities.forEach(authorityEntity ->{
					 RoleAuthority roleAuthority=new RoleAuthority();
					 roleAuthority.setRoleId(roleid);
					 roleAuthority.setPermissionId(authorityEntity.getPermissionId());
					 roleAuthorities.add(roleAuthority);
				 });
				 List<RoleAuthority> resEntities=(List<RoleAuthority>) roleService.addPermissions(roleAuthorities);
				 res.put("result", "OK");
				 res.put("info", "成功添加"+resEntities.size()+"个权限");
			 }
		} catch (Exception e) {
				 res.put("result", "ERROR");
				 res.put("info", "重复插入");
		}
		 return res;
		 
		
	 }
	 
}
