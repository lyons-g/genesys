package com.amazonaws.lambda.demo;

import java.util.ArrayList;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class ProfessorFindFunction 
extends CollegeS3Client
implements RequestHandler<HttpRequest, httpProfessorResponse> {
	@Override
	public httpProfessorResponse handleRequest(HttpRequest request, Context context) {
		context.getLogger().log("Input: " + request);
		
		Map<String, String> pathParams = request.getPathParameters();
		if(pathParams == null) {
			
			ArrayList<Professor> allProfessors = getAll().getProfessors();
			httpProfessorResponse response = new httpProfessorResponse(allProfessors);
			return response;
		}
		String idAsString = pathParams.get("id");
		Integer professorId = Integer.parseInt(idAsString);
		Professor professor = getProfessorById(professorId);
		
		return new httpProfessorResponse(professor);
	}
	
	
	private Professor getProfessorById(int profId) {
		College college = getAll();
		
		for(Professor prof : college.professors) {
			if(prof.getPid()==profId) {
				return prof;
			}
		}
		
		return null;
	}

    }


