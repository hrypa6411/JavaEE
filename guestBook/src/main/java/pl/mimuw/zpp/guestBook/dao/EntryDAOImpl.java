package pl.mimuw.zpp.guestBook.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import pl.mimuw.zpp.guestBook.domain.Entry;

public class EntryDAOImpl extends HibernateDaoSupport implements EntryDAO {
	
	private Log log = LogFactory.getLog(EntryDAOImpl.class);
	
	public EntryDAOImpl() {
		log.info("Utworzyłem obiekt EntryDAOImpl");
	}

	@Override
	@Transactional
	public void saveEntry(Entry e) {
		e.setDate(new Date());
		getHibernateTemplate().save(e);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Entry> getEntries() {
		List<Entry> entries = (List<Entry>) getHibernateTemplate().find("from Entry");
		return entries;
	}

	
	
}
