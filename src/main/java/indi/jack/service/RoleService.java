/**
 * 
 */
package indi.jack.service;

import java.util.List;
import java.util.Set;

import indi.jack.entity.RoleAuthority;
import indi.jack.entity.RoleEntity;

/**
 * <p>Title:RoleService</p>
 * <p>Description:角色服务</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月23日 下午7:24:03
 */
public interface RoleService {
	Iterable<RoleEntity> getAllRoles();
	RoleEntity getRole(Integer roleid);
	RoleEntity saveRole(RoleEntity roleEntity);
	void deleteRole(Integer roleid);
	RoleEntity updateRole(RoleEntity roleEntity);
	Set<RoleAuthority> getPermissions(int roleid);
	String deleteOnePermission(Integer perId);
	Iterable<RoleAuthority> addPermissions(Iterable<RoleAuthority> roleAuthorities);
}
