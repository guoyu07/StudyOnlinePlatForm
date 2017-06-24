/**
 * 
 */
package indi.jack.dao;

import java.io.Serializable;

/**
 * <p>Title:UserPrincipalExpandDao</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月4日 下午8:29:28
 */
public interface UserPrincipalExpandDao<UserPrincipal, ID extends Serializable> {
	//批量保存实体，对于存在的实体不覆盖,并返回保存实体
	<S extends UserPrincipal> Iterable<UserPrincipal> saveNonentity(Iterable<UserPrincipal> entities);
	//保存单个实体，对于存在的实体不覆盖,并返回保存实体
	<S extends UserPrincipal> UserPrincipal saveNonentity(UserPrincipal entity);
}
