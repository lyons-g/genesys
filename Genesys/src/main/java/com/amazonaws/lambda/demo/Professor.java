package com.amazonaws.lambda.demo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.gson.annotations.SerializedName;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "pid", scope = Professor.class)
public class Professor {
	
	
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

	public int getPid() {
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