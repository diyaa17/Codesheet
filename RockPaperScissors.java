import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        // Game options
        String[] choices = {"Rock", "Paper", "Scissors"};
        
        // Scores
        int playerScore = 0;
        int computerScore = 0;
        int rounds = 3;

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("You will play 3 rounds against the computer. Let's see who wins more rounds!");

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRound " + i + ": Enter 'Rock', 'Paper', or 'Scissors' to play.");
            
            // Player's choice
            System.out.print("Your choice: ");
            String playerChoice = scanner.nextLine().trim();

            // Validate player's choice
            if (!playerChoice.equalsIgnoreCase("Rock") &&
                !playerChoice.equalsIgnoreCase("Paper") &&
                !playerChoice.equalsIgnoreCase("Scissors")) {
                System.out.println("Invalid choice. Please enter 'Rock', 'Paper', or 'Scissors'.");
                i--;  // Invalid round, repeat the same round
                continue;
            }

            // Computer's choice
            String computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer chose: " + computerChoice);

            // Determine the winner of the round
            if (playerChoice.equalsIgnoreCase(computerChoice)) {
                System.out.println("It's a tie!");
            } else if ((playerChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
                       (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) ||
                       (playerChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))) {
                System.out.println("You win this round!");
                playerScore++;
            } else {
                System.out.println("Computer wins this round!");
                computerScore++;
            }
        }

        // Display final results
        System.out.println("\n--- Game Over ---");
        System.out.println("Your Score: " + playerScore);
        System.out.println("Computer's Score: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("Congratulations! You are the overall winner!");
        } else if (computerScore > playerScore) {
            System.out.println("The computer wins overall! Better luck next time.");
        } else {
            System.out.println("It's a tie overall!");
        }

        scanner.close();
    }
}
