package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Course;
import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;
import com.luv2Code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		// create sessionfactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(Review.class)
				.buildSessionFactory();
		// create session object
		Session session = factory.getCurrentSession();
		try {
			// begin the transaction
			session.beginTransaction();
			//create a course
			Course tempCourse = new Course("pacman-how to score 1 million points.");
			//create some reviews
			tempCourse.addReviews(new Review("great course-love it."));
			tempCourse.addReviews(new Review("cool course,job well done."));
			tempCourse.addReviews(new Review("what a dumb course,you are an idiot."));
			//save the course and leverage the cascade all
			System.out.println("saving course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);
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
