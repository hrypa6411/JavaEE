package pl.mimuw.zpp.guestBook.www;

import java.util.List;

import javax.faces.bean.ManagedBean;

import pl.mimuw.zpp.guestBook.controller.EntryController;
import pl.mimuw.zpp.guestBook.domain.Entry;


@ManagedBean
public class EntryBean {
	private Entry entry;
	private List<Entry> entries;
	private EntryController entryController;
		
    public EntryBean(Entry entry, EntryController entryController) {
    	this.entry = entry;
    	this.entryController = entryController;
        this.entries = entryController.getEntries();
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

	    
    public void pressButton() {
    	this.entryController.commit(this);
    }
	    


}
