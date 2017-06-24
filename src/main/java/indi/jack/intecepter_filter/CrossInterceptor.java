/**
 * 
 */
package indi.jack.intecepter_filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * <p>Title:CrossInterceptor</p>
 * <p>Description:跨域拦截器</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月1日 下午1:03:40
 */
public class CrossInterceptor extends HandlerInterceptorAdapter{
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		response.addHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Methods","*");
        response.addHeader("Access-Control-Max-Age","100");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        response.addHeader("Access-Control-Allow-Credentials","true");
        return super.preHandle(request, response, handler);
    }
}
