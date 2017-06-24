package indi.jack.model;

import java.io.Serializable;

import indi.jack.entity.ClassCourseTree;
import indi.jack.entity.TeachResource;
import java.util.List;


/**
 * The persistent class for the class_course_tree database table.
 * 
 */
public class TreeModel implements Serializable {
	private static final long serialVersionUID = 1L;
	private ClassCourseTree node;
	private List<TreeModel> children;
	
	public ClassCourseTree getNode() {
		return node;
	}

	public void setNode(ClassCourseTree node) {
		this.node = node;
	}

	public List<TreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "TreeModel [node=" + node + ", children=" + children + "]";
	}

	

	
}