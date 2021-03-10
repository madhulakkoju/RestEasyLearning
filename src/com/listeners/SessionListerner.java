package com.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListerner implements HttpSessionListener {

    public SessionListerner() {
        // TODO Auto-generated constructor stub
    }

    public void sessionCreated(HttpSessionEvent sessionEvent)  { 
         // TODO Auto-generated method stub
    	System.out.println("A New Session Created !");
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("Session Expired !!");
    }
}
