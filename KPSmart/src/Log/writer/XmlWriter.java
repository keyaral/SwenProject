package Log.writer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import Log.reader.XmlReader;
import Logic.KPEvent;

import Log.Log;
import Log.Log.Cost;
import Log.Log.Discontinue;
import Log.Log.KPEvents;
import Log.Log.Mail;
import Log.Log.Price;
import Log.Log.Timelimit;
import Log.Log.Route;


public class XmlWriter implements IXmlWriter{
	
	private String _xmlPath = "";
	
	public XmlWriter(String xmlPath){
		_xmlPath = xmlPath;
	}

	@Override
	public Log WriteLog(Log log) {
		// TODO Auto-generated method stub
		//Unsafe, use carefully;
		
		try {
		
		File file = new File(_xmlPath);
		JAXBContext jaxbContext = JAXBContext.newInstance(Log.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(log, file);
		jaxbMarshaller.marshal(log, System.out); //TODO
		
		 } catch (JAXBException e) {
				e.printStackTrace();
			      }
		
		return log;
	}

	@Override
	public Log UpdateCost(Cost cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log UpdatePrice(Price price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log UpdateMail(Mail mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log UpdateTimeLimit(Timelimit timeLimit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log UpdateDiscontinue(Discontinue discontinue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log InsertCost(Cost cost) {
		// TODO Auto-generated method stub
		XmlReader reader =  new XmlReader(_xmlPath);
		Log log = reader.FindAll();
		log.getCostOrPriceOrRoute().add(cost);
		
		WriteLog(log);
		
		return log;
	}

	@Override
	public Log InsertPrice(Price price) {
		XmlReader reader =  new XmlReader(_xmlPath);
		Log log = reader.FindAll();
		log.getCostOrPriceOrRoute().add(price);
		
		WriteLog(log);
		
		return log;
	}

	@Override
	public Log InsertMail(Mail mail) {
		XmlReader reader =  new XmlReader(_xmlPath);
		Log log = reader.FindAll();
		log.getCostOrPriceOrRoute().add(mail);
		
		WriteLog(log);
		
		return log;
	}

	@Override
	public Log InsertTimeLimit(Timelimit timeLimit) {
		XmlReader reader =  new XmlReader(_xmlPath);
		Log log = reader.FindAll();
		log.getCostOrPriceOrRoute().add(timeLimit);
		
		WriteLog(log);
		
		return log;
	}

	@Override
	public Log InsertDiscontinue(Discontinue discontinue) {
		XmlReader reader =  new XmlReader(_xmlPath);
		Log log = reader.FindAll();
		log.getCostOrPriceOrRoute().add(discontinue);
		
		WriteLog(log);
		
		return log;
	}
	
	@Override
	public Log InsertRoute(Route route) {
		XmlReader reader =  new XmlReader(_xmlPath);
		Log log = reader.FindAll();
		log.getCostOrPriceOrRoute().add(route);
		
		WriteLog(log);
		
		return log;
	}

	@Override
	public Log InsertKPEvent(KPEvent event) {	
		// TODO Auto-generated method stub
		
		//load log
		XmlReader reader =  new XmlReader(_xmlPath);
		Log log = reader.FindAll();			
		//populate event field and add in event list
		KPEvents.Event kPEvent = new KPEvents.Event();
		kPEvent.setSuccess(event.success);
		kPEvent.setType(event.type);
		
		if(event.object.getClass() == Logic.Cost.class){
			//populate Cost object
			KPEvents.Event.Cost cost = new KPEvents.Event.Cost();
			Logic.Cost logicCost = (Logic.Cost) event.object;
			cost.setDestination(logicCost.destination);
			cost.setId(logicCost.ID);
			cost.setOrigin(logicCost.origin);
			cost.setPriority(logicCost.priority);
			cost.setVolume(logicCost.volume);
			cost.setWeight(logicCost.weight);
			kPEvent.getCostOrMailOrRoute().add(cost);
		}else if(event.object.getClass() == Logic.Mail.class){
			//populate Mail object
			KPEvents.Event.Mail mail = new KPEvents.Event.Mail();
			Logic.Mail logicMail = (Logic.Mail) event.object;
			mail.setCost(logicMail.cost);
			mail.setDate(logicMail.date);
			mail.setDestination(logicMail.destination);
			mail.setId(logicMail.ID);
			mail.setIncome(logicMail.income);
			mail.setName(logicMail.name);
			mail.setOrigin(logicMail.origin);
			mail.setPriority(logicMail.priority);
			mail.setTime(logicMail.time);
			mail.setVolume(logicMail.volume);
			mail.setWeight(logicMail.weight);
			kPEvent.getCostOrMailOrRoute().add(mail);
		}else if (event.object.getClass() == Logic.Route.class){
			//populate Route object
			KPEvents.Event.Route route = new KPEvents.Event.Route();
			Logic.Route logicRoute = (Logic.Route) event.object;
			
			route.setCompanyName(logicRoute.companyName);
			route.setCostVolume(logicRoute.costVolume);
			route.setCostWeight(logicRoute.costWeight);
			route.setDay(logicRoute.day);
			route.setDestination(logicRoute.destination);
			route.setDuration(logicRoute.duration);
			route.setFrequency(logicRoute.frequency);
			route.setId(logicRoute.ID);
			route.setMaxVolume(logicRoute.maxVolume);
			route.setMaxWeight(logicRoute.maxWeight);
			route.setOrigin(logicRoute.origin);
			route.setPriority(logicRoute.priority);
			
			kPEvent.getCostOrMailOrRoute().add(route);
		}

		//populate Mails
		Log.KPEvents.Event.Mails mails = new Log.KPEvents.Event.Mails();
		for(Logic.Mail logicMail:event.statistics.mails){
			KPEvents.Event.Mails.Mail mail = new KPEvents.Event.Mails.Mail();
			mail.setCost(logicMail.cost);
			mail.setDate(logicMail.date);
			mail.setDestination(logicMail.destination);
			mail.setId(logicMail.ID);
			mail.setIncome(logicMail.income);
			mail.setName(logicMail.name);
			mail.setOrigin(logicMail.origin);
			mail.setPriority(logicMail.priority);
			mail.setTime(logicMail.time);
			mail.setVolume(logicMail.volume);
			mail.setWeight(logicMail.weight);

			mails.getMail().add(mail);
		}
		
		kPEvent.getMails().add(mails);
		
		//populate routes
		//comment out. staticis class has been changed, routes has been removed.
		/*Log.KPEvents.Event.Routes routes = new Log.KPEvents.Event.Routes();
		for(Logic.Route logicRoute:event.statistics.routes){
			KPEvents.Event.Routes.Route route = new KPEvents.Event.Routes.Route();
			
			route.setCompanyName(logicRoute.companyName);
			route.setCostVolume(logicRoute.costVolume);
			route.setCostWeight(logicRoute.costWeight);
			route.setDay(logicRoute.day);
			route.setDestination(logicRoute.destination);
			route.setDuration(logicRoute.duration);
			route.setFrequency(logicRoute.frequency);
			route.setId(logicRoute.ID);
			route.setMaxVolume(logicRoute.maxVolume);
			route.setMaxWeight(logicRoute.maxWeight);
			route.setOrigin(logicRoute.origin);
			route.setPriority(logicRoute.priority);

			
			routes.getRoute().add(route);
		}
		
		kPEvent.getRoutes().add(routes);
		*/
		
		
		//Update KPEvents node
		
		
		Log.KPEvents kPEvents = reader.FindKPEvents();
		if(kPEvents == null){
			kPEvents = new Log.KPEvents();
			kPEvents.getEvent().add(kPEvent);
			log.getCostOrPriceOrRoute().add(kPEvents);
		}else{
			kPEvents.getEvent().add(kPEvent);
			for(Object o : log.getCostOrPriceOrRoute()){
				if(o.getClass()==Log.KPEvents.class){
					((Log.KPEvents) o).getEvent().add(kPEvent);
				}
			}
		}
		
		
		WriteLog(log);
		
		return log;
	}

	
}
