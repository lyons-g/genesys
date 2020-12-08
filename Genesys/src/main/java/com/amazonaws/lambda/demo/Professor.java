package com.amazonaws.lambda.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Professor")
public class Professor implements java.io.Serializable {
	
	
	int pid;
	String name;
	
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

	@Id
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