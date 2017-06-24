/**
 * 
 */
package indi.jack.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>Title:ApplyClassModel</p>
 * <p>Description:</p>
 * <p>Company:</p>
 * @author jackhoo
 * @date   2017年5月1日 下午8:39:41
 */
public class ApplyClassEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private int courseCategory;
	private String course_Name;
	private int period;
	private String target_User;
	private Long applicantId;
	private String class_Poster;
	private byte[] class_Introduce;
	private Date applyTime;
	public int getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(int courseCategory) {
		this.courseCategory = courseCategory;
	}
	public String getCourse_Name() {
		return course_Name;
	}
	public void setCourse_Name(String course_Name) {
		this.course_Name = course_Name;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getTarget_User() {
		return target_User;
	}
	public void setTarget_User(String target_User) {
		this.target_User = target_User;
	}
	public Long getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}
	public String getClass_Poster() {
		return class_Poster;
	}
	public void setClass_Poster(String class_Poster) {
		this.class_Poster = class_Poster;
	}
	public Object getClass_Introduce() {
		return class_Introduce;
	}
	public void setClass_Introduce(byte[] class_Introduce) {
		this.class_Introduce = class_Introduce;
	}
	
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
	
	
}
