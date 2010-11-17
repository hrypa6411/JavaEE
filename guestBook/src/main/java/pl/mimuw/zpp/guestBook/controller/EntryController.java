package pl.mimuw.zpp.guestBook.controller;

import java.io.IOException;

import javax.faces.context.FacesContext;

import pl.mimuw.zpp.guestBook.dao.EntryDAOImpl;
import pl.mimuw.zpp.guestBook.domain.Entry;

public class EntryController {
	EntryDAOImpl entryDaoImpl;
	
	public EntryController() {
		this.entryDaoImpl = new EntryDAOImpl();
	}
	
	public void commit(Entry e) {
		this.entryDaoImpl.saveEntry(e);
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/guestBook/");
		} catch(IOException ex){

		}
	}
}
