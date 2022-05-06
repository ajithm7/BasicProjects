package com.database;

import java.sql.*;
import java.util.Scanner;

public class StudentDetailsDB {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		StudentDetailsDB student=new StudentDetailsDB();
		student.menu();

	}
	public void menu() throws SQLException {
			while (true) {
				System.out.print("Enter any One of below:" + "\n" + "1->Add student details" + "\n" + "2->Get All details"
						+ "\n" + "3->Get individual details" + "\n" + "4->Edit details" + "\n" + "5->Exit");
				char n = scan.next().charAt(0);
				switch (n) {
				case '1' -> register() ;
				case '2' -> getAllDetails();
				case '3' -> getIndivitualDetails();
				case '4' ->editIndivitualDetails();
				case '5' -> System.exit(0);
				default -> System.err.println("Enter 1 or 2.");
				}}
			
	}

	public void register() {
		try {DataBaseMethod dbMethod = new DataBaseMethod();
		String string = " insert into studentdetails values(?,?,?,?,?)";

		System.out.print("How many students to enter :");
		int n = scan.nextInt();
		for (int i = 1; i <= n; i++) {
			PreparedStatement prstatement;
			
				prstatement = dbMethod.getpStatement(string);
			 
			// statement.execute("insert into studentdetails values(?,?,?,?,?)");
			System.out.print("Roll no :");
			int rollNo = scan.nextInt();
			prstatement.setInt(1, rollNo);
			System.out.print("Name :");
			String name = scan.next();
			prstatement.setString(2, name);
			System.out.print("Email ID :");
			String emailId = scan.next();
			emailId = emailId + "@gmail.com";
			prstatement.setString(3, emailId);
			System.out.print("Department :");
			String department = scan.next();
			prstatement.setString(4, department);
			System.out.print("College :");
			String college = scan.next();
			prstatement.setString(5, college);
			System.out.println("\n\n");
			 prstatement.executeUpdate();

		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROROROOROOR");
			e.printStackTrace();
		}

	}

	public void getAllDetails() throws SQLException {
		DataBaseMethod dbMethod = new DataBaseMethod();
		Statement statement = dbMethod.getStatement();
		ResultSet result = statement.executeQuery("select * from studentdetails");
		while (result.next()) {
			System.out.println("Roll No    : " + result.getInt(1));
			System.out.println("Name       : " + result.getString(2));
			System.out.println("Email Id   : " + result.getString(3));
			System.out.println("Department : " + result.getString(4));
			System.out.println("College    : " + result.getString(5));
			System.out.println("\n");
		}
		/*
		 * System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.
		 * getString(3)+" "+result.getString(4)+" "+result.getString(5));
		 */

	}
	public void getIndivitualDetails() throws SQLException {
		DataBaseMethod dbMethod = new DataBaseMethod();
		Statement statement = dbMethod.getStatement();
		ResultSet result = statement.executeQuery("select * from studentdetails");
		System.out.println("Enter your roll number");
		int rollNo=scan.nextInt();
		while (result.next()) {
			if(result.getInt(1)==rollNo) {
			System.out.println("Roll No    : " + result.getInt(1));
			System.out.println("Name       : " + result.getString(2));
			System.out.println("Email Id   : " + result.getString(3));
			System.out.println("Department : " + result.getString(4));
			System.out.println("College    : " + result.getString(5));
			System.out.println("\n");
		}}
		/*
		 * System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.
		 * getString(3)+" "+result.getString(4)+" "+result.getString(5));
		 */

	}
	public void editIndivitualDetails() throws SQLException {
		String string = "UPDATE studentdetails SET  Email_Id = ?  WHERE Roll_Number=?";

		DataBaseMethod dbMethod=new DataBaseMethod();
		PreparedStatement prstatement = dbMethod.getpStatement(string);
		System.out.print("Enter your Roll Number : ");
		prstatement.setInt(2, 02);
		System.out.println("Enter you want to change : ");
		System.out.print("\n" + "1-->Roll Number" + "\n" + "2-->Name" + "\n"
				+ "3-->E-mail ID" + "\n" + "4-->Department" + "\n" + "5-->College" + "\n" + "6-->Exit");
		char choice=scan.next().charAt(0);
		switch(choice) {
		case '1'->{System.out.print("Enter your Roll Numb ");
		prstatement.setInt(1, scan.nextInt());}
		case '2'->{System.out.print("Enter your Name ");
		prstatement.setString(1, scan.next());}
		case '3'->{System.out.print("Enter your Email Id ");
		prstatement.setString(1, scan.next());}
		case '4'->{System.out.print("Enter your Department ");
		prstatement.setString(1, scan.next());}
		case '5'->{System.out.print("Enter your College ");
		prstatement.setString(1, scan.next());}
		case '6'->System.exit(0);
		default ->{System.err.print("You enter invalid");
		editIndivitualDetails();}
		}
		prstatement.setString(1, "subashhhhh@gmail.com");
		prstatement.setInt(2, 02);
		prstatement.execute();
		System.out.println("jhcchgsdhsbivnhsdbcc");
		
	}

}
//try {
//Class.forName("com.mysql.cj.jdbc.Driver");
//Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:8080/mydatabase","root","1234");
//Statement statement=connection.createStatement();
////statement.execute("insert into studentdetails values(02,'subash','subashk1997@gmail.com','Mech','PSN')");
////connection.commit();
//ResultSet result=statement.executeQuery("select * from studentdetails");
//while(result.next()) {
//	System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4)+" "+result.getString(5));
//}
//}
//catch(Exception e) {
//System.out.println(e);
//
//}//

/*
* DbMethod dbMethod = new DbMethod(); Statement statement =
* dbMethod.getStatement(); ResultSet result =
* statement.executeQuery("select * from studentdetails"); while (result.next())
* { System.out.println("Roll No    : " + result.getInt(1));
* System.out.println("Name       : " + result.getInt(2));
* System.out.println("Email Id   : " + result.getInt(3));
* System.out.println("Department : " + result.getInt(4));
* System.out.println("College    : " + result.getInt(5));
*


  System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.
  getString(3)+" "+result.getString(4)+" "+result.getString(5));
  }*/

/*
* String string="UPDATE table_name\r\n" +
* "SET column1 = value1, column2 = value2, ...\r\n" + "WHERE condition";
*/



//PreparedStatement prstatement = dbMethod.getpStatement(string);
/* String query = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
+ " values (?, ?, ?, ?, ?)";

// create the mysql insert preparedstatement
PreparedStatement preparedStmt = conn.prepareStatement(query);
preparedStmt.setString (1, "Barney");
preparedStmt.setString (2, "Rubble");
preparedStmt.setDate   (3, startDate);
preparedStmt.setBoolean(4, false);
preparedStmt.setInt    (5, 5000);

// execute the preparedstatement
preparedStmt.execute();

conn.close();*/