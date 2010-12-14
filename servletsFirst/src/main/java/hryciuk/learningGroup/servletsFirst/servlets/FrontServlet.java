package hryciuk.learningGroup.servletsFirst.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FrontServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	static ApplicationContext context;
	
	static {
		context =
		    new ClassPathXmlApplicationContext(
		    	new String[] {"daos.xml" });		 
	}	

	@Override
	 public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
		if (dispatcher != null) {
			 dispatcher.forward(req, resp);
		} 
	}

}

