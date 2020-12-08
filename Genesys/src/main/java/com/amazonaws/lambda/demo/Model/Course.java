package com.amazonaws.lambda.demo.Model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Course")
public class Course {
	
	@Id
	@Column(name = "cid")
	int cid;
	String title;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "professor", referencedColumnName = "pid")
	Professor professor;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
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
		return "Course [cid=" + cid + ", title=" + title + ", professor=" + professor + ", students=" + students + "]";
	}

	
}
