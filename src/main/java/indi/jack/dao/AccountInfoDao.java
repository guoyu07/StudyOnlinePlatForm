/**
 * 
 */
package indi.jack.dao;

import org.springframework.data.repository.CrudRepository;

import indi.jack.entity.AccountInfo;

/**
 * <p>Title:AccountInfoDao</p>
 * <p>Description:用户详细信息表仓库</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月10日 下午7:31:02
 */
public interface AccountInfoDao extends CrudRepository<AccountInfo, Long>{
		/*AccountInfo findByuserId(Long userId);*/
}
