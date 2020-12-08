package com.amazonaws.lambda.demo.Model;

import java.util.ArrayList;

public class College {
	
	
	ArrayList<Course> courses = new ArrayList<Course>();
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Professor> professors = new ArrayList<Professor>();
	

	public College() {
		
	}
	
	public ArrayList<Student> getStudents() {

		return students;
	}
	
	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	public ArrayList<Professor> getProfessors() {
		return professors;
	}
	public void setProfessors(ArrayList<Professor> professors) {
		this.professors = professors;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "College [students=" + getStudents() + ", professors=" + getProfessors() + ", courses=" + getCourses() + "]";
	}
	
	
}

