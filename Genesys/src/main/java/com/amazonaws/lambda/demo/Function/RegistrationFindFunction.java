package com.amazonaws.lambda.demo.Function;

import com.amazonaws.lambda.demo.CollegeS3Client;
import com.amazonaws.lambda.demo.Model.College;
import com.amazonaws.lambda.demo.Model.Course;
import com.amazonaws.lambda.demo.http.HttpRequest;
import com.amazonaws.lambda.demo.http.httpCourseResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.core.ResponseInputStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class RegistrationFindFunction 
extends CollegeS3Client
implements RequestHandler<HttpRequest, httpCourseResponse>  {

	@Override
	public httpCourseResponse handleRequest(HttpRequest request, Context context) {
		context.getLogger().log("Input: " + request);

		/*
		 * look up id of query parameter and get its value
		 * return numbers in string format
		 */
		Map<String, String> pathParams = request.getPathParameters();
		if(pathParams == null) {
	
			ArrayList<Course> allCourses = getAll().getCourses();
			httpCourseResponse response = new httpCourseResponse(allCourses);
			return response;

		}
		String idAsString = pathParams.get("id");
		Integer courseId = Integer.parseInt(idAsString);
		Course course = getCourseById(courseId);

		return new httpCourseResponse(course);

	}

	private Course getCourseById(int courId) {

		College college = getAll();

		for(Course cour: college.courses) {
			if(cour.getCid()==courId) {
				return cour;
			}
		}
		return null;
	}

}

