/**
 * 
 */
package indi.jack.dao;

import org.springframework.data.repository.CrudRepository;

import indi.jack.entity.StudentClass;

/**
 * <p>Title:StudentClassDao</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月4日 上午8:15:05
 */
public interface StudentClassDao extends CrudRepository<StudentClass, Long>{
	Iterable<StudentClass> findByclassId(Integer classid);
}
