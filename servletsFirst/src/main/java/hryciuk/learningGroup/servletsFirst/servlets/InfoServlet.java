package hryciuk.learningGroup.servletsFirst.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InfoServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	 public void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Date startTime = (Date)session.getAttribute("startTime");
		long a = (new Date()).getTime() - startTime.getTime();
		String browserInfo = req.getHeader("User-Agent");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>InfoPage</title></head>");
		out.println("<body bgcolor=\"white\">");
		out.println("MINELO  :   " + a + "   ms od zalogowania");
		out.println("<br>");
		out.println("Korzystasz z przegladarki    :    " + browserInfo );
		out.println("<a href = \"/servletsFirst/logout/\" > WYLOGUJ </a><br>");
		out.println("</body>");
		out.println("</html>");
	}
}


