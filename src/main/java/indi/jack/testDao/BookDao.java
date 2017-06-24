/**
 * 
 */
package indi.jack.testDao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import indi.jack.testEntity.Book;

/**
 * <p>Title:BookDao</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月17日 下午8:25:00
 */
public interface BookDao extends CrudRepository<Book, Serializable>{

}
