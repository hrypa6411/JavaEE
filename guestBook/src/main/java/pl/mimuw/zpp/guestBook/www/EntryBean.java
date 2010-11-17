package pl.mimuw.zpp.guestBook.www;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import pl.mimuw.zpp.guestBook.controller.EntryController;
import pl.mimuw.zpp.guestBook.dao.EntryDAO;
import pl.mimuw.zpp.guestBook.dao.EntryDAOImpl;
import pl.mimuw.zpp.guestBook.domain.Entry;


@ManagedBean
public class EntryBean {
	
	private Entry entry;
	private List<Entry> entries;
	private EntryDAOImpl entryDaoImpl;
	private EntryController entryController;
		
    public EntryBean() {
    	this.entry = new Entry();
    	this.entryDaoImpl = new EntryDAOImpl();
    	this.entries = this.entryDaoImpl.getEntries();
    	this.entryController = new EntryController();
        System.out.println("Utworzylem obiekt Entry");
    }

	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	public EntryDAOImpl getEntryDaoImpl() {
		return entryDaoImpl;
	}

	public void setEntryDaoImpl(EntryDAOImpl entryDaoImpl) {
		this.entryDaoImpl = entryDaoImpl;
	}
    
    public void pressButton() {
    	this.entryController.commit(this.entry);
    }
	    


}
