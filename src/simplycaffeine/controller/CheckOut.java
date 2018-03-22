package simplycaffeine.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplycaffeine.model.OrderEntry;

@WebServlet("/CheckOut")
public class CheckOut extends HttpServlet {

	private static final long serialVersionUID = 1L;

	int idSeed = 100;

	public CheckOut() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/CheckOut.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get the user input
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
	}

}
