/**
 * 
 */
package indi.jack.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import indi.jack.entity.ApplyClassEntity;
import indi.jack.entity.Class;
import indi.jack.entity.StudentClass;

/**
 * <p>Title:ClassService</p>
 * <p>Description:课程服务</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月1日 下午8:26:35
 */
public interface ClassService {
	//当保存一个班时，需要创建一颗课程树
	Class saveOneClass(Class clazz);
	Class updateClass(Class clazz);
	void deleteOneClass(Integer id);
	Class getOneClass(Integer id);
	Iterable<Class> getAllClass();
	Page<Class> getAllClassWithPage(Pageable pageable);
	Page<Class> getClassByTeaId(Long id,Pageable pageable);
	Iterable<Class> getClassByTeaId(Long id);
	//获取某班级的所有个人信息
	Iterable<StudentClass> getStudentsByClassId(Integer classid);
	//教师申请开设班级
	void applyNewClass(ApplyClassEntity model);
	List<ApplyClassEntity> getAllApplicant();
	//批准开设班级
	void ratifyNewClass(ApplyClassEntity model);
}
