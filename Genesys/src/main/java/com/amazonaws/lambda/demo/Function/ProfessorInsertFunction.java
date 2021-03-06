package com.amazonaws.lambda.demo.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amazonaws.lambda.demo.CollegeS3Client;
import com.amazonaws.lambda.demo.HibernateUtil;
import com.amazonaws.lambda.demo.Model.Professor;
import com.amazonaws.lambda.demo.http.HttpRequest;
import com.amazonaws.lambda.demo.http.httpProfessorResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

public class ProfessorInsertFunction 
extends CollegeS3Client
implements RequestHandler<HttpRequest, httpProfessorResponse> {

    @Override
    public httpProfessorResponse handleRequest(HttpRequest request, Context context) {
        context.getLogger().log("Input: " + request);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            
            String body = request.getBody();
            Gson gson = new Gson();
            
            Professor professor = gson.fromJson(body, Professor.class);
           
            session.save(professor);
            session.getTransaction().commit();
        
            httpProfessorResponse response = new httpProfessorResponse(professor);
            
            return response;
    }

}

}