package com.amazonaws.lambda.demo;

import java.util.Map;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class studentFindFunction 
extends CollegeS3Client
implements RequestHandler<HttpRequest, httpStudentResponse> {

	@Override
	public httpStudentResponse handleRequest(HttpRequest request, Context context) {
		context.getLogger().log("Input: " + request);

		Map<String, String> pathParams = request.getPathParameters();
		if(pathParams == null) {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			try (Session session = sessionFactory.openSession()) {
				session.beginTransaction();

				ArrayList<Student> allStudentsArray = new ArrayList<Student>();
				List<Student> students = session.createQuery("from Student").getResultList();
				for(Student student : students) {

					allStudentsArray.add(student);

				}
				session.getTransaction().commit();

				httpStudentResponse response = new httpStudentResponse(allStudentsArray);

				return response;
			}
		}

		String idAsString = pathParams.get("id");
		Integer studentId = Integer.parseInt(idAsString);
	

		SessionFactory sessionFactory2 = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory2.openSession()) {
			session.beginTransaction();

			Student readStudent = new Student();
					
			session.get(Student.class, readStudent.getId(studentId));
			session.getTransaction().commit();

			return new httpStudentResponse(readStudent);


		}
	}

}
	
