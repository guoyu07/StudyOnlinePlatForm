package indi.jack.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the teach_resource database table.
 * 
 */
@Entity
@Table(name="teach_resource")
@NamedQuery(name="TeachResource.findAll", query="SELECT t FROM TeachResource t")
public class TeachResource implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long teachResourceId;
	private Long courseTreeNodeId;
	private String resourceName;
	private String resourcePath;
	private String resourceType;
	/*private ClassCourseTree treeNode;*/

	public TeachResource() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Teach_Resource_Id")
	public Long getTeachResourceId() {
		return this.teachResourceId;
	}
	
	public void setTeachResourceId(Long teachResourceId) {
		this.teachResourceId = teachResourceId;
	}
	@Column(name="Course_Tree_Node_Id")
	public Long getCourseTreeNodeId() {
		return courseTreeNodeId;
	}
	public void setCourseTreeNodeId(Long courseTreeNodeId) {
		this.courseTreeNodeId = courseTreeNodeId;
	}
	@Column(name="Resource_Name")
	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}


	@Column(name="Resource_Path")
	public String getResourcePath() {
		return this.resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}


	@Column(name="Resource_Type")
	public String getResourceType() {
		return this.resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/*@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name="Course_Tree_Node_Id")
	@JsonIgnore
	public ClassCourseTree getTreeNode() {
		return treeNode;
	}


	public void setTreeNode(ClassCourseTree treeNode) {
		this.treeNode = treeNode;
	}*/

}