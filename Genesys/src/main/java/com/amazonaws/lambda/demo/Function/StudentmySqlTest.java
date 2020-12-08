package com.amazonaws.lambda.demo.Function;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amazonaws.lambda.demo.HibernateUtil;
import com.amazonaws.lambda.demo.Model.Request;
import com.amazonaws.lambda.demo.Model.Student;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class StudentmySqlTest implements RequestHandler<Request, String> {

    @Override
    public String handleRequest(Request request, Context context) {
    	System.out.println("Entering handle request");
    	
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = new Student();
            student.setId(request.id);
            student.setName(request.name);
            session.save(student);
            session.getTransaction().commit();
        }

        return String.format("Added %s %s.", request.id, request.name);
    }
}