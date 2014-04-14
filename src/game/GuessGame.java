package game;

import java.util.Scanner;

public class GuessGame {
	private Scanner input = new Scanner(System.in);
	private int numberToGuess;
	private int guessedNumber;
	private String playerName;
	private boolean gameIsRunning = true;

	// This is the score - the idea is to handle a scoring system in the future
	private int tries;

	public static void main(String[] args) {
		GuessGame game = new GuessGame();
		game.run();
	}

	private void run() {
		playerName = getPlayerName(input);
		while (gameIsRunning) {
			// We initialize the # of tries. To do: scoring system.
			tries = 0;

			// Generates a random number. To do: ask the players for the range
			numberToGuess = getRandomNumber(1, 100);

			// Debugging only. Remove this line to play the game.
			System.out.println(numberToGuess);

			System.out.println(playerName
					+ ", I've picked a number between 1 and 100, guess it!");

			do {
				guessedNumber = guessNumber(input);
				isNumberLowOrHigh(numberToGuess, guessedNumber);
				tries++;
			} while (guessedNumber != numberToGuess);

			if (guessedNumber == numberToGuess) {
				System.out.println("Good job. You guessed it in " + tries
						+ (tries == 1 ? " try." : " tries"));
			}

			gameIsRunning = playAgain(input);
		}
		input.close();
	}

	/*
	 * Method to generate a random number in a specific range
	 */
	private int getRandomNumber(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	/*
	 * Method to ask for the player's name
	 */
	private String getPlayerName(Scanner keyboard) {
		System.out.println("Hi there! What's your name?");
		String playerName = keyboard.nextLine();
		System.out.println("Hi " + playerName + ", let's play!");
		return playerName;
	}

	/*
	 * Method to ask for a number to guess.
	 */
	private int guessNumber(Scanner keyboard) {
		System.out.println("Pick a number: ");
		return Integer.parseInt(keyboard.nextLine());
	}

	/*
	 * Method to check if the guessed number is too low or too high
	 */
	private void isNumberLowOrHigh(int numberToGuess, int guessedNumber) {
		if (numberToGuess < guessedNumber) {
			System.out.println("Too high. Guess again.");
		}
		if (numberToGuess > guessedNumber) {
			System.out.println("Too low. Guess again.");
		}
	}

	/*
	 * Method to keep playing or finish it.
	 */
	private boolean playAgain(Scanner keyboard) {
		boolean playAgain;
		System.out.println("Play again? y/n");
		playAgain = keyboard.nextLine().toLowerCase().trim().startsWith("y");
		if (playAgain) {
			System.out.println("Let's play again!");
			return true;
		} else {
			System.out.println("Thanks for playing. Good bye!");
			return false;
		}
	}
}