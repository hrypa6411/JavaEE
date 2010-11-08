package pl.mimuw.zpp.guestBook.domain;

import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;

import pl.mimuw.zpp.guestBook.util.HibernateUtil;

@ManagedBean
public class Entry {
	private long id;
    String name;
    String email;
    String text;
    private Date date;
	
	
    public Entry() {
        System.out.println("Utworzylem obiekt Entry");
    }

    

	public long getId() {
		return id;
	}



	protected void setId(long id) {
		this.id = id;
	}



	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public void submit() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		this.date = new Date();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/guestBook/");
		} catch(IOException e){
			
		}

	}

    
}
