package com.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {

    
    public RequestListener() {
        // TODO Auto-generated constructor stub
    }

    public void requestDestroyed(ServletRequestEvent requestEvent)  { 
         // TODO Auto-generated method stub
    	System.out.println("A Request Destroyed ->" + requestEvent.toString());
    }

    public void requestInitialized(ServletRequestEvent requestEvent)  { 
         // TODO Auto-generated method stub
    	System.out.println("A Request arrived to the server ! ->" + requestEvent.toString());
    }
	
}
