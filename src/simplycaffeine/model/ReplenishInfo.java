package simplycaffeine.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ReplenishInfo {

	int amount;
	String itemName;

	public ReplenishInfo(int amount, String itemName) throws FileNotFoundException, UnsupportedEncodingException {
		this.amount = amount;
		this.itemName = itemName;
		
		updateDB();
	}

	public void updateDB() throws FileNotFoundException, UnsupportedEncodingException {
		Scanner input = new Scanner(System.in);
		String fileName = "ReplenishInfo.txt";
		File file = new File(fileName);
		int[][] result = new int[3][1];

		Scanner fileTest = null;
		try {
			fileTest = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		while (fileTest.hasNext()) {
			String temp = fileTest.nextLine();

			for (int i = 0; i <= 1; i++) {
				String[] temp1 = temp.split(" ");
				result[Integer.parseInt(temp1[0])][i] = 1;
			}

		}
		updateAmount(result);
		printToConsole(result);
		printToText(result);
	}

	public void updateAmount(int[][] item) {
		int itemIndex = 0;
		if (itemName.equals("Americano")) {
			itemIndex = 0;
		}

		if (itemName.equals("Mocha")) {
			itemIndex = 1;
		}

		if (itemName.equals("Latte")) {
			itemIndex = 2;
		}

		if (itemName.equals("Espresso")) {
			itemIndex = 3;
		}

		item[itemIndex][1] += amount;

	}

	public static void printToConsole(int[][] temp) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= 1; j++) {
				System.out.print(temp[i][j]);
			}
			System.out.println();
		}
	}

	public static void printToText(int[][] temp) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("ReplenishInfo.txt", "UTF-8");
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= 1; j++) {
				output.append(temp[i][j]);
			}
			output.append("\n");
		}
		writer.print(output.toString());
		writer.close();
	}

}