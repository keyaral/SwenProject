package Logic;//

import gui.MainWindow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EventProcesser {

	RouteListClass routes;
	CostListClass costs;
	MailDelivery mailList = new MailDelivery();
	ArrayList<KPEvent> events = new ArrayList<KPEvent>();

	public EventProcesser() {
		routes = new RouteListClass();
		costs = new CostListClass();
	}

	public String proccess(String details) throws Exception {

		String type = details.substring(0, 2);
		Boolean safe = false;
		if (type.equals("1a") || type.equals("1b") || type.equals("1c")
				|| type.equals("2a") || type.equals("2b") || type.equals("2c")
				|| type.equals("3a"))
			safe = true;
		// if (safe == false) throw new
		// Exception("Error in Input: Can't detect type.");
		if (safe == false)
			return "Error not a valid event";
		details = details.substring(3);
		if (type.equals("1a")) {// call routes
			if (!checkDetails(details, type))
				;
			Route r = new Route(details);
			Boolean success = routes.addRoute(r);
			KPEvent e = new KPEvent("Add", r, success, (Statistics)MainWindow.logic.stats.clone());
			events.add(e);
		}
		if (type.equals("1b")) {
			if (!checkDetails(details, type))
				;
			Route r = new Route(details);
			Boolean success = routes.changeRoute(r);
			KPEvent e = new KPEvent("Change", r, success, (Statistics)MainWindow.logic.stats.clone());
			events.add(e);
		}

		if (type.equals("1c")) {
			if (!checkDetails(details, type))
				;
			Route r = new Route(details);
			Boolean success = routes.deleteRoute(r);
			KPEvent e = new KPEvent("Delete", r, success, (Statistics)MainWindow.logic.stats.clone());
			events.add(e);
		}

		if (type.equals("2a")) {// call Costs
			if (!checkDetails(details, type))
				;
			Cost c = new Cost(details);
			Boolean success = costs.addCost(c);
			KPEvent e = new KPEvent("Add", c, success, (Statistics)MainWindow.logic.stats.clone());
			events.add(e);
		}
		if (type.equals("2b")) {// call Costs
			if (!checkDetails(details, type))
				;
			Cost c = new Cost(details);
			Boolean success = costs.changeCost(c);
			KPEvent e = new KPEvent("Change", c, success, (Statistics)MainWindow.logic.stats.clone());
			events.add(e);
		}
		if (type.equals("2c")) {// call Costs
			if (!checkDetails(details, type))
				;
			Cost c = new Cost(details);
			Boolean success = costs.deleteCost(c);
			KPEvent e = new KPEvent("Delete", c, success, (Statistics)MainWindow.logic.stats.clone());
			events.add(e);
		}

		if (type.equals("3a")) {// call Mail
			if (!checkDetails(details, type))
				;
			Mail m = new Mail(details);
			// TODO ShipMail
			KPEvent e = new KPEvent("Send", m, true, (Statistics)MainWindow.logic.stats.clone());
			events.add(e);
		}
		return type;
	}

	@SuppressWarnings("deprecation")
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
				//Date date = new Date();
				DateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
				dateFormat.parse(values[6]);
				//date.parse(values[6]);
				if (destination == null || origin == null || dateFormat == null)
					throw new Exception(
							"Null values in mail creation for destination/origin or date");
			} catch (Exception e) {
		
				throw new Exception("Error in creating a new mail");
			}
		}
		return true;
	}
	
	private void addEvent(String type, boolean success, Object o) throws CloneNotSupportedException{
		events.add(new KPEvent(type, o, success, (Statistics)MainWindow.logic.stats.clone()));
		if (o instanceof Mail) {
			Mail m = (Mail) o;
			MainWindow.logic.stats.setRevenue(mailList.gettRevenue());
			MainWindow.logic.stats.setExpenditure(mailList.gettExpediture());
			MainWindow.logic.stats.mails.add(m);
		}
		else if (o instanceof Route) {
			
		}
		else if (o instanceof Cost) {
			
		}
		MainWindow.logic.stats.incrementEvents();
	}
	
	public ArrayList<KPEvent> getEvents() {
		return events;
		}

}