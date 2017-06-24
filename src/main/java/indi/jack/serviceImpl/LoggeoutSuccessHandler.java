/**
 * 
 */
package indi.jack.serviceImpl;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import indi.jack.dao.UserPrincipalDao;
import indi.jack.entity.UserPrincipal;

/**
 * <p>Title:LoggeoutSuccessHandler</p>
 * <p>Description:用户退出成功后处理方案</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月7日 下午3:57:29
 */
public class LoggeoutSuccessHandler implements LogoutSuccessHandler{
	@Inject UserPrincipalDao userPrincipalDao; 
	private RedirectStrategy redirectStrategy;
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		//从数据库中注销用户当前状态
		String username=authentication.getName();
		UserPrincipal userPrincipal=userPrincipalDao.findOne(Long.parseLong(username));
		userPrincipal.setOnlineState(false);
		userPrincipal.setLastloggedoutTime(new Date());
		userPrincipalDao.save(userPrincipal);
		//跳转到指定页面
	}

}
