package com.example.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
		conn =
			DriverManager.getConnection("jdbc:mysql://raspberrypi/remote?" +
										"user=remote&password=remote");

		// Do something with the Connection
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM toDoList");

		// or alternatively, if you don't know ahead of time that
		// the query will be a SELECT...

		if (stmt.execute("SELECT * FROM toDoList")) {
			rs = stmt.getResultSet();

			System.out.println((rs));
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("task_name");
				String task_description = rs.getString("task_description");
				System.out.println("ID: " + id + ", Name: " + name + ", task_description: " + task_description);
			  }
    }

		
		} catch (SQLException ex) {
		// handle any errors
		System.out.println("SQLException: " + ex.getMessage());
		System.out.println("SQLState: " + ex.getSQLState());
		System.out.println("VendorError: " + ex.getErrorCode());
		}

	}

}
