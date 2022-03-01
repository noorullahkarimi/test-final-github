package connector;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.mysql.cj.Query;

import entity.Member;

public class Db {

	public static boolean insert(Member m) {
		System.out.println("===========db. class===" + m + "=====================");
		try {
			System.out.println("=========111==========================");
			SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			System.out.println("===========222========================");
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			System.out.println("===========444========================");

			session.save(m);
			tx.commit();
			session.close();
			System.out.println("this do is work");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("errorr occure");
		}
		return false;

	}

	public static boolean select(String usename, String password) {

		try {
			System.out.println("=========111==========================");
			SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			System.out.println("===========222========================");
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			String tablename = "entity.Member";
			System.out.println(Member.class);
			Criteria crit = session.createCriteria(tablename);
			crit.add(Restrictions.eq("username", usename));
			crit.add(Restrictions.eq("password", password));
			 List<Member> result = crit.list();
			 

			 for(Member b :result)
				{
					System.out.println(b.getUsername());
				}

			tx.commit();
			session.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("errorr occure");
		}
		return false;

	}
}
