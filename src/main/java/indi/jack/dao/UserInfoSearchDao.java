/**
 * 
 */
package indi.jack.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import indi.jack.entity.UserInfoEntitySearchable;

/**
 * <p>Title:UserInfoSearchDao</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月13日 下午9:38:12
 */
public interface UserInfoSearchDao extends CrudRepository<UserInfoEntitySearchable, Long>,PagingAndSortingRepository<UserInfoEntitySearchable, Long>,SearchableDao<UserInfoEntitySearchable>{
	
}
