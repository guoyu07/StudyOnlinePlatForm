/**
 * 
 */
package indi.jack.daoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import indi.jack.dao.UserPrincipalExpandDao;
import indi.jack.entity.UserPrincipal;
/**
 * <p>Title:UserPrincipalDaoImpl</p>
 * <p>Description:注意该类是UserPrincipalExpandDao的实现类，
 * 	  但是spring data 会默认扫描该类，所以命名必须是被拓展类+Impl
 * </p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月4日 下午8:56:04
 */
@Repository
public class UserPrincipalDaoImpl implements UserPrincipalExpandDao<UserPrincipal, Serializable>{
	@PersistenceContext EntityManager entityManager;
	@Override
	public <S extends UserPrincipal> UserPrincipal saveNonentity(UserPrincipal entity) {
		if (entityManager.find(UserPrincipal.class, entity.getUserid())==null) {
			//说明该账号不存在
			return entityManager.merge(entity);
		} else {
			//说明该账号已存在
			return null;
		}
	}
	@Override
	public <S extends UserPrincipal> Iterable<UserPrincipal> saveNonentity(Iterable<UserPrincipal> entities) {
		
		List<UserPrincipal> result = new ArrayList<UserPrincipal>();

		if (entities == null) {
			return result;
		}
		List<UserPrincipal> userPrinciples=new ArrayList<>();
		userPrinciples=(List<UserPrincipal>) entities;
		for (int i=0; i<userPrinciples.size(); i++){
			UserPrincipal flag=saveNonentity(userPrinciples.get(i));
			if(flag!=null){
				result.add(flag);
			}
			if(i % 30==0){
				System.out.println("数据是30的倍数，执行flush");
				entityManager.flush();
				entityManager.clear();
			}
		}

		return result;
	}
	
    	
}
