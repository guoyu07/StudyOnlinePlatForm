/**
 * 
 */
package indi.jack.serviceImpl;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import indi.jack.dao.RoleAuthorityDao;
import indi.jack.dao.RoleDao;
import indi.jack.entity.RoleAuthority;
import indi.jack.entity.RoleEntity;
import indi.jack.service.RoleService;

/**
 * <p>Title:RoleServiceImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月23日 下午7:24:46
 */
@Service
public class RoleServiceImpl implements RoleService{

	@Inject RoleDao roleDao;
	@Inject RoleAuthorityDao roleAuthorityDao;
	@Override
	@Transactional
	public Iterable<RoleEntity> getAllRoles() {
		return roleDao.findAll();
	}


	@Override
	@Transactional
	public RoleEntity updateRole(RoleEntity roleEntity) {
		return roleDao.save(roleEntity);
	}

	@Override
	@Transactional
	public RoleEntity getRole(Integer roleid) {
		return roleDao.findOne(roleid);
	}
	@Transactional
	@Override
	public RoleEntity saveRole(RoleEntity roleEntity) {
		return roleDao.save(roleEntity);
	}

	@Override
	@Transactional
	public void deleteRole(Integer roleid) {
		RoleEntity entity=roleDao.findOne(roleid);
		roleDao.delete(roleid);
	}
	@Override
	@Transactional
	public Set<RoleAuthority> getPermissions(int roleid) {
		return roleAuthorityDao.getByRoleId(roleid);
	}
	@Override
	@Transactional
	public String deleteOnePermission(Integer perId) {
		RoleAuthority entity=roleAuthorityDao.findOne(perId);
		if(entity!=null){
			entity.setAuthorityEntity(null);
			roleAuthorityDao.delete(entity);
			return "OK";
		}
		return "ERROR";
	}
	@Override
	@Transactional
	public Iterable<RoleAuthority> addPermissions(Iterable<RoleAuthority> roleAuthorities) {
		return roleAuthorityDao.save(roleAuthorities);
	}

}
