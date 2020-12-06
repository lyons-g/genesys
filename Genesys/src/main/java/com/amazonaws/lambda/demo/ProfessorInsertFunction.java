package com.amazonaws.lambda.demo;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

public class ProfessorInsertFunction 
extends CollegeS3Client
implements RequestHandler<HttpRequest, httpProfessorResponse> {

    @Override
    public httpProfessorResponse handleRequest(HttpRequest request, Context context) {
        context.getLogger().log("Input: " + request);

        //Take the body section of the request 
        String body = request.getBody();

        //Convert to Pojo
        Gson gson = new Gson();
        Professor professorToAdd = gson.fromJson(body, Professor.class);
        
        //get full College and add new professor to Professors<>
        College college = getAll();
        //college.professors.add(professorToAdd);
        college.getProfessors().add(professorToAdd);
       
                
        if(updateAllCollege(college)) {
        return new httpProfessorResponse(professorToAdd);	
        }
        
        httpProfessorResponse response = new httpProfessorResponse();
        response.setStatusCode("500");
        return response;
    }


    	
    }

