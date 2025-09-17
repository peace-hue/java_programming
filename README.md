# java_programming
Q1.
package supermarket;

import java.util.Scanner;

public class supermarketbills {


	public static void main(String[] args) {
		Scanner Sc=new Scanner(System.in);

		System.out.println("Enter number of different items: ");
		int n =Sc.nextInt();
		String[] itemNames = new String[n];
		double[] prices = new double[n];
		int[] quantities = new int[n];
		double[] subtotals = new double[n];

		double totalBill = 0;
		for (int i = 0; i < n; i++) {
			Sc.nextLine();
			System.out.println("\nEnter name of item " + (i + 1) + ": ");
			itemNames[i] = Sc.nextLine();

			System.out.println("Enter price per unit of " + itemNames[i] + ": ");
			prices[i] =Sc.nextDouble();

			System.out.println("Enter quantity of " + itemNames[i] + ": ");
			quantities[i] =Sc.nextInt();
			subtotals[i] = prices[i] * quantities[i];
			totalBill += subtotals[i];
		}
		double amount = 0;
		if (totalBill > 50000) {
			amount = totalBill * 0.05; 
		}
		double finalAmount = totalBill - amount;
		System.out.println("\n................SUPERMARKET RECEIPT...................");
		System.out.println("%-15s %-10s %-10s %-10s\n");
		for (int i = 0; i < n; i++) {
			System.out.println();
		}
		System.out.println("----------------------------------");
		System.out.println(totalBill);
		System.out.println(amount);
		System.out.println(finalAmount);
		System.out.println("Thank you for using calculator!");
		Sc.close();

	}


	    }

}}

}


Q2.package supermarket;

import java.util.Scanner;

public class studentrecordingmarks {
	public static void main(String[] args) {

		Scanner abc=new Scanner(System.in);

		int totalStudents = 0;
		int passes = 0;
		int fails = 0;

		while (true) {

			System.out.print("Enter student marks (0-100), or enter -1 to stop: ");
			int marks =abc.nextInt();


			if (marks == -1) {
				break;
			}


			if (marks < 0 || marks > 100) {
				System.out.println("Invalid marks. Please enter a value between 0 and 100.");
				continue;
			}
			totalStudents++;

			char grade;
			if (marks >= 80) {
				grade = 'A';
			} else if (marks >= 70) {
				grade = 'B';
			} else if (marks >= 60) {
				grade = 'C';
			} else if (marks >= 50) {
				grade = 'D';
			} else {
				grade = 'F';
			}

			System.out.println("Student's grade: " + grade);


			if (marks >= 50) {
				passes++;
			} else {
				fails++;
			}
		}


		System.out.println("\nSummary Report:");
		System.out.println("Total students: " + totalStudents);
		System.out.println("Passed: " + passes);
		System.out.println("Failed: " + fails);


		if (totalStudents > 0) {
			double passRate = (double) passes / totalStudents * 100;
			System.out.println("Class pass rate: " + passRate + "%");
		} else {
			System.out.println("No students entered.");
		}

		abc.close();
	}



}


package supermarket;

import java.util.Scanner;

public class studentrecordingmarks {
	public static void main(String[] args) {

		Scanner abc=new Scanner(System.in);

		int totalStudents = 0;
		int passes = 0;
		int fails = 0;

		while (true) {

			System.out.print("Enter student marks (0-100), or enter -1 to stop: ");
			int marks =abc.nextInt();


			if (marks == -1) {
				break;
			}


			if (marks < 0 || marks > 100) {
				System.out.println("Invalid marks. Please enter a value between 0 and 100.");
				continue;
			}
			totalStudents++;

			char grade;
			if (marks >= 80) {
				grade = 'A';
			} else if (marks >= 70) {
				grade = 'B';
			} else if (marks >= 60) {
				grade = 'C';
			} else if (marks >= 50) {
				grade = 'D';
			} else {
				grade = 'F';
			}

			System.out.println("Student's grade: " + grade);


			if (marks >= 50) {
				passes++;
			} else {
				fails++;
			}
		}


		System.out.println("\nSummary Report:");
		System.out.println("Total students: " + totalStudents);
		System.out.println("Passed: " + passes);
		System.out.println("Failed: " + fails);


		if (totalStudents > 0) {
			double passRate = (double) passes / totalStudents * 100;
			System.out.println("Class pass rate: " + passRate + "%");
		} else {
			System.out.println("No students entered.");
		}

		abc.close();
	}



}


