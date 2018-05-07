package pl.coderslab.controlerUserLogged;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;

/**
 * Servlet implementation class SolutionEditServlet
 */
@WebServlet("/SolutionEditServlet")
public class SolutionEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolutionEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String solutionDescription = request.getParameter("solutionDescription");
		int solutionExcerciseID = Integer.valueOf(request.getParameter("excercise"));
		int solutionID = Integer.valueOf(request.getParameter("solutionID"));
		try {
			Solution solution = SolutionDao.loadSolutionById(solutionID);
			solution.setDescription(solutionDescription);
			solution.setExcercise_id(solutionExcerciseID);
			SolutionDao.saveToDB(solution);			
		} catch (Exception e) {
			// TODO: handle exception
		}
		request.setAttribute("solutionID", solutionID);
		getServletContext().getRequestDispatcher("/WEB-INF/views/solutionEditView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
