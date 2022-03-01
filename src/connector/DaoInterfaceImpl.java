package connector;

import javax.servlet.http.HttpServletRequest;

import entity.Address;
import entity.Member;

public class DaoInterfaceImpl implements DaoInterface{

	@Override
	public boolean add(HttpServletRequest request) {
		System.out.println("coming to daoInterface");
		Member m = new Member();
		m.setPassword(request.getParameter("password"));
		m.setUsername(request.getParameter("username"));

		Address addre = new Address();
		addre.setAddress(request.getParameter("address"));
		addre.setEmail(request.getParameter("email"));
		
		addre.setPhoneNumber(Integer.parseInt(request.getParameter("phonenumber")));
		addre.setZipcode(Integer.parseInt(request.getParameter("zipcode")));
		
		m.getAddress().add(addre);
		System.out.println("dao interface is up");
		
		return Db.insert(m);
		
	}

	@Override
	public boolean choose(HttpServletRequest request) {
		Member m = new Member();
		
		String user= request.getParameter("username").toString();
		String pass = request.getParameter("password").toString();
		
		Boolean result = Db.select(user,pass);
	
		return result;
	}
	
	

}
