package com.facundoprecentado.guessthenumber;

import java.util.Scanner;

public class Utils {
	
	/*
	 * Returns a random number within a specified range
	 */
	public static int getRandomNumber(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}
	
	/*
	 * Returns true if the players wants to keep playing
	 */
	public static boolean playAgain(Scanner keyboard) {
		return keyboard.nextLine().toLowerCase().trim().startsWith("y");
	}
	
	/*
	 * Returns the name of the player
	 */
	public static String getPlayerName(Scanner keyboard) {
		return keyboard.nextLine();
	}
	
	/*
	 * Asks to guess the number.
	 */
	public static int guessNumber(Scanner keyboard) {
		try {
			return Integer.parseInt(keyboard.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Please try with an integer. No letters, no decimals. Guess again.");
			return guessNumber(keyboard);
		}
	}
	
	/*
	 * Check if the guessed number is too low or too high
	 */
	public static void isNumberLowerOrHigher(int numberToGuess, int guessedNumber) {
		if (numberToGuess < guessedNumber) {
			System.out.println("Too high. Guess again.");
		}
		if (numberToGuess > guessedNumber) {
			System.out.println("Too low. Guess again.");
		}
	}

}
