package com.amazonaws.lambda.demo.Model;

import java.util.ArrayList;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.gson.annotations.SerializedName;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cid", scope = Course.class)

public class Course {
	
	
	int cid;
	String title;
	Professor professor;
	ArrayList<Student> students;

	public Course() {
		
	}
	
	public Course(int cid, String title, Professor professor, ArrayList<Student> students) {
		super();
		this.cid = cid;
		this.title = title;
		this.professor = professor;
		this.students = students;
	}

	
	public Course(CourseJson courseToAdd) {
		this.cid = courseToAdd.getCid();
		this.title = courseToAdd.getTitle();
		this.professor = new Professor(courseToAdd.getPid());
		
		ArrayList<Student> students = new ArrayList<Student>();
		for(int sid : courseToAdd.getSids()) {
			students.add(new Student(sid));
		}
		this.students = students;
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

	public void setProfessor(int pid) {
		this.professor = new Professor(pid);
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", title=" + title + ", professor=" + professor + ", students=" + students
				+ "]";
	}
	
}
