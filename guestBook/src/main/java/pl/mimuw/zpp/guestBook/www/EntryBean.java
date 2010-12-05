package pl.mimuw.zpp.guestBook.www;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.mimuw.zpp.guestBook.controller.EntryController;
import pl.mimuw.zpp.guestBook.domain.Entry;


@ManagedBean
public class EntryBean {
	private Entry entry;
	private List<Entry> entries;
	private EntryController entryController;
		
	private static ApplicationContext context;
	private static final String CTX_CONTROLLER = "entryController";
	
	
	static {
		context =
		    new ClassPathXmlApplicationContext(
		    	new String[] {"daos.xml", "buisnessLogic.xml", "hibernate.xml" });		 
	}	
	
	
    public EntryBean() {
    	this.entry = new Entry();
    	this.entryController = (EntryController) context.getBean(CTX_CONTROLLER);
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
