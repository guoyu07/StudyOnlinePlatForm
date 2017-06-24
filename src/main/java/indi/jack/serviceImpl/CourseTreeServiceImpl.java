/**
 * 
 */
package indi.jack.serviceImpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import indi.jack.dao.CourseTreeDao;
import indi.jack.entity.ClassCourseTree;
import indi.jack.service.CourseTreeService;

/**
 * <p>Title:CourseTreeServiceImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月4日 上午11:40:07
 */
@Service
public class CourseTreeServiceImpl implements CourseTreeService{
	@Inject CourseTreeDao courseTreeDao;
	
	@Override
	public Iterable<ClassCourseTree> getNodesbyClassId(Integer classid) {
		return courseTreeDao.findByclassId(classid);
	}

	@Override
	public ClassCourseTree getOneNodebyId(Long id) {
		return courseTreeDao.findOne(id);
	}

	@Override
	public void deleteNode(Long id) {
		courseTreeDao.delete(id);
	}

	@Override
	public ClassCourseTree saveNode(ClassCourseTree entity) {
		return courseTreeDao.save(entity);
	}

	@Override
	public ClassCourseTree updateNode(ClassCourseTree entity) {
		return courseTreeDao.save(entity);
	}

	@Override
	public Integer getWidthOfTree(Integer classid, Long pid) {
		return courseTreeDao.countByClassIdAndPId(classid, pid);
	}

}
