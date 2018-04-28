package simplycaffeine.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class StatsUserInfoOneDrink {
	int amount;
	String itemName;
	int userId;

	public StatsUserInfoOneDrink(int userId, int amount, String itemName)
			throws FileNotFoundException, UnsupportedEncodingException {
		this.userId = userId;
		this.amount = amount;
		this.itemName = itemName;

		updateDB();
	}

	public void updateDB() throws FileNotFoundException, UnsupportedEncodingException {
		Scanner input = new Scanner(System.in);
		String fileName = "OrderStats.csv";
		File file = new File(fileName);
		int[][] result = new int[10][5];

		Scanner fileTest = null;
		try {
			fileTest = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		while (fileTest.hasNext()) {
			String temp = fileTest.nextLine();

			String[] temp2 = temp.split(",");
			int index = Integer.parseInt(temp2[0]);
			for (int i = 0; i < 5; i++) {
				if ((index - 1) >= 0) {
					result[index - 1][i] = Integer.parseInt(temp2[i]);
				} else {
					result[index][i] = Integer.parseInt(temp2[i]);
				}

			}

		}
		updateAmount(result);
		printToConsole(result);
		getMostOrderedDrink(result);
		printToText(result);
	}

	public void updateAmount(int[][] user) {
		int itemIndex = 0;
		if (itemName.equals("Americano")) {
			itemIndex = 1;
		}

		if (itemName.equals("Mocha")) {
			itemIndex = 2;
		}

		if (itemName.equals("Latte")) {
			itemIndex = 3;
		}

		if (itemName.equals("Espresso")) {
			itemIndex = 4;
		}

		user[userId][itemIndex] += amount;

	}

	public static void printToConsole(int[][] temp) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				if (temp[i][0] != 0) {
					System.out.print(temp[i][j] + " ");
				}
			}
			if (temp[i][0] != 0) {
				System.out.println();
			}
		}
	}

	public static void printToText(int[][] temp) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("OrderStats.csv", "UTF-8");
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				if (temp[i][0] != 0) {
					output.append(temp[i][j] + ",");
				}
			}
			output.append("\n");
		}
		writer.print(output.toString());
		writer.close();
	}

	public static void getMostOrderedDrink(int[][] temp) {
		String result = "";
		int order1 = 0;
		int order2 = 0;
		int order3 = 0;
		int order4 = 0;

		for (int i = 0; i < 10; i++) {
			order1 += temp[i][1];
		}
		for (int i = 0; i < 10; i++) {
			order2 += temp[i][2];
		}
		for (int i = 0; i < 10; i++) {
			order3 += temp[i][3];
		}
		for (int i = 0; i < 10; i++) {
			order4 += temp[i][4];
		}

		if (order1 > order2) {
			result = "Americano";
		} else {
			result = "Mocha";
		}
		if (order2 > order3) {
			result = "Mocha";
		} else {
			result = "Latte";
		}
		if (order3 > order4) {
			result = "Latte";
		} else {
			result = "Espresso";
		}
		if (order4 > order1) {
			result = "Espresso";
		} else {
			result = "Americano";
		}

		System.out.println(result + " is the most popular drink");
	}

}
