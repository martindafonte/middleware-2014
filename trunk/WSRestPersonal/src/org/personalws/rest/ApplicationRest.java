package org.personalws.rest;

import java.util.Set;
import java.util.HashSet;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/Rest")
public class ApplicationRest extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();
	public ApplicationRest(){
	     classes.add(PersonalRest.class);
	}
	
	@Override
	public Set<Class<?>> getClasses() {
	     return classes;
	}
	@Override
	public Set<Object> getSingletons() {
	     return singletons;
	}
}
