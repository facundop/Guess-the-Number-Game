package com.facundoprecentado.guessthenumber;

import java.util.Scanner;

public class Application {
	private Scanner input = new Scanner(System.in);
	private int numberToGuess;
	private int guessedNumber;
	private String playerName;
	private boolean gameIsRunning = true;
	private int tries;

	public static void main(String[] args) {
		Application game = new Application();
		game.run();
	}

	private void run() {
		System.out.println("Hi there! What's your name?");
		playerName = Utils.getPlayerName(input);
		System.out.println(playerName + ", let's play!");

		while (gameIsRunning) {
			numberToGuess = Utils.getRandomNumber(1, 100);
			tries = 0;

			// Debugging only. Remove this line to play the game.
			System.out.println("Number to guess: " + numberToGuess);
			System.out.println(playerName + ", I've picked a number between 1 and 100, guess it!");

			do {
				System.out.println("Pick a number: ");
				guessedNumber = Utils.guessNumber(input);
				Utils.isNumberLowerOrHigher(numberToGuess, guessedNumber);
				tries++;
			} while (guessedNumber != numberToGuess);

			if (guessedNumber == numberToGuess) {
				System.out.println("Good job. You guessed it in " + tries + (tries == 1 ? " try." : " tries"));
			}

			System.out.println("Play again? y/n");
			gameIsRunning = Utils.playAgain(input);
			if (gameIsRunning)
				System.out.println("Let's play again!");

		}
		System.out.println("Thanks for playing. Good bye!");
		input.close();
	}

}