import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {
	private static void PrintResults(int cows, int bulls) {

		if (bulls > 0) {
			cows = cows - bulls;
		}
		System.out.println("-------------------------------------------------");
		System.out.println("You have: " + cows + " Cows " + bulls + " Bulls");

	}

	private static int GetPlayerNumber() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.print("Please Enter 4 digit Number: ");
		int playerNumber = scanner.nextInt();

		return playerNumber;
	}

	static int GetRandomNumber(int max, int min) {

		Random rand = new Random();
		int randomNumber = min;
		while (CheckComputerNumber(randomNumber) > 0) {
			randomNumber = rand.nextInt((max - min) + 1) + min;
		}

		return randomNumber;
	}

	static int CheckComputerNumber(int computerNumber) {
		int[] computerNumberArray = ConvertIntegerToArray(computerNumber);
		int countEquals = 0;

		for (int i = 0; i < computerNumberArray.length; i++) {
			for (int j = 0; j < computerNumberArray.length; j++) {
				if (computerNumberArray[i] == computerNumberArray[j]) {
					countEquals++;
				}
			}
		}

		return countEquals;
	}

	static int[] ConvertIntegerToArray(int number) {

		String temp = Integer.toString(number);
		int[] newArray = new int[4];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = temp.charAt(i);
		}

		return newArray;
	}

	static int CountCows(int computerNumber, int playerNumber) {

		int[] computerNumberArray = ConvertIntegerToArray(computerNumber);
		int[] playerNumberArray = ConvertIntegerToArray(playerNumber);
		int countCows = 0;

		for (int i = 0; i < playerNumberArray.length; i++) {
			for (int j = 0; j < computerNumberArray.length; j++) {
				if (playerNumberArray[i] == computerNumberArray[j]) {
					countCows++;
				}
			}
		}
		return countCows;
	}

	static int CountBulls(int computerNumber, int playerNumber) {
		int[] computerNumberArray = ConvertIntegerToArray(computerNumber);
		int[] playerNumberArray = ConvertIntegerToArray(playerNumber);
		int countBulls = 0;

		for (int i = 0; i < playerNumberArray.length; i++) {
			if (playerNumberArray[i] == computerNumberArray[i]) {
				countBulls++;
			}
		}

		return countBulls;
	}

	public static void main(String[] args) {

		int computerMin = 1000;
		int computerMax = 9999;
		int playerNumber = 0;
		int computerNumber = GetRandomNumber(computerMax, computerMin);
		int cows = 0;
		int bulls = 0;

		while (bulls < 4) {
			playerNumber = GetPlayerNumber();
			cows = CountCows(computerNumber, playerNumber);
			bulls = CountBulls(computerNumber, playerNumber);
			PrintResults(cows, bulls);
		}

		System.out.println("Congrutualtions!!!!!!!!!!!!!");

	}

}
