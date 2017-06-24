/**
 * 
 */
package indi.jack.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import indi.jack.model.SearchResult;
/**
 * <p>Title:SearchAbleDao</p>
 * <p>Description:公共搜索仓库</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月13日 上午9:46:41
 */
public interface SearchableDao<T>{
	Page<T> search(String query, Pageable pageable);
}
