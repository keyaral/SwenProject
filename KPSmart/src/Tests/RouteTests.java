package Tests;



import org.junit.Test;

import Logic.Cost;
import Logic.Route;

public class RouteTests {
	
	@Test
	public void EqualsTest(){
		Route r1 = new Route(1, "des1", "origin1", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		Route r2 = r1;
		
		assert(r1.equals(r2));
	}
	
	@Test
	public void isCriticalTest(){
		Route r1 = new Route(1, "des1", "origin1", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1");
		assert(r1.isCritical(new Cost(1, 2.0, 3.0, "Auckland", "Wellington", 1)));
	}
	
}
