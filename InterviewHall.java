package com.project;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//This done by the use of Queue 
// This program for interview process
public class InterviewHall {
	Scanner scan = new Scanner(System.in);
	Queue<String> interviewHall = new LinkedList<String>();
	Queue<String> reception = new LinkedList<String>();
	static int numberOfCandidates=0;
	static String interviewCandidate;

	public void setInterviewCandidate(String candidate) {
		interviewCandidate = candidate;
	}

	public static void main(String[] args) {
		InterviewHall hall = new InterviewHall();
		hall.initiate();

	}

	private void initiate() {
		/*
		 * System.out.println("Enter the candidate name in interview room : "); String
		 * interviewPerson = (scan.nextLine()).toUpperCase();
		 * if(interviewPerson!="null") {numberOfCandidates++;}
		 * setInterviewCandidate(interviewPerson);
		 */
		System.out.println("Enter how many candidates stay in interview hall : ");
		int n = scan.nextInt();
		System.out.println("Enter " + (n) + " number of candidates name : ");
		while (n-- > 0) {
			String candidate = (scan.nextLine()).toUpperCase();
			if (candidate.length() == 0) {
				n = n + 1;
				continue;
			}
			interviewHall.add(candidate);
		}
		System.out.println();
		reception();
		process();

	}

	private void reception() {
		System.out.println("Number of candidates comes newly in reception : ");
		int n = scan.nextInt();
		System.out.println("Name of candidates : ");
		while (n-- > 0) {
			String name = (scan.nextLine()).toUpperCase();
			if (name.length() == 0) {
				n = n + 1;
				continue;
			}
			reception.add(name);

		}
		System.out.println();

	}

	private void process() {
		while (true) {
			System.out.println(
					"Enter any One of below:" + "\n" + "1-->Next candidate" + "\n" + "2-->Enter newly coming candidate"
							+ "\n" + "3-->Get interview details" + "\n" + "4-->To end interview");
			char menu = scan.next().charAt(0);
			 System.out.println();
			 if(menu=='1') {numberOfCandidates++;}
			switch (menu) {
			case '1' -> nextCandidate();
			case '2' -> reception();
			case '3' -> getCurrentDetails();
			case '4' -> System.exit(0);
			default -> System.err.println("Invalid input");
			}

		}

	}

	public void nextCandidate() {
		
		System.out.println("If you want to enter newly come candidates in the reception press 1 ");
		char newCandidate = scan.next().charAt(0);
		System.out.println();
		if (newCandidate == '1') {
			reception();
		}

		if (reception.isEmpty() == false) {
			interviewHall.add(reception.poll());
		}

		if (interviewHall.isEmpty()) {
			System.out.println("No more candidate. so, the interview is over .");
			System.exit(0);
		} else {
			setInterviewCandidate(interviewHall.poll());
		}

	}

	public void getCurrentDetails() {
		//System.out.println();
		System.out.println("Enter any One of below:" + "\n" + "1-->Position of each section" + "\n"
				+ "2-->Overall details" +  "\n"+ "3-->Number of candidates completed interview" +"\n" + "4-->Main process");
		char details = scan.next().charAt(0);
		System.out.println();
		switch (details) {
		case '1' -> position();
		case '2' -> overallDetails();
		case '3' ->{System.out.print("NUmber of candidates completed interview : ");
			System.out.println(numberOfCandidates);}
		case '4' -> process();
		case '5' -> System.exit(0);
		default -> System.err.println("Enter valid input");
		}
		System.out.println();
	}

	public void position() {
		//System.out.println();
		System.out.println("Candidate name, who attenting a interview is : " + interviewCandidate);
		if (interviewHall.peek() == null) {
			System.out.println("No more person");
		} else {
			System.out.println("Candidate name, who next to attent a interview is : " + interviewHall.peek());
		}
		if (reception.peek() == null) {
			System.out.println("No more person");
		} else {
			System.out.println("Candidate name, who next to enter in interview hall is : " + reception.peek());
		}

	}

	public void overallDetails() {
		//System.out.println();
		System.out.println("Candidate, who attenting a interview is : " + interviewCandidate);
		System.out.println("Candidates, who are waiting in interview hall : ");
		if (interviewHall.size() != 0) {
			System.out.println(interviewHall);
		} else {
			System.out.println("No more person");
		}

		System.out.println("Candidates, who waiting in reception hall  : ");
		if (reception.size() != 0) {
			System.out.println(reception);
		} else {
			System.out.println("No more person");
		}

		System.out.println();
	}
}
