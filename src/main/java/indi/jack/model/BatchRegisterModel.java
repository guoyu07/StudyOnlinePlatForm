/**
 * 
 */
package indi.jack.model;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>Title:BatchRegisterModel</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年4月12日 下午3:10:27
 */
public class BatchRegisterModel {
	//必选注册项
	private List<MultipartFile> files;
	private Integer roleid;
	//可选注册项
	private String usernameCol;
	private String genderCol;
	private String PhoneNumCol;
	private String EmailCol;
	private String SchoolNameCol;
	private String BirthDayCol;
	private String AddressCol;
	private String UserIdCol;
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public String getUsernameCol() {
		return usernameCol;
	}
	public void setUsernameCol(String usernameCol) {
		this.usernameCol = usernameCol;
	}
	public String getGenderCol() {
		return genderCol;
	}
	public void setGenderCol(String genderCol) {
		this.genderCol = genderCol;
	}
	public String getPhoneNumCol() {
		return PhoneNumCol;
	}
	public void setPhoneNumCol(String phoneNumCol) {
		PhoneNumCol = phoneNumCol;
	}
	public String getEmailCol() {
		return EmailCol;
	}
	public void setEmailCol(String emailCol) {
		EmailCol = emailCol;
	}
	public String getSchoolNameCol() {
		return SchoolNameCol;
	}
	public void setSchoolNameCol(String schoolNameCol) {
		SchoolNameCol = schoolNameCol;
	}
	public String getBirthDayCol() {
		return BirthDayCol;
	}
	public void setBirthDayCol(String birthDayCol) {
		BirthDayCol = birthDayCol;
	}
	public String getAddressCol() {
		return AddressCol;
	}
	public void setAddressCol(String addressCol) {
		AddressCol = addressCol;
	}
	public String getUserIdCol() {
		return UserIdCol;
	}
	public void setUserIdCol(String userIdCol) {
		UserIdCol = userIdCol;
	}
	
	
}
