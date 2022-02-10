package com.workouts.servletlisteners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletRequestListener
 *
 */
@WebListener
public class RequestListenerExample implements ServletRequestListener {

	public void requestInitialized(ServletRequestEvent sre)  {
		System.out.println("Request Initialized");
    }
	
    public void requestDestroyed(ServletRequestEvent sre)  {
    	System.out.println("Request Destroyed");
    }
}
