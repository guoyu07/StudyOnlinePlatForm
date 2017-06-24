/**
 * 
 */
package indi.jack.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import indi.jack.entity.CourseEntity;
/**
 * <p>Title:CourseService</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月27日 下午6:11:06
 */
public interface CourseService {
	CourseEntity saveOneCourse(CourseEntity entity);
	CourseEntity UpdateCourse(CourseEntity entity);
	void deleteOneCourse(Integer id);
	CourseEntity getOneCourseByid(Integer id);
	Iterable<CourseEntity> getAllCourse();
	Page<CourseEntity> getAllCourseWithPage(Pageable pageable);
}
