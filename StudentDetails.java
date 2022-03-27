package com.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
//This done by the use of Array List 
//School student details management
class Student {
	Scanner scan = new Scanner(System.in);
	private String rollNo;
	private String name;
	private String emailId;
	private String department;
	private String college;
	
	

	public String getrollNo() {
		return this.rollNo;
	}

	public String getName() {
		return this.name;
	}

	public String getEmailID() {
		return this.emailId;
	}

	public String getDepartment() {
		return this.department;
	}

	public String getCollege() {
		return this.college;
	}

	public void setrollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmailID(String emailId) {
		this.emailId = emailId;
		
		
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setCollege(String college) {
		this.college = college;
	}

}

class StudentDetails {
	static Scanner scan = new Scanner(System.in);
	 ArrayList<Student> studentsList =new ArrayList<Student>();
	 
	public static void main(String[] args) throws Exception {
		StudentDetails objectDetails=new StudentDetails();
		objectDetails.processStart();
		} 
	
public void processStart() {
		 studentsList.addAll(register()) ;
		while (true) {
			System.out.print("Enter any One of below:" + "\n" + "1->Add student details" + "\n" + "2->Get All details"
					+ "\n" + "3->Get individual details" + "\n" + "4->Edit details" + "\n" + "5->Exit");
			char n = scan.next().charAt(0);
			switch (n) {
			case '1' -> studentsList.addAll(register()) ;
			case '2' -> getAllDetails(studentsList);
			case '3' -> getDetails(studentsList);
			case '4' -> editDetails(studentsList);
			case '5' -> System.exit(0);
			default -> System.err.println("Enter 1 or 2.");
			}
		}
	}

	public  ArrayList<Student> register() {
		
		System.out.print("How many students to enter :");
		int n = scan.nextInt();
		ArrayList<Student> register = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			Student studentObject = new Student();
			System.out.print("Roll no :");
			String rollNo = "9527151140" + scan.next();
			studentObject.setrollNo(rollNo);
			System.out.print("Name :");
			String name = scan.next();
			studentObject.setName(name);
			System.out.print("Email ID :");
			String emailId = scan.next();
			emailId = emailId + "@gmail.com";
			studentObject.setEmailID(emailId);
			System.out.print("Department :");
			String department = scan.next();
			studentObject.setDepartment(department);
			System.out.print("College :");
			String college = scan.next();
			studentObject.setCollege(college);
			System.out.println("\n\n");
		
			register.add(studentObject);
		}
		
		return register;
		
	}

	public void getAllDetails(ArrayList<Student> student) {

		System.out.println("ALL STUDENT DETAILS ");

		for (Student details : student) {
			System.out.println("Roll No    : " + details.getrollNo());
			System.out.println("Name       : " + details.getName());
			System.out.println("Email      : " + details.getEmailID());
			System.out.println("Department : " + details.getDepartment());
			System.out.println("College    : " + details.getCollege());
			System.out.println("\n");

		}

	}

	public  void getDetails(ArrayList<Student> student) {
		
		System.out.print("Enter student Roll number : ");
		String selectedRollNo = scan.next();
		selectedRollNo=selectedRollNo.substring(selectedRollNo.length()-2, selectedRollNo.length());
		for (Student details : student) {
			String rollNo = details.getrollNo();
			rollNo=rollNo.substring(rollNo.length()-2, rollNo.length());

			if ( rollNo.equalsIgnoreCase(selectedRollNo) ) {

				System.out.println("Roll No    : " + details.getrollNo());
				System.out.println("Name       : " + details.getName());
				System.out.println("Email      : " + details.getEmailID());
				System.out.println("Department : " + details.getDepartment());
				System.out.println("College    : " + details.getCollege());
				System.out.println("\n\n");

			}

		}

	}

	public  void editDetails(ArrayList<Student> student) {
		
		System.out.print("Enter student Roll number : ");
		String selectedRollNo = scan.next();
		selectedRollNo=selectedRollNo.substring(selectedRollNo.length()-2, selectedRollNo.length());
		for (Student details : student) {
			String rollNo = details.getrollNo();
			rollNo=rollNo.substring(rollNo.length()-2, rollNo.length());

			if ( rollNo.equalsIgnoreCase(selectedRollNo) ) {
				System.out.print("Pick anyone below :" + "\n" + "1-->Roll Number" + "\n" + "2-->Name" + "\n"
						+ "3-->E-mail ID" + "\n" + "4-->Department" + "\n" + "5-->College" + "\n" + "6-->Exit");
				int n = scan.nextInt();
				switch (n) {
				case 1 -> {
					System.out.println("Enter your new roll number : ");
					details.setrollNo(scan.next());}
				case 2 ->{System.out.println("Enter your new name number : ");
					details.setName(scan.next());}
				case 3 ->{System.out.println("Enter your new email Id number : ");
				details.setEmailID(scan.next());} 
				case 4 ->{System.out.println("Enter your new department number : ");
				  details.setDepartment(scan.next());}
				case 5 ->{System.out.println("Enter your new college number : ");
				details.setCollege(scan.next());} 
				case 6 -> System.exit(0);
				default -> System.err.println("Enter valid input");

				}

			}

		}
	}

}
