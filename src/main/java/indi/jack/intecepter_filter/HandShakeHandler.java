/**
 * 
 */
package indi.jack.intecepter_filter;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketExtension;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

/**
 * <p>Title:HandShakeHandler</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月26日 下午7:51:16
 */
public class HandShakeHandler extends DefaultHandshakeHandler{

	@Override
	protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler,
			Map<String, Object> attributes) {
		System.out.println("principal"+request.getPrincipal());
		System.out.println("wshandler");
		return super.determineUser(request, wsHandler, attributes);
	}

	@Override
	protected List<WebSocketExtension> filterRequestedExtensions(ServerHttpRequest request,
			List<WebSocketExtension> requested, List<WebSocketExtension> supported) {
		return super.filterRequestedExtensions(request, requested, supported);
	}
	

}
