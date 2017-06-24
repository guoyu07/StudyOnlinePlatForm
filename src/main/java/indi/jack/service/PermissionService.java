/**
 * 
 */
package indi.jack.service;

import indi.jack.entity.AuthorityEntity;

/**
 * <p>Title:PermissionService</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月16日 上午10:43:49
 */
public interface PermissionService {
	Iterable<AuthorityEntity> getAllAus();
	AuthorityEntity saveAu(AuthorityEntity entity);
	AuthorityEntity update(AuthorityEntity entity);
	void delete(Integer AuId);
}
