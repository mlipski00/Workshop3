package pl.coderslab.controlerLogged;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;

/**
 * Servlet implementation class UserLoggedServlet
 */
@WebServlet("/UserLoggedServlet")
public class UserLoggedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoggedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<User> userList = new ArrayList<>();
		try {
			userList = UserDao.loadAllUsers();
		} catch (SQLException e) {
			response.getWriter().append("SQL error");
			e.printStackTrace();
		}
		request.setAttribute("userList", userList);
		System.out.println(userList);
		getServletContext().getRequestDispatcher("/WEB-INF/views/userLoggedList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
