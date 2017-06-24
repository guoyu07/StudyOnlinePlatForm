package indi.jack.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the class_course_tree database table.
 * 
 */
@Entity
@Table(name="class_course_tree")
@NamedQuery(name="ClassCourseTree.findAll", query="SELECT c FROM ClassCourseTree c")
public class ClassCourseTree implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String chapterAbstract;
	private Long chapterTest;
	private int classId;
	private short level;
	private String name;
	private Long pId;
	private short width;
	private List<TeachResource> resources;
	public ClassCourseTree() {
	}


	@Id
	@Column(name="Course_Tree_Id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Lob
	@Basic(fetch=FetchType.LAZY)
	@Column(name="Chapter_Abstract")
	public String getChapterAbstract() {
		return this.chapterAbstract;
	}

	public void setChapterAbstract(String chapterAbstract) {
		this.chapterAbstract = chapterAbstract;
	}

	@Column(name="Chapter_Test")
	public Long getChapterTest() {
		return this.chapterTest;
	}

	public void setChapterTest(Long chapterTest) {
		this.chapterTest = chapterTest;
	}

	@Column(name="class_Id")
	public int getClassId() {
		return classId;
	}


	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Column(name="Deepth")
	public short getLevel() {
		return this.level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	@Column(name="Node_Name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public short getWidth() {
		return this.width;
	}
	
	@Column(name="p_Node_Id")
	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}


	public void setWidth(short width) {
		this.width = width;
	}

	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="Course_Tree_Node_Id")
	public List<TeachResource> getResources() {
		return resources;
	}


	public void setResources(List<TeachResource> resources) {
		this.resources = resources;
	}


	@Override
	public String toString() {
		return "ClassCourseTree [id=" + id + ", chapterAbstract=" + chapterAbstract + ", chapterTest=" + chapterTest
				+ ", classId=" + classId + ", level=" + level + ", name=" + name + ", pId=" + pId + ", width=" + width
				+ ", resources=" + resources + "]";
	}


	
	

	
}