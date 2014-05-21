package Tests;

import Logic.*;

import java.util.*;

import org.junit.Test;

public class MailDeliveryTests {
	
	private MailDelivery mailDeliverer = new MailDelivery();
	
	@Test
	public void newNzDestinationTest() {
		mailDeliverer.newNzDestination("Queenstown");
		assert(mailDeliverer.findDestination("Queenstown") != null);
		assert(mailDeliverer.isDomestic("Queenstown") == true);
	}
	
	@Test
	public void deliverMailTest() {
		Mail mail = new Mail(1, "Auckland", "Wellington", 2.0, 3.0, 1, new Date(2014,05,20),13.0);
		Cost cost = new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 1);
		Route route = new Route(1, "Auckland", "Wellington", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		ArrayList<Route> routeList = new ArrayList<Route>();
		routeList.add(route);
		RouteChain routeChain = new RouteChain(routeList, new Destination("Auckland", true), "Wellington");
		assert(mailDeliverer.deliverMail(mail, routeChain, cost) == true);
	}
	
	@Test
	public void assignDestinationsTest2() {
		Route route = new Route(1, "Auckland", "Wellington", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		mailDeliverer.assignDestinations(route);
		assert(route.destination.equals("Auckland") && route.origin.equals("Wellington"));
	}
	
	@Test
	public void assignDestinationsTest1() {
		Mail mail = new Mail(1, "Auckland", "Wellington", 2.0, 3.0, 1, new Date(2014,05,20),13.0);
		mailDeliverer.assignDestinations(mail);
		assert(mail.destination.equals("Auckland") && mail.origin.equals("Wellington"));
	}
	
	@Test
	public void isDomesticTest() {
		assert(mailDeliverer.isDomestic("Auckland") == true);
	}
	
	@Test
	public void containsDesStringTest() {
		assert(mailDeliverer.containsDesString("Auckland") == true);
	}
	
}
