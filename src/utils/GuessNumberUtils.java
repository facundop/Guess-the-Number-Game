package utils;

import java.util.Scanner;

public class GuessNumberUtils {

	/*
	 * Method to generate a random number in a specific range
	 */
	public int getRandomNumber(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	/*
	 * Method to ask for the player's name
	 */
	static public String getPlayerName(Scanner keyboard) {
		String playerName;
		System.out.println("Hi there! What's your name?");
		playerName = keyboard.nextLine();
		System.out.println("Hi " + playerName + ", let's play!");
		return playerName;
	}

	/*
	 * Method to ask for a number to guess.
	 */
	static public int guessNumber(Scanner keyboard) {
		System.out.println("Pick a number: ");
		return Integer.parseInt(keyboard.nextLine());
	}

	/*
	 * Method to check if the player has guessed the number.
	 */
	static public boolean isNumberCorrect(int numberToGuess, int guessedNumber) {
		if (numberToGuess == guessedNumber) {
			return true;
		} else {
			if (numberToGuess < guessedNumber) {
				System.out.println("Too high. Guess again.");
			} else {
				System.out.println("Too low. Guess again.");
			}
			return false;
		}
	}

	/*
	 * Method to keep playing or finish it.
	 */
	static public boolean playAgain(Scanner keyboard) {
		char playAgain;
		System.out.println("Play again? y/n");
		playAgain = keyboard.nextLine().charAt(0);
		while (playAgain != 'y' && playAgain != 'n') {
			System.out.println("Please use 'y' for yes or 'n' for no.");
			System.out.println("Play again? (y/n)");
			playAgain = keyboard.nextLine().charAt(0);
		}
		if (playAgain == 'n') {
			System.out.println("Thanks for playing. Good bye!");
			return true;
		} else {
			System.out.println("Let's play again!");
			return false;
		}
	}
}
