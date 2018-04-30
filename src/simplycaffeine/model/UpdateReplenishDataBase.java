package simplycaffeine.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdateReplenishDataBase {

	int amount;
	String itemName;
	int maxAmount = 100;

	public UpdateReplenishDataBase(ArrayList<ReplenishInfo> input) throws FileNotFoundException, UnsupportedEncodingException {

		for (int i = 0; i < input.size(); i++) {
			this.amount = input.get(i).qty;
			this.itemName = input.get(i).coffeeName;
			updateDB();
		}
	}

	public void updateDB() throws FileNotFoundException, UnsupportedEncodingException {
		Scanner input = new Scanner(System.in);
		String fileName = "ReplenishInfo.csv";
		File file = new File(fileName);
		int[][] result = new int[4][2];

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
			for (int i = 0; i < 2; i++) {
				result[index - 1][i] = Integer.parseInt(temp2[i]);
			}

		}
		updateAmount(result);
		//printToConsole(result);
		printToText(result);
	}

	public void updateAmount(int[][] item) throws FileNotFoundException, UnsupportedEncodingException {
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

		int tempAmount = item[itemIndex][1];

		PrintWriter writer = new PrintWriter("ReplenishNeeded.txt", "UTF-8");

		if (tempAmount >= (maxAmount / 2.0)) {
			writer.print(itemName + " needs to be replenished!");
			writer.close();
		}

	}

	public static void printToConsole(int[][] temp) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= 1; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void printToText(int[][] temp) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("ReplenishInfo.csv", "UTF-8");
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= 1; j++) {
				output.append(temp[i][j] + ",");
			}
			output.append("\n");
		}
		writer.print(output.toString());
		writer.close();
	}

}