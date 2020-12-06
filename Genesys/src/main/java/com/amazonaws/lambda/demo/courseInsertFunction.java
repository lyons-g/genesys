package com.amazonaws.lambda.demo;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

public class courseInsertFunction 
extends CollegeS3Client
implements RequestHandler<HttpRequest, httpCourseResponse> {

    @Override
    public httpCourseResponse handleRequest(HttpRequest request, Context context) {
        context.getLogger().log("Input: " + request);

        String body = request.getBody();
        
        Gson gson = new Gson();
        

        CourseJson courseToAdd = gson.fromJson(body, CourseJson.class);
        Course course = new Course(courseToAdd);
        
        College college = getAll();

        ArrayList <Course> collegeCourse = college.getCourses();
        
        collegeCourse.add(course);
        
        college.setCourses(collegeCourse);
        
        if(updateAllCollege(college)) {
        	return new httpCourseResponse(course);
        }
        
         httpCourseResponse response = new httpCourseResponse();
         response.setStatusCode("500");
         return response;
    }

}