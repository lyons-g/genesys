package com.amazonaws.lambda.demo.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.lambda.demo.Model.Student;
import com.google.gson.Gson;

public class httpStudentResponse {

		private String body;
		private	String statusCode ="200";
		private	Map<String, String> headers = new HashMap<String, String>();
		
		public httpStudentResponse(){
			super();
			this.headers.put("Content-Type", "application/json");
		}
		
		public httpStudentResponse(Student student) { 
			this();
			Gson gson = new Gson();
			this.body = gson.toJson(student);
		}
		
		/*
		 * return all
		 */
		public httpStudentResponse(ArrayList <Student> student) {
			this();
			Gson gson = new Gson();
			this.body = gson.toJson(student);
		}
		
		
		public String getBody() {
			return body;
		}
		public void setBody(String body) {
			this.body = body;
		}
		public String getStatusCode() {
			return statusCode;
		}
		public void setStatusCode(String statusCode) {
			this.statusCode = statusCode;
		}
		public Map<String, String> getHeaders() {
			return headers;
		}
		public void setHeaders(Map<String, String> headers) {
			this.headers = headers;
		}

	}
