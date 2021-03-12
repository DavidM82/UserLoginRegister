package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		
		
		//out.println(request.getParameter("name"));
		//out.println(request.getParameter("pwd"));
		//out.println(request.getParameter("email"));
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			
			Session session = factory.openSession();
			
			User user = new User(request.getParameter("name"), request.getParameter("email"), request.getParameter("pwd"));	
			
			session.save(user);
			session.close();
			out.println("<br> <h3>User has been added to the database.</h3>");
			out.println("<a href='index.jsp'>Return to index</a>");
			
		} catch(Exception ex) {
			ex.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
