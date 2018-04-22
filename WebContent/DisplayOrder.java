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

import simplycaffeine.model.OrderEntry;

@WebServlet(urlPatterns = "/DisplayOrder")
public class DisplayOrder extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DisplayOrder() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// create some test data for display
		List<OrderEntry> entries = new ArrayList<OrderEntry>();
		entries.add(new OrderEntry(1, "kh", "235","1","05","pm"));
		entries.add(new OrderEntry(2, "sh", "235","1","05","pm"));

		// stored the data somewhere that can be accessed by this servlet
		// and other servlets.
		getServletContext().setAttribute("entries", entries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // Set refresh, autoload time as 5 seconds
	      response.setIntHeader("Refresh", 5);
		request.getRequestDispatcher("/DisplayOrder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
