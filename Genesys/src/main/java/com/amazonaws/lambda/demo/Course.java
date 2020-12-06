package com.amazonaws.lambda.demo;

import java.util.ArrayList;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
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

	@DynamoDBHashKey
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
