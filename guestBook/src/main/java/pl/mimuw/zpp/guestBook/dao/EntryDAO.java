package pl.mimuw.zpp.guestBook.dao;

import java.util.List;

import pl.mimuw.zpp.guestBook.domain.Entry;

public interface EntryDAO {

	
	void saveEntry(Entry e);
	
	List<Entry> getEntries();
	
}
