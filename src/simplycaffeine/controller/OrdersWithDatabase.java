package simplycaffeine.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import simplycaffeine.model.StatUserInfoOneDrink;
import simplycaffeine.model.User;

@WebServlet("/OrderSuces")
public class OrdersWithDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}

		List<User> userEntries = new ArrayList<User>();

		getServletContext().setAttribute("userEntries", userEntries);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		  HttpSession session = request.getSession();
		  
		  User user = (User) session.getAttribute("user");
		  
		  if (user == null) { response.sendRedirect("Login"); return; }
		 

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
				"	<img src=\"https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/oldfiles/logo/LOGOpage.jpg\" width=10% height=20%>");
		out.println("	<h3>Simply Caffeine</h3>");
		out.println("<p>We will deliver coffee to your class!</p>");
		out.println("</div>");

		out.println("<div class=\"container\">");

		for (StatUserInfoOneDrink stat : stats) {
			int userID = stat.getUserID();
			Double total = stat.getTotal();

			
			// processOrder(userID, total);

			String sql = "update usersinfo set charge = " + total + "where id = " + userID;

			// Is there a query to submit?
			if (sql != null && sql.trim().length() > 0) {
				Connection c = null;
				try {
					String url = "jdbc:mysql://cs3.calstatela.edu/cs3337stu01";
					String username = "cs3337stu01";
					String password = "OK#jT.#e";

					// Create a connection
					c = DriverManager.getConnection(url, username, password);

					// Create a new statement and execute it
					Statement stmt = c.createStatement();
					int rs = stmt.executeUpdate(sql);
					/*
					 * ResultSet result =
					 * stmt.executeQuery("select * from usersinfo");
					 * ResultSetMetaData meta = result.getMetaData();
					 * 
					 * int numberOfColumns = meta.getColumnCount();
					 * 
					 * // Create a table with headings that match the result set
					 * out.println("<table>"); out.println("<tr>");
					 * 
					 * for (int i = 1; i <= numberOfColumns; i++) { String
					 * columnName = meta.getColumnName(i);
					 * out.println("	<th>" + columnName + "</th>"); }
					 * 
					 * out.println("</tr>");
					 * 
					 * while (result.next()) { out.println("<tr>"); for (int i =
					 * 1; i <= numberOfColumns; i++) { String columnValue =
					 * result.getString(i); out.println("<td>" + columnValue +
					 * "</td>"); } out.println("</tr>"); }
					 */
					// out.println("<h3 class=\"text-success\">Order successful!
					// Thank you for your business!</h3>");
				} catch (SQLException e) {
					throw new ServletException(e);
				} finally {
					try {
						if (c != null)
							c.close();
					} catch (SQLException e) {
						throw new ServletException(e);
					}
				}
			}

		}
		out.println("<h3 class=\"text-success\">Order successful! Thank you for your business!</h3>");
		out.print("</body></html>");
	}
}