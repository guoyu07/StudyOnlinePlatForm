/**
 * 
 */
package indi.jack.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import indi.jack.entity.UserPrincipal;
/**
 * <p>Title:UserPrincipalService</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月21日 下午4:47:50
 */

public interface UserPrincipalService extends UserDetailsService {
		UserPrincipal getUserPrincipalById(Long userid);
		//Iterable<UserPrincipal> getAllUserPrincipal();
		void deleteUserPrincipalByid(Long userid);
		UserPrincipal saveUserPrincipal(UserPrincipal userPrincipal);
		void deleteUserPrincipals(Iterable<UserPrincipal> entities);
		UserPrincipal saveUserPrincipal(UserPrincipal userPrincipal,String passwrod);
	    Iterable<UserPrincipal> saveUserPrincipals(Iterable<UserPrincipal> UserPrincipals,String pwdSchema);
	    UserPrincipal mergeUserPrincipal(UserPrincipal userPrincipal,String passwrod);
	    //UserPrincipal updateUserPrincipal(UserPrincipal userPrincipal);
	    //Page<UserPrincipal> getUserByPageandSort(Pageable pageable);
}
