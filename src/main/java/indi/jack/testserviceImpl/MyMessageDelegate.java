/**
 * 
 */
package indi.jack.testserviceImpl;

import java.io.Serializable;
import java.util.Map;

import indi.jack.testservice.MessageDelegate;

/**
 * <p>Title:MyMessageDelegate</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月25日 下午5:10:50
 */
public class MyMessageDelegate implements MessageDelegate{

	@Override
	public void handleMessage(String message) {
		System.out.println("handleMessage(String message):" + message);
	}

	@Override
	public void handleMessage(Map<?, ?> message) {
		System.out.println("handleMessage(Map<?, ?> message):" + message);
	}

	@Override
	public void handleMessage(byte[] message) {
		System.out.println("handleMessage(byte[] message):"
				+ new String(message));
	}

	@Override
	public void handleMessage2(Serializable message) {
		System.out.println("handleMessage(Serializable message):"
				+ message.toString());
	}

	@Override
	public void handleMessage(Serializable message, String channel) {
		System.out
				.println("handleMessage(Serializable message, String channel):"
						+ message.toString() + ", channel:" + channel);
	}

	/* (non-Javadoc)
	 * @see indi.jack.testservice.MessageDelegate#testtopic(java.io.Serializable)
	 */
	@Override
	public void testtopic(Serializable message) {
		System.out.println("自定义方法接收"+message.toString());
	}

}
