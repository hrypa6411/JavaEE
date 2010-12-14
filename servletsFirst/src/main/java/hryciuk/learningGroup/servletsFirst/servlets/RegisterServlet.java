package hryciuk.learningGroup.servletsFirst.servlets;

import hryciuk.learningGroup.servletsFirst.dao.UserDao;
import hryciuk.learningGroup.servletsFirst.domain.SystemUser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String USER_DAO_NAME = "userDaoImpl";
	
	private UserDao systemUserDao;

	

	@Override
	public void init() throws ServletException {
		this.systemUserDao = (UserDao)FrontServlet.context.getBean(USER_DAO_NAME);
	}
	
	@Override
		 public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String password = req.getParameter("password");
		String login = req.getParameter("login");
		SystemUser user = new SystemUser();
		user.setLoginUser(login);
		user.setPasswordUser(password);
		this.systemUserDao.saveUser(user);
		resp.sendRedirect("/servletsFirst/login.jsp");
//		RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
//		if (dispatcher != null) {
//			 dispatcher.forward(req, resp);
//		} 
		
	}
	

}
