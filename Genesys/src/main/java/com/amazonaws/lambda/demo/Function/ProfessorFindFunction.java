package com.amazonaws.lambda.demo.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amazonaws.lambda.demo.CollegeS3Client;
import com.amazonaws.lambda.demo.HibernateUtil;
import com.amazonaws.lambda.demo.Model.Professor;
import com.amazonaws.lambda.demo.http.HttpRequest;
import com.amazonaws.lambda.demo.http.httpProfessorResponse;
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

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			try (Session session = sessionFactory.openSession()) {
				session.beginTransaction();

				ArrayList<Professor> allProfessorArray = new ArrayList<Professor>();
				List<Professor> professors = session.createQuery("from Professor").getResultList();
				for(Professor prof : professors) {

					allProfessorArray.add(prof);

				}
				session.getTransaction().commit();

				httpProfessorResponse response = new httpProfessorResponse(allProfessorArray);

				return response;
			}
	}
	
		String idAsString = pathParams.get("id");
		Integer profId = Integer.parseInt(idAsString);
	

		SessionFactory sessionFactory2 = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory2.openSession()) {
			session.beginTransaction();

			Professor readProf = new Professor();
					
			session.get(Professor.class, readProf.getPid(profId));
			session.getTransaction().commit();

			return new httpProfessorResponse(readProf);


		}
	}

}