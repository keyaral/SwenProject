package Logic;//

import gui.MainWindow;

import java.awt.List;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import Log.Log;
import Log.Log.KPEvents;
import Log.Log.KPEvents.Event;
import Log.Log.KPEvents.Event.Routes;
import Log.reader.XmlReader;
import Log.writer.*;



public class EventProcesser {

	RouteListClass routes = new RouteListClass();

	CostListClass costs = new CostListClass();;
	MailDelivery mailList = new MailDelivery();
	ArrayList<KPEvent> events = new ArrayList<KPEvent>();
	String fail = "";

	Cost tempCost = null;
	Route tempRoute = null;
	Mail tempMail = null;


	private String _xmlPath = "file.xml";

	Statistics currentStats;


	public EventProcesser(Statistics stats) {

		currentStats = stats;
		currentStats.setRouteList(routes);
		currentStats.setCostList(costs);

		LoadpreviousEvents();


	}


	private void LoadpreviousEvents() {

		//Read all KPEvents from file.xml
		XmlReader reader = new XmlReader(_xmlPath);
		Log.KPEvents loKPEvents = reader.FindKPEvents();

		//Convert Log.KPEvents to Logic.KPEvents and save in events collection

		for(Log.KPEvents.Event e : loKPEvents.getEvent()){
			String type = e.getType();
			Boolean isSuccess = e.isSuccess();
			Object obj = e.getCostOrMailOrRoute().get(0);		
		
			System.out.print(" 11 ");
			addXMLevent(type, obj);
			//KPEvent kpe = new KPEvent(type,obj,isSuccess,null);
		//	events.add(kpe);


		
		}

	}





