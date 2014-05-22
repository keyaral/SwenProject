package Tests;

import org.junit.Test;
import java.util.*;
import Logic.*;
import Log.event.*;

public class StatTests {
	
	@Test
	public void testGetAmountOfMail1() {
		Statistics stat = new Statistics();
		stat.mails.add(new Mail(1,"dest1","org1",10,10,3,new Date(),13.0));
		stat.mails.add(new Mail(2,"dest1","org1",10,10,3,new Date(),13.0));
		List<String[]> result = stat.getMailAmounts();
		assert(result.size() == 1);
		assert(Double.parseDouble(result.get(0)[2]) == 20
				&& Double.parseDouble(result.get(0)[3]) == 20
				&& Integer.parseInt(result.get(0)[4]) == 2);
	}
	
	@Test
	public void testGetAmountOfMail2() {
		Statistics stat = new Statistics();
		stat.mails.add(new Mail(1,"dest1","org1",10,10,3,new Date(),13.0));
		stat.mails.add(new Mail(2,"dest1","org2",10,10,3,new Date(),13.0));
		List<String[]> result = stat.getMailAmounts();
		assert(result.size() == 2);
		assert(Double.parseDouble(result.get(0)[2]) == 10
				&& Double.parseDouble(result.get(0)[3]) == 10
				&& Integer.parseInt(result.get(0)[4]) == 1);
		assert(Double.parseDouble(result.get(1)[2]) == 10
				&& Double.parseDouble(result.get(1)[3]) == 10
				&& Integer.parseInt(result.get(1)[4]) == 1);
	}
	
	@Test
	public void testGetAverageDeliveryTimes1() {
		Statistics stat = new Statistics();
		Mail m1 = new Mail(1,"dest1","org1",10,10,3,new Date(),13.0);
		Mail m2 = new Mail(1,"dest1","org1",10,10,3,new Date(),13.0);
		m1.addShipmentTime(10);
		m2.addShipmentTime(18);
		stat.mails.add(m1);
		stat.mails.add(m2);
		List<String[]> result = stat.getDeliveryTimes();
		assert(result.size() == 1);
		assert(Double.parseDouble(result.get(0)[3]) == ((18+10)/2));
	}
	
	@Test
	public void testGetAverageDeliveryTimes2() {
		Statistics stat = new Statistics();
		Mail m1 = new Mail(1,"dest1","org1",10,10,3,new Date(),13.0);
		Mail m2 = new Mail(1,"dest1","org2",10,10,3,new Date(),13.0);
		m1.addShipmentTime(10);
		m2.addShipmentTime(18);
		stat.mails.add(m1);
		stat.mails.add(m2);
		List<String[]> result = stat.getDeliveryTimes();
		assert(result.size() == 2);
		assert(Double.parseDouble(result.get(0)[3]) == 10);
		assert(Double.parseDouble(result.get(1)[3]) == 18);
	}
	
	@Test
	public void testEmptyMailListHandling() {
		Statistics stat = new Statistics();
		assert(stat.getMailAmounts() == null);
		assert(stat.getDeliveryTimes() == null);
	}
	
	@Test
	public void testGetCriticalRoutes1() {
		Statistics stat = new Statistics();
		RouteListClass rlc = new RouteListClass();
		CostListClass clc = new CostListClass();
		rlc.addRoute(new Route(1, "Auckland", "Wellington", 5.0, 5.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1"));
		clc.addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 1));
		stat.setCostList(clc);
		stat.setRouteList(rlc);
		assert(stat.getCriticalRoutes().size() > 0);
	}
	
	@Test
	public void testGetCriticalRoutes2() {
		Statistics stat = new Statistics();
		RouteListClass rlc = new RouteListClass();
		CostListClass clc = new CostListClass();
		rlc.addRoute(new Route(1, "Auckland", "Wellington", 1.0, 2.0, 3.0, 4.0, 1, "today", 1.0, 1.0, "TestCompany1"));
		clc.addCost(new Cost(1, 1.0, 2.0, "Auckland", "Wellington", 1));
		stat.setCostList(clc);
		stat.setRouteList(rlc);
		assert(stat.getCriticalRoutes().size() == 0);
	}
	
	
}
