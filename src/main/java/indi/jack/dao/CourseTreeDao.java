/**
 * 
 */
package indi.jack.dao;

import org.springframework.data.repository.CrudRepository;

import indi.jack.entity.ClassCourseTree;

/**
 * <p>Title:CourseTreeDao</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月4日 上午11:27:20
 */
public interface CourseTreeDao extends CrudRepository<ClassCourseTree, Long>{
	Iterable<ClassCourseTree> findByclassId(Integer classid);
	Integer countByClassIdAndPId(Integer classid,Long PId);
}
