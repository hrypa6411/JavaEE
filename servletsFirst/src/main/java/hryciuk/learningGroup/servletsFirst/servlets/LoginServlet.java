package hryciuk.learningGroup.servletsFirst.servlets;


import hryciuk.learningGroup.servletsFirst.dao.UserDao;
import hryciuk.learningGroup.servletsFirst.domain.SystemUser;

import java.io.IOException;
import java.util.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	private static final String USER_DAO_NAME = "userDaoImpl";
	
	private Log log = LogFactory.getLog(LoginServlet.class);
	
	
	public UserDao getUserDao() {
		return userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void init() throws ServletException {
		this.userDao = (UserDao)FrontServlet.context.getBean(USER_DAO_NAME);
	}

	@Override
	 public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		
		SystemUser user = this.userDao.loadUser(login, password);
		RequestDispatcher dispatcher = null;
		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("startTime", new Date());
			
			dispatcher = req.getRequestDispatcher("/info/");
			log.info("ZALOGOWANY");
			resp.sendRedirect("/servletsFirst/");
//			if (dispatcher != null) {
//				dispatcher.forward(req, resp);
//			} 
		} else {
			dispatcher = req.getRequestDispatcher("login.jsp");
			if (dispatcher != null) {
				 dispatcher.forward(req, resp);
			}
		}
	}
}
