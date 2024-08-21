package com.sql.curd.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Retrivedata {

	private static final String URL = "jdbc:postgresql://localhost:5432/employees";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456";
	public static void main(String[] args) {
	
		        try {
		            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

		           

		            // Read
		            String selectQuery = "SELECT * FROM employees";
		            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
		                 ResultSet resultSet = selectStmt.executeQuery()) {

		                while (resultSet.next()) {
		                   // int id = resultSet.getInt("id");
		                    String name = resultSet.getString("name");
		                    String position = resultSet.getString("position");
		                    int salary = resultSet.getInt("salary");
		                    System.out.println(
		                    		
		                    		name + ", " + position + ", " + salary);
		                }
		            }

		      
		            connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		

	
}
