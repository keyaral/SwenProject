package Logic;//

import java.util.ArrayList;
import java.util.Date;

public class EventProcesser {

	RouteListClass routes = new RouteListClass();
	CostListClass costs = new CostListClass();;
	ArrayList<KPEvent> events = new ArrayList<KPEvent>();

	public EventProcesser() {
		 
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
	 * 
	 * 3 = Add Cost
	 * 4 = Change Cost
	 * 
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
			
			
			private String error(String[] details, String string) {
		// TODO Auto-generated method stub
		return null;
	}

		private String deliverMail(String[] details) throws CloneNotSupportedException {
			Mail m = new Mail(details);
			// TODO ShipMail
			KPEvent e = new KPEvent("Send", m, true, (Statistics)Logic.stats.clone());
			// e.addStats;
			events.add(e);
			
		// TODO Auto-generated method stub
		return null;
	}

		private String changeCost(String[] details) throws CloneNotSupportedException {
			
			Cost c = new Cost(details);
			Boolean success = costs.changeCost(c);
			KPEvent e = new KPEvent("Change", c, success, (Statistics)Logic.stats.clone());
			// e.addStats;
			events.add(e);	
			
		// TODO Auto-generated method stub
		return null;
	}

		private String addCost(String[] details) throws CloneNotSupportedException {
			Cost c = new Cost(details);
			Boolean success = costs.addCost(c);
			KPEvent e = new KPEvent("Add", c, success , (Statistics)Logic.stats.clone());
			// e.addStats;
			events.add(e);
			
			
		// TODO Auto-generated method stub
		return null;
	}

		
		
		
		private String discontineRoute(String[] details) throws CloneNotSupportedException {
			Route r = new Route(details);
			Boolean success = routes.deleteRoute(r);
			KPEvent e = new KPEvent("Delete", r, success,  (Statistics)Logic.stats.clone());
			// e.addStats;
			events.add(e);
			
			
		// TODO Auto-generated method stub
		return null;
	}

		private String changeRoute(String[] details) throws CloneNotSupportedException {
			
			Route r = new Route(details);
			Boolean success = routes.changeRoute(r);
			KPEvent e = new KPEvent("Change", r, success,  (Statistics)Logic.stats.clone());
			// e.addStats;
			events.add(e);
			// TODO Auto-generated method stub
			return null;
			
		
	}

		private String addRoute(String[] details) throws CloneNotSupportedException {
			Route r = new Route(details);
			Boolean success = routes.addRoute(r);
			KPEvent e = new KPEvent("Add", r, success, (Statistics)Logic.stats.clone());
			// e.addStats;
			events.add(e);	
		
			// TODO Auto-generated method stub
			return null;
			
		
			
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