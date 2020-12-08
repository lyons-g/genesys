package com.amazonaws.lambda.demo.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.amazonaws.lambda.demo.HibernateUtil;
import com.amazonaws.lambda.demo.Model.Course;
import com.amazonaws.lambda.demo.http.HttpRequest;
import com.amazonaws.lambda.demo.http.httpCourseResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class CourseFindFunction implements RequestHandler<HttpRequest, httpCourseResponse> {

	@Override
	public httpCourseResponse handleRequest(HttpRequest request, Context context) {
		context.getLogger().log("Input: " + request);

		Map<String, String> pathParams = request.getPathParameters();
		if(pathParams == null) {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			try (Session session = sessionFactory.openSession()) {
				session.beginTransaction();

				ArrayList<Course> allCourseArray = new ArrayList<Course>();
				List<Course> courses = session.createQuery("from Course").getResultList();
				for(Course course : courses) {

					allCourseArray.add(course);

				}
				session.getTransaction().commit();

				httpCourseResponse response = new httpCourseResponse(allCourseArray);

				return response;
			}
		}

		String idAsString = pathParams.get("id");
		Integer studentId = Integer.parseInt(idAsString);
	

		SessionFactory sessionFactory2 = HibernateUtil.getSessionFactory();
		try (Session session = sessionFactory2.openSession()) {
			session.beginTransaction();

			Course readCourse = new Course();
					
			session.get(Course.class, readCourse.getId(studentId));
			session.getTransaction().commit();

			return new httpCourseResponse(readCourse);


		}
	}

}
	
