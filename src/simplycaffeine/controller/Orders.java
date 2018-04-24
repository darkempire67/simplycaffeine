package simplycaffeine.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import simplycaffeine.model.User;

@WebServlet("/Orders")
public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<User> userEntries = new ArrayList<User>();

		getServletContext().setAttribute("userEntries", userEntries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<StatUserInfoOneDrink> stats = (List<StatUserInfoOneDrink>) getServletContext().getAttribute("stats");
		
		for (StatUserInfoOneDrink stat : stats) {
			int userID = stat.getUserID();
			Double total = stat.getTotal();
		
			processOrder(userID, total);
		}

	}

	public void processOrder(int userID, Double amount) throws IOException {

		String userDB = "/Users/V/eclipse/java-neon/eclipse/UserInfo.csv"; // make
																			// sure
																			// this
																			// file
																			// exists
		File inFile = new File(userDB);
		System.out.println("Attempting to read from file in: " + inFile.getCanonicalPath());
		if (!inFile.exists()) {
			// JOptionPane.showMessageDialog(null,
			System.out.println(" File Doesnt exist");
		}
		Scanner fileeReader = new Scanner(inFile);
		String newLine;
		int nextUserID;
		int cardNum;
		String[] dataSplit = new String[4];
		Boolean found = false;
		File outFile = new File("transactions.txt");

		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile.getAbsoluteFile(), true));
		while (fileeReader.hasNextLine()) { // look for users creditcard num by
											// using userID in UserInfo DB
			newLine = fileeReader.nextLine();
			dataSplit = newLine.split(",");
			nextUserID = Integer.parseInt(dataSplit[0]);
			cardNum = Integer.parseInt(dataSplit[1]);

			if (nextUserID == userID) { // ---------found user, now copy to txt
										// file-> credit card num-
										// and amount to charge.
				found = true;
				// print cardNum and amount to file.
				String data = "Charge credit card Number "+ cardNum + " total of " + amount;
				writer.newLine();
				writer.write(data);
				break;
			}
		}
		fileeReader.close();
		writer.close();

		if (!found) { // if not found exit order process
			System.exit(1);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}
