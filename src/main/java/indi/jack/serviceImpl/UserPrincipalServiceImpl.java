/**
 * 
 */
package indi.jack.serviceImpl;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import indi.jack.dao.AuthorityDao;
import indi.jack.dao.RoleAuthorityDao;
import indi.jack.dao.RoleDao;
import indi.jack.dao.UserPrincipalDao;
import indi.jack.entity.AuthorityEntity;
import indi.jack.entity.RoleAuthority;
import indi.jack.entity.RoleEntity;
import indi.jack.entity.UserPrincipal;
import indi.jack.model.UserDetailesImpl;
import indi.jack.service.UserPrincipalService;
import indi.jack.util.TransformToHashPassword;

/**
 * <p>Title:UserPrincipalServiceImpl</p>
 * <p>Description:业务范围
 * 		对用户主体：账号安全，锁定，权限，角色
 * 		用户主体注册，批量注册（不含账号详细信息填充）
 * 		批量删除
 * </p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月21日 下午4:49:22
 */
@Service(value="UserPrincipalServiceImpl")
public class UserPrincipalServiceImpl implements Serializable, UserPrincipalService{
	private static final long serialVersionUID = 1L;
	@Inject UserPrincipalDao userPrincipalDao;
	@Inject RoleAuthorityDao roleAuthorityDao;
	@Inject RoleDao roleDao; 
	@Inject AuthorityDao authorityDao;
	
	@SuppressWarnings("serial")
	@Override
	/**
	 * 重写spring security的认证方法
	 */
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		//从仓库中获取用户信息
		UserPrincipal principal = userPrincipalDao.findOne(Long.valueOf(s));
		UserDetailesImpl userDetailes=new UserDetailesImpl();
		if(principal!=null){
			Integer roleid=principal.getRoleid();
			//获取用户角色信息
			RoleEntity roleEntity=roleDao.findOne(roleid);		
			String rolename=roleEntity.getRoleName();
			String username=principal.getUserid().toString();
			byte[] password=principal.getHashPassword();
			Boolean accountNonExpired=principal.isAccountNonExpired();
			Boolean accountNonLocked=principal.isAccountNonLocked();
			Boolean credentialsNonExpired=principal.isCredentialsNonExpired();
			Boolean enabled=principal.isEnabled();
			userDetailes.setPassword(password);
			userDetailes.setUsername(username);
			userDetailes.setAccountNonExpired(accountNonExpired);
			userDetailes.setAccountNonLocked(accountNonLocked);
			userDetailes.setCredentialsNonExpired(credentialsNonExpired);
			userDetailes.setEnabled(enabled);
			//通过查询角色权限表，获取权限信息
			Set<GrantedAuthority> authorities=new HashSet<>();
			authorities.add(new GrantedAuthority() {			
				@Override
				public String getAuthority() {
					return "ROLE_"+rolename;
				}
			});
			Set<RoleAuthority> roleAuthorities=roleAuthorityDao.getByRoleId(roleid);
			Iterator<RoleAuthority> iterator=roleAuthorities.iterator();
			Set<AuthorityEntity> authorityEntities=new HashSet<>();
			while (iterator.hasNext()) {
				RoleAuthority roleAuthority = (RoleAuthority) iterator.next();
				//遍历获得权限id
				AuthorityEntity authorityEntity=roleAuthority.getAuthorityEntity();
				authorityEntities.add(authorityEntity);
			}
			//通过查找到的多个权限id获取权限名称，权限实体继承了GrantedAuthority
			/*Iterator<AuthorityEntity> iterator2=authorityEntities.iterator();
			while (iterator2.hasNext()) {
				AuthorityEntity authorityEntity = (AuthorityEntity) iterator2.next();
				authorities.add(authorityEntity);
			}*/
			authorities.addAll(authorityEntities);
			userDetailes.setAuthorities(authorities);
		}
		/*userDetailes.setCredentialsNonExpired(true);*/
		//将权限赋给GrantedAuthority
		//最终赋值给pricipal返回
		return userDetailes;
	}
	
	@Override
	@Transactional
	public UserPrincipal getUserPrincipalById(Long roleid) {
		return userPrincipalDao.findOne(roleid);
	}
	/*@Override
	@Transactional
	public Iterable<UserPrincipal> getAllUserPrincipal(){
		return userPrincipalDao.findAll();
	}*/
	@Transactional
	@Override
	//保存用户，如果用户已经存在则不做任何操作
	public UserPrincipal saveUserPrincipal(UserPrincipal userPrincipal,String password) {
		userPrincipal.setHashPassword(TransformToHashPassword.formToHash(password));
		return userPrincipalDao.saveNonentity(userPrincipal);
	}
	@Transactional
	@Override
	//保存 用户，如果用户已经存在则覆盖
	public UserPrincipal mergeUserPrincipal(UserPrincipal userPrincipal,String password) {
		userPrincipal.setHashPassword(TransformToHashPassword.formToHash(password));
		return userPrincipalDao.save(userPrincipal);
	}
	@Transactional
	@Override
	public  Iterable<UserPrincipal> saveUserPrincipals(Iterable<UserPrincipal> entities,
			String pwdSchema) {
		if(pwdSchema.equals("LAST6")){
			Iterator<UserPrincipal> iterator=entities.iterator();
			while (iterator.hasNext()) {
				UserPrincipal userPrincipal = (UserPrincipal) iterator.next();
				String password=String.valueOf(userPrincipal.getUserid());
				String newpassword=password.substring(password.length()-6, password.length());
				//System.out.println("密码=="+newpassword);
				userPrincipal.setHashPassword(TransformToHashPassword.formToHash(newpassword));
			}
			return userPrincipalDao.saveNonentity(entities);
		}
		if(pwdSchema.equals("FIRST6")){
			Iterator<UserPrincipal> iterator=entities.iterator();
			while (iterator.hasNext()) {
				UserPrincipal userPrincipal = (UserPrincipal) iterator.next();
				String password=String.valueOf(userPrincipal.getUserid());
				String newpassword=password.substring(0, 5);
				userPrincipal.setHashPassword(TransformToHashPassword.formToHash(newpassword));
			}
			return userPrincipalDao.saveNonentity(entities);
		}
		return null;
	}
	@Transactional
	@Override
	public void deleteUserPrincipalByid(Long userid) {
		userPrincipalDao.delete(userid);
	}
	@Transactional
	@Override
	public void deleteUserPrincipals(Iterable<UserPrincipal> entities) {
		userPrincipalDao.delete(entities);
	}
	@Transactional
	@Override
	public UserPrincipal saveUserPrincipal(UserPrincipal userPrincipal) {
		return userPrincipalDao.save(userPrincipal);
	}
	/*@Transactional
	@Override
	public UserPrincipal updateUserPrincipal(UserPrincipal userPrincipal) {
		return userPrincipalDao.save(userPrincipal);
	}
	@Override
	public Page<UserPrincipal> getUserByPageandSort(org.springframework.data.domain.Pageable pageable) {
		return userPrincipalDao.findAll(pageable);
	}*/
	

	

}
