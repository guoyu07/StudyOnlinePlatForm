/**
 * 
 */
package indi.jack.dao;
import java.io.Serializable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import indi.jack.entity.UserPrincipal;

/**
 * <p>Title:UserPrincipalDao</p>
 * <p>Description:用户账号密码仓库继承jpa仓库</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月21日 下午4:58:06
 */
public interface UserPrincipalDao extends CrudRepository<UserPrincipal, Serializable>,UserPrincipalExpandDao<UserPrincipal, Serializable>,PagingAndSortingRepository<UserPrincipal, Serializable>{
	
	//Page<UserPrincipal> findByuserid(Pageable pageable);
}
