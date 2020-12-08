package com.amazonaws.lambda.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student implements java.io.Serializable {
	 
	private int id;
	private String name;
	
	public Student () {
		
	}
	public Student(int id) {
		this.id=id;
		this.name=getName();
	}
	
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Id
	public int getId() {
		return id;
	}
	
	public int getId(int id) {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
}


