// -------------------------------------------------------
// Assignment 4
// Written by: Safira Sari (40249017)
// For COMP 248 Section T – Fall 2022
// --------------------------------------------------------

// HouseholdBudget Class containing the methods for householdbudgets involving methods from the fund and expense class.

public class HouseholdBudget {

	// PRIVATE ATTRIBUTES
	// Object of type Fund.
	private Fund objFund = new Fund();
	
	// Array Expenses of objects of type Expense.
	private Expense arrayExpense[];

	
	// CONSTRUCTORS
	// Default Constructor
	public HouseholdBudget() {
		this.objFund = null;
		this.arrayExpense = null;
	}
	
	// Custom Constructor
	public HouseholdBudget(Fund fund, Expense arrayExpense[]) {
		this.objFund = fund;
		this.arrayExpense = arrayExpense;
	}
	
	// METHODS
	// Method which will return a boolean if the total value of the fund of two HouseholdBudget objects are equal.
	public boolean fundTotalEquals(HouseholdBudget paramHouseholdBudget) {
		 return this.objFund.fundTotal() == (paramHouseholdBudget.objFund.fundTotal());
		// return this.objFund.fundTotal().equals(paramHouseholdBudget.objFund.fundTotal());
	}
	
	// Method which will return a boolean if the number of each fund type of two HouseholdBudget objects are equal.
	public boolean fundBreakdownEquals(HouseholdBudget paramHouseholdBudget) {
		return this.objFund.toString().equals(paramHouseholdBudget.objFund.toString());
	}
	
	// Method which will return the total value of fund of a HouseholdBudget.
	public double fundTotalValue() {
		return this.objFund.fundTotal();
	}
	
	// Method which will return the number of expenses of the HouseholdBudget. 
	public int numExpenses() {
		return arrayExpense.length;
	}
	
	// Method which will add a new expense to the householdbudget. Returns the number of expenses of a householdBudget after the addition. 
	public int addExpense(String expenseType, String nameBusiness, double expenseAmount, int dueDay, int dueMonth) {
		// New expense to be added to the householdbudget.
		Expense addedExpense = new Expense(expenseType, nameBusiness, expenseAmount, dueDay, dueMonth);
		Expense newArray[] = {addedExpense};	
		
		// Storing contents of the original array into a temporary array
		Expense tempArray[] = new Expense[arrayExpense.length];
		for (int i = 0; i < arrayExpense.length; i++) {
			tempArray[i] = arrayExpense[i];
		}

		// Re-initializing the original array by increasing its size.
		arrayExpense = new Expense[this.arrayExpense.length + 1];
		
		// Moving the contents of the temporary array into the original array.
		for (int i = 1; i < arrayExpense.length; i++) {
			arrayExpense[i] = tempArray[i];
		}
		
		// Adding the new content into the original array
		for (int i = tempArray.length; i < arrayExpense.length; i++)	{
			arrayExpense[i] = newArray[i - tempArray.length];
		}
		
		return numExpenses();
	}

	
	// Method which will remove an expense from the householdBudget. Returns boolean of the success of the removal of the expense. 
	public boolean removeExpense(int n) {
		// Parameter int n is the index of the expense to be removed.
	
		// Returns false if the householdBudget has 0 expenses to begin with.
		if (arrayExpense.length == 0) {
			return false;
		} else {
			// Create a temporary array with the content of arrayExpense.
			Expense tempArray[] = new Expense[arrayExpense.length];
			for (int i = 0; i < arrayExpense.length; i++) {
				tempArray[i] = arrayExpense[i];
			}
			
			// Re-initializing the original array to decrease its size by 1.
			arrayExpense = new Expense[this.arrayExpense.length - 1];
			
			// Moving the contents of the temporary array into the original arrayExpense, excluding the index at n.
			for (int i = 0; i < n; i++){
				arrayExpense[i] = tempArray[i];
			}
			for (int i = n + 1; i < tempArray.length; i++){
				arrayExpense[i - 1] = tempArray[i];
			}
			
			// Returns true if the removal of the expense is successful.
			//if (tempArray.length == (arrayExpense.length + 1)) {
			return true;
		}	
	}
	
	
	// Method which will update the due date day and due month of an expense.
	public void setDueDate(int index, int dueDay, int dueMonth) {	
		this.arrayExpense[index].setDueDay(dueDay);
		this.arrayExpense[index].setDueMonth(dueMonth);	
	}
	
	
	// Method which will add fund to the householdBudget. Returns the new total value of the fund of the householdBudget. 
	public double addFund(int n1, int n2, int n5, int n10, int n20) {
		this.objFund.addFund(n1, n2, n5, n10, n20);
		return fundTotalValue();
	}
	
	// equals() Method which will return a boolean if the total value of fund & the number of expenses of two hhb objects are equal.
	public boolean equals(HouseholdBudget paramHousholdBudget) {
		return ((this.fundTotalValue() == paramHousholdBudget.fundTotalValue()) && (this.numExpenses() == paramHousholdBudget.numExpenses()));
	}
	
	// toString() Method which will return a string indicating the number of each money type & the details of each expense of the hhb. 
	public String toString() {		
		String moneyExpenses = "";

		for (int i = 0; i < arrayExpense.length; i++) {
			moneyExpenses = moneyExpenses + "\n" + arrayExpense[i].toString();
		}
		
		if (arrayExpense.length == 0) {
			moneyExpenses = "\nNo Expenses";
		}
		
		String moneyDetails = fundBreakdown() + moneyExpenses;
		return moneyDetails;
	}
	
	
	// Method which will return a string with just the breakdown of the fund.
	public String fundBreakdown() {
		return objFund.toString();
	}
	
}
