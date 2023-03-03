package com.example.todo;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.cfg.Configuration;

import com.example.todo.Model.ToDoItem;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			//query.setParameter("*", "toDoList");
			List<ToDoItem> employees = em.createQuery("FROM ToDoItem", ToDoItem.class).getResultList();

			for (ToDoItem e : employees) {
				System.out.println(e.getTask_description());
			}

			tx.commit();
			em.close();
			emf.close();
	
	
		
		// or alternatively, if you don't know ahead of time that
		// the query will be a SELECT...
/*
 * 
 * 
 
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
*/
		


	}

}
