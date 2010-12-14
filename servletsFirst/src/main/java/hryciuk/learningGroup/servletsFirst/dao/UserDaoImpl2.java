package hryciuk.learningGroup.servletsFirst.dao;

import hryciuk.learningGroup.servletsFirst.domain.SystemUser;
import hryciuk.learningGroup.servletsFirst.util.HibernateUtil;

import java.util.List;

import org.hibernate.Session;

public class UserDaoImpl2 implements UserDao{

	@Override
	public SystemUser loadUser(String login, String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<SystemUser> result = (List<SystemUser>)session.createQuery(
				"from SystemUser where loginUser = :login and passwordUser = :pass")
				.setParameter("login", login)
				.setParameter("pass", password).list();
		session.getTransaction().commit();
		if (result.size() > 0) {
			return result.get(0);
		}
		
		return null;
	}

	@Override
	public long saveUser(SystemUser user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return user.getIdUser();
	}

}


