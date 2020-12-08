package com.amazonaws.lambda.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

public class StudentInsertFunction 
extends CollegeS3Client
implements RequestHandler<HttpRequest, httpStudentResponse> {

    @Override
    public httpStudentResponse handleRequest(HttpRequest request, Context context) {
        context.getLogger().log("Input: " + request);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            
            String body = request.getBody();
            Gson gson = new Gson();
            
            Student student = gson.fromJson(body, Student.class);
           
            session.save(student);
            session.getTransaction().commit();
        
            httpStudentResponse response = new httpStudentResponse(student);
            
            return response;
    }

}

}


