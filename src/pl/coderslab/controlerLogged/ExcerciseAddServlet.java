package pl.coderslab.controlerLogged;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Excercise;
import pl.coderslab.model.ExcerciseDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;

/**
 * Servlet implementation class ExcerciseAddServlet
 */
@WebServlet("/ExcerciseAddServlet")
public class ExcerciseAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcerciseAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id;
		String excerciseTitle = request.getParameter("excerciseTitle");
		String excerciseDescription = request.getParameter("excerciseDescription");

		Excercise excercise = new Excercise(excerciseTitle, excerciseDescription);
		System.out.println(excercise);
		try {
			ExcerciseDao.saveToDB(excercise);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		id = excercise.getId();
		request.setAttribute("newID", id);
		getServletContext().getRequestDispatcher("/WEB-INF/views/excerciseAddedView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
