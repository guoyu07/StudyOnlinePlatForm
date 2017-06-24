/**
 * 
 */
package indi.jack.testController;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * <p>Title:RedisMessageListener</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月25日 下午4:03:33
 */
public class RedisMessageListener implements MessageListener{
	@Autowired RedisTemplate redisTemplate;
	RedisSerializer serializer;
	@Override
	public void onMessage(Message message, byte[] pattern) {
		/*serializer = redisTemplate.getValueSerializer();*/
        /*String messageStr = (String) serializer.deserialize(message.getBody());*/
        System.out.println("message received:" + message.toString());
	}
	/*public void testtopic(Serializable message){
		System.out.println("收到消息="+message.toString());
	}*/

}
