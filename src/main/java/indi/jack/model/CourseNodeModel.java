/**
 * 
 */
package indi.jack.model;

import java.io.Serializable;

/**
 * <p>Title:CourseNodeModel</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月4日 上午11:47:21
 */
public class CourseNodeModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long nodeid;
	private short deepth;
	private String nodeName;
	private Integer classid;
	public Long getNodeid() {
		return nodeid;
	}
	public void setNodeid(Long nodeid) {
		this.nodeid = nodeid;
	}
	public short getDeepth() {
		return deepth;
	}
	public void setDeepth(short deepth) {
		this.deepth = deepth;
	}
	public String getNodeName() {
		return nodeName;
	}
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	public Integer getClassid() {
		return classid;
	}
	public void setClassid(Integer classid) {
		this.classid = classid;
	}
	
}
