package pl.coderslab.filters;

import java.io.IOException;
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

/**
 * Servlet Filter implementation class LoggedFilter
 */
@WebFilter("/index.jsp")
public class LoggedFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoggedFilter() {
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

		System.out.println("login valid " + loginValidation);
		if(loginValidation == null || loginValidation.equals("false")) {
			chain.doFilter(servletRequest, response);
			
		} else if (loginValidation.equals("admin")) {
			servletResponse.sendRedirect("indexLogged.jsp");	
		}
		else if (loginValidation.equals("user")) {
			servletResponse.sendRedirect("indexUserLogged.jsp");	
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
