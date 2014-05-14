package Logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class RouteListClass {

	public HashSet<Route> routes;
	public ArrayList<ArrayList<Route>>tempPath = new ArrayList<ArrayList<Route>>();


	public RouteListClass(){
		routes = new HashSet<Route>();
		//routes.addAll(); ADD ALL From data base
		Route routeTest1 = new Route(1,"Auckland","Wellington",10,15,200,200,1,"Thursday",2,3,"TylerCorp");
		Route routeTest2 = new Route(2,"Christchurch","Wellington",10,15,200,200,2,"Thursday",2,3,"TylerCorp");
		Route routeTest3 = new Route(3,"Auckland","Wellington",10,15,200,200,1,"Thursday",2,3,"TylerCorp");
		routes.add(routeTest1);
		routes.add(routeTest2);
		routes.add(routeTest3);
	}
	
	public Boolean addRoute(Route r){
		Boolean exists = false;
		for(Route a : routes){
			if(a.ID == r.ID) exists = true;		//Can change to names instead of ID's
		}

		
		if(exists == true){ 
						JOptionPane.showMessageDialog(null,r.ID + " Already Exists",null, 1);
						System.out.println("Already Exists"); return false;}
		
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




	public RouteChain findValidRoute(Mail m) { return null; }
//		this.tempPath.clear();
//		for(Route r : this.routes) r.visited = false;
//		ArrayList<Route> origins = new ArrayList<Route>();
//		ArrayList<Route> destinations = new ArrayList<Route>();
//	for(Route r : this.routes){									//Search for routes that are capable of handling the initial criteria
//			if(r.origin.getName().equals(m.origin)) origins.add(r);
//			if(r.destination.getName().equals(m.destination)) destinations.add(r);
//		}
//			if(origins.isEmpty() || destinations.isEmpty()){ return null;}
//
//		HashMap<String,RouteChain> PossibleRoutes = new HashMap<String,RouteChain>();
//		HashMap<String,RouteChain> PreferableRoutes = new HashMap<String,RouteChain>();
//	
//		for(Route r : origins){
//			int i;
//			do {
//			i = this.tempPath.size();
//			searchRouteChain(r.origin,new ArrayList<Route>(), m.destination);
//		}
//			while(i < destinations.size()); //create Routes for a new route chain
//		}
//		
//		for(ArrayList<Route> l : this.tempPath){
//		RouteChain MakeChain = new RouteChain(l,m.destination,m.origin);
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
//		for(RouteChain r1 : PreferableRoutes.values()){r1.PrintAllRoutes();}
//		
//		return PossibleRoutes.get((Double.toString(lowestCost)));
// 	}
//

	public void printAll() {
		System.out.println (" Route LIST ");
		for (Route r : routes){
			System.out.println (r.ID +" "+ r.destination +" "+ r.origin+" "+ r.priority);
			
		}
		
	}


//	private ArrayList<Route> searchRouteChain(Destination d, ArrayList<Route> currentRoutes, Destination finish) {
//		//
//		for(Route t :d.routes){
//			if(t.visited == false){
//				t.visited = true;
//				currentRoutes.add(t); 
//				if(t.destination.getName().equals(finish.getName())) {System.out.println("Found Route to Destination From: "+t.origin.getName()); 
//				ArrayList<Route> tempRoutes = new ArrayList<Route>();
//				for(Route r : currentRoutes) if(r.added == false){ tempRoutes.add(r); r.added = true;}
//				tempPath.add(tempRoutes);
//				} 
//				else currentRoutes = searchRouteChain(t.destination, currentRoutes,finish);}
//	     	}
//		return currentRoutes;
//	}	
//	
//	public ArrayList<RouteChain> findCriticalRoutes(Mail m){
//		findValidRoute(m);
//		ArrayList<RouteChain> possibleRoutes = new ArrayList<RouteChain>();
//		ArrayList<RouteChain> criticalRoutes = new ArrayList<RouteChain>();
//		for(ArrayList<Route> r : this.tempPath){
//			possibleRoutes.add(new RouteChain(r,m.destination,m.origin));
//		}
//		for(RouteChain r : possibleRoutes){
//			if(r.isCritical(m) && r.checkViable(m)) criticalRoutes.add(r);
//		}
//		return criticalRoutes;
//	}
	

	
}
