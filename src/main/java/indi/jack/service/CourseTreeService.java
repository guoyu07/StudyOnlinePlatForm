/**
 * 
 */
package indi.jack.service;

import indi.jack.entity.ClassCourseTree;

/**
 * <p>Title:CourseTreeService</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月4日 上午11:31:06
 */
public interface CourseTreeService {
	Iterable<ClassCourseTree> getNodesbyClassId(Integer classid);
	ClassCourseTree getOneNodebyId(Long id);
	void deleteNode(Long id);
	ClassCourseTree saveNode(ClassCourseTree entity);
	ClassCourseTree updateNode(ClassCourseTree entity);
	//获取节点宽度
	Integer getWidthOfTree(Integer classid,Long pid);
}
