package com.amazonaws.lambda.demo;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.amazonaws.lambda.demo.Model.Professor;
import com.amazonaws.lambda.demo.Model.Student;

public class HibernateUtil {


    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (null != sessionFactory)
            return sessionFactory;
        
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
    	

        String jdbcUrl = System.getenv("DB_CONNECTION");
       
        
        configuration.setProperty("hibernate.connection.url", jdbcUrl);
        configuration.setProperty("hibernate.connection.username", System.getenv("AWS_USER"));
        configuration.setProperty("hibernate.connection.password", System.getenv("AWS_PASSWORD"));

        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Professor.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        try {
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
        return sessionFactory;
    }
}


	
