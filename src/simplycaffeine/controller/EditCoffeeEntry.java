package simplycaffeine.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplycaffeine.model.CoffeeEntry;

@WebServlet("/Edit")
public class EditCoffeeEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected CoffeeEntry getEntry(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));

		List<CoffeeEntry> coffeeEntries = (List<CoffeeEntry>) getServletContext().getAttribute("coffeeEntries");

		for (CoffeeEntry coffeeEntry : coffeeEntries)
			if (coffeeEntry.getId() == id)
				return coffeeEntry;

		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set the content type to HTML
		response.setContentType("text/html");

		// Get a Print Writer
		PrintWriter out = response.getWriter();

		// Generate the template HTML
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		out.println(
				"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println("        <title>Edit Entry</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		CoffeeEntry coffeeEntry = getEntry(request);

		// If we can't find the entry, go back to the guestbook
		if (coffeeEntry == null) {
			response.sendRedirect("Homepage");
			return;
		}

		out.println("<form action=\"Edit\" method=\"post\">");

		out.println("	Coffee :<input class=\"form-control \" id=\"disabledInput\" type=\"text\" "
				+ "name=\"coffeeName\" value=\"" + coffeeEntry.getCoffeeName() + "\" disabled>");
		out.println("	<br>");

		out.println("	<input type=\"hidden\" name=\"id\" value=\"" + coffeeEntry.getId() + "\" >");

		out.println("Quantity: <input class=\"form-control \" type=\"text\" name=\"quantity\" value=\"" + coffeeEntry.getQuantity() + "\">");
		out.println("	<br>");
		
		out.println("	<input class=\"btn btn-success \" type=\"submit\" value=\"Save \">");
		out.println("</form>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String quantity = request.getParameter("quantity");

		CoffeeEntry coffeeEntry = getEntry(request);
		coffeeEntry.setQuantity(quantity);
	
		String cost = coffeeEntry.getCost();
		Double totalCost = Double.parseDouble(cost) * Integer.parseInt(quantity);
		
		coffeeEntry.setTotalCost(totalCost);
		
		Double sumTotal = 0.00;
	
			sumTotal += totalCost;
	
		
		request.getServletContext().setAttribute("sumTotal", sumTotal);
		
		response.sendRedirect("Homepage#checkout");
	}

}
