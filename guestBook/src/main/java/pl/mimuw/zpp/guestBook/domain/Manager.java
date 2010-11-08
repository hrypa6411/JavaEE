package pl.mimuw.zpp.guestBook.domain;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.hibernate.Session;

import pl.mimuw.zpp.guestBook.util.HibernateUtil;

@ManagedBean
public class Manager {

	List<Entry> entries;
	
	
	public Manager() {
		this.reloadEntries();
	}
	
	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
	
	public void reloadEntries() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		this.entries = (List<Entry>)session.createQuery("from Entry").list();
		session.getTransaction().commit();
	}
	
}
