package com.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/app")
public class StudentApplication extends Application
{
	// this singletons set contains all the Resources created in the aplication
	// we need to add objects of all the resources 
	private Set<Object> singletons = new HashSet<Object>();
	
	public StudentApplication()
	{
		// This is initial creation od application. 
		// So, add all the reources to the set.
		singletons.add(new StudentResource());
	}
	
	@Override
	public Set<Object> getSingletons()
	{
		return this.singletons;
	}
	
}
