package com.amazonaws.lambda.demo;

import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.NA;

public class Application {

	public static void main(String[] args) {
		
		Student a = new Student(1, "Tom");
		Professor p = new Professor(2, "Mike");
		Student s = new Student(3, "Ger");
		
		Course c = new Course();
		c.setCid(5);
		c.setTitle("Biology");
		
		c.setProfessor(p);
		
		ArrayList<Student> classes = new ArrayList<>();
		classes.add(a);
		classes.add(s);
		
		c.setEnrollment(classes);
		
		System.out.println(c.toString());

	}

}
