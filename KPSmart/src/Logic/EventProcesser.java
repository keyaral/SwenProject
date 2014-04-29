package Logic;

import java.util.ArrayList;

public class EventProcesser {
	
	RouteListClass routes;
	CostListClass costs;
	ArrayList<KPEvent> events = new ArrayList<KPEvent>();

	public EventProcesser(){
		routes = new RouteListClass();
		costs = new CostListClass();
	}
	
	public String proccess(String details) {

	String type = details.substring(0, 2);
	details = details.substring(3);
	 if (type.equals("1a")) {// call routes
		Route r = new Route(details);
		Boolean success = routes.addRoute(r);
		KPEvent e = new KPEvent("Add", r,success);
		//e.addStats;
		events.add(e);
	 } 
	 if (type.equals("1b")){
		 Route r = new Route(details);
		 Boolean success = routes.changeRoute(r);
		 KPEvent e = new KPEvent("Change", r,success);
		//e.addStats;
	     events.add(e);
	 }
	 
	 if (type.equals("1c")){
		 Route r = new Route(details);
		 Boolean success = routes.deleteRoute(r);
		 KPEvent e = new KPEvent("Delete", r,success);
		//e.addStats;
		 events.add(e);
		}
	 
	 if (type.equals("2a")) {// call Costs
		 Cost c = new Cost(details);
		 Boolean success = costs.addCost(c);
		 KPEvent e = new KPEvent("Add", c,success);
		//e.addStats;
		 events.add(e);
	 }
	 if (type.equals("2b")) {// call Costs
		 Cost c = new Cost(details);
		 Boolean success = costs.changeCost(c);
		 KPEvent e = new KPEvent("Change", c,success);
		//e.addStats;
		 events.add(e);
	 }
	if (type.equals("2c")) {// call Costs
		Cost c = new Cost(details);
		Boolean success = costs.deleteCost(c);
		 KPEvent e = new KPEvent("Delete", c,success);
		//e.addStats;
		 events.add(e);
	}
	 
	 if (type.equals("3a")) {// call Mail
		Mail m = new Mail(details);
		//TODO ShipMail
		 KPEvent e = new KPEvent("Send", m,true);
		//e.addStats;
		 events.add(e);
	 } 
		return type;
	}

}
