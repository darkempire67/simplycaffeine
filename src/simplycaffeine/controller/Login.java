package simplycaffeine.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import simplycaffeine.model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	protected User getUser(String email, String password) {

		// For you to do...
		ArrayList<User> users = (ArrayList<User>) getServletContext().getAttribute("users");

		for (User user : users) {
			if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}

		return null;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// find user
		User user = getUser(email, password);

		if (user == null) {
			request.setAttribute("loginError", true);
			doGet(request, response);
		} else {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("Homepage");
		}
	}

}
