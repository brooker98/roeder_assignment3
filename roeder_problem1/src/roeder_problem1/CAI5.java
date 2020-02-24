package roeder_problem1;
import java.util.Scanner;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class CAI5 {
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException  {
		quiz();
	}

	public static void quiz() throws NoSuchAlgorithmException, NoSuchProviderException {
		
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		int restart = 1, level = 1, type = 1;
		
		do {	
			int correct = 0;
			
			askProblemType();
			type = readProblemType();
			if (type<1 | type>5) {
				do {
					System.out.println("ERROR!");
					askProblemType();
					type = readProblemType();
				}
				while (type<1 | type>5);
			}
			
			askDifficulty();
			level = readDifficulty();
			if (level<1 | level>4) {
				do {
					System.out.println("ERROR!");
					askDifficulty();
					level = readDifficulty();
				}
				while (level<1 | level>4);
			}
			
			
			if (type == 5) {
				for (int i=0;i<10;i++) {
					int problem = secureRandomGenerator.nextInt(4) + 1;
					int numOne = generateQuestionArgument(level);
					int numTwo = generateQuestionArgument(level);
					if (problem == 4 & numTwo == 0) {
						do {
							numTwo = generateQuestionArgument(level);
						}
						while (numTwo == 0);
					}
					askQuestion(numOne, numTwo, i, problem);
					double answer = calcAnswer(numOne, numTwo, problem);
					double userAns = readResponse();
					correct = isAnswerCorrect(userAns, answer, correct);
				}
			}
			
			else {
				for (int i=0;i<10;i++) {
					int numOne = generateQuestionArgument(level);
					int numTwo = generateQuestionArgument(level);
					if (type == 4 & numTwo == 0) {
						do {
							numTwo = generateQuestionArgument(level);
						}
						while (numTwo == 0);
					}
					askQuestion(numOne, numTwo, i, type);
					double answer = calcAnswer(numOne, numTwo, type);
					double userAns = readResponse();
					correct = isAnswerCorrect(userAns, answer, correct);
				}
			}
		
			int grade = correct*10;
			displayCompletionMessage(grade);
				System.out.println("Would yout like to start a new problem set? (0: No, 1: Yes)");
				Scanner in = new Scanner(System.in);
				restart = in.nextInt();
		}
		while(restart == 1);
	}
	
	
	
	public static void askProblemType() {
		System.out.println("Enter problem type:\n1: addidtion\n2:multiplication\n3: subtraction\n4: division\n5: random");
	}
	
	public static int readProblemType() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	public static void askDifficulty() {
		System.out.println("Enter difficulty (1 to 4):");
	}
	
	public static int readDifficulty() {
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	public static int generateQuestionArgument(int level) throws NoSuchAlgorithmException, NoSuchProviderException {
		SecureRandom secureRandomGenerator = SecureRandom.getInstance("SHA1PRNG", "SUN");
		int max = 10;
		
		switch(level) {
			case 1: 
				max = 10;
				break;
			case 2: 
				max = 100;
				break;
			case 3: 
				max = 1000;
				break;
			case 4: 
				max = 10000;
				break;
		}
		
		return secureRandomGenerator.nextInt(max);
	}
	
	
	public static void askQuestion(int numOne, int numTwo, int n, int problem) throws NoSuchAlgorithmException, NoSuchProviderException {
		switch (problem) {
			case 1:
				System.out.println(n + ". How much is " + numOne + " plus " + numTwo + "?");
				break;
			case 2:
				System.out.println(n + ". How much is " + numOne + " times " + numTwo + "?");
				break;
			case 3:
				System.out.println(n + ". How much is " + numOne + " minus " + numTwo + "?");
				break;
			case 4:
				System.out.println(n + ". How much is " + numOne + " divided by " + numTwo + "?");
				break;
		}
	}
	
	public static double calcAnswer(int numOne, int numTwo, int problem) {
		double answer = 0, x = numOne, y = numTwo;
		
		switch (problem) {
			case 1:
				answer = x + y;
				break;
			case 2:
				answer = x * y;
				break;
			case 3:
				answer = x - y;
				break;
			case 4:
				answer = x / y;
				break;
		}
		return answer;
	}
	
	public static double readResponse() {
		Scanner in = new Scanner(System.in);
		return in.nextDouble();
	}
	
	public static int isAnswerCorrect(double userAns, double answer, int correct) throws NoSuchAlgorithmException, NoSuchProviderException {
		if (userAns == answer) {
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
