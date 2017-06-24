/**
 * 
 */
package indi.jack.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import indi.jack.entity.RoleAuthority;
import indi.jack.entity.RoleEntity;

/**
 * <p>Title:RoleAuthorityDao</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月21日 下午8:06:22
 */
public interface RoleAuthorityDao extends CrudRepository<RoleAuthority, Serializable>{
	Set<RoleAuthority> getByRoleId(Integer roleid);
}
