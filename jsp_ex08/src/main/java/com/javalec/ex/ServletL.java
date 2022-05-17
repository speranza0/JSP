package com.javalec.ex;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ServletL implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized");

	}
}
