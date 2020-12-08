package com.amazonaws.lambda.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Professor")
public class Professor implements java.io.Serializable {
	
	@Id
	@Column(name = "pid")
	private int pid;
	@Column(name = "name")
	private String name;
	@OneToOne(mappedBy = "professor")
	private int course;

	
	public void setCourse(int course) {
		this.course = course;
	}

	public Professor() {
	}
	
	public Professor(int pid) {
		this.pid=pid;
		this.name = getName();
	}
	
	public Professor(int pid, String name) {
		super();
		this.pid = pid;
		this.name = name;
	}

	
	public int getPid() {
		return pid;
	}
	
	public int getPid(int id) {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Professor [pid=" + pid + ", name=" + name + "]";
	}


}