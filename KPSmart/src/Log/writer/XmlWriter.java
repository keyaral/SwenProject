package Log.writer;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import Log.reader.XmlReader;

import Log.Log;
import Log.Log.Cost;
import Log.Log.Discontinue;
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
		jaxbMarshaller.marshal(log, System.out);
		
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

	
}
