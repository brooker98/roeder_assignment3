package roeder_problem2;

public class SavingsAccountTest {
	public static void main(String[] args) {
		
		SavingsAccount saver1 = new SavingsAccount();
		SavingsAccount saver2 = new SavingsAccount();
		
		saver1.setBalance(2000);
		saver2.setBalance(3000);
		
		SavingsAccount.setInterestRate(0.04);
		
		System.out.println("\t\t\tsaver1 \t\tsaver2");
		int i;
		for (i=1;i<=12;i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			System.out.println("Month " + i + " balance: \t" + String.format("%.2f", saver1.getBalance()) + "\t\t" + String.format("%.2f", saver2.getBalance()));
		}
		
		SavingsAccount.modifyInterestRate(0.05);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		System.out.println("Month " + i + " balance: \t" + String.format("%.2f", saver1.getBalance()) + "\t\t" + String.format("%.2f", saver2.getBalance()));
		
	}

}
