/**
 * 
 */
package indi.jack.testController;

import java.security.Principal;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

/**
 * <p>Title:WebSocketTest</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月25日 下午9:12:42
 */
@Controller
public class WebSocketTest {
	@MessageMapping(value="/socket")
	public void socket(Principal principal ){
		
	}
}
