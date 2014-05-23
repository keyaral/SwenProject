package Logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.swing.JOptionPane;

/**
 * All the routes in our system. It also encompasses an AStar algorithm to find the most optimal
 * route and link routes together to create a route chain.
 * @author BusyBees
 */
public class RouteListClass implements Cloneable{

	public HashSet<Route> routes;
	public ArrayList<ArrayList<Route>>tempPath = new ArrayList<ArrayList<Route>>();
	public PriorityQueue<QueueObject> fringe;				
	public Mail PendingMailToSend;		
	private boolean swapped;

	public RouteListClass(){
		routes = new HashSet<Route>();
		
		//routes.addAll(); ADD ALL From data base
	
	}
	
	public RouteListClass(HashSet<Route> routes){
		this.routes = new HashSet<Route>();
		try {
			for (Route route: routes)
				this.routes.add((Route)route.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	public Boolean addRoute(Route r){
		Boolean exists = false;
		for(Route a : routes){
			if(a.ID == r.ID) exists = true;		//Can change to names instead of ID's
		}

		
		if(exists == true){ 
						//JOptionPane.showMessageDialog(null,r.ID + " Already Exists",null, 1);
					return false;}
		
	//	if(exists == true){ System.out.println("Already Exists"); return false;}

		else{routes.add(r); return true;}
	}
	
	public Boolean changeRoute(Route r){
		
		Boolean found = false;
		for(Route a : routes){
			if(a.ID == r.ID) {found = true;	a = r;}	//Can change to names instead of ID's
		}
		if(found == true){ return true;}
		else return false; 
	}
	
	public Boolean deleteRoute(Route r){
		Boolean found = false;
		for(Route a : routes){
			if(a.ID == r.ID) {found = true;	routes.remove(a);}	//Can change to names instead of ID's
		}
		if(found == true){ return true;}
		else return false; 
	}

	public Route createRoute(String details) {
		return null;
	}


/**
 * The AStart Algorithm used to find a valid and also the most optimal routeChain
 * @param m
 * @param eventProccessor
 * @return
 */
	public RouteChain findValidRoute(Mail m , EventProcesser eventProccessor) { 
		PendingMailToSend = m;
		this.fringe = new PriorityQueue<QueueObject>(2000,RouteListClass.desComparator); //Fringe for the AStar
		assignDestination(eventProccessor);
		Destination start = m.getOriginD();
		Destination goal = m.getDestinationD();
		if(start.GeographicalY < goal.GeographicalY) {Destination temp = start; start = goal; goal = temp; this.swapped = true;} //Swap since destination is higher than origin
		for(Destination d : eventProccessor.mailList.allDestinations){ d.visited = false;}
		fringe.add(new QueueObject(start,null,0,start.GeographicalY-goal.GeographicalY));
		
		Boolean Found = false;
		double costToHere = 0;
		
		while(fringe.size() > 0 && Found == false){ 
			QueueObject current = fringe.remove();
			
			if(current.destination.visited == false){
				current.destination.visited = true;
				costToHere+=current.weight;
				if(current.destination == goal) {Found = true; return buildFinalPath(current);}
			    for(Route r : current.destination.routes){
					if(r.destinationD.visited == false && this.swapped == false){ //If the search is finding routes upwards
			    		double costToNeigh = costToHere + r.cost;
			    		double estTotal = costToNeigh + r.destinationD.GeographicalY-current.destination.GeographicalY;
			    		fringe.add(new QueueObject(r.destinationD,current,costToNeigh,estTotal));
			    	}
					else if(r.originD.visited == false && this.swapped == true){ //If the search is finding routes downwards
			    		double costToNeigh = costToHere + r.cost;
			    		double estTotal = costToNeigh + r.originD.GeographicalY-current.destination.GeographicalY;
			    		fringe.add(new QueueObject(r.originD,current,costToNeigh,estTotal));
			    	}
			    }
				
			}
			
		}
		return null;	//if the algorithm does not find any valid routes return null
	}
	
	public void assignDestination(EventProcesser eventProccessor) {	//Assign all the destinations appropriately
		for(Route r : this.routes){
			for(Destination d :eventProccessor.getMailList().allDestinations){
				if((r.origin.equals(d.getName()) || r.destination.equals(d.getName())&&!d.routes.contains(r))) d.routes.add(r);
			}
		}
	}

	public RouteChain buildFinalPath(QueueObject finalNode) { //Build the final path to take once the AStar gives the most optimal destinations
		Destination goal = finalNode.destination;
		Stack<QueueObject> FinalPath = new Stack<QueueObject>();
		FinalPath.push(finalNode);
		QueueObject Prior = finalNode.from;
		FinalPath.push(Prior);
		do{if(Prior!= null)FinalPath.push(Prior);Prior = Prior.from;}
		while(Prior != null);
		ArrayList<Destination> finalDestList = new ArrayList<Destination>();
		QueueObject current = FinalPath.pop();
		finalDestList.add(current.destination);
		QueueObject next = FinalPath.pop();
		finalDestList.add(next.destination);
		if(next.destination == goal) return makeRouteChain(finalDestList);
		while(FinalPath.isEmpty() == false){
			finalDestList.add(FinalPath.pop().destination);
		}
		return makeRouteChain(finalDestList);	//Finally turn the final path into a route chain.
	}


	/**
	 * This function turns a sequence of destinations into a sequence of routes to take and prioritized them based on cost and priority
	 * @param finalDestList
	 * @return
	 */
	public RouteChain makeRouteChain(ArrayList<Destination> finalDestList) {	
		ArrayList<Route> makeAChain = new ArrayList<Route>();
		Route before = null;
		int count = 0;
		while(count < finalDestList.size()-1){
		for(Route r:this.routes){ 
			if(r.priority+1 == this.PendingMailToSend.priority && this.swapped == false && before != null &&  (r.origin.equals(finalDestList.get(count).getName()) && r.destination.equals(finalDestList.get(count+1).getName()))){if(r.cost<before.cost){makeAChain.remove(before); makeAChain.add(r);}}
			else if(before != null &&  r.priority+1 == this.PendingMailToSend.priority+1 &&(r.origin.equals(finalDestList.get(count+1).getName()) && r.destination.equals(finalDestList.get(count).getName()))){if(r.cost<before.cost){makeAChain.remove(before); makeAChain.add(r);}}
			if(r.priority+1 == this.PendingMailToSend.priority &&this.swapped == false && r.origin.equals(finalDestList.get(count).getName()) && r.destination.equals(finalDestList.get(count+1).getName())){makeAChain.add(r); before = r;}
			if(r.priority+1 == this.PendingMailToSend.priority && r.origin.equals(finalDestList.get(count+1).getName()) && r.destination.equals(finalDestList.get(count).getName())){makeAChain.add(r); before = r; System.out.println("X");}
		}
		before = null;
		count++;
		}
		if(makeAChain.size() == 0){ 
			count = 0;
			while(count < finalDestList.size()-1){
			for(Route r:this.routes){
				if(this.swapped == false && before != null &&  (r.origin.equals(finalDestList.get(count).getName()) && r.destination.equals(finalDestList.get(count+1).getName()))){if(r.cost<before.cost){makeAChain.remove(before); makeAChain.add(r);}}
				else if(before != null &&  (r.origin.equals(finalDestList.get(count+1).getName()) && r.destination.equals(finalDestList.get(count).getName()))){if(r.cost<before.cost){makeAChain.remove(before); makeAChain.add(r);}}
				if(this.swapped == false && r.origin.equals(finalDestList.get(count).getName()) && r.destination.equals(finalDestList.get(count+1).getName())){makeAChain.add(r); before = r;}
				if(r.origin.equals(finalDestList.get(count+1).getName()) && r.destination.equals(finalDestList.get(count).getName())){makeAChain.add(r); before = r; System.out.println("X");}
			}
		before = null;
		count++;}
		}
		return new RouteChain(makeAChain,makeAChain.get(makeAChain.size()-1).destinationD,makeAChain.get(0).origin);
	}

	
	public HashMap<Route, Double> findCriticalRoutes(ArrayList<Cost> customerCosts){
		HashMap<Route,Double> criticalRoutes = new HashMap<Route,Double>();
		for(Route r : this.routes){
			for(Cost c: customerCosts){
			if(c.origin.equals(r.origin) && c.destination.equals(r.destination))if( r.isCritical(c)) {criticalRoutes.put(r, (r.costVolume*r.costWeight)-(c.volume*c.weight));}}
		}
		return criticalRoutes;
	}
	
	public void printAll() {
		System.out.println (" Route LIST ");
		for (Route r : routes){
			System.out.println (r.ID +" "+ r.destination +" "+ r.origin+" "+ r.priority);
		}
		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new RouteListClass(routes);
	}

	public boolean contains(Route r) {
		Boolean found = false;
		for(Route a : routes){
			if(a.ID == r.ID) {found = true;	}	//Can change to names instead of ID's
		}
		if(found == true){ return true;}
		else return false; 
	}
	/**
	 * this is used to compare destinations in order to make sure the algorithm doesn't backtrack
	 */
	 public static Comparator<QueueObject> desComparator = new Comparator<QueueObject>(){
	        @Override
	        public int compare(QueueObject a, QueueObject b) {
	            if(a.destination.GeographicalY > b.destination.GeographicalY) return 1;
	            else return 0;
	        }
	    };
	
}
