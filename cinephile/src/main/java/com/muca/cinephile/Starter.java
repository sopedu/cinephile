package com.muca.cinephile;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.rometools.rome.io.FeedException;

/**
 * Application Lifecycle Listener implementation class Starter
 *
 */
@WebListener
public class Starter implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public Starter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		try {
		MynetExtractor me=new MynetExtractor();
		me.fillComingSoon("http://sinema.mynet.com/rss/RSS-gelecekprogram/rss.xml");
		me.fillOnCinemas("http://sinema.mynet.com/rss/RSS-vizyon/rss.xml");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
