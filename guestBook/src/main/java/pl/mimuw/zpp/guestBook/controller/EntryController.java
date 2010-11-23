package pl.mimuw.zpp.guestBook.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import pl.mimuw.zpp.guestBook.dao.EntryDAO;
import pl.mimuw.zpp.guestBook.dao.EntryDAOImpl;
import pl.mimuw.zpp.guestBook.www.EntryBean;
import pl.mimuw.zpp.guestBook.domain.Entry;

public class EntryController {
	private EntryDAO entryDao;
	
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
	
	public List<Entry> getEntries() {
		return this.entryDao.getEntries();
	}
}
