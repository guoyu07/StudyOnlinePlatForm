package indi.jack.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@Table(name="course")
@NamedQuery(name="CourseEntity.findAll", query="SELECT c FROM CourseEntity c")
public class CourseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private int course_Id;
	private CourseCategory category;
	private CourseType type;
	private String courseName;
	/*private int course_Category;
	private int course_Type_Id;*/
	private String targetUser;
	/*private List<Class> clazzs;*/

	public CourseEntity() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourse_Id() {
		return this.course_Id;
	}

	public void setCourse_Id(int course_Id) {
		this.course_Id = course_Id;
	}
	
	/*public int getCourse_Category() {
		return this.course_Category;
	}

	public void setCourse_Category(int course_Category) {
		this.course_Category = course_Category;
	}

	public int getCourse_Type_Id() {
		return this.course_Type_Id;
	}
	
	public void setCourse_Type_Id(int course_Type_Id) {
		this.course_Type_Id = course_Type_Id;
	}*/
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Course_Category")
	public CourseCategory getCategory() {
		return category;
	}


	public void setCategory(CourseCategory category) {
		this.category = category;
	}

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Course_Type_Id")
	public CourseType getType() {
		return type;
	}


	public void setType(CourseType type) {
		this.type = type;
	}


	@Column(name="Course_Name")
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}


	


	@Column(name="Target_User")
	public String getTargetUser() {
		return this.targetUser;
	}

	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}


	//bi-directional many-to-one association to Class
	/*@OneToMany(mappedBy="courseEntity",fetch=FetchType.EAGER)
	public List<Class> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(List<Class> clazzs) {
		this.clazzs = clazzs;
	}

	public Class addClazz(Class clazz) {
		getClazzs().add(clazz);
		clazz.setCourseEntity(this);

		return clazz;
	}

	public Class removeClazz(Class clazz) {
		getClazzs().remove(clazz);
		clazz.setCourseEntity(null);

		return clazz;
	}*/

}