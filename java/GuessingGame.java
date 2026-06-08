import java.util.Random;
import java.util.Scanner;

class GuessingGame{
    public static void main(String[] args) {

        System.out.println("Welcome to the Guessing Game!"); 

        // Generate a random number between 1 and 100 
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;
        
        // Get user input
        Scanner scanner = new Scanner(System.in);

        // count
        int count = 0;

        while (true) { 

            // Let user guess the number 
            System.out.println("\nGuess a number between 1 and 100:");
            System.out.println("(Enter any character to exit.)");
            
            if(scanner.hasNextInt()){
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
            } else{
                break;
            }

        }

        scanner.close();
        System.out.println("\nThank you for playing Guessing Game!");

    }
}