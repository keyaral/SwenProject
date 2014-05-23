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
			assert(eventProcesser.getStats().events() == 1);
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
			assert(eventProcesser.getStats().events() == 0);
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
			assert(eventProcesser.getStats().events() == 0);
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
			assert(eventProcesser.getStats().events() == 1);
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
			assert(eventProcesser.getStats().events() == 0);
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
			assert(eventProcesser.getStats().events() == 0);
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
			assert(eventProcesser.getStats().events() == 1);
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
			assert(eventProcesser.getStats().events() == 0);
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
			assert(eventProcesser.getStats().events() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Change Route Event");
		}
	}

	// COSTS

	@Test
	public void testProcessAddCostEvent() {
		try {
			String result = eventProcesser.proccess(new String[]{"3", "1", "1.0", "2.0", "Auckland", "Wellington", "3"});
			assert(result.equals("Cost: 1 was successfully added"));
			assert(eventProcesser.getCosts().costs.size() > 0);
			assert(eventProcesser.getStats().events() == 1);
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
			assert(eventProcesser.getStats().events() == 0);
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
			assert(eventProcesser.getStats().events() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

	@Test
	public void testProcessChangeCostEvent() {
		try {
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 3));
			String result = eventProcesser.proccess(new String[]{"4", "1", "1.0", "8.0", "Auckland", "Wellington", "3"});
			assert(result.equals("Cost: 1 was successfully changed"));
			assert(eventProcesser.getStats().events() == 1);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

	@Test
	public void testInvalidProcessChangeCostEvent1() {
		try {
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 3));
			String result = eventProcesser.proccess(new String[]{"4", "1", "1.0", "8.0", "Auckland", "Wellington", "1"});
			assert(result.equals("Invalid Destination Orgin Priority Match"));
			assert(eventProcesser.getStats().events() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

	@Test
	public void testInvalidProcessChangeCostEvent2() {
		try {
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 3));
			String result = eventProcesser.proccess(new String[]{"4", "2", "1.0", "8.0", "Auckland", "Wellington", "3"});
			assert(result.equals("Cost does not exist to change. Please consider adding"));
			assert(eventProcesser.getStats().events() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

	@Test
	public void testInvalidProcessChangeCostEvent3() {
		try {
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 3));
			String result = eventProcesser.proccess(new String[]{"4", "1", "1.0", "8.0", "Christchurch", "Wellington", "3"});
			assert(result.equals("Cost does not exist to change. Please consider adding"));
			assert(eventProcesser.getStats().events() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

	@Test
	public void testInvalidProcessChangeCostEvent4() {
		try {
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 3));
			String result = eventProcesser.proccess(new String[]{"4", "1", "1.0", "8.0", "Auckland", "Christchurch", "3"});
			assert(result.equals("Cost does not exist to change. Please consider adding"));
			assert(eventProcesser.getStats().events() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

	@Test
	public void testMailSentEvent() {
		try {
			eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
					2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 3));
			String result = eventProcesser.proccess(new String[]{"5", "1", "Auckland", "Wellington", "2.0", "2.0", "3", "2012-12-30"});
			assert(result.equals("Mail: 1 was successfully sent"));
			assert(eventProcesser.getMailList().mails.size() == 1);
			assert(eventProcesser.getStats().revenue() > 0);
			assert(eventProcesser.getStats().expenditure() > 0);
			assert(eventProcesser.getStats().events() == 1);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

	@Test
	public void testInvalidMailSentEvent1() {
		try {
			eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
					2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 3));
			String result = eventProcesser.proccess(new String[]{"5", "1", "Auckland", "Wellington", "2.0", "2.0", "2", "2012-12-30"});
			assert(result.equals("Invalid Destination Orgin Priority Match"));
			assert(eventProcesser.getMailList().mails.size() == 0);
			assert(eventProcesser.getStats().revenue() == 0);
			assert(eventProcesser.getStats().expenditure() == 0);
			assert(eventProcesser.getStats().events() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

	@Test
	public void testInvalidMailSentEvent2() {
		try {
			eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
					2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Christchurch", 3));
			String result = eventProcesser.proccess(new String[]{"5", "1", "Auckland", "Wellington", "2.0", "2.0", "3", "2012-12-30"});
			assert(result.equals("No valid Cost"));
			assert(eventProcesser.getMailList().mails.size() == 0);
			assert(eventProcesser.getStats().revenue() == 0);
			assert(eventProcesser.getStats().expenditure() == 0);
			assert(eventProcesser.getStats().events() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

	@Test
	public void testInvalidMailSentEvent3() {
		try {
			eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Christchurch", 1.0,
					2.0, 3.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 3));
			String result = eventProcesser.proccess(new String[]{"5", "1", "Auckland", "Wellington", "2.0", "2.0", "3", "2012-12-30"});
			assert(result.equals("No valid Route"));
			assert(eventProcesser.getMailList().mails.size() == 0);
			assert(eventProcesser.getStats().revenue() == 0);
			assert(eventProcesser.getStats().expenditure() == 0);
			assert(eventProcesser.getStats().events() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

	@Test
	public void testInvalidMailSentEvent4() {
		try {
			eventProcesser.getRoutes().addRoute(new Route(1, "Auckland", "Wellington", 1.0,
					2.0, 4.0, 4.0, 3, "today", 1.0, 1.0, "TestCompany1"));
			eventProcesser.getCosts().addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 3));
			String result = eventProcesser.proccess(new String[]{"5", "1", "Auckland", "Wellington", "5.0", "5.0", "3", "2012-12-30"});
			assert(result.equals("No valid Route"));
			assert(eventProcesser.getMailList().mails.size() == 0);
			assert(eventProcesser.getStats().revenue() == 0);
			assert(eventProcesser.getStats().expenditure() == 0);
			assert(eventProcesser.getStats().events() == 0);
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}

}
