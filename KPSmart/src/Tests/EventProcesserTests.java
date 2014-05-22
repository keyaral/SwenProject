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
			
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}
	
	@Test
	public void testProcessAddRouteEventError1() {
		try {
			String result = eventProcesser.proccess(new String[]{"0", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "1", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Invalid Destination Orgin Priority Match"));
			
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}
	
	@Test
	public void testProcessAddRouteEventError2() {
		try {
			String result = eventProcesser.proccess(new String[]{"0", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "3", "today", "1.0", "1.0", "TestCompany1"});
			result = eventProcesser.proccess(new String[]{"0", "1", "Auckland", "Wellington",
					"1.0", "2.0", "3.0", "4.0", "3", "today", "1.0", "1.0", "TestCompany1"});
			assert(result.equals("Route was not added - it already exists"));
			
		} catch (Exception e) {
			fail("An error occurred while trying to process an Add Route Event");
		}
	}
	
}
