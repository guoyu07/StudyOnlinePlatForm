package indi.jack.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.apache.lucene.analysis.cn.ChineseAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;

import java.util.Date;


/**
 * The persistent class for the account_info database table.
 * 
 */
@Entity
@Table(name="account_info")
@NamedQuery(name="AccountInfo.findAll", query="SELECT a FROM AccountInfo a")
@Indexed()
public class AccountInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long account_Info_Id;
	private String address;
	private String avatar;
	private Date birthDay;
	private String email;
	private String gender="保密";
	private String phoneNum;
	private String profile;
	private String schoolName;
	private String user_Name;
	//private UserPrincipal userPrincipal;
	public AccountInfo() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public Long getAccount_Info_Id() {
		return this.account_Info_Id;
	}

	public void setAccount_Info_Id(Long account_Info_Id) {
		this.account_Info_Id = account_Info_Id;
	}


	@Column(length=100)
	@Field(analyze=Analyze.NO)
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

	@Field
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

	@Field
	@Column(length=20)
	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	@Column(length=255)
	@Field(analyze=Analyze.NO)
	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}


	@Column(length=30)
	@Field(analyze=Analyze.NO)
	public String getSchoolName() {
		return this.schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	@Column(length=30)
	@Field(analyze=Analyze.NO)
	public String getUser_Name() {
		return this.user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}


	@Override
	public String toString() {
		return "AccountInfo [account_Info_Id=" + account_Info_Id + ", address=" + address + ", avatar=" + avatar
				+ ", birthDay=" + birthDay + ", email=" + email + ", gender=" + gender + ", phoneNum=" + phoneNum
				+ ", profile=" + profile + ", schoolName=" + schoolName + ", user_Name=" + user_Name + "]";
	}

    /*@OneToOne(cascade=CascadeType.ALL)
	public UserPrincipal getUserPrincipal() {
		return userPrincipal;
	}


	public void setUserPrincipal(UserPrincipal userPrincipal) {
		this.userPrincipal = userPrincipal;
	}*/

}