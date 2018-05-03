package pl.coderslab.controlerLogged;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;

/**
 * Servlet implementation class UserEditServlet
 */
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		int id = 0;
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		int person_group_id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			person_group_id = Integer.parseInt(request.getParameter("userGroup"));	
		} catch (Exception e) {
			// TODO: handle exception
		}
		User user = new User(id, username, email, password, person_group_id);
		try {
			UserDao.saveToDB(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("id", id);
		getServletContext().getRequestDispatcher("/WEB-INF/views/userUpdatedView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
