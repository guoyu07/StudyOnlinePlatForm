package indi.jack.testEntity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the account_info database table.
 * 
 */
/*@Entity*/
@Table(name="account_info")
@NamedQuery(name="AccountInfo.findAll", query="SELECT a FROM AccountInfo a")
public class AccountInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String account_Info_Id;
	private String address;
	private String avatar;
	private Date birthDay;
	private String email;
	private String gender;
	private String phoneNum;
	private String profile;
	private String schoolName;
	private String user_Name;
	private UserPrincipal userPrincipal;

	public AccountInfo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public String getAccount_Info_Id() {
		return this.account_Info_Id;
	}

	public void setAccount_Info_Id(String account_Info_Id) {
		this.account_Info_Id = account_Info_Id;
	}


	@Column(length=100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(length=255)
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	@Temporal(TemporalType.DATE)
	public Date getBirthDay() {
		return this.birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}


	@Column(length=30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(length=1)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@Column(length=20)
	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	@Column(length=255)
	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}


	@Column(length=30)
	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	@Column(length=30)
	public String getUser_Name() {
		return this.user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}


	/*//bi-directional many-to-one association to UserPrincipal
	@ManyToOne(cascade={CascadeType.ALL})*/
	/*@OneToOne(mappedBy="accountInfo")*/
	@Column(name="User_Id")
	public UserPrincipal getUserPrincipal() {
		return this.userPrincipal;
	}

	public void setUserPrincipal(UserPrincipal userPrincipal) {
		this.userPrincipal = userPrincipal;
	}

}