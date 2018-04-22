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
	
	
	public StatsUserInfoOneDrink(int userId, int amount, String itemName) throws FileNotFoundException, UnsupportedEncodingException {
		this.userId = userId;
		this.amount = amount;
		this.itemName = itemName;
		
		updateDB();
	}
	
	public void updateDB() throws FileNotFoundException, UnsupportedEncodingException {
		Scanner input = new Scanner(System.in);
		String fileName = "OrderStats.txt";
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

			for (int i = 0; i < 5; i++) {
				int tempInt = Character.getNumericValue(temp.charAt(0));
				result[tempInt - 1][i] = Character.getNumericValue(temp.charAt(i));
			}

		}
		updateAmount(result);
		printToConsole(result);
		printToText(result);
	}
	
	public void updateAmount(int[][] user) {
		int itemIndex = 0;
		if(itemName.equals("Americano")) {
			itemIndex = 1;
		}
		
		if(itemName.equals("Mocha")) {
			itemIndex = 2;
		}
		
		if(itemName.equals("Latte")) {
			itemIndex = 3;
		}
		
		if(itemName.equals("Espresso")) {
			itemIndex = 4;
		}
		
		user[userId][itemIndex] += amount;
		
	}

	public static void printToConsole(int[][] temp) {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(temp[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void printToText(int[][] temp) throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter("OrderStats.txt", "UTF-8");
		StringBuilder output = new StringBuilder();
		for(int i = 0; i < 10;i++) {
			for(int j = 0;j < 5; j++) {
				output.append(temp[i][j]);
			}
			output.append("\n");
		}
		writer.print(output.toString());
		writer.close();
	}

}
