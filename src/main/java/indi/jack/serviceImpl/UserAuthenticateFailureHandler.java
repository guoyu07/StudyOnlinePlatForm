/**
 * 
 */
package indi.jack.serviceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Service;

/**
 * <p>Title:UserAuthenticateFailureImpl</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月7日 上午11:11:47
 */
@Service
public class UserAuthenticateFailureHandler implements AuthenticationFailureHandler{
	private RedirectStrategy redirectStrategy;
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException)
			throws IOException, ServletException {
		redirectStrategy=new DefaultRedirectStrategy();
		System.out.println("认证消息=="+authenticationException.getMessage());
		System.out.println("getLocalizedMessage=="+authenticationException.getLocalizedMessage());
		System.out.println("getCause=="+authenticationException.getCause());
		System.out.println("一系列信息="+authenticationException.getAuthentication()+authenticationException.getExtraInformation());
		redirectStrategy.sendRedirect(request, response, "/login?error="+authenticationException.getMessage());
	}

}
