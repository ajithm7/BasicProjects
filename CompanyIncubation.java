package com.project;

import java.util.LinkedList;
import java.util.Scanner;
//This done by the use of linked List
// Consider the MLM company. Incubation student detail management
class Members {// pojo class

	private String idNumber;
	private String name;
	private String emailId;
	private String gender;
	private String city;

	public Members(String idNumber, String name, String emailId, String gender, String city) {
		this.idNumber = idNumber;
		this.name = name;
		this.emailId = emailId;
		this.gender = gender;
		this.city = city;
	}

	public String getID() {
		return this.idNumber;
	}

	public String getName() {
		return this.name;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public String getGender() {
		return this.gender;
	}

	public String getCity() {
		return this.city;
	}

	public void setId(String idNo) {
		this.idNumber = idNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmailID(String emailId) {
		this.emailId = emailId;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCity(String city) {
		this.city = city;
	}

}

public class CompanyIncubation {
	static Scanner scan = new Scanner(System.in);
	LinkedList<Members> studentDetails;

	public static void main(String[] args) {

		CompanyIncubation zsgsInc = new CompanyIncubation();
		zsgsInc.init();

	}

	private void init() {
		while (true) {
			System.out.println("Enter any One of below:" + "\n" + "1->Add student details" + "\n" + "2->Get All details"
					+ "\n" + "3->Get individual details" + "\n" + "4->Edit details" + "\n" + "5->Exit");
			int n = scan.nextInt();
			switch (n) {
			case 1 -> register();
			case 2 -> getAllDetails();
			case 3 -> getDetails();
			case 4 -> editDetails();
			case 5 -> System.exit(0);
			default -> System.err.println("Enter valid input.");
			}

		}

	}

	public void register() {
		System.out.println("How many students to enter : ");
		int n = scan.nextInt();
		LinkedList<Members> register = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			System.out.print("Student ID :");
			String studentId = "MLM0" + scan.next();
			System.out.print("Name :");
			String name = scan.next();
			System.out.print("Email ID :");
			String emailId = scan.next();
			System.out.print("Gender :");
			String gender = scan.next();
			System.out.print("City :");
			String city = scan.next();
			System.out.println("\n");
			Members ob = new Members(studentId, name, emailId, gender, city);
			register.add(ob);
		}

		studentDetails = register;
	}

	public void getAllDetails() {

		System.out.println("ALL STUDENT DETAILS ");

		for (Members student : studentDetails) {
			System.out.println("Student ID : " + student.getID());
			System.out.println("Name       : " + student.getName());
			System.out.println("Email      : " + student.getEmailId());
			System.out.println("Department : " + student.getGender());
			System.out.println("College    : " + student.getCity());
			System.out.println("\n");

		}

	}

	public void getDetails() {
		System.out.print("Enter student ID : ");
		String id = scan.next();
		id = id.substring(id.length() - 2, id.length());
		System.out.println("\n");
		for (Members student : studentDetails) {
			String selectedID = student.getID();

			selectedID = selectedID.substring(selectedID.length() - 2, selectedID.length());
			if (selectedID.equalsIgnoreCase(id)) {

				System.out.println("Student ID : " + student.getID());
				System.out.println("Name       : " + student.getName());
				System.out.println("Email      : " + student.getEmailId());
				System.out.println("Department : " + student.getGender());
				System.out.println("College    : " + student.getCity());
				System.out.println("\n\n");

			}

		}

	}

	public void editDetails() {
		System.out.println("Enter your ID number only");
		String changeId = scan.next();
		changeId = changeId.substring(changeId.length() - 2, changeId.length());

		for (Members details : studentDetails) {
			String selectedId = details.getID();
			selectedId = selectedId.substring(selectedId.length() - 2, selectedId.length());

			if (selectedId.equalsIgnoreCase(changeId)) {

				System.out.println("Pick anyone below :" + "\n" + "1->ID Number" + "\n" + "2->Name" + "\n"
						+ "3->E-mail ID" + "\n" + "4->Gender" + "\n" + "5->City" + "\n" + "6->Exit");
				scan.nextLine();
				char n = scan.next().charAt(0);
				System.out.println("\n");

				switch (n) {
				case '1' -> {
					System.out.println("Enter student Id :");
					String set = "MLM0" + scan.next();
					details.setId(set);
				}
				case '2' -> {
					System.out.println("Enter Name :");
					String set = scan.next();
					details.setName(set);
				}
				case '3' -> {
					System.out.println("Enter Email ID :");
					String set = scan.next();
					details.setEmailID(set);
				}
				case '4' -> {
					System.out.println("Enter Gender :");
					String set = scan.next();
					details.setGender(set);
				}
				case '5' -> {
					System.out.println("Enter City :");
					String set = scan.next();
					details.setCity(set);
				}
				case '6' -> System.exit(0);
				default -> System.err.println("Enter valid input");

				}

				// If you forget the ID use this on your method
				/*
				 * System.out.print("Enter any one of student details"); String
				 * detail=sc.nextLine(); for(Members x:student){ String rollNo = x.getID();
				 * String name = x.getName(); String eID = x.getEmailID(); String department =
				 * x.getGender(); String college = x.getCity();
				 * 
				 * if (name.equalsIgnoreCase(detail) || studentId.equalsIgnoreCase(detail) ||
				 * eID.equalsIgnoreCase(detail) || department.equalsIgnoreCase(detail) ||
				 * college.equalsIgnoreCase(detail)) {"Enter from the previous"}}
				 */

			}

		}
	}

}
