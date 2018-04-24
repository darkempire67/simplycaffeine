package simplycaffeine.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplycaffeine.model.User;

@WebServlet(urlPatterns = { "/Register" }, loadOnStartup = 1)
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int id = 1;
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		// Create the Array of Users
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User(1,"Cris", "Ramos", "cris@ramos.com", "abcd"));
		users.add(new User(2,"Gian", "Tolentino", "gian@tolentino.com", "abcd"));
		users.add(new User(3,"Leonardo", "Gallegos", "leonardo@gallegos.com", "abcd"));
		users.add(new User(4,"Vay", "Tang", "vay@tang.com", "abcd"));

		getServletContext().setAttribute("users", users);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Do we have any errors?
		String nameError = (String) request.getAttribute("nameError");
		String emailError = (String) request.getAttribute("emailError");
		String passwordError = (String) request.getAttribute("passwordError");
		String password2Error = (String) request.getAttribute("password2Error");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		name = name == null ? "" : name;
		email = email == null ? "" : email;
		password1 = password1 == null ? "" : password1;
		password2 = password2 == null ? "" : password2;

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
		out.println(
				"       <link rel=\"icon\" type=\"image/png\" sizes=\"32x32\" href=\"https://raw.githubusercontent.com/giantolentino/simplycaffeine/test/WebContent/WEB-INF/favicon-32x32.png\">");
		out.println(
				"<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"https://raw.githubusercontent.com/giantolentino/simplycaffeine/test/WebContent/WEB-INF/favicon-16x16.png\">");

		out.println("        <title>Register</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<h1 class=\"display-1\">Register</h1>");

		out.println("<form action=\"Register\" method=\"post\">");
		out.println("    <div class=\"form-group\">");
		out.println("        <label for=\"name\">Full Name</label>");

		if (nameError != null) {
			out.println("        <input class=\"form-control is-invalid\"  value=\"" + name
					+ "\" type=\"text\" name=\"name\" id=\"name\" placeholder=\"Enter your first and last names\">");
			out.println("        <div class=\"invalid-feedback\">" + nameError + "</div>");
		} else
			out.println("        <input class=\"form-control\" type=\"text\" value=\"" + name
					+ "\" name=\"name\" id=\"name\" placeholder=\"Enter your first and last names\">");

		out.println("    </div>");
		out.println("    <div class=\"form-group\">");
		out.println("        <label for=\"email\">E-mail Address</label>");

		if (emailError != null) {
			out.println("        <input class=\"form-control is-invalid\" value=\"" + email
					+ "\" type=\"email\" name=\"email\" id=\"email\" placeholder=\"Enter your e-mail address\">");
			out.println("        <div class=\"invalid-feedback\">" + emailError + "</div>");
		} else
			out.println("        <input class=\"form-control\" value=\"" + email
					+ "\" type=\"email\" name=\"email\" id=\"email\" placeholder=\"Enter your e-mail address\">");

		out.println("    </div>");
		out.println("    <div class=\"form-group\">");
		out.println("        <label for=\"password\">Credit Card Number</label>");

		if (passwordError != null) {
			out.println("        <input class=\"form-control is-invalid\" value=\"" + password1
					+ "\" type=\"password\" name=\"password1\" id=\"password1\" placeholder=\"Enter your credit card number\">");
			out.println("        <div class=\"invalid-feedback\">" + passwordError + "</div>");
		} else
			out.println("        <input class=\"form-control\" value=\"" + password1
					+ "\" type=\"password\" name=\"password1\" id=\"password1\" placeholder=\"Enter your credit card number\">");

		out.println("    </div>");
		out.println("    <div class=\"form-group\">");
		out.println("        <label for=\"password\">Re-Enter Credit Card Number</label>");

		out.println("        <input class=\"form-control\" value=\"" + password2
				+ "\" type=\"password\" name=\"password2\" id=\"password2\" placeholder=\"Re-enter your credit card number\">");

		out.println("    </div>");
		out.println("    <div class=\"form-group\">");
		out.println("        <button type=\"submit\" class=\"btn btn-primary\">Register</button>");
		out.println("    </div>");
		out.println("</form>");
		out.println("<p>Already have an account? <a href=\"Login\">Login</a></p>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
//		request.getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
	}

	protected void displayWelcome(User user, HttpServletResponse response) throws ServletException, IOException {
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
		out.println("        <title>Success</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");

		out.println("<h1 class=\"display-1\">Welcome, " + user.getFirst() + "!</h1>");
		out.println("<p class=\"lead\">You have successfully registered!</p>");
		out.println("<a href=\"Login\" class=\"btn btn-primary\">Login</a>");

		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Parse the request parameters and validate
		String fullName = request.getParameter("name");
		String email = request.getParameter("email");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");

		String nameError = (String) request.getAttribute("nameError");
		String emailError = (String) request.getAttribute("emailError");
		String passwordError = (String) request.getAttribute("passwordError");

		// Assume there are no errors to begin with
		boolean hasError = false;

		// validate name

		if (fullName.equals("") || null == fullName) {
			nameError = "You must enter your ful name!";
			request.setAttribute("nameError", nameError);
			hasError = true;
		} else {
			String username = fullName;
			String[] nameSplit = username.split("\\s+");

			if (nameSplit.length >= 2) {
				String firstName = nameSplit[0];
				String lastName = nameSplit[1];
				request.setAttribute("firstName", firstName);
				request.setAttribute("lastName", lastName);
			} else {
				nameError = "You must enter your last name!";
				request.setAttribute("nameError", nameError);

				hasError = true;
			}

		}

		// validate e-mail
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);

		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

		if (email.equals("") || email == null || !matcher.find()) {

			emailError = "You must provide an e-mail address.";
			request.setAttribute("emailError", emailError);
			hasError = true;
		}

		// validate password
		if (password1 == "" || password1 == null || password2 == "" || password2 == null)

		{
			passwordError = "You must enter your credit card number!";
			request.setAttribute("passwordError", passwordError);
			hasError = true;
		}
		if (!password1.equals(password2)) {
			passwordError = "The numbers do not match";
			request.setAttribute("passwordError", passwordError);
			hasError = true;
		}

		String firstName = (String) request.getAttribute("firstName");
		String lastName = (String) request.getAttribute("lastName");

		if (hasError) {
			doGet(request, response);
		} else {

			User newUser = new User(id++,firstName, lastName, email, password1);
			ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");
			users.add(newUser);
			displayWelcome(newUser, response);

		}
	}
}
