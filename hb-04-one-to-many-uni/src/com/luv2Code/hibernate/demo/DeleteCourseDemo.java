package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Course;
import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// create sessionfactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// create session object
		Session session = factory.getCurrentSession();
		try {
			// begin the transaction
			session.beginTransaction(); 
			// get the instructor from db
			int id = 10;
			Course tempCourse = session.get(Course.class, 10);

			System.out.println(tempCourse);
			// delete course with id = 10
			session.delete(tempCourse);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}

}
