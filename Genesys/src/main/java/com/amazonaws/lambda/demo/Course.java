package com.amazonaws.lambda.demo;

import java.util.ArrayList;

public class Course {
	
	int cid;
	String title;
	Professor professor;
	ArrayList<Student> enrollment;

	public Course() {
		
	}
	
	public Course(int cid, String title, Professor professor, ArrayList<Student> enrollment) {
		super();
		this.cid = cid;
		this.title = title;
		this.professor = professor;
		this.enrollment = enrollment;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public ArrayList<Student> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(ArrayList<Student> enrollment) {
		this.enrollment = enrollment;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", title=" + title + ", professor=" + professor + ", enrollment=" + enrollment
				+ "]";
	}
	
}
