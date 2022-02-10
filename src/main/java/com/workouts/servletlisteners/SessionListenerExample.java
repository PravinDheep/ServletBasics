package com.workouts.servletlisteners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListenerExample
 *
 */
@WebListener
public class SessionListenerExample implements HttpSessionListener {

	
    public void sessionCreated(HttpSessionEvent se)  {
    	System.out.println("Session created");
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  {
    	System.out.println("Session destroyed");
    }
	
}
