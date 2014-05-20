package Tests;

import java.util.HashSet;

import org.junit.Test;

import Logic.Route;
import Logic.RouteListClass;

public class RouteListClassTests {
	
	private HashSet<Route> routes;
	private RouteListClass rc;
	
	
	private void GenerateTestRoutes(){
		Route r1 = new Route(1, "des1", "origin1", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		Route r2 = new Route(2, "des2", "origin2", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany2");
		Route r3 = new Route(3, "des3", "origin3", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany3");
		
		routes.add(r1);
		routes.add(r2);
		routes.add(r3);
		
		rc = new RouteListClass(routes);
	}
	
	@Test
	public void addExistingRouteTest(){
		Route r1 = new Route(1, "des1", "origin1", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		assert(!rc.addRoute(r1));
	}
	
	@Test
	public void addNonExistingRouteTest(){
		Route r4 = new Route(4, "des4", "origin4", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany4");
		assert(rc.addRoute(r4));
	}
	
	@Test 
	public void changeRouteTest(){
		Route r1 = new Route(1, "des1", "origin1", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		assert(rc.changeRoute(r1));
	}
	
	@Test
	public void deleteRouteTest(){
		Route r1 = new Route(1, "des1", "origin1", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		assert(rc.deleteRoute(r1));
		//rc.addRoute(r1);
	}
	
}
