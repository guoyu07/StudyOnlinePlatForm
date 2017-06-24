/**
 * 
 */
package indi.jack.model;


/**
 * <p>Title:ChangePwdModel</p>
 * <p>Description:用户修改密码提交的模型</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月14日 下午2:06:11
 */
public class ChangePwdModel {
	/*@NotBlank*/
	private Long userid;
	/*@NotBlank*/
	private String oldPwd;
	/*@NotBlank*/
	private String newPwd;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	
}
