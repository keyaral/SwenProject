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




/**
 * 
 * @author Marian Clements
 *
 *Class for processing user requests and creating the KPEvent List.
 *
 *This is also used for reading the XML log and recreating the system.
 *
 *Either a user request comes in and is processed by processform()
 *
 *or a logged event is restored with addXMLevent()
 *
 *
 *Both use the individual methods for handling each event and then add the event to the 
 *KpEvent List, along with the system statistic.
 *
 */
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
	
	
	/**
	 * 
	 * Sets up the current statistic, which will then be cloned and modified each time.
	 * if there are previous events they are loaded
	 */

	public EventProcesser(Statistics stats) {

		currentStats = stats;
		currentStats.setRouteList(routes);
		currentStats.setCostList(costs);

		LoadpreviousEvents();

	}

	
	/***
	 * 
	 * Opens the XML reader and creates a log which is a list of KPEvents store in XML
	 * format. 
	 * 
	 * it calls load XML event on each
	 */
	private void LoadpreviousEvents() {

		// Read all KPEvents from file.xml
		XmlReader reader = new XmlReader(_xmlPath);
		Log.KPEvents loKPEvents = reader.FindKPEvents();

		// Convert Log.KPEvents to Logic.KPEvents and save in events collection
		for (Log.KPEvents.Event e : loKPEvents.getEvent()) {
			String type = e.getType();
			Boolean isSuccess = e.isSuccess();
			Object obj = e.getCostOrMailOrRoute().get(0);

			Statistics stats = new Statistics();

			KPEvent kpe = new KPEvent(type, obj, isSuccess, stats);

			events.add(kpe);

		}

	}
	
	/***
	 * This method determines the type of event and type of object being added to the system
	 * and calls the appropriate event handling method.
	 * 
	 * 	 */

	public void addXMLevent(String t, Object object) {
		try {
			String[] tempArray = new String[] { "" };

			String type = t;
			Object ob = object;

			if (ob.getClass().toString()
					.equals("class Log.Log$KPEvents$Event$Cost")) {

				Log.KPEvents.Event.Cost c = (Log.KPEvents.Event.Cost) ob;
				tempCost = new Cost(c.getId(), c.getWeight(), c.getVolume(),
						c.getDestination(), c.getOrigin(), c.getPriority());

				if (type.equals("Add")) {

					addCost(tempArray);
				}

				else if (type.equals("Change")) {

					changeCost(tempArray);
				}

				tempCost = null;
			}

			if (ob.getClass().toString()
					.equals("class Log.Log$KPEvents$Event$Mail")) {

				Log.KPEvents.Event.Mail m = (Log.KPEvents.Event.Mail) ob;
				tempMail = new Mail(m.getId(), m.getDestination(),
						m.getOrigin(), m.getWeight(), m.getVolume(),
						m.getPriority(), m.getDate(), m.getTime());

				if (type.equals("Send")) {
					deliverMail(tempArray);
				}

				tempMail = null;

			}

			if (ob.getClass().toString()
					.equals("class Log.Log$KPEvents$Event$Route")) {

				Log.KPEvents.Event.Route r = (Log.KPEvents.Event.Route) ob;
				tempRoute = new Route(r.getId(), r.getDestination(),
						r.getOrigin(), r.getCostWeight(), r.getCostVolume(),
						r.getMaxWeight(), r.getMaxVolume(), r.getPriority(),
						r.getDay(), r.getFrequency(), r.getDuration(),
						r.getCompanyName());

				if (type.equals("Add")) {

					addRoute(tempArray);
				}

				if (type.equals("Change")) {

					changeRoute(tempArray);
				}

				if (type.equals("Remove")) {
					discontineRoute(tempArray);
				}

			}

		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * This method determines what event has been request by the user, and 
	 * calls the appropriate event handling method
	 * 
	 * Case Switch
	 * 
	 * 
	 * 0 = Add route 
	 * 1 = change Route 
	 * 2 = discontine 
	 * Route 3 = Add Cost
	 *  4 =Change Cost 
	 * 5 Deliver Mail
	 * 
	 */
	
	
	public String proccess(String[] details) throws Exception {

		// checkDetails( details, details[0]);
		int type = Integer.parseInt(details[0]);
		
		String message = "error";
		

		switch (type) {

		case 0:
			message = addRoute(details);
			break;
		case 1:
			message = changeRoute(details);
			break;
		case 2:
			message = discontineRoute(details);
			break;
		case 3:
			message = addCost(details);
			break;
		case 4:
			message = changeCost(details);
			break;
		case 5:
			message = deliverMail(details);
			break;
		default:
			message = error(details, " Not a valid Type");
			break;

		}
		return message;

	}

	/**
	 * A method that will return an error message.
	
	 */
	private String error(String[] details, String string) {

		return "error: " + string;
	}
	
	

	/**
	 * Method for handling Mail Delivery events It calls find valid cost and
	 * valid route from the RouteList and CostList classes.
	 * 
	 * It then determines if the mail can be sent, and calls MailDelivery Class
	 * to update systems state and statisitcs.
	 * 
	 * If successful a confirmation message is returned, else an error message
	 */

	private String deliverMail(String[] details)
			throws CloneNotSupportedException {
		Mail m;


		if (details.length < 4) {
			if (tempMail == null) {
				System.out.print(" no temp");
				}
			m = tempMail;
		}
		else  m = new Mail(details);

		if (DomesticPriorityFailure(m.destination, m.origin, m.priority))
			return "Invalid Destination Orgin Priority Match ";

		mailList.assignDestinations(m);
		Cost c = costs.findValidCost(m);
		if (c == null) {
			return error(details, "No valid Cost");
		}
		RouteChain r = routes.findValidRoute(m, this);
		if (r == null) {
			return error(details, "No valid Route");
		}

		Boolean success = mailList.deliverMail(m, r, c);
		if (success) {
			addEvent("Send", success, m);
			Log.Mail mail = new Log.Mail();
			LogMail(mail, m);
			return "Mail: " + m.ID + " was successfully sent";
		}
		return error(details, "Mail was not sent");
	}

	private void LogMail(Log.Mail mail, Mail m) {
		// Log mail send
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
	 * Method for handling Changing Costs events
	 * 
	 * Makes a new cost, and then tries to change it.
	 * 
	 * If successful a confirmation message is returned, else an error message
	 * 
	 *
	 * Finally addevent() is called with a new event and the current statistics
	 */

	

	private String changeCost(String[] details)
			throws CloneNotSupportedException {
		Cost c;

		System.out.print(" 3 cost  change ");

		if (details.length < 4) {
			if (tempCost == null) {
				System.out.print(" no temp");
			}
			c = tempCost;
		}

		else
			c = new Cost(details);

		if (!costs.contains(c)) {
			return error(details,
					"Cost does not exist to change. Please consider adding");
		}

		if (DomesticPriorityFailure(c.destination, c.origin, c.priority))
			return "Invalid Destination Orgin Priority Match ";

		Boolean success = costs.changeCost(c);

		if (success) {

			addEvent("Change", success, c);
			Log.Cost cost = new Log.Cost();
			LogCost(cost, c);
			return "Cost: " + c.ID + " was successfully changed";
		}

		else
			return error(details, "Cost was not changed");
	}

	/**
	 * Method for handling adding Costs events
	 * 
	 * Makes a new cost, and then tries to add it.
	 * 
	 * If successful a confirmation message is returned, else an error message
	 * 
	 * If new Destinations are created by the KpCost, then they are added and it
	 * is reported
	 * 
	 * Finally addevent is called to create a new event and adds current statistics
	 */

	private String addCost(String[] details) throws CloneNotSupportedException {
		Cost c;

		if (details.length < 4) {
			if (tempCost == null) {
				System.out.print(" no temp");
			}
			c = tempCost;
		}

		else
			c = new Cost(details);

		if (DomesticPriorityFailure(c.destination, c.origin, c.priority))
			return "Invalid Destination Orgin Priority Match ";
		Boolean success = costs.addCost(c);

		boolean neworigin = !mailList.containsDesString(c.origin);
		boolean newdest = !mailList.containsDesString(c.destination);

		if (success) {

			addEvent("Add", success, c);
			Log.Cost cost = new Log.Cost();
			LogCost(cost, c);

			String result = "Cost: " + c.ID + " was successfully added";
			if (neworigin) {
				result += "\n A new origin is avaliable: " + c.origin;
				mailList.allDestinations.add(new Destination(c.origin, false));
			}
			if (newdest) {
				result += "\n A new destination is avaliable" + c.destination;
				mailList.allDestinations.add(new Destination(c.destination,
						false));
			}
			return result;
		} else {
			return error(details, "Cost was not added");
		}

	}

	private void LogCost(Log.Cost cost, Cost c) {
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
	 * Uses either an xml object ( tempRoute ) or creates a route from the given arrayList
	 * 
	 * It assigns the correct destination objects and checks the 
	 * priority is correct.
	 * Then attempts to call delete.
	 * 
	 * If it is not successfull added an error message is returned,
	 * 
	 * else add event is called to add the new event and the current system statistics.
	 * 
	 * 	 */

	private String discontineRoute(String[] details)
			throws CloneNotSupportedException {
		Route r;
		if (details.length < 4) {
			if (tempRoute == null) {
				System.out.print(" no temp");
			}
			r = tempRoute;

			System.out.print(" no routes error" + routes.routes.size());
			if (routes == null) {
			}
		} else
			r = new Route(details);

		mailList.assignDestinations(r);

		if (!routes.contains(r)) {
			return error(details,
					"Route does not exist to change. Please consider adding");
		}

		if (DomesticPriorityFailure(r.destination, r.origin, r.priority))
			return "Invalid Destination Orgin Priority Match ";

		Boolean success = routes.deleteRoute(r);

		if (success) {

			addEvent("Remove", success, r);
			Log.Route route = new Log.Route();
			LogRoute(route, r);
			return "Route: " + r.ID + " was successfully deleted";
		}

		return error(details, "Route was not deleted ");
	}

	/**
	 * Uses either an xml object ( tempRoute ) or creates a route from the given arrayList
	 * 
	 * It then assigns the correct destination objects and attempts to call add.
	 * 
	 * If it is not successful added an error message is returned,
	 * 
	 * else add event is called to add the new event and the current system statistics.
	 * 
	 * 	 */
	
	
	private String changeRoute(String[] details)
			throws CloneNotSupportedException {
		Route r;

		System.out.print(" 3 Route  change ");
		if (details.length < 4) {
			if (tempRoute == null) {
				System.out.print(" no temp");
			}
			r = tempRoute;
		} else
			r = new Route(details);

		mailList.assignDestinations(r);

		if (!routes.contains(r)) {
			return error(details,
					"Route does not exist to change. Please consider adding");
		}

		if (DomesticPriorityFailure(r.destination, r.origin, r.priority))
			return "Invalid Destination Orgin Priority Match ";

		Boolean success = routes.changeRoute(r);

		if (success) {

			addEvent("Change", success, r);
			Log.Route route = new Log.Route();
			LogRoute(route, r);
			return "Route: " + r.ID + " was successfully changed ";
		}

		else
			return error(details, "Route was not changed");

	}

	/**
	 * Uses either an xml object ( tempRoute ) or creates a route from the given arrayList
	 * 
	 * It assigns the correct destination objects and checks the 
	 * priority is correct.
	 * Then attempts to call add.
	 * 
	 * If it is not successfull added an error message is returned,
	 * 
	 * else add event is called to add the new event and the current system statistics.
	 * 
	 * 	 */
	
	
	
	private String addRoute(String[] details) throws CloneNotSupportedException {
		Route r;

		System.out.print(" 3 Route add  ");
		if (details.length < 4) {
			if (tempRoute == null) {
				System.out.print(" no temp");
			}
			r = tempRoute;
		} else
			r = new Route(details);

		if (DomesticPriorityFailure(r.destination, r.origin, r.priority))
			return "Invalid Destination Orgin Priority Match ";

		mailList.assignDestinations(r);
		Boolean success = routes.addRoute(r);

		if (success) {
			addEvent("Add", success, r);
			// log add route
			Log.Route route = new Log.Route();
			LogRoute(route, r);
			return "Route: " + r.ID + " was successfully added ";
		}

		else {
			return error(details, "Route was not added - it already exists");
		}

	}

	private void LogRoute(Log.Route route, Route r) {
		// log add route
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

	/**
	 * Takes two strings and resolve if their corresponding destination are either domestic
	 * or international.
	 * 
	 * it then checks if the priority given is appropriate. 
	 * 
	 * Two domestic destinations must use domestic services.
	 */

	private boolean DomesticPriorityFailure(String destination, String origin,
			int priority) {

		Boolean originD = mailList.isDomestic(origin);
		Boolean destinationD = mailList.isDomestic(destination);

		if (originD && destinationD) {
			if (priority < 3)
				return true;
			else
				return false;
		}

		else if (priority > 2)
			return true;

		return false;
	}

	/**
	 * Adds in the event based on the type and object assigned with it as the
	 * current statistics at this stage. Note that for an object that changes,
	 * two objects will be needed to set the objects
	 * 
	 */
	private void addEvent(String type, boolean success, Object o)
			throws CloneNotSupportedException {
		if (o instanceof Mail) {
			Mail m = (Mail) o;
			currentStats.setRevenue(mailList.gettRevenue());
			currentStats.setExpenditure(mailList.gettExpediture());
			currentStats.mails.add(m);

			events.add(new KPEvent(type, m, success, new Statistics(
					(Statistics) currentStats.clone())));
			XmlWriter writer = new XmlWriter("file.xml");
			writer.InsertKPEvent(new KPEvent(type, m, success, new Statistics(
					(Statistics) currentStats.clone())));

		} else if (o instanceof Route) {
			Route r = (Route) o;
			events.add(new KPEvent(type, r, success, new Statistics(
					(Statistics) currentStats.clone())));
			XmlWriter writer = new XmlWriter("file.xml");
			writer.InsertKPEvent(new KPEvent(type, r, success, new Statistics(
					(Statistics) currentStats.clone())));
		} else if (o instanceof Cost) {
			Cost c = (Cost) o;
			events.add(new KPEvent(type, c, success, new Statistics(
					(Statistics) currentStats.clone())));
			XmlWriter writer = new XmlWriter("file.xml");
			writer.InsertKPEvent(new KPEvent(type, c, success, new Statistics(
					(Statistics) currentStats.clone())));
		}
		currentStats.incrementEvents();
	}

	public ArrayList<KPEvent> getEvents() {
		return events;
	}

	public Statistics getStats() {
		return currentStats;
	}

	public RouteListClass getRoutes() {
		return routes;
	}

	public CostListClass getCosts() {
		return costs;
	}

	public MailDelivery getMailList() {
		return mailList;
	}

}
