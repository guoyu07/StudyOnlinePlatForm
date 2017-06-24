/**
 * 
 */
package indi.jack.testserviceImpl;

import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * <p>Title:WebsocketHandler</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月25日 下午8:37:47
 */
public class WebsocketHandler extends TextWebSocketHandler {

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		 super.handleTextMessage(session, message);  
		TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");  
        Map<String, Object> sessioncontents=session.getAttributes();
        for (Map.Entry<String, Object> entry : sessioncontents.entrySet()) {
        	   System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        	  }
		session.sendMessage(returnMessage);
		System.out.println("处理消息==》》"+message.toString());
	}

	@Override
	public void afterConnectionClosed(WebSocketSession websocketsession, CloseStatus closestatus) throws Exception {
		super.afterConnectionClosed(websocketsession, closestatus);
		System.out.println("用户离开了");
	}
	
}
