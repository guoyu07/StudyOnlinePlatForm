package indi.jack.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the course_category database table.
 * 
 */
@Entity
@Table(name="course_category")
@NamedQuery(name="CourseCategory.findAll", query="SELECT c FROM CourseCategory c")
public class CourseCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	private int course_Category_Id;
	private String category_Desc;
	private String category_Name;
	/*private List<CourseEntity> courses;*/

	public CourseCategory() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourse_Category_Id() {
		return this.course_Category_Id;
	}

	public void setCourse_Category_Id(int course_Category_Id) {
		this.course_Category_Id = course_Category_Id;
	}


	public String getCategory_Desc() {
		return this.category_Desc;
	}

	public void setCategory_Desc(String category_Desc) {
		this.category_Desc = category_Desc;
	}


	public String getCategory_Name() {
		return this.category_Name;
	}

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}


	//bi-directional many-to-one association to CourseEntity
	/*@OneToMany(mappedBy="courseCategory")
	public List<CourseEntity> getCourses() {
		return this.courses;
	}

	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}

	public CourseEntity addCours(CourseEntity cours) {
		getCourses().add(cours);
		cours.setCourseCategory(this);

		return cours;
	}

	public CourseEntity removeCours(CourseEntity cours) {
		getCourses().remove(cours);
		cours.setCourseCategory(null);

		return cours;
	}*/

}