/**
 * 
 */
package indi.jack.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import indi.jack.entity.RoleEntity;

/**
 * <p>Title:RoleDao</p>
 * <p>Description:角色仓库</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月23日 下午7:21:00
 */
public interface RoleDao extends CrudRepository<RoleEntity, Integer>{
	
}
