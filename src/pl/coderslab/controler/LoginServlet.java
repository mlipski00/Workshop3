package pl.coderslab.controler;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;
import pl.coderslab.utils.BCrypt;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		int userID = 0;
		boolean validLogin = false, validPassword = false;
		try {
			List<User> users = UserDao.loadAllUsers();

			for (User user : users) {
				if (user.getEmail().equals(login)) {
					validLogin = true;
					validPassword = BCrypt.checkpw(password, user.getPassword());
					userID = user.getId();
				}
			}
		} catch (Exception e) {
			response.getWriter().append(e.getMessage().toString());
		}

		if (login == null || password == null) {
			getServletContext().getRequestDispatcher("/WEB-INF/views/indexLoggingError.jsp").forward(request, response);
		} else if (validLogin == true && validPassword == true) {
			session.setAttribute("isLogged", "user");
			session.setAttribute("userID", userID);
			getServletContext().getRequestDispatcher("/indexUserLogged.jsp").forward(request, response);
		} else if (login.equals("admin") && password.equals("password")) {
			session.setAttribute("isLogged", "admin");
			getServletContext().getRequestDispatcher("/indexLogged.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/WEB-INF/views/indexLoggingError.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
