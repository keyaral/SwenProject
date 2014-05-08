package TylerWorkInProgress;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class RouteListClass {

	public HashSet<Route> routes;
	public ArrayList<ArrayList<Route>>tempPath = new ArrayList<ArrayList<Route>>();

	public RouteListClass(){
		routes = new HashSet<Route>();
		//routes.addAll(); ADD ALL From data base
		Route routeTest1 = new Route(1,"Wellington","Rotorua",10,15,200,200,1,"Thursday",2,3,"TylerCorp");
		Route routeTest2 = new Route(2,"Rotorua","Taupo",10,15,200,200,2,"Thursday",2,3,"TylerCorp");
		Route routeTest3 = new Route(3,"Taupo","Auckland",10,15,200,200,1,"Thursday",2,3,"TylerCorp");
		Route routeTest4 = new Route(4,"Wellington","Auckland",10,15,200,200,1,"Thursday",2,3,"TylerCorp");
		Route routeTest5 = new Route(5,"Auckland","Wellington",10,15,200,200,1,"Thursday",2,3,"TylerCorp");
		routeTest1.origin.addRoute(routeTest1);
		routeTest1.origin.addRoute(routeTest4);
		routeTest1.destination.addRoute(routeTest2);
		routeTest1.destination.addRoute(routeTest1);
		routeTest2.origin.addRoute(routeTest1);
		routeTest2.origin.addRoute(routeTest2);
		routeTest2.destination.addRoute(routeTest3);
		routeTest2.destination.addRoute(routeTest2);
		routeTest3.origin.addRoute(routeTest3);
		routeTest3.destination.addRoute(routeTest1);
		routeTest3.destination.addRoute(routeTest3);
		routes.add(routeTest1);
		routes.add(routeTest2);
		routes.add(routeTest3);
		routes.add(routeTest4);
		routes.add(routeTest5);
	}
	
	public Boolean addRoute(Route r){
		Boolean exists = false;
		for(Route a : routes){
			if(a.ID == r.ID) exists = true;		//Can change to names instead of ID's
		}
		if(exists == true){ System.out.println("Already Exists"); return false;}
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

	public RouteChain findValidRoute(Mail m) {
		for(Route r : this.routes) r.visited = false;
		ArrayList<Route> origins = new ArrayList<Route>();
		ArrayList<Route> destinations = new ArrayList<Route>();
		for(Route r : this.routes){									//Search for routes that are capable of handling the initial criteria
			if(r.origin.getName().equals(m.origin)) origins.add(r);
			if(r.destination.getName().equals(m.destination.getName())) destinations.add(r);
		}
			if(origins.isEmpty() || destinations.isEmpty()){ return null;}

		HashMap<String,RouteChain> PossibleRoutes = new HashMap<String,RouteChain>();
		HashMap<String,RouteChain> PreferableRoutes = new HashMap<String,RouteChain>();
	
		for(Route r : origins){
			int i = 0;
			while(i <= destinations.size()){			//TODO do this a better way
			searchRouteChain(r.origin,new ArrayList<Route>(), m.destination);
			i++;}}
		
		for(ArrayList<Route> l : this.tempPath){
		RouteChain MakeChain = new RouteChain(l,m.destination,m.origin);
		PossibleRoutes.put(Double.toString(MakeChain.calculateCost(m)),MakeChain);
		if(MakeChain.checkViable(m)) PreferableRoutes.put(Double.toString(MakeChain.calculateCost(m)),MakeChain);
		}

		double lowestCost = Integer.MAX_VALUE;
		if(PreferableRoutes.size() == 0){
			for(String s : PossibleRoutes.keySet()){
				if(Double.valueOf(s) < lowestCost) lowestCost = Double.valueOf(s);
			}
		}
		else{
			for(String s : PreferableRoutes.keySet()){
				if(Double.valueOf(s) < lowestCost) lowestCost = Double.valueOf(s);
			}
		}
		for(RouteChain r1 : PreferableRoutes.values()){System.out.println("Test1");r1.PrintAllRoutes();}
		
		return PossibleRoutes.get((Double.toString(lowestCost)));
	}

	private ArrayList<Route> searchRouteChain(Destination d, ArrayList<Route> currentRoutes, Destination finish) {
		for(Route t :d.routes){
			if(t.visited == false){
				t.visited = true;
				currentRoutes.add(t); 
				if(t.destination.getName().equals(finish.getName())) {System.out.println("Found "+t.origin.getName()); tempPath.add(currentRoutes); 
				currentRoutes.removeAll(currentRoutes);
				}
				else currentRoutes = searchRouteChain(t.destination, currentRoutes,finish);}
	     	}
		return currentRoutes;
	}	
	
	
	public static void main(String args[]){
		Mail M = new Mail(1,"Auckland","Wellington",10,10,1,null);
		RouteListClass c = new RouteListClass();
		c.findValidRoute(M);
	}
}
