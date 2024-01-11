// -------------------------------------------------------
// Assignment 4
// Written by: Safira Sari (40249017)
// For COMP 248 Section T – Fall 2022
// --------------------------------------------------------

import java.util.Scanner;

public class BudgetDemo {
	
	public static void main(String[] args) {
		
		// Introducing Scanner Class.
		Scanner input = new Scanner(System.in);
		
		// HARDCODING 5 HOUSEHOLDBUDGETS OBJECTS
		// HouseholdBudget #0:
		Fund fund0 = new Fund(0, 1, 0, 2, 1);
		Expense exp01 = new Expense("Purchase", "IGA", 85.5, 25, 11);
		Expense exp02 = new Expense("Bill", "Videotron", 122.75, 2, 12);
		Expense [] arrayExpense0 = {exp01, exp02};
		HouseholdBudget hhb0 = new HouseholdBudget(fund0, arrayExpense0);
		
		// HouseholdBudget #1:
		Fund fund1 = new Fund(0, 1, 0, 2, 1);
		Expense exp11 = new Expense("Purchase", "IGA", 85.5, 25, 11);
		Expense exp12 = new Expense("Bill", "Costco", 16.2, 23, 11);
		Expense [] arrayExpense1 = {exp11, exp12};
		HouseholdBudget hhb1 = new HouseholdBudget(fund1, arrayExpense1);
		
		// HouseholdBudget #2:
		Fund fund2 = new Fund(2, 0, 2, 1, 1);
		Expense exp21 = new Expense("Purchase", "Pharmaprix", 50.75, 1, 12);
		Expense exp22 = new Expense("Purchase", "IGA", 85.5, 16, 12);
		Expense exp23 = new Expense("Bill", "Fido", 65.85, 5, 1);	
		Expense [] arrayExpense2 = {exp21, exp22, exp23};
		HouseholdBudget hhb2 = new HouseholdBudget(fund2, arrayExpense2);
		
		// HouseholdBudget #3:
		Fund fund3 = new Fund(2, 1, 2, 1, 5);
		Expense [] arrayExpense3 = {};
		HouseholdBudget hhb3 = new HouseholdBudget(fund3, arrayExpense3);
				
		// HouseholdBudget #4:
		Fund fund4 = new Fund(2, 1, 2, 1, 5);	
		Expense [] arrayExpense4 = {};
		HouseholdBudget hhb4 = new HouseholdBudget(fund4, arrayExpense4);
		
		// Array of HouseholdBudgets
		HouseholdBudget [] hhb = {hhb0, hhb1, hhb2, hhb3, hhb4};
		
		// Initializing variables: -Choice is the user's input.
		String codeChoice = "";
		int houseChoice = -1;
		String expTypeChoice = "";
		double amountChoice = 0.0;
		String businessChoice = "";
		int dayChoice, monthChoice = -1;
		int expenseChoice = 0;
		int looniesChoice, tooniesChoice, bill5Choice, bill10Choice, bill20Choice = 0;
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n"
						+ "Welcome to COMP248 Geek's HouseholdBudget_2022 Application\n\n"
						+ "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		do { 
			System.out.println("\nWhat would you like to do?\n"
							+ "1. See the possessions of all householdBudgets\n"
							+ "2. See the possessions of one householdBudget\n"
							+ "3. List householdBudgets with same total amount of fund\n"
							+ "4. List householdBudgets with same fund denomination(s)\n"
							+ "5. List householdBudgets with same total amount of fund and same number of expenses\n"
							+ "6. Add an expense to an existing householdBudget\n"
							+ "7. Remove an existing expense from householdBudget\n"
							+ "8. Update the payment due date of an existing expense\n"
							+ "9. Add fund to a householdBudget\n"
							+ "0. To quit\n");
			System.out.print("Please enter your choice and press <Enter>: ");	
			codeChoice = input.next();
			
			switch (codeChoice) {
				case "1":	// See the possessions of all householdBudgets
					System.out.println("Content of each HouseholdBudget:\n"
									+ "------------------------");
					for (int i = 0; i < 5; i++) {
						System.out.print("HouseholdBudget #" + i + ":\n" + hhb[i].toString() + "\n\n");
					}
					break;
					
				case "2":	// See the possessions of one householdBudget
					System.out.print("Which HouseholdBudget do you want to see the possessions of? (Enter number 0 to 4): ");
					houseChoice = input.nextInt();
					if (houseChoice < 0 || houseChoice > 4) {
						do {	
						
							System.out.print("Sorry but there is no HouseholdBudget number " + houseChoice
											+ "\n--> Try again: (Enter number 0 to 4): ");						
							houseChoice = input.nextInt();	
						} while (houseChoice < 0 || houseChoice > 4);
					}
					
					System.out.println(hhb[houseChoice].toString());
					break;
					
				case "3":	// List householdBudgets with same total amount of fund
					System.out.println("List of HouseholdBudgets with same total fund: \n");
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							if ((i > j) && (hhb[i].fundTotalEquals(hhb[j]))){
								System.out.println("\tHouseholdBudgets " + j + " and " + i + " both have " + hhb[i].fundTotalValue());
							}		
						}
					}	
					break;
					
