import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int roundsWon = 0;

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;  
            int attemptsLeft = 10;  
            boolean isCorrect = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts to guess it.");

            while (attemptsLeft > 0 && !isCorrect) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attemptsLeft--;

                if (userGuess == targetNumber) {
                    isCorrect = true;
                    System.out.println("Congratulations! You guessed the number correctly.");
                } else if (userGuess > targetNumber) {
                    System.out.println("Your guess is too high. Try again.");
                } else {
                    System.out.println("Your guess is too low. Try again.");
                }

                System.out.println("You have " + attemptsLeft + " attempts left.");
            }

            if (!isCorrect) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.println("Would you like to play another round? (yes/no): ");
            String response = scanner.next();
            if (response.equalsIgnoreCase("no")) {
                playAgain = false;
            } else {
                roundsWon++;
            }
        }

        System.out.println("Thanks for playing! You won " + roundsWon + " rounds.");
        scanner.close();
    }
}