	public void addXMLevent( String t, Object object) {
		try {
	String[] tempArray = new String[] {""};
	System.out.print(" 12 ");
		String type = t;
		Object ob = object;
		
		if(ob.getClass().toString().equals("class Log.Log$KPEvents$Event$Cost")){
		
		
	 Log.KPEvents.Event.Cost c = ( Log.KPEvents.Event.Cost) ob;
	  tempCost = new Cost(c.getId(), c.getWeight(),c.getVolume(),c.getDestination(),c.getOrigin(),c.getPriority());
	
	  System.out.print(" 1 COST ");
		
		if (type.equals("Add") ) {
			System.out.print(" 1 cost add ");
			addCost(tempArray);
		}

		
		
		else if (type.equals("Change") ) { 
			System.out.print(" 1 cost change ");
			changeCost(tempArray);   }
		

		else System.out.print("COST EVENT FAIL");

	    tempCost = null;
	}

		
		if(ob.getClass().toString().equals("class Log.Log$KPEvents$Event$Mail")){
			
			
			 Log.KPEvents.Event.Mail m = ( Log.KPEvents.Event.Mail) ob;
			  tempMail = new Mail( m.getId(),m.getDestination(),m.getOrigin(),
					  m.getWeight(),m.getVolume(),m.getPriority(), m.getDate(), m.getTime()  );
			
			
		
		
			System.out.print(" 1 mail ");
		
		if (type.equals("Send") ) { deliverMail(tempArray);   }

		tempMail=null;

		}


		if(ob.getClass().toString().equals("class Log.Log$KPEvents$Event$Route")){
			
			
			 Log.KPEvents.Event.Route r = ( Log.KPEvents.Event.Route) ob;
			  tempRoute = new Route(r.getId(), r.getDestination(),r.getOrigin(),r.getCostWeight(), r.getCostVolume(),
					 r.getMaxWeight(), r.getMaxVolume(), r.getPriority(), 
					 r.getDay(), r.getFrequency(), r.getDuration(), r.getCompanyName() );
			
			  
			
			  
			if (type.equals("Add") ) { 
				System.out.print(" 2 route Add ");

				addRoute(tempArray);
			}

			if (type.equals("Change") ) {
				System.out.print(" 2 route change ");
				changeRoute(tempArray);
			}

			if (type.equals("Remove") ) {
				discontineRoute(tempArray);
			}

			
		}

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}






	public ArrayList<Destination> validOrigin(){

		return null;
	}
public ArrayList<Destination> validDestinations(){

		return null;
	}



	public String proccess(String[] details) throws Exception {

//  checkDetails( details, details[0]);
		int type = Integer.parseInt(details[0]);
		Boolean safe = false;
		String message = "error";
	/**
	 * Case Switch
	 *
	 *
	 * 0 = Add route
	 * 1 = change Route
	 * 2 = discontine Route
	 * 3 = Add Cost
	 * 4 = Change Cost
	 * 5 Deliver Mail
	 *
	 */

switch (type) {


		case 0:   message = addRoute(details) ;
		  break;
		case 1:  message =  changeRoute(details);
		  break;
		case 2: message =   discontineRoute(details);
		  break;
		case 3: message =  addCost(details);
    	  break;
		case 4: message =  changeCost(details);
		  break;
		case 5:  message =  deliverMail(details);
		  break;
		 default: message = error(details, " Not a valid Type");
         break;

		}
		return message;

	}



		/**
		 * A method that will return an error message.
		 *
		 * I have put this in place so we can trace to an error method call.
		 *
		 * @param details String Array of event informations
		 * @param string Error message from a problems
		 * @return
		 */
			private String error(String[] details, String string) {

		return "error: "+string;
	}
/**
 *Method for handling Mail Delivery events
 *It calls find valid cost and valid route from the RouteList and CostList classes.
 *
 * It then determines if the mail can be sent, and calls MailDelivery Class to update systems state and statisitcs.
 *
 * If successful a confimtion message is returned, else an error message
 */

		private String deliverMail(String[] details) throws CloneNotSupportedException {
			Mail m;

			if ( details.length < 4 ){
				if (tempMail == null){ System.out.print( " no temp"); }
				m = tempMail; }

			else  m = new Mail(details);



			if ( DomesticPriorityFailure(m.destination, m.origin, m.priority) )
				return "Invalid Destination Orgin Priority Match ";

			mailList.assignDestinations(m);
			Cost c = costs.findValidCost(m);
			if (c==null){ return error(details, "No valid Cost"); }
			RouteChain r = routes.findValidRoute(m);
			if (r==null){ return error(details, "No valid Route"); }



			Boolean success = mailList.deliverMail(m, r, c);
			if (success){
				addEvent("Send", success, m);
				Log.Mail mail = new Log.Mail();
				LogMail(mail,m);
				return "Mail: " +  m.ID + " was successfully sent";
			}
			return error(details, "Mail was not sent");
	}
		private void LogMail(Log.Mail mail, Mail m){
			//Log mail send
			XmlWriter writer = new XmlWriter(_xmlPath);
			mail.setCost(m.cost);
			mail.setDate(m.date);
			mail.setDestination(m.destination);
			mail.setId(m.ID);
			mail.setIncome(m.income);
			mail.setName(m.name);
			mail.setOrigin(m.origin);
			mail.setPriority(m.priority);
			mail.setTime(m.time);
			mail.setVolume(m.volume);
			mail.setWeight(m.weight);
			writer.InsertMail(mail);
		}

		/**
		 *Method for handling Changing Costs events
		 *
		 *Makes a new cost, and then tries to change it.
		 *
		 * If successful a confimtion message is returned, else an error message
		 */



		private String changeCost(String[] details) throws CloneNotSupportedException {
		Cost c;
		
		System.out.print(" 3 cost  change ");

			if ( details.length < 4  ){
				if (tempCost == null){ System.out.print( " no temp"); }
				c = tempCost; }

			else  c = new Cost(details);

			if (! costs.contains(c) ) { return error(details, "Cost does not exist to change. Please consider adding"); }

			if ( DomesticPriorityFailure(c.destination, c.origin, c.priority) )
				return "Invalid Destination Orgin Priority Match ";

			Boolean success = costs.changeCost(c);

			if (success ){



			addEvent("Change", success, c);
			Log.Cost cost  = new Log.Cost();
			LogCost(cost,c);
			return "Cost: " +  c.ID + " was successfully changed"; }

			else return error(details, "Cost was not changed");
	}

		/**
		 *Method for handling adding Costs events
		 *
		 *Makes a new cost, and then tries to add it.
		 *
		 * If successful a confimtion message is returned, else an error message
		 *
		 * If new Destinations are created by the KpCost, then they are added and it is reported
		 */


		private String addCost(String[] details) throws CloneNotSupportedException {
			Cost c;
		
			if ( details.length < 4 ){
				if (tempCost == null){ System.out.print( " no temp"); }
				c = tempCost; }

			else c = new Cost(details);

			if ( DomesticPriorityFailure(c.destination, c.origin, c.priority) )
				return "Invalid Destination Orgin Priority Match ";
			Boolean success = costs.addCost(c);



			boolean neworigin = ! mailList.containsDesString(c.origin);
			boolean newdest = ! mailList.containsDesString(c.destination);

			if (success) {


				addEvent("Add", success, c);
				Log.Cost cost  = new Log.Cost();
				LogCost(cost,c);




				String result = "Cost: " + c.ID + " was successfully added";
				if (neworigin) {
					result += "\n A new origin is avaliable: "+ c.origin;
					mailList.allDestinations.add(new Destination(c.origin,false));
				}
				if (newdest) {
					result+= "\n A new destination is avaliable" + c.destination;
					mailList.allDestinations.add(new Destination(c.destination,false));
				}
				return result;
				}
			else { return error(details, "Cost was not added"); }


	}

		private void LogCost(Log.Cost cost, Cost c){
			XmlWriter writer = new XmlWriter(_xmlPath);
			cost.setDestination(c.destination);
			cost.setId(c.ID);
			cost.setOrigin(c.origin);
			cost.setPriority(c.priority);
			cost.setVolume(c.volume);
			cost.setWeight(c.weight);
			writer.InsertCost(cost);

		}

		/**
		 *Method for handling adding Costs events
		 *
		 *Makes a new cost, and then tries to add it.
		 *
		 * If successful a confimtion message is returned, else an error message
		 */



		private String discontineRoute(String[] details) throws CloneNotSupportedException {
			Route r;
			if (details.length < 4){
				if (tempRoute == null){ System.out.print( " no temp"); }
				r = tempRoute; }
			else r = new Route(details);



			mailList.assignDestinations(r);

			if (! routes.contains(r) ) { return error(details, "Route does not exist to change. Please consider adding"); }

			if ( DomesticPriorityFailure(r.destination, r.origin, r.priority) )
				return "Invalid Destination Orgin Priority Match ";


			Boolean success = routes.deleteRoute(r);



			if(success)	{


				addEvent("Remove", success, r);
				Log.Route route = new Log.Route();
				LogRoute(route,r);
				return "Route: " + r.ID + " was successfully deleted"; }

			return error(details, "Route was not deleted ");
	}

		private String changeRoute(String[] details) throws CloneNotSupportedException {
			Route r;
			
			System.out.print(" 3 Route  change ");
			if (details.length < 4){
				if (tempRoute == null){ System.out.print( " no temp"); }
				r = tempRoute; }
			else r = new Route(details);


			mailList.assignDestinations(r);

			if (! routes.contains(r) ) { return error(details, "Route does not exist to change. Please consider adding"); }

			if ( DomesticPriorityFailure(r.destination, r.origin, r.priority) )
				return "Invalid Destination Orgin Priority Match ";

			Boolean success = routes.changeRoute(r);

			if(success)	{



				addEvent("Change", success, r);
				Log.Route route = new Log.Route();
				LogRoute(route,r);
				return "Route: " + r.ID + " was successfully changed ";
			}

			else return error(details, "Route was not changed");


	}

		private String addRoute(String[] details) throws CloneNotSupportedException {
			Route r;
			
			System.out.print(" 3 Route add  ");
			if (details.length < 4){
				if (tempRoute == null){ System.out.print( " no temp"); }
				r = tempRoute; }
			else r = new Route(details);

			if ( DomesticPriorityFailure(r.destination, r.origin, r.priority) )
				return "Invalid Destination Orgin Priority Match ";

			mailList.assignDestinations(r);
			Boolean success = routes.addRoute(r);

			if (success){
				addEvent("Add", success, r);
				//log add route
				Log.Route route = new Log.Route();
				LogRoute(route,r);
				return "Route: " + r.ID + " was successfully added ";
			}

			else { return error(details, "Route was not added - it already exists"); }


		}

		private void LogRoute(Log.Route route, Route r){
			//log add route
			XmlWriter writer = new XmlWriter(_xmlPath);
			route.setCompanyName(r.companyName);
			route.setCostVolume(r.costVolume);
			route.setCostWeight(r.costWeight);
			route.setDay(r.day);
			route.setDestination(r.destination);
			route.setDuration(r.duration);
			route.setFrequency(r.frequency);
			route.setId(r.ID);
			route.setMaxVolume(r.maxVolume);
			route.setMaxWeight(r.maxWeight);
			route.setOrigin(r.origin);
			route.setPriority(r.priority);
			writer.InsertRoute(route);
		}







	private boolean checkDetails(String[] values, String type) throws Exception {

		if (type.equals("0")) {

				int ID = Integer.parseInt(values[1]);
				String destination = (values[2]);
				String origin = (values[3]);
				int costWeight = Integer.parseInt(values[4]);
				int costVolume = Integer.parseInt(values[5]);
				int maxWeight = Integer.parseInt(values[6]);
				int maxVolume = Integer.parseInt(values[7]);
				int priority = Integer.parseInt(values[8]);
				String day = (values[9]);
				int frequency = Integer.parseInt(values[10]);
				int duration = Integer.parseInt(values[11]);
				String companyName = (values[12]);
				if (destination == null || origin == null || day == null
						|| companyName == null) {
					fail = " Null Values Entered in route adding - strings"; }

				if ( DomesticPriorityFailure( destination, origin, priority) )
					fail ="Invalid Destination Orgin Priority Match ";


		}
		if (type.equals("1")) {
			try {
				int ID = Integer.parseInt(values[1]);
				String destination = (values[2]);
				String origin = (values[3]);
				int costWeight = Integer.parseInt(values[4]);
				int costVolume = Integer.parseInt(values[5]);
				int maxWeight = Integer.parseInt(values[6]);
				int maxVolume = Integer.parseInt(values[7]);
				int priority = Integer.parseInt(values[8]);
				String day = (values[9]);
				int frequency = Integer.parseInt(values[10]);
				int duration = Integer.parseInt(values[11]);
				String companyName = (values[12]);
				if (destination == null || origin == null || day == null
						|| companyName == null)
					throw new Exception(
							"Null Values Entered in route adding - strings");

				if ( DomesticPriorityFailure( destination, origin, priority) )
					throw new Exception(
							"Invalid Destination Orgin Priority Match ");

			} catch (Exception e) {
				throw new Exception(
						"Null Values Entered in route adding - ints");
			}
		}
		if (type.equals("2")) {
			try {
				int ID = Integer.parseInt(values[1]);
			} catch (Exception e) {
				throw new Exception("Error in entering an ID to delete");
			}
		}
		if (type.equals("3")) {
			try {
				int ID = Integer.parseInt(values[1]);
				int weight = Integer.parseInt(values[2]);
				int volume = Integer.parseInt(values[3]);
				String destination = (values[4]);
				String origin = (values[5]);
				int priority = Integer.parseInt(values[6]);
				if (destination == null || origin == null)
					throw new Exception(
							"Null Values Entered in cost adding - strings");

				if ( DomesticPriorityFailure( destination, origin, priority) )
						throw new Exception(
								"Invalid Destination Orgin Priority Match ");
			} catch (Exception e) {
				throw new Exception("Null values entered in cost adding - ints");
			}
		}
		if (type.equals("4")) {
			try {
				int ID = Integer.parseInt(values[1]);
				int weight = Integer.parseInt(values[2]);
				int volume = Integer.parseInt(values[3]);
				String destination = (values[4]);
				String origin = (values[5]);
			} catch (Exception e) {
				throw new Exception("Error in entering an ID or values");
			}
		}

		if (type.equals("5")) {
			try {
				int ID = Integer.parseInt(values[1]);
				String destination = (values[2]);
				String origin = (values[3]);
				int weight = Integer.parseInt(values[4]);
				int volume = Integer.parseInt(values[5]);
				int priority = Integer.parseInt(values[6]);
				//Date date = new Date();
				DateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
				dateFormat.parse(values[7]);
				//date.parse(values[6]);
				if (destination == null || origin == null || dateFormat == null)
					throw new Exception(
							"Null values in mail creation for destination/origin or date");
				if ( DomesticPriorityFailure( destination, origin, priority) )
					throw new Exception(
							"Invalid Destination Orgin Priority Match ");

			} catch (Exception e) {

				throw new Exception("Error in creating a new mail");
			}
		}
		return true;
	}

	private boolean DomesticPriorityFailure(String destination, String origin,int priority) {

		Boolean originD = mailList.isDomestic(origin);
		Boolean destinationD =  mailList.isDomestic(destination);

		if (originD && destinationD) {if (priority < 3) return true;
									else return false;}

		else if (priority > 2) return true;

		return false;
	}

	/**
	 * Adds in the event based on the type and object assigned
	 * with it as the current statistics at this stage. Note that
	 * for an object that changes, two objects will be needed to
	 * set the objects
	 *
	 */
	private void addEvent(String type, boolean success, Object o) throws CloneNotSupportedException{
		if (o instanceof Mail) {
			Mail m = (Mail) o;
			currentStats.setRevenue(mailList.gettRevenue());
			currentStats.setExpenditure(mailList.gettExpediture());
			currentStats.mails.add(m);

			KPEvent event = new KPEvent(type, m, success, new Statistics((Statistics)currentStats.clone()));
			events.add(new KPEvent(type, m, success, new Statistics((Statistics)currentStats.clone())));
			XmlWriter writer = new XmlWriter("file.xml");
			writer.InsertKPEvent(new KPEvent(type, m, success, new Statistics((Statistics)currentStats.clone())));


		}
		else if (o instanceof Route) {
			Route r = (Route) o;
			events.add(new KPEvent(type, r, success, new Statistics((Statistics)currentStats.clone())));
			XmlWriter writer = new XmlWriter("file.xml");
			writer.InsertKPEvent(new KPEvent(type, r, success, new Statistics((Statistics)currentStats.clone())));
		}
		else if (o instanceof Cost){
			Cost c = (Cost) o;
			events.add(new KPEvent(type, c, success, new Statistics((Statistics)currentStats.clone())));
			XmlWriter writer = new XmlWriter("file.xml");
			writer.InsertKPEvent(new KPEvent(type, c, success, new Statistics((Statistics)currentStats.clone())));
		}
		currentStats.incrementEvents();
	}

	public ArrayList<KPEvent> getEvents() {
		return events;
	}

	public Statistics getStats() {
		return currentStats;
	}
	public  RouteListClass getRoutes() {
		return routes;
	}

	public  CostListClass getCosts() {
		return costs;
	}

	public  MailDelivery getMailList() {
		return mailList;
	}

}
