package pl.coderslab.controlerUserLogged;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;

/**
 * Servlet implementation class SolutionAddServlet
 */
@WebServlet("/SolutionAddServlet")
public class SolutionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolutionAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int userID = (int)  session.getAttribute("userID");
		String solutionDescription = request.getParameter("solutionDescription");
		int excerciseID = Integer.valueOf(request.getParameter("excercise"));
		Solution solution = new Solution(solutionDescription, excerciseID, userID);
		try {
			SolutionDao.saveToDB(solution);
		} catch (Exception e) {
		}
		int solutionID = solution.getId();
		System.out.println(solution.getId());
		request.setAttribute("solutionID", solutionID);
		getServletContext().getRequestDispatcher("/WEB-INF/views/solutionAddedView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
