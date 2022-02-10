package com.workouts.servletlisteners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListenersExample
 *
 */
@WebListener
public class ServletContextListenerExample implements ServletContextListener {

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	//Any JNDI object, any connection pool object
    	// one per application
    	System.out.println("Context Initialized");
    }
    
	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("Context Destroyed");
    }

	
	
}
