package Tests;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import Log.Log.KPEvents.Event.Mail;
import Logic.Destination;
import Logic.Route;
import Logic.RouteChain;

public class RouteChainTests {
	
	private ArrayList<Route> routes = new ArrayList<Route>();
	
	@Test
	public void calculateCostTest(){
		Route r1 = new Route(1, "des1", "origin1", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		Route r2 = new Route(2, "des2", "origin2", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany2");
		Route r3 = new Route(3, "des3", "origin3", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany3");
		
		routes.add(r1);
		routes.add(r2);
		routes.add(r3);
		
		Destination d = new Destination("Dest1", 1.0,
				2.0, 3.0,4.0);
		
		RouteChain rc = new RouteChain(routes, d, "origin");
		
		Logic.Mail mail = new Logic.Mail(1, "Auck", "Welly", 2.0, 3.0, 1, new Date(2014,05,20),13.0);
		
		assert(rc.calculateCost(mail) == 3.0);
	}
	
	@Test
	public void checkViableTest(){
		Route r1 = new Route(1, "des1", "origin1", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		Route r2 = new Route(2, "des2", "origin2", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany2");
		Route r3 = new Route(3, "des3", "origin3", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany3");
		
		routes.add(r1);
		routes.add(r2);
		routes.add(r3);
		
		Destination d = new Destination("Dest1", 1.0,
				2.0, 3.0,4.0);
		
		RouteChain rc = new RouteChain(routes, d, "origin");
		
		Logic.Mail mail = new Logic.Mail(1, "Auck", "Welly", 2.0, 3.0, 1, new Date(2014,05,20),13.0);
		
		assert(rc.checkViable(mail));
	}
	
	@Test
	public void gettotaldurationTest(){
		Route r1 = new Route(1, "des1", "origin1", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		Route r2 = new Route(2, "des2", "origin2", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany2");
		Route r3 = new Route(3, "des3", "origin3", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany3");
		
		routes.add(r1);
		routes.add(r2);
		routes.add(r3);
		
		Destination d = new Destination("Dest1", 1.0,
				2.0, 3.0,4.0);
		
		RouteChain rc = new RouteChain(routes, d, "origin");
		
		Logic.Mail mail = new Logic.Mail(1, "Auck", "Welly", 2.0, 1.0, 1, new Date(2014,05,20),13.0);
		
		assert(rc.gettotalduration()==3);
	}
	
	
}
