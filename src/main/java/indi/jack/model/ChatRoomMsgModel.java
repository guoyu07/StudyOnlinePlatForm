/**
 * 
 */
package indi.jack.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>Title:ChatRoomMsgModel</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月15日 下午5:13:34
 */
/*@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.NONE,
fieldVisibility = JsonAutoDetect.Visibility.NONE,
getterVisibility = JsonAutoDetect.Visibility.NONE,
isGetterVisibility = JsonAutoDetect.Visibility.NONE,
setterVisibility = JsonAutoDetect.Visibility.NONE)*/
public class ChatRoomMsgModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private String msg_from;
	private String msg;
	/*@JsonProperty*/
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/*@JsonProperty*/
	public String getMsg_from() {
		return msg_from;
	}
	public void setMsg_from(String msg_from) {
		this.msg_from = msg_from;
	}
}
