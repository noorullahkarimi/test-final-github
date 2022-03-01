package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import connector.DaoInterface;
import connector.DaoInterfaceImpl;
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

	public static Object run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// it is a router for the proccess request
		System.out.println("------------------>" + request.getParameter("debug"));
		switch (request.getParameter("debug")) {
		case "login":
			try {
				DaoInterface d = new DaoInterfaceImpl();

//				Member m = new Member();
//				String user= request.getParameter("username").toString();
//				String pass = request.getParameter("password").toString();
//			
//				Boolean result = Db.select(user,pass);
				
				d.choose(request);
				
				String script = "hello world !";
				
				response.setContentType("text/html;charset=UTF-8");
		        response.setCharacterEncoding("utf-8");
		        response.setHeader("Content-Type", "text/html;charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        out.print(script);
		        out.close();
		        out.flush();
				
			} catch (Exception e) {
				e.fillInStackTrace();
			}
			break;
		case "switchregister":
			RequestDispatcher requestDispatcher; 
			requestDispatcher = request.getRequestDispatcher("register.jsp");
			requestDispatcher.forward(request, response);
			break;
		case "switchlogin":
			RequestDispatcher requestDispatcherLogin; 
			requestDispatcherLogin = request.getRequestDispatcher("login.jsp");
			requestDispatcherLogin.forward(request, response);
			break;
		case "register":
			try {
				DaoInterface dao = new DaoInterfaceImpl();

//				Member m = new Member();
//				m.setPassword(request.getParameter("password"));
//				m.setUsername(request.getParameter("username"));
//
//				Address addre = new Address();
//				addre.setAddress(request.getParameter("address"));
//				addre.setEmail(request.getParameter("email"));
//				
//				addre.setPhoneNumber(Integer.parseInt(request.getParameter("phonenumber")));
//				addre.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
//				
//				m.getAddress().add(addre);
//
//				Db.insert(m);
				System.out.println("coming to register");
				dao.add(request);
				response.sendRedirect("register.jsp");
			} catch (Exception e) {
				e.fillInStackTrace();
			}
			break;
		default:
			break;
		}

//		response.sendRedirect("login.jsp");
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
