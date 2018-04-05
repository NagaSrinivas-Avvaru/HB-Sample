package com.nt.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.nt.utility.HibernateUtil;

@WebListener
public class SessionClosingRequestListener implements ServletRequestListener {
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("requestDestroyed(-)");
		if(((HttpServletRequest)sre.getServletRequest()).getServletPath().equals("/controller")){
			System.out.println("request to servlet...");
		   HibernateUtil.closeSession();
		}
	}
	

}
