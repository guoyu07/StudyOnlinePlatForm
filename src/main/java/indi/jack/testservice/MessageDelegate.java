/**
 * 
 */
package indi.jack.testservice;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>Title:MessageDelegate</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月25日 下午5:10:08
 */
public interface MessageDelegate {
	public void handleMessage(String message);

	public void handleMessage(Map<?, ?> message);

	public void handleMessage(byte[] message);

	public void handleMessage2(Serializable message);

	// pass the channel/pattern as well
	public void handleMessage(Serializable message, String channel);
	
	public void testtopic(Serializable message);
}
