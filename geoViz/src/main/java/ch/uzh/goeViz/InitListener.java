package ch.uzh.goeViz;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.uzh.geoViz.util.Util;


public class InitListener implements ServletContextListener{
	
	private static Logger log = LoggerFactory.getLogger(InitListener.class);

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Properties prop = new Properties();
		try {
			prop.load(arg0.getServletContext().getResourceAsStream("/WEB-INF/geoViz.properties"));
			Util.setProperties(prop);
		} catch (IOException e) {
			log.error("Failed to load properties.");
		}
		log.info("Properties loaded");
		
	}

}
