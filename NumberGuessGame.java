import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        // Game settings
        int minNumber = 1;
        int maxNumber = 100;
        int maxAttempts = 10;
        int rounds = 1;
        int score = 0;
        boolean playAgain = true;

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int randomNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Round " + rounds + ": Guess the number between " + minNumber + " and " + maxNumber);

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score++;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The correct number was: " + randomNumber);
            }

            rounds++;
            System.out.println("Current score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}

