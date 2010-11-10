package pl.mimuw.zpp.guestBook.dao;

import java.util.Date;

import org.hibernate.Session;

import pl.mimuw.zpp.guestBook.domain.Entry;
import pl.mimuw.zpp.guestBook.util.HibernateUtil;

public class EntryDAOImpl implements EntryDAO {

	@Override
	public void saveEntry(Entry e) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		e.setDate(new Date());
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();		
	}

}
