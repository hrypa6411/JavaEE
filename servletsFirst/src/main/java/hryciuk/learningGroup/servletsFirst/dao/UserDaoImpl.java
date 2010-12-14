package hryciuk.learningGroup.servletsFirst.dao;


import hryciuk.learningGroup.servletsFirst.dao.UserDao;
import hryciuk.learningGroup.servletsFirst.domain.SystemUser;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;



public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	private Log log = LogFactory.getLog(UserDaoImpl.class);
		
	public UserDaoImpl() {
		log.info("Utworzyłem obiekt UserDaoImpl");
	}

	@Override
	@Transactional
	public long saveUser(SystemUser user) {
		getHibernateTemplate().save(user);
		return user.getIdUser();
	}
		

	@Override
	@Transactional(readOnly = true)
	public SystemUser loadUser(String login, String password) {
		log.info("login " + login);
		log.info("hasloOOOOOOOOOOOOOOOOOOOOOOOOO   " + password);
		
		List<SystemUser> result = (List<SystemUser>)getHibernateTemplate().find(
							"from SystemUser where login = ? and password = ?",
							new Object[]{login, password});
		if (result.size() > 0) {
			return result.get(0);
		}
		return null;
	}

}
