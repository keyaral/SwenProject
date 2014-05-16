package Log.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Log.reader.*;
import Log.writer.XmlWriter;
import Log.Log;
import Log.reader.XmlReader;

public class LogTest {
	
	@Test
	public void FindAllTest(){
		
		XmlReader reader = new XmlReader("src/Log.xml");
		
		Log log = reader.FindAll();
		assert(log.getCostOrPriceOrRoute().get(0)!=null);
		
		
	}
	
	@Test
	public void FindCostTest(){
		XmlReader reader = new XmlReader("src/Log.xml");
		ArrayList<Log.Cost> cost = reader.FindCost();
		assert(cost.size()>0);
 	}
	
	@Test
	public void FindPriceTest(){
		XmlReader reader = new XmlReader("src/Log.xml");
		ArrayList<Log.Price> price = reader.FindPrice();
		assert(price.size()>0);
 	}
	
	@Test
	public void FindMailTest(){
		XmlReader reader = new XmlReader("src/Log.xml");
		ArrayList<Log.Mail> mail = reader.FindMail();
		assert(mail.size()>0);
 	}
	
	@Test
	public void FindDiscontinueTest(){
		XmlReader reader = new XmlReader("src/Log.xml");
		ArrayList<Log.Discontinue> disContinue = reader.FindDiscontinue();
		assert(disContinue.size()>0);
 	}
	
	@Test
	public void FindTimelimitTest(){
		XmlReader reader = new XmlReader("src/Log.xml");
		ArrayList<Log.Timelimit> timeLimit = reader.FindTimelimit();
		assert(timeLimit.size()>0);
 	}
	
	@Test
	public void WriteLogTest(){
		
		XmlWriter writer = new XmlWriter("src/LogXmlTest.xml");
		//Construct a base object
	    Log log = ConstructLogObjects();
	    
	    writer.WriteLog(log);
	    
	    XmlReader reader = new XmlReader("src/LogXmlTest.xml");
	    
	    Log result = reader.FindAll();
	
		assert(result.getCostOrPriceOrRoute().size()>=2);
 	}
	
	@Test
	public void InsertPriceTest(){
		
		XmlWriter writer = new XmlWriter("src/LogXmlTest.xml");
		//Construct a price object
		
		Log.Price price = new Log.Price();
		price.setFrom("Lower Hutt");
		price.setTo("Auclland");
		price.setPriority("high");
		price.setVolumecost((short)10);
		price.setWeightcost((short)10);
		
		Log log =  writer.InsertPrice(price);
	    
		assert(log.getCostOrPriceOrRoute().get(log.getCostOrPriceOrRoute().indexOf(price)) != null);
 	}
	
	@Test
	public void InsertKPEventTest(){
		
		XmlWriter writer = new XmlWriter("src/LogXmlTest.xml");
		//Construct a KPEvent object
		
		Log.KPEvents kPEvent = new Log.KPEvents();
		Log.KPEvents.Event event = new Log.KPEvents.Event();
		
		event.setSuccess(true);
		event.setType("Test");
		//Construct cost;
		Log.KPEvents.Event.Cost cost = new Log.KPEvents.Event.Cost();
		cost.setId(0);
		cost.setOrigin("Welly");
		cost.setDestination("Auckland");
		cost.setPriority(1);
		cost.setVolume(3.0);
		cost.setWeight(2.0);
		//add cost to event
		event.setCost(cost);
		//Construct mails
		Log.KPEvents.Event.Mails mails = new Log.KPEvents.Event.Mails();
		Log.KPEvents.Event.Mails.Mail mail1 = new Log.KPEvents.Event.Mails.Mail();
		mail1.setId(1);
		Log.KPEvents.Event.Mails.Mail mail2 = new Log.KPEvents.Event.Mails.Mail();
		mail2.setId(2);
		List<Log.KPEvents.Event.Mails.Mail> mails1 = new ArrayList<Log.KPEvents.Event.Mails.Mail>();
		mails1.add(mail1);
		mails1.add(mail2);
		mails.setMails(mails1);
		event.setMails(mails);
		//Construct routes
		Log.KPEvents.Event.Routes routes = new Log.KPEvents.Event.Routes();
		Log.KPEvents.Event.Routes.Route route1 = new Log.KPEvents.Event.Routes.Route();
		mail1.setId(1);
		Log.KPEvents.Event.Routes.Route route2 = new Log.KPEvents.Event.Routes.Route();
		mail2.setId(2);
		List<Log.KPEvents.Event.Routes.Route> routes1 = new ArrayList<Log.KPEvents.Event.Routes.Route>();
		routes1.add(route1);
		routes1.add(route2);
		routes.setRoutes(routes1);
		event.setRoutes(routes);	
		//finally construct a KPEvent
		kPEvent.setEvent(event);

		Log log =  writer.InsertKPEvent(kPEvent);
		
		assert(log.getCostOrPriceOrRoute() != null);
		
 	}
	
	private Log ConstructLogObjects(){
		//Construct a Log object
		Log log = new Log();
		//Construct a cost object
		Log.Cost cost = new Log.Cost();
		
		
		//Construct a price object
		Log.Price price = new Log.Price();
		price.setFrom("Welly");
		price.setTo("Auclland");
		price.setPriority("high");
		price.setVolumecost((short)10);
		price.setWeightcost((short)10);
		
		log.getCostOrPriceOrRoute().add(cost);
		log.getCostOrPriceOrRoute().add(price);
		
		return log;
		
	}
	
	
	

}
