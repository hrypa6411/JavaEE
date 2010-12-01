package pl.mimuw.zpp.guestBook.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import pl.mimuw.zpp.guestBook.domain.Entry;
import pl.mimuw.zpp.guestBook.util.HibernateUtil;

public class EntryDAOImpl implements EntryDAO {
	
	public EntryDAOImpl() {
		System.out.println("Utworzyłem obiekt EntryDAOImpl");
	}

	@Override
	public void saveEntry(Entry e) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		e.setDate(new Date());
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();		
	}
	
	public List<Entry> getEntries() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Entry> entries = (List<Entry>)session.createQuery("from Entry").list();
		session.getTransaction().commit();
		return entries;
	}

	
	
}
