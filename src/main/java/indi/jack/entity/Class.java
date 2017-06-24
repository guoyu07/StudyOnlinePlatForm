package indi.jack.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.Date;


/**
 * The persistent class for the class database table.
 * 
 */
@Entity
@NamedQuery(name="Class.findAll", query="SELECT c FROM Class c")
public class Class implements Serializable {
	private static final long serialVersionUID = 1L;
	private int classId;
	private String briefIntroduce;
	private String detailedIntroduce;
	private Integer classOrder;
	private boolean classOver;
	private String classPoster;
	private int period;
	private Long teacherId;
	private Date termEnd;
	private Date termStart;
	private CourseEntity courseEntity;

	public Class() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Class_Id")
	public int getClassId() {
		return this.classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Column(name="Brief_Introduce")
	public String getBriefIntroduce() {
		return briefIntroduce;
	}


	public void setBriefIntroduce(String briefIntroduce) {
		this.briefIntroduce = briefIntroduce;
	}
	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="Detailed_Introduce")
	public String getDetailedIntroduce() {
		return detailedIntroduce;
	}


	public void setDetailedIntroduce(String detailedIntroduce) {
		this.detailedIntroduce = detailedIntroduce;
	}


	@Column(name="Class_Order")
	public Integer getClassOrder() {
		return this.classOrder;
	}

	public void setClassOrder(Integer classOrder) {
		this.classOrder = classOrder;
	}


	@Column(name="Class_Over")
	public boolean getClassOver() {
		return this.classOver;
	}

	public void setClassOver(boolean classOver) {
		this.classOver = classOver;
	}


	@Column(name="Class_Poster")
	public String getClassPoster() {
		return this.classPoster;
	}

	public void setClassPoster(String classPoster) {
		this.classPoster = classPoster;
	}


	public int getPeriod() {
		return this.period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	@Column(name="teacher_Id")
	public Long getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Term_End")
	public Date getTermEnd() {
		return this.termEnd;
	}

	public void setTermEnd(Date termEnd) {
		this.termEnd = termEnd;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Term_Start")
	public Date getTermStart() {
		return this.termStart;
	}

	public void setTermStart(Date termStart) {
		this.termStart = termStart;
	}
	//bi-directional many-to-one association to CourseEntity
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Course_Id")
	/*@JsonIgnore */
	public CourseEntity getCourseEntity() {
		return courseEntity;
	}


	public void setCourseEntity(CourseEntity courseEntity) {
		this.courseEntity = courseEntity;
	}


	@Override
	public String toString() {
		return "Class [classId=" + classId + ", briefIntroduce=" + briefIntroduce + ", detailedIntroduce="
				+ detailedIntroduce + ", classOrder=" + classOrder + ", classOver=" + classOver + ", classPoster="
				+ classPoster + ", period=" + period + ", teacherId=" + teacherId + ", termEnd=" + termEnd
				+ ", termStart=" + termStart + ", courseEntity=" + courseEntity + "]";
	}



}