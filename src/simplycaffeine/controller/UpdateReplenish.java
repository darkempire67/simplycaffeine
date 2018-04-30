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

import simplycaffeine.model.ReplenishInfo;


@WebServlet("/UpdateReplenish")
public class UpdateReplenish extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int amount = 0;
	String itemName = "";
	int maxAmount = 1000;


	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<ReplenishInfo> reps = new ArrayList<ReplenishInfo>();

		getServletContext().setAttribute("reps", reps);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		List<ReplenishInfo> reps = (List<ReplenishInfo>) getServletContext().getAttribute("reps");
		
		for (ReplenishInfo rep : reps) {
			 amount = rep.getQty();
			  itemName  = rep.getCoffeeName();
		
			updateDB();
		}
	}

//	public void replenish(ArrayList<ReplenishInfo> input)
//				throws FileNotFoundException, UnsupportedEncodingException {
//
//			for (int i = 0; i < input.size(); i++) {
//				int amount = input.get(i).qty;
//				String itemName = input.get(i).coffeeName;
//				updateDB();
//			}
//		}

	public void updateDB() throws IOException {
		Scanner input = new Scanner(System.in);
		String fileName = "/Users/V/eclipse/java-neon/eclipse/ReplenishInfo.csv";
		
		
		File file = new File(fileName);
	
		int[][] result = new int[4][2];

		Scanner fileTest = null;
		
		System.out.println("Attempting to read from file in: " + file.getCanonicalPath());
		
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
		// printToConsole(result);
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

		if (tempAmount >= (maxAmount / 2.0)) {
			PrintWriter writer = new PrintWriter("ReplenishNeeded.txt", "UTF-8");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
