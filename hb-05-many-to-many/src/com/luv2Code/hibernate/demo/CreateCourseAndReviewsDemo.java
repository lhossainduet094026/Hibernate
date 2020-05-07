package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Course;
import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;
import com.luv2Code.hibernate.demo.entity.Review;
import com.luv2Code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		// create sessionfactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create session object
		Session session = factory.getCurrentSession();
		try {
			// begin the transaction
			session.beginTransaction();
			//create a course
			Course tempCourse = new Course("pacman-how to score 1 million points.");
			System.out.println("saving course"+tempCourse);
			session.save(tempCourse);
			//create some students
			Student student1 = new Student("kaiyom", "mohammad","kaiyom@gamil.com");
			Student student2 = new Student("imaran","hossain","imran@yahoo.com");
			//add with a course 
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student1);
			//save student
			System.out.println("\nsaving students.............");
			session.save(student1);
			session.save(student2);
			//getting the students of this course 
			System.out.println("saved students:"+tempCourse.getStudents());
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
