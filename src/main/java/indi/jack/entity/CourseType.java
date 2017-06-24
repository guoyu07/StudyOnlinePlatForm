package indi.jack.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course_type database table.
 * 
 */
@Entity
@Table(name="course_type")
@NamedQuery(name="CourseType.findAll", query="SELECT c FROM CourseType c")
public class CourseType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int course_Type_Id;
	private String course_Type_Name;
	private String description;
	/*private List<CourseEntity> courses;*/

	public CourseType() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourse_Type_Id() {
		return this.course_Type_Id;
	}

	public void setCourse_Type_Id(int course_Type_Id) {
		this.course_Type_Id = course_Type_Id;
	}


	public String getCourse_Type_Name() {
		return this.course_Type_Name;
	}

	public void setCourse_Type_Name(String course_Type_Name) {
		this.course_Type_Name = course_Type_Name;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	//bi-directional many-to-one association to CourseEntity
	/*@OneToMany(mappedBy="courseType")
	public List<CourseEntity> getCourses() {
		return this.courses;
	}

	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}

	public CourseEntity addCours(CourseEntity cours) {
		getCourses().add(cours);
		cours.setCourseType(this);

		return cours;
	}

	public CourseEntity removeCours(CourseEntity cours) {
		getCourses().remove(cours);
		cours.setCourseType(null);

		return cours;
	}*/

}