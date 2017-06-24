/**
 * 
 */
package indi.jack.model;

import indi.jack.entity.AccountInfo;

/**
 * <p>Title:RegisterModel用户注册模型</p>
 * <p>Description:使用bean验证</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年3月23日 上午9:03:35
 */
public class RegisterModel {
	/*@NotBlank(message="{validate.register.form.username.notblank}")*/
	/*@Pattern(regexp = "^[0-9]*$",message="{validate.register.form.username.onlydigit}")*/
	/*@NotNull(message="{validate.register.form.username.notblank}")*/
	private Long userId;
	/*@NotBlank(message="{validate.register.form.password.notblank}")*/
	private String password;
	/*@NotNull(message="{validate.register.form.username.notblank}")*/
	private int roleid;
	private AccountInfo accountInfo;

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public AccountInfo getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	
}
