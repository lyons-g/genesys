package com.amazonaws.lambda.demo;

import java.util.Map;
import java.util.ArrayList;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;






public class studentFindFunction 
extends CollegeS3Client
implements RequestHandler<HttpRequest, httpStudentResponse> {

	@Override
	public httpStudentResponse handleRequest(HttpRequest request, Context context) {
		context.getLogger().log("Input: " + request);
		
		Map<String, String> pathParams = request.getPathParameters();
		if(pathParams == null) {
			
			ArrayList<Student> allStudents = getAll().getStudents();
			httpStudentResponse response = new httpStudentResponse(allStudents);
			return response;
		}
		String idAsString = pathParams.get("id");
		Integer studentId = Integer.parseInt(idAsString);
		Student student = getStudentById(studentId);
		
		return new httpStudentResponse(student);
	}
	
	
	private Student getStudentById(int stuId) {
		College college = getAll();
		
		for(Student stu : college.students) {
			if(stu.getSid()==stuId) {
				return stu;
			}
		}
		
		return null;
	}
}