package com.example;

import java.io.IOException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String user = request.getParameter("name");
				String pwd = request.getParameter("pwd");
				String email = request.getParameter("email");
				try {
					SessionFactory factory = HibernateUtil.getSessionFactory();
					Session session = factory.openSession();
					CriteriaBuilder builder = session.getCriteriaBuilder();
					CriteriaQuery<User> query = builder.createQuery(User.class);
					Root<User> root = query.from(User.class);
					query.select(root).where(builder
												.equal(root.get("email"), email)).where(builder
																							.equal(root.get("password"), pwd));
					Query<User> q = session.createQuery(query);
					if (q.list().size() == 0) {
						response.sendRedirect(request.getContextPath() + "/login.jsp");
					}
					else {
						User returnedUser = q.getSingleResult();
						
						response.sendRedirect(request.getContextPath() + "/landingpage.jsp");
					}					

					System.out.println("Closing session");
					session.close();
					
				} catch (Exception ex) {
					ex.getStackTrace();
				}
	}

}
