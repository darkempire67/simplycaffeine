package simplycaffeine.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplycaffeine.model.OrderEntry;

@WebServlet("/Delivered")
public class Delivered extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Delivered() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		List<OrderEntry> entries = (List<OrderEntry>) getServletContext().getAttribute("entries");
		for (OrderEntry entry : entries)
			if (entry.getId().equals(id)) {
				entries.remove(entry);
				break;
			}

		response.sendRedirect("DisplayOrder");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
