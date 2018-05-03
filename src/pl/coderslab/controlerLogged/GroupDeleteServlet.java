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
import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDao;

/**
 * Servlet implementation class GroupDeleteServlet
 */
@WebServlet("/GroupDeleteServlet")
public class GroupDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int groupID = 0;
		
		try {
			groupID  = Integer.parseInt(request.getParameter("groupID"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		Group group;
		try {
			group = GroupDao.loadGroupById(groupID);
			GroupDao.delete(group);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("groupID", groupID);
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
