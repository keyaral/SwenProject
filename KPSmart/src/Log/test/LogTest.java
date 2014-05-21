package Log.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import Log.reader.*;
import Log.writer.XmlWriter;
import Log.Log;
import Log.Log.KPEvents;
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
		String type = "addCost";
		Logic.Cost cost = new Logic.Cost(1, 2.0, 3.0, "Auckland", "Wellington", 1);
		
		Logic.Statistics statics = new Logic.Statistics();
		Logic.Mail mail1 = new Logic.Mail(1, "Auckland", "Wellington", 2.0, 3.0, 3, new Date(2014,05,20,0,0),13.0);
		statics.mails.add(mail1);
		Logic.Mail mail2 = new Logic.Mail(1, "Palmerston North", "Wellington", 2.0, 3.0, 3, new Date(2014,05,20,0,0),13.0);
		statics.mails.add(mail2);
		
		/*Logic.Route route1 = new Logic.Route(1, "Auckland", "Wellington", 2.0, 2.0, 2.0, 2.0, 1, "test", 3.0, 3.0, "test again");
		statics.routes.add(route1);
		Logic.Route route2 = new Logic.Route(1, "Palmerston North", "Wellington", 2.0, 2.0, 2.0, 2.0, 1, "test", 3.0, 3.0, "test again");
		statics.routes.add(route2);*/
		
		Logic.KPEvent kPEvent = new Logic.KPEvent(type, cost, true, statics);
		
		Log log = writer.InsertKPEvent(kPEvent);
		
		boolean found = false;
		for(Object o : log.getCostOrPriceOrRoute() ){
			if (o.getClass() == Log.KPEvents.class){
				found = true;
			}
		}
		
		assert(found);
		
		
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
