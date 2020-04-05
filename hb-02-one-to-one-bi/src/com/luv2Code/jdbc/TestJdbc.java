package com.luv2Code.jdbc;

import java.sql.DriverManager;
import java.sql.*;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";

		try {
			System.out.println("connection to database" + jdbcUrl);
			Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection successful.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
