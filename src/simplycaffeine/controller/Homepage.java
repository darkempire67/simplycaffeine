package simplycaffeine.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import simplycaffeine.model.CoffeeEntry;
import simplycaffeine.model.OrderEntry;
import simplycaffeine.model.ReplenishInfo;
import simplycaffeine.model.StatUserInfoOneDrink;
import simplycaffeine.model.User;

@WebServlet(urlPatterns = "/Homepage", loadOnStartup = 1)
public class Homepage extends HttpServlet {

	int idSeed = 1;
	int id = 0;
	private static final long serialVersionUID = 1L;

	public Homepage() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<OrderEntry> entries = new ArrayList<OrderEntry>();
		List<CoffeeEntry> coffeeEntries = new ArrayList<CoffeeEntry>();
		List<User> userEntries = new ArrayList<User>();
		List<StatUserInfoOneDrink> stats = new ArrayList<StatUserInfoOneDrink>();
		List<ReplenishInfo> reps = new ArrayList<ReplenishInfo>();

		getServletContext().setAttribute("reps", reps);
		getServletContext().setAttribute("stats", stats);
		getServletContext().setAttribute("entries", entries);
		getServletContext().setAttribute("coffeeEntries", coffeeEntries);
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

		request.getRequestDispatcher("/WEB-INF/Homepage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");

		List<User> userEntries = (List<User>) getServletContext().getAttribute("userEntries");

		List<CoffeeEntry> coffeeEntries = (List<CoffeeEntry>) getServletContext().getAttribute("coffeeEntries");

		List<StatUserInfoOneDrink> stats = (List<StatUserInfoOneDrink>) getServletContext().getAttribute("stats");

		List<ReplenishInfo> reps = (List<ReplenishInfo>) getServletContext().getAttribute("reps");

		String firstName = user.getFirst();
		String coffeeName = request.getParameter("coffeeName");
		String quantity = request.getParameter("quantity");
		String cost = request.getParameter("price");

		if (coffeeName != null) {

			Double totalcost = Double.parseDouble(cost) * Integer.parseInt(quantity);

			CoffeeEntry coffeeEntry = new CoffeeEntry(idSeed++, coffeeName, quantity, cost, totalcost);

			coffeeEntries.add(coffeeEntry);

			Double sumTotal = 0.00;

			for (int i = 0; i < coffeeEntries.size(); i++) {
				sumTotal += coffeeEntries.get(i).getTotalCost();

			}

			User userEntry = new User(firstName, coffeeName, quantity, sumTotal);

			userEntries.add(userEntry);

			request.getServletContext().setAttribute("sumTotal", sumTotal);
		}

		String building = request.getParameter("building");
		String roomNumber = request.getParameter("roomNumber");
	
		if (building == null || building.isEmpty() || roomNumber.isEmpty() || roomNumber == null) {
			
			response.sendRedirect("Homepage#checkout");
		return;
		}
		if (building != null || roomNumber != null) {
			/* String roomNumber = request.getParameter("roomNumber"); */
			String hour = request.getParameter("hour");
			String minute = request.getParameter("minutes");
			String period = request.getParameter("period");
			String coffeeName1 = "";
			String quantity1 = "";
			Double sumTotal = 0.0;
			int userId;

			for (User userEntry : userEntries) {
				if (user.getFirst().equals(userEntry.getFirst())) {

					coffeeName1 = userEntry.getCoffeeName();
					quantity1 = userEntry.getQuantity();
					userId = user.getId();

					sumTotal = userEntry.getSumTotal();

					OrderEntry entry = new OrderEntry(id++, firstName, coffeeName1, quantity1, building, roomNumber,
							hour, minute, period);

					List<OrderEntry> entries = (List<OrderEntry>) getServletContext().getAttribute("entries");
					entries.add(entry);

					StatUserInfoOneDrink stat = new StatUserInfoOneDrink(userId, sumTotal);
					stats.add(stat);

					ReplenishInfo rep = new ReplenishInfo(quantity1, coffeeName);
					reps.add(rep);

				}
			}

			sumTotal = null;

			request.getServletContext().setAttribute("sumTotal", sumTotal);

			coffeeEntries.clear();

			response.sendRedirect("Homepage");

		}

	}
}
