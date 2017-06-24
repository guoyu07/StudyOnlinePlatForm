/**
 * 
 */
package indi.jack.serviceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.connection.RedisZSetCommands.Tuple;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import indi.jack.dao.ClassDao;
import indi.jack.dao.CourseTreeDao;
import indi.jack.dao.StudentClassDao;
import indi.jack.entity.ApplyClassEntity;
import indi.jack.entity.Class;
import indi.jack.entity.ClassCourseTree;
import indi.jack.entity.StudentClass;
import indi.jack.service.ClassService;

/**
 * <p>Title:ClassServiceImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月1日 下午8:47:07
 */
@Service
public class ClassServiceImpl implements ClassService{
	@Inject ClassDao classDao;
	@Inject StudentClassDao studentClassDao; 
	@Inject CourseTreeDao courseTreeDao; 
	@Autowired RedisTemplate<String, ApplyClassEntity> redisTemplate;
	@Override
	@Transactional
	public Class saveOneClass(Class clazz) {
		Class entity=classDao.save(clazz);
		ClassCourseTree rootnode=new ClassCourseTree();
		rootnode.setClassId(entity.getClassId());
		rootnode.setName(entity.getCourseEntity().getCourseName()+"目录树");
		rootnode.setWidth((short) 0);
		rootnode.setLevel((short) 0);
		courseTreeDao.save(rootnode);
		return entity;
	}
	@Override
	@Transactional
	public Class updateClass(Class clazz) {
		return classDao.save(clazz);
	}
	@Override
	@Transactional
	public void deleteOneClass(Integer id) {
		classDao.delete(id);
	}
	@Override
	@Transactional
	public Class getOneClass(Integer id) {
		return classDao.findOne(id);
	}
	@Override
	@Transactional
	public Iterable<Class> getAllClass() {
		return classDao.findAll();
	}
	@Override
	@Transactional
	public Page<Class> getAllClassWithPage(Pageable pageable) {
		return classDao.findAll(pageable);
	}
	@Override
	@Transactional
	public void applyNewClass(ApplyClassEntity model) {
		String key="applicantinfo";
		//如申请在7天之内未受理，自动过期
		redisTemplate.opsForZSet().add(key, model,model.getApplyTime().getTime());
	}
	
	@Override
	@Transactional
	public java.util.List<ApplyClassEntity> getAllApplicant() {
		 return redisTemplate.execute(new RedisCallback<List<ApplyClassEntity>>() {

			@Override
			public List<ApplyClassEntity> doInRedis(RedisConnection connection) throws DataAccessException {
				Set<Tuple> datas=connection.zRangeWithScores("applicantinfo".getBytes(), 0, -1);
				Iterator<Tuple> iterator=datas.iterator();
				List<ApplyClassEntity> models=new ArrayList<>();
				while (iterator.hasNext()) {
					RedisZSetCommands.Tuple tuple = (RedisZSetCommands.Tuple) iterator.next();
					ApplyClassEntity model=(ApplyClassEntity) redisTemplate.getValueSerializer().deserialize(tuple.getValue());
					models.add(model);
				}	
				return models;
				
			}
		});
	}
	@Override
	public void ratifyNewClass(ApplyClassEntity model) {
	}
	@Override
	public Page<Class> getClassByTeaId(Long id,Pageable pageable) {
		return classDao.findByteacherId(id,pageable);
	}
	@Override
	public Iterable<Class> getClassByTeaId(Long id) {
		return classDao.findByteacherId(id);
	}
	@Override
	public Iterable<StudentClass> getStudentsByClassId(Integer classid) {
		return studentClassDao.findByclassId(classid);
	}
	

}
