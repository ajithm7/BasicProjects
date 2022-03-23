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
	

	public Student(String rollNo, String name, String emailId, String department, String college) {
		this.rollNo = rollNo;
		this.name = name;
		this.emailId = emailId;
		this.department = department;
		this.college = college;
	}

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

	public void setrollNo() {
		System.out.println("Enter new ID");
		String  rollNo = scan.nextLine();
		this.rollNo = rollNo;
		
		
		
		
	}

	public void setName() {
		System.out.println("Enter new Name");
		String name = scan.nextLine();
		this.name = name;
	}

	public void setEmailID() {
		System.out.println("Enter new Email-ID");
		String emailId = scan.nextLine();
		this.emailId = emailId;
	}

	public void setDepartment() {
		System.out.println("Enter new Department");
		String department = scan.nextLine();
		this.department = department;
	}

	public void setCollege() {
		System.out.println("Enter new College");
		String college = scan.nextLine();
		this.college = college;
	}

}

class StudentDetails {
	static Scanner scan = new Scanner(System.in);
	 ArrayList<Student> StudentDet =new ArrayList<Student>();
	public static void main(String[] args) throws Exception {
		StudentDetails objectDetails=new StudentDetails();
		} 
	
public void processStart() {
		 StudentDet = register();
		while (true) {
			System.out.print("Enter any One of below:" + "\n" + "1->Add student details" + "\n" + "2->Get All details"
					+ "\n" + "3->Get individual details" + "\n" + "4->Edit details" + "\n" + "5->Exit");
			int n = scan.nextInt();
			switch (n) {
			case 1 -> StudentDet = register();
			case 2 -> getAllDetails(StudentDet);
			case 3 -> getDetails(StudentDet);
			case 4 -> editDetails(StudentDet);
			case 5 -> System.exit(0);
			default -> System.err.println("Enter 1 or 2.");
			}
		}
	}

	public  ArrayList<Student> register() {
		Scanner sc = new Scanner(System.in);
		System.out.print("How many students to enter :");
		int n = sc.nextInt();
		ArrayList<Student> register = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			System.out.print("Roll no :");
			String rollNo = "9527151140" + sc.next();
			System.out.print("Name :");
			String name = sc.nextLine();
			System.out.print("Email ID :");
			String emailId = sc.next();
			emailId = emailId + "@gmail.com";
			System.out.print("Department :");
			String department = sc.next();
			System.out.print("College :");
			String college = sc.next();
			System.out.println("\n\n");
			Student studentObject = new Student(rollNo, name, emailId, department, college);
			register.add(studentObject);
		}
		sc.close();
		return register;
		
	}

	public void getAllDetails(ArrayList<Student> student) {

		System.out.print("ALL STUDENT DETAILS ");

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
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter student Roll number : ");
		String detail = scanner.nextLine();
		for (Student details : student) {
			String rollNo = details.getrollNo();

			if ( rollNo.equalsIgnoreCase(detail) ) {

				System.out.println("Roll No    : " + details.getrollNo());
				System.out.println("Name       : " + details.getName());
				System.out.println("Email      : " + details.getEmailID());
				System.out.println("Department : " + details.getDepartment());
				System.out.println("College    : " + details.getCollege());
				System.out.println("\n\n");

			}

		}scanner.close();

	}

	public  void editDetails(ArrayList<Student> student) {
		Scanner scann = new Scanner(System.in);

		System.out.println("Enter your roll number : ");
		String changeid = scann.nextLine();
		
		for (Student detail : student) {
			String rollNo = detail.getrollNo();
 
			if (rollNo.equalsIgnoreCase(changeid)) {
				System.out.print("Pick anyone below :" + "\n" + "1-->Roll Number" + "\n" + "2-->Name" + "\n"
						+ "3-->E-mail ID" + "\n" + "4-->Department" + "\n" + "5-->College" + "\n" + "6-->Exit");
				int n = scann.nextInt();
				switch (n) {
				case 1 -> {
					System.out.println("Enter your new roll number : ");
					detail.setrollNo();}
				case 2 ->{System.out.println("Enter your new name number : ");
					detail.setName();}
				case 3 ->{System.out.println("Enter your new email Id number : ");
				detail.setEmailID();} 
				case 4 ->{System.out.println("Enter your new department number : ");
				  detail.setDepartment();}
				case 5 ->{System.out.println("Enter your new college number : ");
				detail.setCollege();} 
				case 6 -> System.exit(0);
				default -> System.err.println("Enter valid input");

				}

			}

		}scann .close();
	}

}