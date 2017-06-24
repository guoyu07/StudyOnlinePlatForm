/**
 * 
 */
package indi.jack.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import indi.jack.entity.CourseEntity;

/**
 * <p>Title:CourseDao</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月27日 下午5:45:29
 */
public interface CourseDao extends CrudRepository<CourseEntity, Integer>,PagingAndSortingRepository<CourseEntity, Integer> {

}
