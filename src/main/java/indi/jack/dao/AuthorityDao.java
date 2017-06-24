/**
 * 
 */
package indi.jack.dao;


import org.springframework.data.repository.CrudRepository;

import indi.jack.entity.AuthorityEntity;

/**
 * <p>Title:AuthorityDao权限仓库</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月24日 上午9:27:26
 */
public interface AuthorityDao extends CrudRepository<AuthorityEntity, Integer>{

}
