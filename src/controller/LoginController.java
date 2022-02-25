package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import connector.Db;
import entity.Address;
import entity.Member;
import java.lang.reflect.*;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");// adding utf-8 for the persian
												// language
		Enumeration<String> parameters = request.getParameterNames();// get all
																		// parameter
																		// name
																		// to
																		// show
																		// them
																		// in
																		// the
																		// output
		System.out.println("----------------show all prameter-----------------");
		while (parameters.hasMoreElements()) {
			String key = (String) parameters.nextElement();
			System.out.println(key + ":" + request.getParameter(key));
		}
		System.out.println("-----------------------" + request.getParameter("debug") + "--"
				+ request.getParameter("username") + "-------------------------");
		run(request, response);

	}

	public static Object run(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// it is a router for the proccess request
		System.out.println("------------------>" + request.getParameter("debug"));
		switch (request.getParameter("debug")) {
		case "login":
			try {

				Member m = new Member();
				m.setPassword(request.getParameter("password"));
				m.setUsername(request.getParameter("username"));

				Address addre = new Address();
				addre.setAddress("esfahan-tehran");
				addre.setEmail("s@gmail.com");
				addre.setPhoneNumber(132978);
				addre.setZipcode(212818616);
				m.getAddress().add(addre);

				Db.insert(m);
////				Db.insert(addre);
				
				
//				
//				 System.out.println("=========111==========================");
//				 SessionFactory sf = new
//				 Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//				 System.out.println("===========222========================");
//				 Session session = sf.openSession();
////				GetSession gs = new GetSession();
////				Session session = gs.getSession();
////				System.out.println("=============333======================");
////				System.out.println(session.isOpen());
////				System.out.println("=============333======================");
//				Transaction tx = session.beginTransaction();
//				System.out.println("===========444========================");
//
//				session.save(m);
////				session.save(addre);
//				tx.commit();
//				session.close();
				
				
				
				
				
				
				 
//				StringBuilder script = new StringBuilder();
//				script.append(
//						"`<div style='positon:absolute;top:0;right:0;width:20%;height:10vh;'>this is the right </div>`");

//				response.setContentType("text/html;charset=UTF-8");
//				response.setCharacterEncoding("utf-8");
//				response.setHeader("Content-Type", "text/html;charset=UTF-8");
//				PrintWriter out = response.getWriter();
//				out.print(script);
//				out.close();
//				out.flush();

			} catch (Exception e) {
				e.fillInStackTrace();
			}
			break;
		case "register":
			System.out.print("register");
			break;
		default:
			break;
		}

		response.sendRedirect("login.jsp");
		return response;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
