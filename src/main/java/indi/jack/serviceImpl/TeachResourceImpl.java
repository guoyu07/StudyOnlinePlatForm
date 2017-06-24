/**
 * 
 */
package indi.jack.serviceImpl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import indi.jack.dao.TeachResourceDao;
import indi.jack.entity.TeachResource;
import indi.jack.service.TeachResourceService;

/**
 * <p>Title:TeachResourceImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月9日 下午3:55:19
 */
@Service
public class TeachResourceImpl implements TeachResourceService{
	@Inject TeachResourceDao teachResourceDao ;
	@Override
	public TeachResource saveResource(TeachResource entity) {
		return teachResourceDao.save(entity);
	}

	@Override
	public void deleteResource(Long id) {
		teachResourceDao.delete(id);
	}

	@Override
	public TeachResource getOneRes(Long id) {
		return teachResourceDao.findOne(id);
	}

}
