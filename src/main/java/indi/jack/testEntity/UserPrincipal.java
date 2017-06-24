package indi.jack.testEntity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the user_principal database table.
 * 
 */
/*@Entity*/
@Table(name="user_principal")
@NamedQuery(name="UserPrincipal.findAll", query="SELECT u FROM UserPrincipal u")
public class UserPrincipal implements Serializable {
	private static final long serialVersionUID = 1L;
	private String user_Principal_Id;
	private byte accountNonExpired;
	private byte accountNonLocked;
	private byte credentialsNonExpired;
	private byte enabled;
	private Date last_logged_Time;
	private Date last_loggedout_Time;
	private byte online_State;
	private byte[] password;
	private Timestamp register_Time;
	private int role_Id;
	private AccountInfo accountInfo;

	public UserPrincipal() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public String getUser_Principal_Id() {
		return this.user_Principal_Id;
	}

	public void setUser_Principal_Id(String user_Principal_Id) {
		this.user_Principal_Id = user_Principal_Id;
	}


	@Column(nullable=false)
	public byte getAccountNonExpired() {
		return this.accountNonExpired;
	}

	public void setAccountNonExpired(byte accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}


	@Column(nullable=false)
	public byte getAccountNonLocked() {
		return this.accountNonLocked;
	}

	public void setAccountNonLocked(byte accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	@Column(nullable=false)
	public byte getCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public void setCredentialsNonExpired(byte credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}


	@Column(nullable=false)
	public byte getEnabled() {
		return this.enabled;
	}

	public void setEnabled(byte enabled) {
		this.enabled = enabled;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getLast_logged_Time() {
		return this.last_logged_Time;
	}

	public void setLast_logged_Time(Date last_logged_Time) {
		this.last_logged_Time = last_logged_Time;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getLast_loggedout_Time() {
		return this.last_loggedout_Time;
	}

	public void setLast_loggedout_Time(Date last_loggedout_Time) {
		this.last_loggedout_Time = last_loggedout_Time;
	}


	@Column(nullable=false)
	public byte getOnline_State() {
		return this.online_State;
	}

	public void setOnline_State(byte online_State) {
		this.online_State = online_State;
	}


	@Column(nullable=false)
	public byte[] getPassword() {
		return this.password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}


	public Timestamp getRegister_Time() {
		return this.register_Time;
	}

	public void setRegister_Time(Timestamp register_Time) {
		this.register_Time = register_Time;
	}


	@Column(nullable=false)
	public int getRole_Id() {
		return this.role_Id;
	}

	public void setRole_Id(int role_Id) {
		this.role_Id = role_Id;
	}


	//bi-directional many-to-one association to AccountInfo
	/*@OneToMany(mappedBy="userPrincipal", cascade={CascadeType.ALL})*/
	@OneToOne(mappedBy="userPrincipal",cascade=CascadeType.ALL)
	public AccountInfo getAccountInfo() {
		return this.accountInfo;
	}

	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}


}