package com.luv2Code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2Code.hibernate.demo.entity.Instructor;
import com.luv2Code.hibernate.demo.entity.InstructorDetail;
import com.luv2Code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// create sessionfactory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		// create session object
		Session session = factory.getCurrentSession();
		try {
			// begin transaction
			session.beginTransaction();
			// getting instructordetail with primary key/id
			int id = 1;
			InstructorDetail tempInstructordetail = session.get(InstructorDetail.class, id);
			// print instructorDetail
			System.out.println("Instructor details......" + tempInstructordetail);
			// getting instructor because of using cascade type ALL

			// print associated instructor
			System.out.println(tempInstructordetail.getInstructor());

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			factory.close();
		}

	}

}
