package Logic;
//
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Stack;

import javax.swing.JOptionPane;

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



	public RouteChain findValidRoute(Mail m , EventProcesser eventProccessor) { 
		PendingMailToSend = m;
		this.fringe = new PriorityQueue<QueueObject>(2000,RouteListClass.desComparator);
		//
		assignDestination(eventProccessor);
		System.out.println("Searching for valid Route");
		Destination start = m.getOriginD();
		Destination goal = m.getDestinationD();
		if(start.GeographicalY < goal.GeographicalY) {Destination temp = start; start = goal; goal = temp; this.swapped = true;} //Swap since one is going down
		for(Destination d : eventProccessor.mailList.allDestinations){ d.visited = false;}
		fringe.add(new QueueObject(start,null,0,start.GeographicalY-goal.GeographicalY));
		
		Boolean Found = false;
		double costToHere = 0;
		
		while(fringe.size() > 0 && Found == false){
			System.out.println("Searching");
			QueueObject current = fringe.remove();
			if(current.destination.visited == false){
				current.destination.visited = true;
				costToHere+=current.weight;
				if(current.destination == goal) {Found = true; return buildFinalPath(current);}
			    for(Route r : current.destination.routes){
					if(r.destinationD.visited == false){
			    		double costToNeigh = costToHere + r.cost;
			    		double estTotal = costToNeigh + r.destinationD.GeographicalY-current.destination.GeographicalY;
			    		fringe.add(new QueueObject(r.destinationD,current,costToNeigh,estTotal));
			    	}
			    	
			    }
				
			}
			
		}
		return null;
	}
	
	public void assignDestination(EventProcesser eventProccessor) {
		for(Route r : this.routes){
			for(Destination d :eventProccessor.getMailList().allDestinations){
				if((r.origin.equals(d.getName()) || r.destination.equals(d.getName())&&!d.routes.contains(r))) d.routes.add(r);
			}
		}
	}

	public RouteChain buildFinalPath(QueueObject finalNode) {
		Destination goal = finalNode.destination;
		Stack<QueueObject> FinalPath = new Stack<QueueObject>();
		FinalPath.push(finalNode);
		QueueObject Prior = finalNode.from;
		FinalPath.push(Prior);
		while(Prior != null){
			Prior = Prior.from;
			if(Prior!= null)FinalPath.push(Prior);
		}
		
		ArrayList<Destination> finalDestList = new ArrayList<Destination>();
		QueueObject current = FinalPath.pop();
		finalDestList.add(current.destination);
		QueueObject next = FinalPath.pop();
		finalDestList.add(next.destination);
		if(next.destination == goal) return makeRouteChain(finalDestList);
		while(FinalPath.size() > 0);{
			finalDestList.add(FinalPath.pop().destination);
		}
		return makeRouteChain(finalDestList);
	}


	private RouteChain makeRouteChain(ArrayList<Destination> finalDestList) {
		ArrayList<Route> makeAChain = new ArrayList<Route>();
		Route before = null;
		int count = 0;
		while(count < finalDestList.size()-1){
		for(Route r:this.routes){
			if(r.priority == this.PendingMailToSend.priority && this.swapped == false && before != null &&  (r.origin.equals(finalDestList.get(count).getName()) && r.destination.equals(finalDestList.get(count+1).getName()))){if(r.cost<before.cost){makeAChain.remove(before); makeAChain.add(r);}}
			else if(before != null &&  r.priority == this.PendingMailToSend.priority &&(r.origin.equals(finalDestList.get(count+1).getName()) && r.destination.equals(finalDestList.get(count).getName()))){if(r.cost<before.cost){makeAChain.remove(before); makeAChain.add(r);}}
			if(r.priority == this.PendingMailToSend.priority &&this.swapped == false && r.origin.equals(finalDestList.get(count).getName()) && r.destination.equals(finalDestList.get(count+1).getName())){makeAChain.add(r); before = r;}
			if(r.priority == this.PendingMailToSend.priority && r.origin.equals(finalDestList.get(count+1).getName()) && r.destination.equals(finalDestList.get(count).getName())){makeAChain.add(r); before = r; System.out.println("X");}
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

//	public RouteChain findValidRoute(Mail m ) { 
//		System.out.println(" Routes enter valid" );
//		this.tempPath.clear();
//		for(Route r : this.routes) r.visited = false;
//		ArrayList<Route> origins = new ArrayList<Route>();
//		ArrayList<Route> destinations = new ArrayList<Route>();
//	for(Route r : this.routes){									//Search for routes that are capable of handling the initial criteria
//			if ( r.priority == m.priority) {
//		System.out.println(" a route r) "+ r.ID );
//		if(r.originD.getName().equals(m.origin)) {  	System.out.println(" a orgin match) " ); origins.add(r); }
//		
//		
//		if(r.destinationD.getName().equals(m.destination)){ System.out.println(" a des match) " ); destinations.add(r); }
//		
//		if(r.destinationD.getName().equals(m.destination) && r.originD.getName().equals(m.origin)) {
//			ArrayList<Route> validr = new ArrayList<Route>() ;
//					validr.add(r);
//			
//			return new RouteChain(validr, m.destinationD, m.origin); }
//			}
//		}
//	
//	
//			if(origins.isEmpty() || destinations.isEmpty()){ System.out.println(" no matches) " ); return null;}
//
//		HashMap<String,RouteChain> PossibleRoutes = new HashMap<String,RouteChain>();
//		HashMap<String,RouteChain> PreferableRoutes = new HashMap<String,RouteChain>();
//	
//		for(Route r : origins){
//			int i;
//			do {
//			i = this.tempPath.size();
//			searchRouteChain(r.originD,new ArrayList<Route>(), m.destinationD);
//		}
//			while(i < destinations.size()); //create Routes for a new route chain
//		}
//		
//		for(ArrayList<Route> l : this.tempPath){
//		RouteChain MakeChain = new RouteChain(l,m.destinationD,m.origin);
//		PossibleRoutes.put(Double.toString(MakeChain.calculateCost(m)),MakeChain);
//		if(MakeChain.checkViable(m)) PreferableRoutes.put(Double.toString(MakeChain.calculateCost(m)),MakeChain);
//		}
//
//		double lowestCost = Integer.MAX_VALUE;
//		if(PreferableRoutes.size() == 0){
//			for(String s : PossibleRoutes.keySet()){
//				if(Double.valueOf(s) < lowestCost) lowestCost = Double.valueOf(s);
//		}
//	}
//		else{
//			for(String s : PreferableRoutes.keySet()){
//				if(Double.valueOf(s) < lowestCost) lowestCost = Double.valueOf(s);
//			}
//		}
//	//	for(RouteChain r1 : PreferableRoutes.values()){r1.PrintAllRoutes();}
//		
//		System.out.println(" lower cost) "+ Double.toString(lowestCost ) );
//		System.out.println(" lower cost orgin + " + PossibleRoutes.get((Double.toString(lowestCost))).origin  );
//		
//		return PossibleRoutes.get((Double.toString(lowestCost)));
// 	}
//
//	private ArrayList<Route> searchRouteChain(Destination d, ArrayList<Route> currentRoutes, Destination finish) {
//		for(Route t :d.routes){
//			if(t.visited == false){
//				t.visited = true;
//				currentRoutes.add(t); 
//				if(t.destinationD.getName().equals(finish.getName())) {System.out.println("Found Route to Destination From: "+t.originD.getName()); 
//				ArrayList<Route> tempRoutes = new ArrayList<Route>();
//				for(Route r : currentRoutes) if(r.added == false){ tempRoutes.add(r); r.added = true;}
//				tempPath.add(tempRoutes);
//				} 
//				else currentRoutes = searchRouteChain(t.destinationD, currentRoutes,finish);}
//	     	}
//		return currentRoutes;
//	}	
//	
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
	
	 public static Comparator<QueueObject> desComparator = new Comparator<QueueObject>(){
	        @Override
	        public int compare(QueueObject a, QueueObject b) {
	            if(a.destination.GeographicalY > b.destination.GeographicalY) return 1;
	            else return 0;
	        }
	    };
	
}
