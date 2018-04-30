package simplycaffeine.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplycaffeine.model.StatUserInfoOneDrink;

@WebServlet("/UserStats")
public class UserStats extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
		List<StatUserInfoOneDrink> userStats = (List<StatUserInfoOneDrink>) getServletContext()
				.getAttribute("userStats");

		getServletContext().setAttribute("userStats", userStats);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<StatUserInfoOneDrink> userStats = (List<StatUserInfoOneDrink>) getServletContext()
				.getAttribute("userStats");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		out.println(
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println("        <title>User Statistic</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("	<p class=\"text-right\"><a href=\"DisplayOrder\">Display Order</a>	</p>");
//		out.println("	<p class=\"text-right\"><a href=\"Inventory\">Inventory</a>	</p>");

		for (StatUserInfoOneDrink userStat : userStats) {
			int userID = userStat.getUserID();
			int quantity = userStat.getQty();
			String coffeeName = userStat.getCoffeeName();

			// processOrder(userID, total);

			
			String sql = "update userStats set "+ coffeeName +" = " + ( + quantity ) + " where userID = " + userID;
		
			System.out.println(sql);
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

					ResultSet result = stmt.executeQuery("select * from userStats where userID = " + userID);
					ResultSetMetaData meta = result.getMetaData();

					int numberOfColumns = meta.getColumnCount();

					// Create a table with headings that match the result set
					out.println("<table>");
					out.println("<tr>");

					for (int i = 1; i < numberOfColumns; i++) {
						String columnName = meta.getColumnName(i);
						out.println("	<th>" + columnName + "</th>");
					}

					out.println("</tr>");

					while (result.next()) {
						out.println("<tr>");
						for (int i = 1; i < numberOfColumns; i++) {
							String columnValue = result.getString(i);
							out.println("<td>" + columnValue + "</td>");
						}
						out.println("</tr>");
					}

					out.println("</table>");
				
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

			out.print("</body></html>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
