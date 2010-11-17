package pl.mimuw.zpp.guestBook.domain;

import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import pl.mimuw.zpp.guestBook.dao.EntryDAO;
import pl.mimuw.zpp.guestBook.dao.EntryDAOImpl;


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
	    
}
