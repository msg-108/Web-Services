import java.util.Random;
import java.util.Scanner;

class GuessingGame{
    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing Game!"); 

        // Generate a random number between 1 and 100 
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;

        // count
        int count = 0;

        while (true) { 

            // Let user guess the number 
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nGuess a number between 1 and 100:");
            int guess = scanner.nextInt();

            // Handling invalid inputs
            if (guess <= 0 || guess > 100){
                System.out.println("ERROR: Invalid input!");
                continue;
            }

            ++count;

            // if guess < target -> "Your guess is lower than target, Guess higher"
            if (guess < target) {
                System.out.println("\nYour guess is lower than target, Guess higher");
            }

            // if guess > target -> "Your guess is higher than target, Guess lower"
            else if (guess > target) {
                System.out.println("\nYour guess is higher than target, Guess lower");
            }

            // if guess == target -> "Congratulations! You guessed the number."
            else {
                System.out.println("\nCongratulations! You guessed the number.");
                System.out.println("\nYou have guessed correct answer in " + count + " attempts.");
                break;
            }

            // Ask user if they want to try again
            System.out.println("\nDo you want to try again?(Y/Yes to continue)");
            String again = scanner.next().trim().toLowerCase();
            
            if (!again.equals("yes") && !again.equals("y")) {
                break;
            }

        }

        System.out.println("\nThank you for playing Guessing Game!");

    }
}