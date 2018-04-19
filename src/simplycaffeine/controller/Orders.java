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
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		List<User> userEntries = (List<User>) getServletContext().getAttribute("userEntries");

		// 0 1 2 3
		// ------------------------------- userID card# name email
		// csv file should be formatted as 1234 4325 John Doe jd@gmail.com

		int userID = user.getId();
		int quantity = 0;
		for (User userEntry : userEntries) {
			if (user.getFirst().equals(userEntry.getFirst())) {

				quantity = Integer.parseInt(userEntry.getQuantity());
				processOrder(userID, quantity);
			}
		}

	}

	public void processOrder(int userID, int amount) throws IOException {

		String userDB = "UserInfo.csv"; // make sure this file exists
		File inFile = new File(userDB);
		if (!inFile.exists()) {
			JOptionPane.showMessageDialog(null, " File Doesnt exist");
		}
		Scanner fileeReader = new Scanner(inFile);
		String newLine;
		int nextUserID;
		int cardNum;
		String[] dataSplit = new String[4];
		Boolean found = false;
		File outFile = new File("transactions.txt");

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
				String data = "charge credit card number " + cardNum + " total of: " + amount;
				BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
				writer.newLine();
				writer.append(data);
				break;
			}

		}
		if (!found) { // if not found exit order process
			System.exit(1);
		}

	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	
}
