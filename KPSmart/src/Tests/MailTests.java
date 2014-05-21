package Tests;

import java.util.Date;

import org.junit.Test;

public class MailTests {
	
	private Logic.Mail mail = new Logic.Mail(1, "Auck", "Welly", 2.0, 3.0, 1, new Date(2014,05,20),13.0);
	
	@Test
	public void getDestinationDTest(){
		mail.setDestinationD(new Logic.Destination("Test", true));
		assert(mail.getDestinationD()!=null);
	}
	
	@Test
	public void getOriginDTest(){
		mail.setOriginD(new Logic.Destination("Test", true));
		assert(mail.getOriginD()!=null);
	}
	
	@Test
	public void addCostTest(){
		mail.addCost(1.0);
		assert(mail.cost==1.0);
	}
	
	@Test 
	public void addShipmentTimeTest(){
		mail.addShipmentTime(1.0);
		assert(mail.time==1.0);
	}
	
}
