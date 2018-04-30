package simplycaffeine.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

import simplycaffeine.model.StatUserInfoOneDrink;
import simplycaffeine.model.User;

@WebServlet("/OrderSuccess")
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

		if (user == null) {
			response.sendRedirect("Login");
			return;
		}

		List<StatUserInfoOneDrink> stats = (List<StatUserInfoOneDrink>) getServletContext().getAttribute("stats");

		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0");

		out.print(" Transitional//EN\">\n");

		out.print("<html><head>");

		out.println("   <meta charset=\"UTF-8\">");

		out.println("   <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");

		out.println("   <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");

		out.println(
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println(
				"       <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"https://raw.githubusercontent.com/giantolentino/simplycaffeine/test/WebContent/WEB-INF/favicon-32x32.png\">");
		out.println(
				"<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"https://raw.githubusercontent.com/giantolentino/simplycaffeine/test/WebContent/WEB-INF/favicon-16x16.png\">");
		out.println("        <link rel=\"stylesheet\" href=\"logo.css\">");

		out.println(" <title>Order Successful</title>");

		out.println("<style>");

		out.println(
				"@keyframes slide { 0% {	opacity: 0;	transform: translateY(70%);}100%{opacity: 1;transform: translateY(0%);}}");
		out.println(
				"@-webkit-keyframes slide { 0% {opacity: 0;	-webkit-transform: translateY(70%);}100%{opacity: 1;-webkit-transform: translateY (0%);}}");
		out.println(
				"@media screen and (max-width: 768px) {	.col-sm-4 {		text-align: center;		margin: 25px 0;	}	.btn-lg {		width: 100%;		margin-bottom: 35px;	}}");
		out.println("@media screen and (max-width: 480px) {	.logo {		font-size: 150px;	}}");
		out.println(
				".jumbotron {	background-color: #1C403E;	color: #fff;	padding-bottom: 2px;	padding-top: 2px;	font-family: Montserrat, sans-serif;}");
		out.println(" .picture img { max-width: 10%; min-width: 170px;		 height: auto;}");

		out.println("</style>");

		out.println("</head>");

		out.println("<body  id=\"myPage\" data-spy=\"scroll\" data-target=\".navbar\" data-offset=\"60\">");

		out.println("<div class=\"jumbotron text-center\">");
		out.println(
				"	<img src=\"https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/oldfiles/logo/LOGOpage.jpg\" width=10% height=15%>");
		out.println("	<h3>Simply Caffeine</h3>");
		out.println("<p>We will deliver coffee to your class!</p>");
		out.println("</div>");

		out.println("<div class=\"container\">");

		out.println("<h3 class=\"text-success\">Order successful! Thank you for your business!</h3>");
		out.print("</body></html>");

		for (StatUserInfoOneDrink stat : stats) {
			int userID = stat.getUserID();
			Double total = stat.getTotal();

			processOrder(userID, total);
		}
		
	}

	public void processOrder(int userID, Double amount) throws IOException {

		// local host
		String userDB = "/Users/V/eclipse/java-neon/eclipse/UserInfo.csv"; // make
																			// sure
																			// this
																			// file
																			// exists
		// //server
		// String userDB = "UserInfo.csv";
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
				String data = "Charge credit card Number " + cardNum + " total of " + amount;
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
