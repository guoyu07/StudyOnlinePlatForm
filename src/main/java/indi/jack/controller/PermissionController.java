/**
 * 
 */
package indi.jack.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import indi.jack.entity.AuthorityEntity;
import indi.jack.service.PermissionService;

/**
 * <p>Title:PermissionController</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月16日 上午10:52:00
 */
@Controller
@RequestMapping(value="/permissions")
public class PermissionController {
	@Inject PermissionService permissionService;
	
	@RequestMapping(value="",method=RequestMethod.GET)
	@ResponseBody
	public Iterable<AuthorityEntity> getAll(){
		return permissionService.getAllAus();
	}
	@RequestMapping(value="/{permissionId:\\d+}",method=RequestMethod.GET)
	@ResponseBody
	public void getOne(@PathVariable(value="permissionId") Integer permissionId){
	
	}
	@RequestMapping(value="/{permissionId:\\d+}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String, String> deleteOne(@PathVariable(value="permissionId") Integer permissionId){
		Map<String, String> res=new HashMap<>();
		try {
			if(permissionId!=null){
				permissionService.delete(permissionId);
				res.put("result", "OK");
			}else {
				res.put("result", "ERROR");
				res.put("info", "请输入权限ID");
			}
		} catch (Exception e) {
			res.put("result", "ERROR");
			res.put("info", "服务器出错，删除失败");
		}
		return res;
		
	}
	@RequestMapping(value="",method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String,String> saveOne(@RequestBody AuthorityEntity permission){
		HashMap<String, String> res=new HashMap<>();
		AuthorityEntity entity=new AuthorityEntity();
		try {
			entity=permissionService.saveAu(permission);
			if(entity!=null){
				res.put("result", "OK");
				res.put("info", entity.toString());
			}else {
				res.put("result", "ERROR");
				res.put("info", "保存失败，用户不存在");
			}
		} catch (Exception e) {
			res.put("result", "ERROR");
			res.put("info", "保存出错");
		}
		return res;
	}
	@RequestMapping(value="",method=RequestMethod.PUT)
	@ResponseBody
	public HashMap<String,String> update(@RequestBody AuthorityEntity permission){
		HashMap<String, String> res=new HashMap<>();
		AuthorityEntity entity=new AuthorityEntity();
		try {
			if(permission.getPermissionId()==null){
				res.put("result", "ERROR");
				res.put("info", "请传入权限ID");
			}else{
				entity=permissionService.saveAu(permission);
				if(entity!=null){
					res.put("result", "OK");
					res.put("info", entity.toString());
				}else {
					res.put("result", "更新出错");
				}
			}
		} catch (Exception e) {
			res.put("result", "ERROR");
			res.put("info", "用户不存在");
		}
		return res;
	}
	
	
}
