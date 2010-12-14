package hryciuk.learningGroup.servletsFirst.dao;

import hryciuk.learningGroup.servletsFirst.domain.SystemUser;

public interface UserDao {
	
	long saveUser(SystemUser user);
	
	SystemUser loadUser(String login, String password);	

}
