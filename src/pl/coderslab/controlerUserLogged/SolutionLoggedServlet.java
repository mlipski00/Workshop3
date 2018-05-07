package pl.coderslab.controlerUserLogged;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;

/**
 * Servlet implementation class SolutionLoggedServlet
 */
@WebServlet("/SolutionLoggedServlet")
public class SolutionLoggedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolutionLoggedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Solution> solutionList = new ArrayList<>();
		try {
			solutionList = SolutionDao.loadAllSolutionsByUserID(Integer.valueOf(request.getParameter("userID")));
		} catch (Exception e) {
			response.getWriter().append(e.getMessage().toString());
		}
		request.setAttribute("solutionList", solutionList);
		getServletContext().getRequestDispatcher("WEB-INF/views/solutionLoggedList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
