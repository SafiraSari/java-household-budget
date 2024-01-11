// -------------------------------------------------------
// Assignment 4
// Written by: Safira Sari (40249017)
// For COMP 248 Section T – Fall 2022
// --------------------------------------------------------

// Expense Class containing the methods for expenses.

public class Expense {

	// PRIVATE ATTRIBUTES
	private String expenseType;
	private double expenseAmount;
	private String nameBusiness;
	private int dueMonth;
	private int dueDay;
	
	// CONSTRUCTORS
	// Default Constructor
	public Expense() 
	{
		this.expenseType = "";
		this.expenseAmount = 0;
		this.nameBusiness = "";
		this.dueMonth = 0;
		this.dueDay = 0;
		
	}
	
	// Custom Constructor with 5 parameters
	public Expense(String expenseType, String nameBusiness, double expenseAmount, int dueDay, int dueMonth) 
	{
		this.expenseType = expenseType;
		this.expenseAmount = expenseAmount;
		this.nameBusiness = nameBusiness;
		if (dueMonth < 1 || dueMonth > 12) {
			this.dueMonth = 0;
		}
		this.dueMonth = dueMonth;
		if (dueDay < 1 || dueDay > 12) {
			this.dueDay = 0;
		}
		this.dueDay = dueDay;
	}
	
	// Copy Constructor: expense is a reference to the object that is sent to the copy constructor.
	public Expense(Expense expense) 
	{
		this.expenseType = expense.expenseType;
		this.expenseAmount = expense.expenseAmount;
		this.nameBusiness = expense.nameBusiness;
		this.dueMonth = expense.dueMonth;
		this.dueDay = expense.dueDay;
	}
	
	// ACCESSOR METHODS - Get attributes outside of the Expense class.
	public String getExpenseType() {
		return this.expenseType;
	}
	
	public double getExpenseAmount() {
		return this.expenseAmount;
	}
	
	public String getNameBusiness() {
		return this.nameBusiness;
	}
	
	public int getDueMonth() {
		return this.dueMonth;
	}
	
	public int getDueDay() {
		return this.dueDay;
	}
	
	// MUTATOR METHODS - Set attributes for the due month and the due day respectively outside of the Expense class.
	public void setDueMonth(int n) {
		if (n < 1 || n > 12) {
			n = 0;
		}
		this.dueMonth = n;
	}
	
	public void setDueDay(int n) {
		if (n < 1 || n > 31) {
			n = 0;
		}
		this.dueDay = n;
		
	}
	
	// METHODS
	// Method returning the breakdown of the household's expenses.
	public String toString() {
		String a =  "";
		String b = "";
		if (dueDay < 10) {
			a = "0";
		}
		if (dueMonth < 10) {
			b = "0";
		}
		String expenseCount = expenseType + " - $" + expenseAmount + " - " + nameBusiness + " - " + a + dueDay + "/" + b + dueMonth + ".";
		return expenseCount;
	}
	// Format: Exp.Type - $xx.x - Business - dd/mm.
	
	// Method returning a boolean of whether two objects (containing the breakdown of expense counts) are equal.
	public boolean equals(Expense expense) {
		String objexpense = this.toString();
		String paramexpense = expense.toString();
		
		if (objexpense.equals(paramexpense)) {
			return true;
		} else {
			return false;
		}	
		
	}
	
	
}
