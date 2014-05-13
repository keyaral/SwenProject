package Log.test;

import java.util.ArrayList;

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
