/**
 * 
 */
package indi.jack.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

/**
 * <p>Title:UserInfoSearchable</p>
 * <p>Description:该实体用于查询用户相关信息，可扩展</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月13日 下午9:20:44
 */
@Entity
@Table(name="User_Principal")
@Indexed
public class UserInfoEntitySearchable implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long userid;
	private RoleEntity roleinfo;
	private boolean onlineState;
	private Date lastLoggedTime;
	private Date lastloggedoutTime;
	private Date registerTime;
	private AccountInfo accountInfo;
	@Id
	@Column(name="User_Principal_Id")
	@DocumentId
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	@OneToOne(cascade=CascadeType.ALL,optional=true)
	@JoinColumn(name="Role_Id")
	@IndexedEmbedded(/*prefix="roleinfo",targetElement=RoleEntity.class*/)
	public RoleEntity getRoleinfo() {
		return roleinfo;
	}
	public void setRoleinfo(RoleEntity roleinfo) {
		this.roleinfo = roleinfo;
	}
	@Column(name="Online_State")
	public boolean isOnlineState() {
		return onlineState;
	}
	
	public void setOnlineState(boolean onlineState) {
		this.onlineState = onlineState;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Last_logged_Time")
	public Date getLastLoggedTime() {
		return lastLoggedTime;
	}
	public void setLastLoggedTime(Date lastLoggedTime) {
		this.lastLoggedTime = lastLoggedTime;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Last_loggedout_Time")
	public Date getLastloggedoutTime() {
		return lastloggedoutTime;
	}
	public void setLastloggedoutTime(Date lastloggedoutTime) {
		this.lastloggedoutTime = lastloggedoutTime;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Register_Time")
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	@OneToOne(cascade=CascadeType.ALL,optional=true)
	@JoinColumn(name="Account_Info_Id",unique=true)
	@IndexedEmbedded(/*prefix="accountInfo",targetElement=AccountInfo.class*/)
	public AccountInfo getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}
	
}
