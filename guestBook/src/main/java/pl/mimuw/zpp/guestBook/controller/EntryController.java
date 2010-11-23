package pl.mimuw.zpp.guestBook.controller;

import java.io.IOException;

import javax.faces.context.FacesContext;

import pl.mimuw.zpp.guestBook.dao.EntryDAO;
import pl.mimuw.zpp.guestBook.dao.EntryDAOImpl;
import pl.mimuw.zpp.guestBook.www.EntryBean;

public class EntryController {
	EntryDAO entryDao;
	
	public EntryController() {
		this.entryDao = new EntryDAOImpl();
	}
	
	public void commit(EntryBean e) {
		this.entryDao.saveEntry(e.getEntry());
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/guestBook/");
		} catch(IOException ex){

		}
	}
}
