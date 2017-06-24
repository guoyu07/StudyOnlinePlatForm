/**
 * 
 */
package indi.jack.dao;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import indi.jack.entity.Class;

/**
 * <p>Title:ClassDao</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月27日 下午9:22:48
 */
public interface ClassDao extends CrudRepository<indi.jack.entity.Class, Integer>,PagingAndSortingRepository<Class, Integer>{
	Page<Class> findByteacherId(Long id,Pageable pageable);
	Iterable<Class> findByteacherId(Long id);
	Iterable<Class> findByTermStart(Date start,Date end);
}
