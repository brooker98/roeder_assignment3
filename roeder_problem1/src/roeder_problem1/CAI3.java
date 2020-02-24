package roeder_problem1;
import java.util.Scanner;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class CAI3 {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException  {
		quiz();
	}

	public static void quiz() throws NoSuchAlgorithmException, NoSuchProviderException {
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		int restart = 1;
		
		do {	
		int correct = 0;
		
		for (int i=0;i<10;i++) {
			int numOne = secureRandomGenerator.nextInt(10);
			int numTwo = secureRandomGenerator.nextInt(10);
			int product = numOne*numTwo;
			askQuestion(numOne, numTwo, i);
			int ans = readResponse();
			correct = isAnswerCorrect(ans, product, correct);
		}
		
		int grade = correct*10;
		displayCompletionMessage(grade);
		System.out.println("Would yout like to start a new problem set? (0: No, 1: Yes)");
		Scanner in = new Scanner(System.in);
		restart = in.nextInt();
		}
		while(restart == 1);
	}
	
	
	public static void askQuestion(int numOne, int numTwo, int n) {
		System.out.println(n + ". How much is " + numOne + " times " + numTwo + "?");
	}
	
	public static int readResponse() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	public static int isAnswerCorrect(int ans, int product, int correct) throws NoSuchAlgorithmException, NoSuchProviderException {
		if (ans == product) {
			displayCorrectResponse();
			return correct+1;
		}
		else {
			displayIncorrectResponse();
			return correct;
		}
	}
	
	public static void displayCorrectResponse() throws NoSuchAlgorithmException, NoSuchProviderException {
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		int response = secureRandomGenerator.nextInt(4);
		
		switch(response) {
			case 0 : 
				System.out.println("Very good!");
				break;
			case 1 : 
				System.out.println("Excellent!");
				break;
			case 2 : 
				System.out.println("Nice work!");
				break;
			case 3 : 
				System.out.println("Keep up the good work!");
				break;
		}
	}
	
	public static void displayIncorrectResponse() throws NoSuchAlgorithmException, NoSuchProviderException {
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		int response = secureRandomGenerator.nextInt(4);
		
		switch(response) {
			case 0 : 
				System.out.println("No. Please try again.");
				break;
			case 1 : 
				System.out.println("Wrong. Try once more.");
				break;
			case 2 : 
				System.out.println("Don’t give up!");
				break;
			case 3 : 
				System.out.println("No. Keep trying.");
				break;
		}
	}
	
	public static void displayCompletionMessage(int grade) {
		System.out.println("Your score is: " + grade + "%");
		 if (grade<75) {
			 System.out.println("Please ask your teacher for more help.");
		 }
		 else if (grade>=75) {
			 System.out.println("Congratulations, you are ready to go to the next level!");
		 }
	}

}
