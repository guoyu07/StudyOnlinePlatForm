package indi.jack.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the student_class database table.
 * 
 */
@Entity
@Table(name="student_class")
@NamedQuery(name="StudentClass.findAll", query="SELECT s FROM StudentClass s")
public class StudentClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long stu_Class_Id;
	private int classId;
	private int course_Id;
	/*private Long student_Id;*/
	private UserInfoEntitySearchable studentinfo;
	private Long teacher_Id;

	public StudentClass() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getStu_Class_Id() {
		return this.stu_Class_Id;
	}

	public void setStu_Class_Id(Long stu_Class_Id) {
		this.stu_Class_Id = stu_Class_Id;
	}


	@Column(name="class_Id")
	public int getClassId() {
		return classId;
	}


	public void setClassId(int classId) {
		this.classId = classId;
	}


	public int getCourse_Id() {
		return this.course_Id;
	}

	public void setCourse_Id(int course_Id) {
		this.course_Id = course_Id;
	}


	@OneToOne
	@JoinColumn(name="student_Id")
	public UserInfoEntitySearchable getStudentinfo() {
		return studentinfo;
	}


	public void setStudentinfo(UserInfoEntitySearchable studentinfo) {
		this.studentinfo = studentinfo;
	}


	public Long getTeacher_Id() {
		return this.teacher_Id;
	}

	public void setTeacher_Id(Long teacher_Id) {
		this.teacher_Id = teacher_Id;
	}

}