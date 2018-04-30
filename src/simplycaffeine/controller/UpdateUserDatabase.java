package simplycaffeine.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplycaffeine.model.StatUserInfoOneDrink;

@WebServlet("/UpdateUserDatabase")
public class UpdateUserDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	int amount;
	String itemName;
	int userID;
	static int[][] result = new int[10][5];
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<StatUserInfoOneDrink> userStats = new ArrayList<StatUserInfoOneDrink>();

		getServletContext().setAttribute("userStats", userStats);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<StatUserInfoOneDrink> userStats = (List<StatUserInfoOneDrink>) getServletContext().getAttribute("userStats");
	
		for (StatUserInfoOneDrink userStat : userStats) {
			 userID = userStat.getUserID();
			 amount = userStat.getQty();
			 itemName = userStat.getCoffeeName();
		
			 System.out.println(userID+ " " + amount + " " + itemName );
			updateDB();
		}

	}
	

		public void updateDB() throws FileNotFoundException, UnsupportedEncodingException {
			String fileName = "/Users/V/eclipse/java-neon/eclipse/OrderStats.csv";
			File file = new File(fileName);

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
						result[index - 1][i] = Integer.parseInt(temp2[i].trim());
					} else {
						result[index][i] = Integer.parseInt(temp2[i].trim());
					}

				}

			}
			updateAmount(result);
			// printToConsole(result);
			// getMostOrderedDrink(result);
			printToText(result);
		}

		private void updateAmount(int[][] user) {
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

			user[userID][itemIndex] += amount;

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
		
		
			
			PrintWriter writer = new PrintWriter("/Users/V/eclipse/java-neon/eclipse/OrderStats.csv", "UTF-8");
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

		public void getMostOrderedDrink() {
			int[][] temp = result.clone();
			String output = "";
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

			int[] orders = { order1, order2, order3, order4 };

			int max = Integer.MIN_VALUE;
			int index = 0;
			for (int i = 0; i < orders.length; i++) {
				if (orders[i] > max) {
					index = i;
					max = orders[i];
				}
			}

			if (index == 0) {
				output = "Americano";
			} else if (index == 1) {
				output = "Mocha";
			} else if (index == 2) {
				output = "Latte";
			} else {
				output = "Espresso";
			}

			System.out.println(output + " is the most popular drink");
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
