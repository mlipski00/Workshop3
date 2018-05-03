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

import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDao;

/**
 * Servlet implementation class GroupLoggedServlet
 */
@WebServlet("/GroupLoggedServlet")
public class GroupLoggedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupLoggedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Group> groupList = new ArrayList<>();
		try {
			groupList = GroupDao.loadAllGroups();
		} catch (SQLException e) {
			response.getWriter().append("SQL error");
			e.printStackTrace();
		}
		request.setAttribute("groupList", groupList);
		System.out.println(groupList);
		getServletContext().getRequestDispatcher("/WEB-INF/views/groupLoggedList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
