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
 * Servlet implementation class ExcerciseDeleteServlet
 */
@WebServlet("/ExcerciseDeleteServlet")
public class ExcerciseDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcerciseDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int excerciseID = 0;
		
		try {
			excerciseID  = Integer.parseInt(request.getParameter("excerciseID"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		Excercise excercise;
		try {
			excercise = ExcerciseDao.loadExcerciseById(excerciseID);
			ExcerciseDao.delete(excercise);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("excerciseID", excerciseID);
		getServletContext().getRequestDispatcher("/WEB-INF/views/excerciseDeletedView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
