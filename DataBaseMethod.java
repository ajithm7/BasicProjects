package com.database;
import java.sql.*;
public class DataBaseMethod {


		private Connection con = null;
		private Statement st = null;
		private PreparedStatement pStatement = null;
	//Driver name
		private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	//URL
		private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
		private static final String USERNAME = "root";

		public Connection getConnection() {
			try {
				Class.forName(JDBC_DRIVER);// connect driver
				con = DriverManager.getConnection(DB_URL, USERNAME, "1234");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}

	//create statement from section query	
		public Statement getStatement() throws SQLException {
			Connection newConnection = getConnection();
			st = newConnection.createStatement();
			return st;
		}

	//create prepared statement 
		public PreparedStatement getpStatement(String str) throws SQLException {
			Connection newConnection = getConnection();
			pStatement = newConnection.prepareStatement(str);
			return pStatement;
		}

	}
