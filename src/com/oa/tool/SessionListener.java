package com.oa.tool;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    public  static SessionContext sessionContext=SessionContext.getInstance();
 
    @Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
    	sessionContext.AddSession(httpSessionEvent.getSession());
    }

    @Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionContext.DelSession(httpSessionEvent.getSession());
    }
}

