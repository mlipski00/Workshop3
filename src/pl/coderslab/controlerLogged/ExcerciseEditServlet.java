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

/**
 * Servlet implementation class ExcerciseEditServlet
 */
@WebServlet("/ExcerciseEditServlet")
public class ExcerciseEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExcerciseEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int excerciseID = 0;
		String excerciseTitle = request.getParameter("excerciseTitle");
		String excerciseDescription = request.getParameter("excerciseDescription");

		try {
			excerciseID = Integer.parseInt(request.getParameter("excerciseID"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(excerciseID + "|" + excerciseTitle + "|" + excerciseDescription);
		Excercise excercise = new Excercise(excerciseID, excerciseTitle, excerciseDescription);
		System.out.println(excercise);
		try {
			ExcerciseDao.saveToDB(excercise);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("excerciseID", excerciseID);
		getServletContext().getRequestDispatcher("/WEB-INF/views/excerciseEditView.jsp").forward(request, response);
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
