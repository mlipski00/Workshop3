package pl.coderslab.controlerUserLogged;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;
import pl.coderslab.model.User;
import pl.coderslab.model.UserDao;

/**
 * Servlet implementation class SolutionDeleteServlet
 */
@WebServlet("/SolutionDeleteServlet")
public class SolutionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolutionDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int solutionID = 0;
		
		try {
			solutionID  = Integer.parseInt(request.getParameter("solutionID"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		Solution solution;
		try {
			solution = SolutionDao.loadSolutionById(solutionID);
			SolutionDao.delete(solution);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("solutionID", solutionID);
		getServletContext().getRequestDispatcher("/WEB-INF/views/solutionDeletedView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
