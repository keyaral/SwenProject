package Logic;//

import java.util.ArrayList;
import java.util.Date;

public class EventProcesser {

	RouteListClass routes = new RouteListClass();
	CostListClass costs = new CostListClass();;
	ArrayList<KPEvent> events = new ArrayList<KPEvent>();
	MailDelivery mailList = new MailDelivery();
//	Statistics currentStats = new Statistics();
	public EventProcesser() {
		 
	}
	
	public ArrayList<Destination> validOrigin(){
		
		return null;
	}
public ArrayList<Destination> validDestinations(){
		
		return null;
	}
	
	

	public String proccess(String[] details) throws Exception {
System.out.println( details);
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
			Mail m = new Mail(details);
			Route r = routes.findValidRoute(m);
			Cost c = costs.findValidCost(m);
			
			if (r==null){ return error(details, "No valid Route"); }
			if (c==null){ return error(details, "No valid Cost"); }
			
			Boolean success = mailList.deliverMail(m, r, c);
			if (success ){
			KPEvent e = new KPEvent("Send", m, success, (Statistics)Logic.stats.clone());
			events.add(e);
			MainWindow.logic.stats.mails.add(m);
			MainWindow.logic.stats.addRevenue((int)m.cost);
			MainWindow.logic.stats.addRevenue((int)r.cost);
			MainWindow.logic.stats.incrementEvents();
			return "Mail: " +  m.ID + " was successfully sent"; 
			}		
			return error(details, "Cost was not Changes");
	} 

		/**
		 *Method for handling Changing Costs events
		 *
		 *Makes a new cost, and then tries to change it. 
		 *
		 * If successful a confimtion message is returned, else an error message
		 */
		
		
		
		private String changeCost(String[] details) throws CloneNotSupportedException {
			
			Cost c = new Cost(details);
			
			Boolean success = costs.changeCost(c);
			
			if (success ){
			KPEvent e = new KPEvent("Change", c, success, (Statistics)Logic.stats.clone());
			events.add(e);	
			
			return "Cost: " +  c.ID + " was successfully changed"; }
		
			else return error(details, "Cost was not Changes");
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
			Cost c = new Cost(details);
			Boolean success = costs.addCost(c);
			
			boolean neworigin = ! mailList.allDestinations.contains(c.origin);
			boolean newdest = ! mailList.allDestinations.contains(c.destination);
			 
				
			
			if ( neworigin && newdest && success) {
				mailList.allDestinations.add(new Destination(c.origin,false)); mailList.allDestinations.add(new Destination(c.destination,false));
				KPEvent e = new KPEvent("Add", c, success , (Statistics)Logic.stats.clone());
				events.add(e);
				
				return "Cost: " + c.ID + " was successfully added  "
																+ "	\n a new origin is avaliable: "+ c.origin
																+ "\n a new destination is avaliable" + c.destination; }
			
			else if ( neworigin && success ) {
				KPEvent e = new KPEvent("Add", c, success , (Statistics)Logic.stats.clone());
				events.add(e);
				mailList.allDestinations.add(new Destination (c.origin,false));  	
				return "Cost: " + c.ID + " was successfully added."
												+ "	\n A new origin is avaliable: "+ c.origin; }
			
			else if ( newdest && success) {
				KPEvent e = new KPEvent("Add", c, success , (Statistics)Logic.stats.clone());
				events.add(e);
				mailList.allDestinations.add(new Destination(c.destination,false));
				return "Cost: " + c.ID + " was successfully added." 
												+ "\n a new destination is avaliable" + c.destination; }
			
			else if (success) {
				KPEvent e = new KPEvent("Add", c, success , (Statistics)Logic.stats.clone());
				events.add(e);
				return "Cost: " + c.ID + " was successfully added";  	}
			
 			
			else { return error(details, "Cost was not added"); }
			 
	
	}

		/**
		 *Method for handling adding Costs events
		 *
		 *Makes a new cost, and then tries to add it. 
		 *
		 * If successful a confimtion message is returned, else an error message
		 */	
		
		
		
		private String discontineRoute(String[] details) throws CloneNotSupportedException {
			Route r = new Route(details);
			Boolean success = routes.deleteRoute(r);
			
			
			
			if(success)	{ 
				KPEvent e = new KPEvent("Delete", r, success,  (Statistics)Logic.stats.clone());
				// e.addStats;
				events.add(e);
				return "Route: " + r.ID + " was successfully deleted"; }
			
			return error(details, "Route was not deleted ");
	}

