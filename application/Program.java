package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of tax payers: ");
		int numberOfPayers = sc.nextInt();

		List<TaxPayer> payers = new ArrayList<>();

		for (int i = 1; i <= numberOfPayers; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			
			System.out.print("Individual or company (i/c): ");
			char type = sc.next().charAt(0);
			
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			
			System.out.print("Annual income: ");
			Double annualIncome = sc.nextDouble();
			
			if (type == 'i') {
				System.out.print("Annual expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				
				Individual individual = new Individual(name, annualIncome, healthExpenditures);
				payers.add(individual);
			} else if (type == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				
				Company company = new Company(name, annualIncome, numberOfEmployees);
				payers.add(company);
			} else {
				System.out.printf("Tax type '%s' does not exit, leaving the program!", type);
				break;
			}
		}
		
		System.out.println("TAXES PAID: ");
		Double totalTax = 0.0;
		for (TaxPayer payer : payers) {
			
			System.out.printf("%s: $ %.2f%n", payer.getName(), payer.calculateTax());
			totalTax += payer.calculateTax();
			
		}
		
		System.out.printf("TOTAL TAXES: $ %.2f%n", totalTax);

	}
}
