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
import simplycaffeine.model.User;
import simplycaffeine.model.OrderEntry;

@WebServlet(urlPatterns = "/Homepage", loadOnStartup = 1)
public class Homepage extends HttpServlet {

	int idSeed = 1;
	private static final long serialVersionUID = 1L;

	public Homepage() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		List<OrderEntry> entries = new ArrayList<OrderEntry>();
		List<CoffeeEntry> coffeeEntries = new ArrayList<CoffeeEntry>();

		getServletContext().setAttribute("entries", entries);		
		getServletContext().setAttribute("coffeeEntries", coffeeEntries);
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

		String coffeeName = request.getParameter("coffeeName");
		if (coffeeName != null) {

			String quantity = request.getParameter("quantity");
			String cost = request.getParameter("price");

			Double totalcost = Double.parseDouble(cost) * Integer.parseInt(quantity);

			CoffeeEntry coffeeEntry = new CoffeeEntry(idSeed++, coffeeName, quantity, cost, totalcost);

			List<CoffeeEntry> coffeeEntries = (List<CoffeeEntry>) getServletContext().getAttribute("coffeeEntries");

			coffeeEntries.add(coffeeEntry);

			Double sumTotal = 0.00;
			for (int i = 0; i < coffeeEntries.size(); i++) {
				sumTotal += coffeeEntries.get(i).getTotalCost();

			}

			request.getServletContext().setAttribute("sumTotal", sumTotal);

		}

		String building = request.getParameter("building");

		if (building == null) {
			response.sendRedirect("Homepage#checkout");
		} else {

			String roomNumber = request.getParameter("roomNumber");
			String hour = request.getParameter("hour");
			String minute = request.getParameter("minutes");
			String period = request.getParameter("period");

		
			
			OrderEntry entry = new OrderEntry(idSeed++, building, roomNumber, hour, minute, period);

			List<OrderEntry> entries = (List<OrderEntry>) getServletContext().getAttribute("entries");
			entries.add(entry);

			response.sendRedirect("Homepage");

		}

	}

}
