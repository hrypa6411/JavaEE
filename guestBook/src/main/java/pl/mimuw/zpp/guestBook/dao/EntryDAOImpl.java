package pl.mimuw.zpp.guestBook.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import pl.mimuw.zpp.guestBook.domain.Entry;

public class EntryDAOImpl implements EntryDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	
	public EntryDAOImpl() {
		System.out.println("Utworzyłem obiekt EntryDAOImpl");
	}

	@Override
	@Transactional
	public void saveEntry(Entry e) {
		Session session = this.sessionFactory.openSession();
		e.setDate(new Date());
		session.beginTransaction();
		session.save(e);
		session.getTransaction().commit();		
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Entry> getEntries() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		List<Entry> entries = (List<Entry>)session.createQuery("from Entry").list();
		session.getTransaction().commit();
		return entries;
	}

	
	
}
