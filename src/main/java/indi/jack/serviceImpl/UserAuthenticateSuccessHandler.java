/**
 * 
 */
package indi.jack.serviceImpl;

import java.io.IOException;
import java.time.Instant;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import indi.jack.dao.AccountInfoDao;
import indi.jack.dao.UserPrincipalDao;
import indi.jack.entity.AccountInfo;
import indi.jack.entity.UserPrincipal;


/**
 * <p>Title:UserDispatcherImpl</p>
 * <p>Description:用户登录成功分配服务</p>
 * 用于记录登录日志（登录地址）
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月24日 下午2:36:53
 */
@Service
public class UserAuthenticateSuccessHandler implements AuthenticationSuccessHandler{
	@Inject UserPrincipalDao userPrincipalDao; 
	@Inject AccountInfoDao accountInfoDao;
	private RedirectStrategy redirectStrategy;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
			//登录成功，记录用户登录的时间，更新用户当前状态
			String userid=authentication.getName();
			String username="";
			
			UserPrincipal userPrincipal=userPrincipalDao.findOne(Long.parseLong(userid));
			AccountInfo accountInfo=userPrincipal.getAccountInfo();
			if(accountInfo!=null){
				username=accountInfo.getUser_Name();
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("userid", userid);
			}
			//保存用户id和名字到session
			HttpSession session=request.getSession();
			session.setAttribute("userid", userid);
			session.setAttribute("username", username);
			userPrincipal.setOnlineState(true);
			userPrincipal.setLastLoggedTime(new Date());
			userPrincipalDao.save(userPrincipal);
			//对不同角色的用户跳转处理
			Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
			Iterator<? extends GrantedAuthority> iterator=authorities.iterator();
			String role="";
			while (iterator.hasNext()) {
				GrantedAuthority grantedAuthority = (GrantedAuthority) iterator.next();				
				String authority=grantedAuthority.getAuthority();
				if(authority.startsWith("ROLE"))
					role=authority;
			}
			redirectStrategy=new DefaultRedirectStrategy();
			switch (role) {
			case "ROLE_TEACHER":
				//教师
				redirectStrategy.sendRedirect(request, response, "/teacher");
				/*request.getRequestDispatcher("/teacher").forward(request, response);*/
				break;
			case "ROLE_STUDENT":
				//学生
				redirectStrategy.sendRedirect(request, response, "/study");
			break;
			case "ROLE_SITE_ADMIN":
				//站点管理员
				redirectStrategy.sendRedirect(request, response, "/admin");
			break;
			case "ROLE_SCHOOL_ADMIN":
				//学校管理员
				redirectStrategy.sendRedirect(request, response, "/admin");
				break;
			default:
				break;
			}
			
	}

}
