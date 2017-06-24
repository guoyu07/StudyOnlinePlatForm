/**
 * 
 */
package indi.jack.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>Title:MessageModel</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月27日 上午11:06:44
 */
@JsonAutoDetect(creatorVisibility = JsonAutoDetect.Visibility.NONE,
fieldVisibility = JsonAutoDetect.Visibility.NONE,
getterVisibility = JsonAutoDetect.Visibility.NONE,
isGetterVisibility = JsonAutoDetect.Visibility.NONE,
setterVisibility = JsonAutoDetect.Visibility.NONE)
public class MessageModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private Date createdTime;
	private String msg_to;
	private String msg_from;
	@JsonProperty
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@JsonProperty
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	@JsonProperty
	public String getMsg_to() {
		return msg_to;
	}
	public void setMsg_to(String msg_to) {
		this.msg_to = msg_to;
	}
	@JsonProperty
	public String getMsg_from() {
		return msg_from;
	}
	public void setMsg_from(String msg_from) {
		this.msg_from = msg_from;
	}
	
	
}
