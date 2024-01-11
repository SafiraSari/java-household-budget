// -------------------------------------------------------
// Assignment 4
// Written by: Safira Sari (40249017)
// For COMP 248 Section T – Fall 2022
// --------------------------------------------------------

// Fund Class containing the methods relating to funds.

public class Fund {
	// STATIC CONSTANTS - Value of each money type
	static final int looniesVal = 1;
	static final int tooniesVal = 2;
	static final int bill5Val = 5;
	static final int bill10Val = 10;
	static final int bill20Val = 20;
	
	// PRIVATE ATTRIBUTES - Number of each money type
	private int n1, n2, n5, n10, n20;
	
	// CONSTUCTORS
	// Default Constructor
	public Fund() {
		this.n1 = 0;
		this.n2 = 0;
		this.n5 = 0;
		this.n10 = 0;
		this.n20 = 0;
	}
	
	// Custom Constructor with 5 integer parameters
	public Fund(int n1, int n2, int n5, int n10, int n20) {
		this.n1 = n1;
		this.n2 = n2;
		this.n5 = n5;
		this.n10 = n10;
		this.n20 = n20;
	}

	// Copy Constructor: fund is a reference to the object that is sent to the copy constructor.
	public Fund(Fund fund) {
		this.n1 = fund.n1;
		this.n2 = fund.n2;
		this.n5 = fund.n5;
		this.n10 = fund.n10;
		this.n20 = fund.n20;	
	}
	
	// ACCESSOR METHODS - Get attributes outside of the Fund class.
	public int getN1() {
		  return this.n1;
	}
	public int getN2() {
		  return this.n2;
	}
	public int getN5() {
		  return this.n5;
	}
	public int getN10() {
		  return this.n10;
	}
	public int getN20() {
		  return this.n20;
	}
	
	// MUTATOR METHODS - Set attributes outside of the Fund class.
	public void setN1(int n) {
		  this.n1 = n;
	}
	public void setN2(int n) {
		  this.n2 = n;
	}
	public void setN5(int n) {
		  this.n5 = n;
	}
	public void setN10(int n) {
		  this.n10 = n;
	}
	public void setN20(int n) {
		  this.n20 = n;
	}
	
	// METHODS
	// Method to increase the number of each fund type by the indicated number.
	public void addFund(int n1, int n2, int n5, int n10, int n20) {	
		this.n1 = this.n1 + n1;
		this.n2 = this.n2 + n2;
		this.n5 = this.n5 + n5;
		this.n10 = this.n10 + n10;
		this.n20 = this.n20 + n20;
	}
	
	// Method to return the total value of the fund possessed by the household.
	public double fundTotal() {
		double fundTotal = n1*looniesVal + n2*tooniesVal + n5*bill5Val + n10*bill10Val + n20*bill20Val;
		return fundTotal;
	}
	
	// Method returning the breakdown of the household's money type.
	public String toString() {
		String fundBreakdown = "(" + n1 + " x $1) + (" + n2 + " x $2) + (" + n5 + " x $5) + (" + n10 + " x $10) + (" + n20 + " x $20)";
		return fundBreakdown;
	}
	// Format: (0 x $1) + (1 x $2) + (0 x $5) + (2 x $10) + (1 x $20)
	
	// Method returning a boolean of whether two objects (containing the breakdown of fund counts) are equal.
	public boolean equals(Fund fund) {	
		String objfund = this.toString();	
		String paramfund = fund.toString();
		
		if (objfund.equals(paramfund)){
			return true;
		} else {
			return false;
		}	
	
	}
}
