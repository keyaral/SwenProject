package Log.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Log.*;
import Log.Log.Cost;
import Log.Log.KPEvents;
import Log.Log.KPEvents.Event;
import Log.Log.*;
import Logic.KPEvent;

public class XmlReader implements IXmlReader{
	
	private String _xmlPath = "";
	
	public XmlReader(String xmlPath){
		_xmlPath = xmlPath;
	}


	@Override
	public Log FindAll() {
		// TODO Auto-generated method stub
		try {
			 
			File file = new File(_xmlPath);
			JAXBContext jaxbContext = JAXBContext.newInstance(Log.class);
	 
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Log log = (Log) jaxbUnmarshaller.unmarshal(file);
			
			
			return log;
	 
		  } catch (JAXBException e) {
			e.printStackTrace();
			return null;
		  }
		
	}

	@Override
	public ArrayList<Cost> FindCost() {
		// TODO Auto-generated method stub
		Log log = FindAll();
		
		ArrayList<Cost> cost = new ArrayList<Cost>();
		for(Object obj : log.getCostOrPriceOrRoute()){
			if (obj.getClass() == Cost.class){
				cost.add((Cost)obj);
			}
		}
		
		
		return cost;
	}

	@Override
	public ArrayList<Price> FindPrice() {
		// TODO Auto-generated method stub
		Log log = FindAll();
		
		ArrayList<Price> price = new ArrayList<Price>();
		for(Object obj : log.getCostOrPriceOrRoute()){
			if (obj.getClass() == Price.class){
				price.add((Price)obj);
			}
		}
		
		
		return price;
	}

	@Override
	public ArrayList<Timelimit> FindTimelimit() {
		// TODO Auto-generated method stub
		Log log = FindAll();
		
		ArrayList<Timelimit> timeLimit = new ArrayList<Timelimit>();
		for(Object obj : log.getCostOrPriceOrRoute()){
			if (obj.getClass() == Timelimit.class){
				timeLimit.add((Timelimit)obj);
			}
		}
		
		
		return timeLimit;
	}

	@Override
	public  ArrayList<Discontinue> FindDiscontinue() {
		// TODO Auto-generated method stub
		Log log = FindAll();
		
		ArrayList<Discontinue> discontinue = new ArrayList<Discontinue>();
		for(Object obj : log.getCostOrPriceOrRoute()){
			if (obj.getClass() == Discontinue.class){
				discontinue.add((Discontinue)obj);
			}
		}
		
		
		return discontinue;
		
	}

	@Override
	public ArrayList<Mail> FindMail() {
		// TODO Auto-generated method stub
		Log log = FindAll();
		
		ArrayList<Mail> mail = new ArrayList<Mail>();
		for(Object obj : log.getCostOrPriceOrRoute()){
			if (obj.getClass() == Mail.class){
				mail.add((Mail)obj);
			}
		}
		
		
		return mail;
	}	
	
	@Override
	public Log.KPEvents FindKPEvents() {
		// TODO Auto-generated method stub
		Log log = FindAll();
		
		for(Object o : log.getCostOrPriceOrRoute()){
			if(o.getClass()==Log.KPEvents.class){
			return (Log.KPEvents) o;	
			}
		}
		
		return null;
		
	}

}
