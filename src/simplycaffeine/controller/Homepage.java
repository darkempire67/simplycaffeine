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

import simplycaffeine.model.CoffeeEntry;
import simplycaffeine.model.OrderEntry;

/**
 * Servlet implementation class Homepage
 */

@WebServlet(urlPatterns = "/Homepage", loadOnStartup = 1)
public class Homepage extends HttpServlet {

	int idSeed = 1;
	private static final long serialVersionUID = 1L;

	public Homepage() {
		super();
	}
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// create some test data for display
		List<CoffeeEntry> coffeeEntries = new ArrayList<CoffeeEntry>();
		
		// stored the data somewhere that can be accessed by this servlet
		// and other servlets.
		getServletContext().setAttribute("coffeeEntries", coffeeEntries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Homepage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the user input
		String coffeeName = request.getParameter("coffeeName");
		String quantity = request.getParameter("quantity");
		String cost = request.getParameter("value");



		// create a new order
		CoffeeEntry coffeeEntry = new CoffeeEntry(idSeed++, coffeeName, quantity, cost);

		// add the new entry to the oder
		List<CoffeeEntry> coffeeEntries = (List<CoffeeEntry>) getServletContext().getAttribute("coffeeEntries");
		coffeeEntries.add(coffeeEntry);
		
		String building = request.getParameter("building");
		String roomNumber = request.getParameter("roomNumber");
		String hour = request.getParameter("hour");
		String minute = request.getParameter("minutes");
		String period = request.getParameter("period");


		// create a new order
		OrderEntry entry = new OrderEntry(idSeed++, building, roomNumber, hour, minute, period);

		// add the new entry to the order
		List<OrderEntry> entries = (List<OrderEntry>) getServletContext().getAttribute("entries");
		entries.add(entry);

		// send data to the display order
//		response.sendRedirect("DisplayOrder");
		response.sendRedirect("Homepage");

		// send data to the display order
//		response.sendRedirect("DisplayOrder");
//		response.sendRedirect("CheckOut");
	}

}
