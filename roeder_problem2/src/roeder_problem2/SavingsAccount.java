package roeder_problem2;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount {
	
	public static double annualInterestRate;
	private double savingsBalance;
	
	public static void setInterestRate(double rate) {
		annualInterestRate = rate;
	}
	
	public static double getInterestRate() {
		return annualInterestRate;
	}
	
	public void setBalance(double balance) {
		savingsBalance = balance;
	}
	
	public double getBalance() {
		return savingsBalance;
	}
	
	public void calculateMonthlyInterest() {
		double monthlyInterest = savingsBalance * annualInterestRate / 12.0;
		BigDecimal interest = (BigDecimal.valueOf(monthlyInterest)).setScale(2, RoundingMode.HALF_UP);
		BigDecimal newBalance = (BigDecimal.valueOf(savingsBalance)).add(interest);
		savingsBalance = newBalance.doubleValue();
	}
	
	public static void modifyInterestRate(double newInterestRate) {
		annualInterestRate = newInterestRate;
	}
	

}
