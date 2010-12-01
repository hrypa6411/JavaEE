package pl.mimuw.zpp.guestBook;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context =
		    new ClassPathXmlApplicationContext(new String[] {"services.xml", "daos.xml", "buisnessLogic.xml"});
	}

}