				case "4":	// List householdBudgets with same fund denomination(s)
					System.out.println("List of HouseholdBudgets with same Fund: \n");	
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							if ((i > j) && (hhb[i].fundBreakdownEquals(hhb[j]))){
								System.out.println("\tHouseholdBudgets " + j + " and " + i + " both have " + hhb[i].fundBreakdown());
							}		
						}
					}	
					break;
					
				case "5":	// List householdBudgets with same total amount of fund and same number of expenses		
					System.out.println("List of HouseholdBudgets with same amount of money and same number of expenses : \n");
					for (int i = 0; i < 5; i++) {
						for (int j = 0; j < 5; j++) {
							if ((i > j) && (hhb[i].equals(hhb[j]))){
								System.out.println("\tHouseholdBudgets " + j + " and " + i);
							}		
						}
					}	
					break;
					
				case "6":	// Add an expense to an existing householdBudget
					System.out.print("Which HouseholdBudget do you want to add an Expense to? (Enter number 0 to 4): ");
					houseChoice = input.nextInt();
					if (houseChoice < 0 || houseChoice > 4) {
						do {	
						
							System.out.print("Sorry but there is no HouseholdBudget number " + houseChoice
											+ "\n--> Try again: (Enter number 0 to 4): ");						
							houseChoice = input.nextInt();	
						} while (houseChoice < 0 || houseChoice > 4);
					}
					
					System.out.println("Please enter the following information so that we may complete the expense-");
					System.out.print(" --> Type of expense (Bill, Purchase, etc ..): ");
					expTypeChoice = input.next();
					System.out.print(" --> Amount of the expense: ");
					amountChoice = input.nextDouble();
					System.out.print(" --> Name of the business: ");
					businessChoice = input.next();
					System.out.print(" --> Payment due day number and month (seperated by a space): ");
					dayChoice = input.nextInt();
					monthChoice = input.nextInt();
					
					hhb[houseChoice].addExpense(expTypeChoice, businessChoice, amountChoice, dayChoice, monthChoice);
					
					System.out.println("You now have " + hhb[houseChoice].numExpenses() + " expense");
					break;
					
				case "7":	// Remove an existing expense from householdBudget
					System.out.print("Which HousholdBudget do you want to remove an expense from? (Enter number 0 to 4): ");
					houseChoice = input.nextInt();
					if (houseChoice < 0 || houseChoice > 4) {
						do {	
						
							System.out.print("Sorry but there is no HouseholdBudget number " + houseChoice
											+ "\n--> Try again: (Enter number 0 to 4): ");						
							houseChoice = input.nextInt();	
						} while (houseChoice < 0 || houseChoice > 4);
					}
					
					boolean result = hhb[houseChoice].removeExpense(expenseChoice);
					
					if (result == false) {
						System.out.println("Sorry that HouseholdBudget has no expenses");
						break;
					}
					
					System.out.println("(Enter number 0 to " + (hhb[houseChoice].numExpenses()) + "): ");
					expenseChoice = input.nextInt();
					
					if (result == true) {
						System.out.println("Expense was removed succesfully.");
					}
					break;
					
					
				case "8":	// Update the payment due date of an existing expense
					System.out.print("Which HouseholdBudget do you want to update an expense from? (Enter number 0 to 4): ");
					houseChoice = input.nextInt();
					if (houseChoice < 0 || houseChoice > 4) {
						do {	
						
							System.out.print("Sorry but there is no HouseholdBudget number " + houseChoice
											+ "\n--> Try again: (Enter number 0 to 4): ");						
							houseChoice = input.nextInt();	
						} while (houseChoice < 0 || houseChoice > 4);
					}
					
					System.out.println("Which expense do you want to update? (Enter number 0 to " + (hhb[houseChoice].numExpenses()-1) + "): ");
					expenseChoice = input.nextInt();
					if (expenseChoice < 0 || houseChoice > 4) {
						do {	
						
							System.out.println("Sorry but there is no expense number " + expenseChoice
									+ "\n--> Try again:"
									+ "\n(Enter number 0 to " + hhb[houseChoice].numExpenses() + "): ");					
							expenseChoice = input.nextInt();	
						} while (expenseChoice < 0 || expenseChoice > hhb[houseChoice].numExpenses());
					}
					
					System.out.println(" --> Enter new payment due day number and month (seperated by a space): ");
					dayChoice = input.nextInt();
					monthChoice = input.nextInt();
					
					hhb[houseChoice].setDueDate(expenseChoice, dayChoice, monthChoice);
					
					System.out.println("Due Date updated.");
					break;
					
				case "9":	// Add fund to a householdBudget
					System.out.print("Which HouseholdBudget do you want to add Fund to? (Enter number 0 to 4): ");
					houseChoice = input.nextInt();
					if (houseChoice < 0 || houseChoice > 4) {
						do {	
						
							System.out.print("Sorry but there is no HouseholdBudget number " + houseChoice
											+ "\n--> Try again: (Enter number 0 to 4): ");						
							houseChoice = input.nextInt();	
						} while (houseChoice < 0 || houseChoice > 4);
					}
					
					System.out.print("How many loonies, toonies, $5, $10 and $20 bills do you want to add?"
									+ "\nEnter 5 numbers seperated by a space: ");
					
					looniesChoice = input.nextInt();
					tooniesChoice = input.nextInt();
					bill5Choice = input.nextInt();
					bill10Choice = input.nextInt();
					bill20Choice = input.nextInt();
					
					System.out.println("You now have $"
								+ hhb[houseChoice].addFund(looniesChoice, tooniesChoice, bill5Choice, bill10Choice, bill20Choice));
					break;
					
				case "0":	// To quit
					System.out.print("Thank you for using COMP248 Geek's HouseholdBudget application!");
					input.close();
					System.exit(0);
					break;
				
				default: 	// User validation for the command number - Error message shown if input is not between 0 and 9.
					System.out.print("Sorry that is not a valid choice. Try again.\n");
					break;	
			}	
			
		} while (true);
		
	}

}
