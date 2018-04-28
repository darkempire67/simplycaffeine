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

import simplycaffeine.model.StatUserInfoOneDrink;
import simplycaffeine.model.User;

@WebServlet("/OrderDatabase")
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
		List<StatUserInfoOneDrink> stats = (List<StatUserInfoOneDrink>) getServletContext().getAttribute("stats");

		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0");
		out.print("Transitional//EN\">\n");
		out.print("<html><head><title>Order</title></head>\n<body>");

		for (StatUserInfoOneDrink stat : stats) {
			int userID = stat.getUserID();
			Double total = stat.getTotal();

	//		processOrder(userID, total);

			String sql = "update usersinfo set charge = " + total + "where id = " + userID ;

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

					ResultSet result = stmt.executeQuery("select * from usersinfo");
					ResultSetMetaData meta = result.getMetaData();

					int numberOfColumns = meta.getColumnCount();

					// Create a table with headings that match the result set
					out.println("<table>");
					out.println("<tr>");

					for (int i = 1; i <= numberOfColumns; i++) {
						String columnName = meta.getColumnName(i);
						out.println("	<th>" + columnName + "</th>");
					}

					out.println("</tr>");

					while (result.next()) {
						out.println("<tr>");
						for (int i = 1; i <= numberOfColumns; i++) {
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
}