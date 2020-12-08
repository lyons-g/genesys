package com.amazonaws.lambda.demo.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amazonaws.lambda.demo.HibernateUtil;
import com.amazonaws.lambda.demo.Model.Student;
import com.amazonaws.lambda.demo.http.HttpRequest;
import com.amazonaws.lambda.demo.http.httpStudentResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.google.gson.Gson;

public class CourseInsertFunction implements RequestHandler<HttpRequest, httpStudentResponse> {

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


