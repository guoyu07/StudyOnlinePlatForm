/**
 * 
 */
package indi.jack.serviceImpl;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import indi.jack.dao.AuthorityDao;
import indi.jack.entity.AuthorityEntity;
import indi.jack.service.PermissionService;

/**
 * <p>Title:PermissionServiceImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月16日 上午10:49:08
 */
@Service
public class PermissionServiceImpl implements PermissionService{
	@Inject AuthorityDao authorityDao;
	@Override
	@Transactional
	public Iterable<AuthorityEntity> getAllAus() {
		return authorityDao.findAll();
	}

	@Override
	@Transactional
	public AuthorityEntity saveAu(AuthorityEntity entity) {
		return authorityDao.save(entity);
	}

	@Override
	@Transactional
	public AuthorityEntity update(AuthorityEntity entity) {
		return authorityDao.save(entity);
	}

	@Override
	@Transactional
	public void delete(Integer AuId) {
		authorityDao.delete(AuId);
	}

}
