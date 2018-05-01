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

@WebServlet(urlPatterns = "/DisplayOrder")
public class DisplayOrder extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DisplayOrder() {
		super();
	}

public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<OrderEntry> entries = (List<OrderEntry>) getServletContext().getAttribute("entries");

		List<CoffeeEntry> coffeeEntries = (List<CoffeeEntry>) getServletContext().getAttribute("coffeeEntries");
}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<OrderEntry> entries = (List<OrderEntry>) getServletContext().getAttribute("entries");
		
		
	      response.setIntHeader("Refresh", 30);
	
	      request.getRequestDispatcher("/WEB-INF/DisplayOrder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
