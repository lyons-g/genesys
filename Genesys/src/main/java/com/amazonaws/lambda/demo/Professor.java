package com.amazonaws.lambda.demo;

public class Professor {

	int pid;
	String name;
	
	public Professor() {
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