package simplycaffeine.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplycaffeine.model.CoffeeEntry;


@WebServlet("/Delete")
public class DeleteCoffeeEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		List<CoffeeEntry> coffeeEntries = (List<CoffeeEntry>) getServletContext().getAttribute("coffeeEntries");
		for (CoffeeEntry entry : coffeeEntries)
			if (entry.getId().equals(id)) {
				coffeeEntries.remove(entry);
				
				break;
		}
		
		

		response.sendRedirect("Homepage#checkout");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}