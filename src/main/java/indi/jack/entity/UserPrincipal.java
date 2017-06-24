/**
 * 
 */
package indi.jack.entity;
import java.io.Serializable;
import java.util.Arrays;
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

import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;

@Entity
@Table(name="User_Principal")
public class UserPrincipal implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long userid;
	private Integer roleid;
	private boolean accountNonExpired=true;
    private boolean accountNonLocked=true;
    private boolean credentialsNonExpired=true;
    private boolean enabled=true;
	/*private RoleEntity roleEntity;*/
	private byte[] hashPassword;
	private boolean onlineState;
	private Date lastLoggedTime;
	private Date lastloggedoutTime;
	private Date registerTime=new Date();
	private AccountInfo accountInfo;
	@Id
	@Column(name="User_Principal_Id")
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	@Column(name="Password")
	
	public byte[] getHashPassword() {
		return hashPassword;
	}
	public void setHashPassword(byte[] hashPassword) {
		this.hashPassword = hashPassword;
	}
	
	@Column(name="Role_Id")
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	@Column(name="AccountNonExpired")
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	@Column(name="AccountNonLocked")
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	@Column(name="CredentialsNonExpired")
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	@Column(name="Enabled")
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
	@OneToOne(cascade=CascadeType.ALL,optional=true/*,mappedBy="accountInfo"*/)
	@JoinColumn(name="Account_Info_Id",unique=true)
	@IndexedEmbedded
	public AccountInfo getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}
	@Override
	public String toString() {
		return "UserPrincipal [userid=" + userid + ", roleid=" + roleid + ", accountNonExpired=" + accountNonExpired
				+ ", accountNonLocked=" + accountNonLocked + ", credentialsNonExpired=" + credentialsNonExpired
				+ ", enabled=" + enabled + ", hashPassword=" + Arrays.toString(hashPassword) + ", onlineState="
				+ onlineState + ", lastLoggedTime=" + lastLoggedTime + ", lastloggedoutTime=" + lastloggedoutTime
				+ ", registerTime=" + registerTime + ", accountInfo=" + accountInfo + "]";
	}
	
	
	
	//不使用实体间关联技术，分散实体
	/*@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="Role_Id")
	public Set<RoleAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<RoleAuthority> authorities) {
		this.authorities = authorities;
	}*/
	/*@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="Role_Id")
	public RoleEntity getRoleEntity() {
		return roleEntity;
	}
	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}*/
}
