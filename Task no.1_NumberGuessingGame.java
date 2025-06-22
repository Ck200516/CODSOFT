import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1; // Random number between 1 and 100
            int numberOfAttempts = 10;
            boolean hasWon = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + numberOfAttempts + " attempts to guess it!");

            for (int i = 1; i <= numberOfAttempts; i++) {
                System.out.print("Attempt " + i + " - Enter your guess: ");
                int userGuess;

                // Validate input
                try {
                    userGuess = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    i--; // Don't count this as a valid attempt
                    continue;
                }

                if (userGuess < 1 || userGuess > 100) {
                    System.out.println(" Please guess a number between 1 and 100.");
                    i--;
                    continue;
                }

                if (userGuess == numberToGuess) {
                    System.out.println(" Congratulations! You guessed the number correctly in " + i + " attempts!");
                    hasWon = true;
                    totalScore += (numberOfAttempts - i + 1) * 10; // Score logic
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println(" Too high! Try again.");
                }
            }

            if (!hasWon) {
                System.out.println(" You've used all your attempts. The correct number was: " + numberToGuess);
            }

            System.out.println("Your current score: " + totalScore);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = sc.nextLine().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("👋 Thanks for playing! Your final score was: " + totalScore);
        sc.close();
    }
}
