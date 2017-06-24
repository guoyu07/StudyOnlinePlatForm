/**
 * 
 */
package indi.jack.serviceImpl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import indi.jack.dao.CourseDao;
import indi.jack.entity.CourseEntity;
import indi.jack.service.CourseService;

/**
 * <p>Title:CourseServiceImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月27日 下午6:31:06
 */
@Service
public class CourseServiceImpl implements CourseService{
	@Inject CourseDao courseDao; 
	@Override
	public CourseEntity saveOneCourse(CourseEntity entity) {
		return courseDao.save(entity);
	}

	@Override
	public CourseEntity UpdateCourse(CourseEntity entity) {
		return courseDao.save(entity);
	}

	@Override
	public void deleteOneCourse(Integer id) {
		courseDao.delete(id);
	}

	@Override
	public CourseEntity getOneCourseByid(Integer id) {
		return courseDao.findOne(id);
	}

	@Override
	public Iterable<CourseEntity> getAllCourse() {
		return courseDao.findAll();
	}
	@Override
	public Page<CourseEntity> getAllCourseWithPage(Pageable pageable) {
		return courseDao.findAll(pageable);
	}

}
