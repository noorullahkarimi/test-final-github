package connector;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Member;

public class Db {

	// public Db() {
	// super();
	// SfInjector inj = new SfInjector();
	// this.session = inj.getSession();
	// }

	public static boolean insert(Member m) {
		System.out.println("===========db. class===" + m + "=====================");
		// connector.main(null);
		try {
			 System.out.println("=========111==========================");
			 SessionFactory sf = new
			 Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			 System.out.println("===========222========================");
			 Session session = sf.openSession();
//			GetSession gs = new GetSession();
//			Session session = gs.getSession();
//			System.out.println("=============333======================");
//			System.out.println(session.isOpen());
//			System.out.println("=============333======================");
			Transaction tx = session.beginTransaction();
			System.out.println("===========444========================");

			session.save(m);
			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
//			session.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("errorr occure");
		}
		return false;

	}
}
