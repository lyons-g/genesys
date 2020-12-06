package com.amazonaws.lambda.demo;

import java.util.ArrayList;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.gson.annotations.SerializedName;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cid", scope = CourseJson.class)

public class CourseJson {
	
	
	int cid;
	String title;
	int pid;
	ArrayList<Integer> sids;

	public CourseJson() {
		
	}
	
	public CourseJson(int cid, String title, int pid, ArrayList<Integer> sids) {
		super();
		this.cid = cid;
		this.title = title;
		this.pid = pid;
		this.sids = sids;
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
	 
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public ArrayList<Integer> getSids() {
		return sids;
	}

	public void setSids(ArrayList<Integer> sids) {
		this.sids = sids;
	}

	@Override
	public String toString() {
		return "CourseJson [cid=" + cid + ", title=" + title + ", pid=" + pid + ", sids=" + sids + "]";
	}
	
	
}
