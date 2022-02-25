package connector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSession {
	private SessionFactory sessionFactory;
	private Session session;
	
	public GetSession(){
		super();
	}
	
	public Session getSession()
	{
		if(session==null)
		{
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			this.session = sessionFactory.openSession();
		}
		else /// if current session is existed 
			this.session=sessionFactory.getCurrentSession(); 
		
		return session;
		
	}

}
