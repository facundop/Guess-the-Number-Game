package game;

import java.util.Scanner;

import utils.GuessNumberUtils;

public class GuessGame {

	// Class with all the methods required by the game
	static GuessNumberUtils numberGenerator = new GuessNumberUtils();

	// Scanner to handle input
	static Scanner keyboard = new Scanner(System.in);

	// This is where we store the number to guess
	static int numberToGuess;

	// This is where we store the number guessed by the player
	static int guessedNumber;

	// Number of tries - the idea is to handle a scoring system in the future
	static int tries;

	// Flag used to loop the game
	static boolean gameEnded = false;

	// This is where we store the player's name
	static String playerName;

	public static void main(String[] args) {

		// Asks for player's name
		playerName = GuessNumberUtils.getPlayerName(keyboard);

		while (!gameEnded) {
			// We initialize the score (tries)
			tries = 1;
			
			// Generates a random number. To do: ask the players for the range
			numberToGuess = numberGenerator.getRandomNumber(1, 100);

			// Debugging only. Remove this line to actually play the game.
			System.out.println(numberToGuess);

			System.out.println(playerName
					+ ", I've picked a number between 1 and 100, guess it!");

			guessedNumber = GuessNumberUtils.guessNumber(keyboard);

			while (guessedNumber != numberToGuess) {
				GuessNumberUtils.isNumberCorrect(numberToGuess, guessedNumber);
				tries++;
				guessedNumber = GuessNumberUtils.guessNumber(keyboard);
			}

			if (guessedNumber == numberToGuess) {
				if (tries == 1) {
					System.out.println("Good job. You guessed it in 1 try.");
				} else {
					System.out.println("Good job. You guessed it in " + tries
							+ " tries.");
				}

			}

			gameEnded = GuessNumberUtils.playAgain(keyboard);
		}
		keyboard.close();
	}

}
