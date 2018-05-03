package pl.coderslab.filters;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.coderslab.model.Group;
import pl.coderslab.model.GroupDao;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(urlPatterns = {"/ExcerciseLoggedServlet", "/GroupLoggedServlet", "/UserLoggedServlet", "/indexLogged.jsp", "/index.jsp"})
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();

		
		String loginValidation = (String) session.getAttribute("isLogged");
		//trzeba zamienić
		System.out.println("login valid " + loginValidation);
		if(loginValidation.equals("true") ) {
			//chain.doFilter(servletRequest, response);
			chain.doFilter(servletRequest, response);
		} else {
			servletResponse.sendRedirect("index.jsp");
		}
//		if (loginValidation.equals("true")) {
//			chain.doFilter(servletRequest, response);
//		} 
					
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