		private String changeRoute(String[] details) throws CloneNotSupportedException {
			
			Route r = new Route(details);
			Boolean success = routes.changeRoute(r);
			
			if(success)	{
				KPEvent e = new KPEvent("Change", r, success,  (Statistics)Logic.stats.clone());
				events.add(e);
				MainWindow.logic.stats.incrementEvents();
			return "Route: " + r.ID + " was successfully changed ";  } 
			
			else return error(details, "Route was not Changes");
			
		
	}

		private String addRoute(String[] details) throws CloneNotSupportedException {
			Route r = new Route(details);
			Boolean success = routes.addRoute(r);
			
		
			if (success)	{ 
				KPEvent e = new KPEvent("Add", r, success, (Statistics)Logic.stats.clone());
				events.add(e);
				MainWindow.logic.stats.incrementEvents();
				return "Route: " + r.ID + " was successfully added "; }
			
			
			else { return error(details, "Route was not added"); }
		
			
		}







	private boolean checkDetails(String details, String type) throws Exception {
		String check = details;
		String[] values = check.split("\t");
		if (type.equals("1a")) {
			try {
				int ID = Integer.parseInt(values[0]);
				String destination = (values[1]);
				String origin = (values[2]);
				int costWeight = Integer.parseInt(values[3]);
				int costVolume = Integer.parseInt(values[4]);
				int maxWeight = Integer.parseInt(values[5]);
				int maxVolume = Integer.parseInt(values[6]);
				int priority = Integer.parseInt(values[7]);
				String day = (values[8]);
				int frequency = Integer.parseInt(values[9]);
				int duration = Integer.parseInt(values[10]);
				String companyName = (values[11]);
				if (destination == null || origin == null || day == null
						|| companyName == null)
					throw new Exception(
							"Null Values Entered in route adding - strings");
			} catch (Exception e) {
				throw new Exception(
						"Null Values Entered in route adding - ints");
			}
		}
		if (type.equals("1b")) {
			try {
				int ID = Integer.parseInt(values[0]);
				int costWeight = Integer.parseInt(values[3]);
				int costVolume = Integer.parseInt(values[4]);
			} catch (Exception e) {
				throw new Exception("Error in entering an ID or cost values");
			}
		}
		if (type.equals("1c")) {
			try {
				int ID = Integer.parseInt(values[0]);
			} catch (Exception e) {
				throw new Exception("Error in entering an ID to delete");
			}
		}
		if (type.equals("2a")) {
			try {
				int ID = Integer.parseInt(values[0]);
				int weight = Integer.parseInt(values[1]);
				int volume = Integer.parseInt(values[2]);
				String destination = (values[3]);
				String origin = (values[4]);
				int priority = Integer.parseInt(values[5]);
				if (destination == null || origin == null)
					throw new Exception(
							"Null Values Entered in cost adding - strings");
			} catch (Exception e) {
				throw new Exception("Null values entered in cost adding - ints");
			}
		}
		if (type.equals("2b")) {
			try {
				int ID = Integer.parseInt(values[0]);
				int weight = Integer.parseInt(values[1]);
				int volume = Integer.parseInt(values[2]);
				String destination = (values[3]);
				String origin = (values[4]);
			} catch (Exception e) {
				throw new Exception("Error in entering an ID or values");
			}
		}
		if (type.equals("2c")) {
			try {
				int ID = Integer.parseInt(values[0]);
			} catch (Exception e) {
				throw new Exception("Error in entering an ID to delete");
			}
		}
		if (type.equals("3a")) {
			try {
				int ID = Integer.parseInt(values[0]);
				String destination = (values[1]);
				String origin = (values[2]);
				int weight = Integer.parseInt(values[3]);
				int volume = Integer.parseInt(values[4]);
				int priority = Integer.parseInt(values[5]);
				Date date = new Date();
				date.parse(values[6]);
				if (destination == null || origin == null || date == null)
					throw new Exception(
							"Null values in mail creation for destination/origin or date");
			} catch (Exception e) {
				throw new Exception("Error in creating a new mail");
			}
		}
		return true;
	}
	
	public ArrayList<KPEvent> getEvents() {
		return events;
		}

}
