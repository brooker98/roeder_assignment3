package roeder_problem1;
import java.util.Scanner;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class CAI1 {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException  {
		quiz();
	}

	public static void quiz() throws NoSuchAlgorithmException, NoSuchProviderException {
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		int correct = 0;
		
		do {
			int numOne = secureRandomGenerator.nextInt(10);
			int numTwo = secureRandomGenerator.nextInt(10);
			int product = numOne*numTwo;
			askQuestion(numOne, numTwo);
			int ans = readResponse();
			correct = isAnswerCorrect(ans, product);
		}
		while(correct==0);
	}
	
	
	public static void askQuestion(int numOne, int numTwo) {
		System.out.println("How much is " + numOne + " times " + numTwo + "?");
	}
	
	@SuppressWarnings("resource")
	public static int readResponse() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	public static int isAnswerCorrect(int ans, int product) {
		if (ans == product) {
			displayCorrectResponse();
			return 1;
		}
		else {
			displayIncorrectResponse();
			return 0;
		}
	}
	
	public static void displayCorrectResponse() {
		System.out.println("Very good!");
	}
	
	public static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}

}
