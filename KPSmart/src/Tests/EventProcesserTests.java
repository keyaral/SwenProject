package Tests;


import static org.junit.Assert.*;


import org.junit.Test;


import Logic.*;


public class EventProcesserTests {
	

	EventProcesser eventProcesser = new EventProcesser(new Statistics());

	@Test
	public void testProcessAddRouteEvent() {
		try {
			String result = eventProcesser.proccess(new String[]{"0", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "3", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Route: 1 was successfully added"));
			assert(eventProcesser.getRoutes().routes.size() > 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}
	
	@Test
	public void testProcessInvalidAddRouteEventError1() {
		try {
			String result = eventProcesser.proccess(new String[]{"0", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "1", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Invalid Destination Orgin Priority Match"));
			assert(eventProcesser.getRoutes().routes.size() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}
	
	@Test
	public void testProcessInvalidAddRouteEvent2() {
		try {
			String result = eventProcesser.proccess(new String[]{"0", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "3", "today", "1.0", "1.0", "TestCompany1"});
			result = eventProcesser.proccess(new String[]{"0", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "3", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Route was not added - it already exists"));
			assert(eventProcesser.getRoutes().routes.size() == 1);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}
	
	@Test
	public void testProcessChangeRouteEvent() {
		eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
				2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
		try {
			String result = eventProcesser.proccess(new String[]{"1", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "4", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Route: 1 was successfully changed"));
		} catch (Exception e) {
			fail("An error occurred while trying to process an Change Route Event");
		}
	}
	
	@Test
	public void testProcessInvalidChangeRouteEvent1() {
		eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
				2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
		try {
			String result = eventProcesser.proccess(new String[]{"1", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "2", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Invalid Destination Orgin Priority Match"));
		} catch (Exception e) {
			fail("An error occurred while trying to process an Change Route Event");
		}
	}
	
	@Test
	public void testProcessInvalidChangeRouteEvent2() {
		eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
				2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
		try {
			String result = eventProcesser.proccess(new String[]{"1", "2", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "4", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Route does not exist to change. Please consider adding"));
		} catch (Exception e) {
			fail("An error occurred while trying to process an Change Route Event");
		}
	}
	
	@Test
	public void testProcessDiscontinueRouteEvent() {
		eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
				2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
		try {
			String result = eventProcesser.proccess(new String[]{"2", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "3", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Route: 1 was successfully deleted"));
			assert(eventProcesser.getRoutes().routes.size() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Change Route Event");
		}
	}
	
	@Test
	public void testProcessInvalidDiscontinueRouteEvent1() {
		eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
				2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
		try {
			String result = eventProcesser.proccess(new String[]{"2", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "2", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Invalid Destination Orgin Priority Match"));
			assert(eventProcesser.getRoutes().routes.size() == 1);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Change Route Event");
		}
	}
	
	@Test
	public void testProcessInvalidDiscontinueRouteEvent2() {
		eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
				2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
		try {
			String result = eventProcesser.proccess(new String[]{"2", "2", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "2", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Route does not exist to remove"));
			assert(eventProcesser.getRoutes().routes.size() == 1);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Change Route Event");
		}
	}
	
	// COSTS
	
	@Test
	public void testProcessAddCostEvent() {
		try {
			eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
					2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
			String result = eventProcesser.proccess(new String[]{"3", "1", "1.0", "2.0", "Auckland", "Wellington", "3"});
			assert(result.equals("Cost: 1 was successfully added"));
			assert(eventProcesser.getCosts().costs.size() > 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}
	
	@Test
	public void testProcessInvalidAddCostEvent1() {
		try {
			String result = eventProcesser.proccess(new String[]{"3", "1", "1.0", "2.0", "Auckland", "Wellington", "2"});
			assert(result.equals("Invalid Destination Orgin Priority Match"));
			assert(eventProcesser.getCosts().costs.size() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}
	
	@Test
	public void testProcessInvalidAddCostEvent2() {
		try {
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 3));
			String result = eventProcesser.proccess(new String[]{"3", "1", "1.0", "2.0", "Auckland", "Wellington", "3"});
			assert(result.equals("Cost was not added"));
			assert(eventProcesser.getCosts().costs.size() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}
	
}
