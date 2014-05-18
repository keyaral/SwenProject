package Logic;
//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.JOptionPane;

public class RouteListClass implements Cloneable{

	public HashSet<Route> routes;
	public ArrayList<ArrayList<Route>>tempPath = new ArrayList<ArrayList<Route>>();


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




	public RouteChain findValidRoute(Mail m ) { 
		System.out.println(" Routes enter valid" );
		this.tempPath.clear();
		for(Route r : this.routes) r.visited = false;
		ArrayList<Route> origins = new ArrayList<Route>();
		ArrayList<Route> destinations = new ArrayList<Route>();
	for(Route r : this.routes){									//Search for routes that are capable of handling the initial criteria
			if ( r.priority == m.priority) {
		System.out.println(" a route r) "+ r.ID );
		if(r.originD.getName().equals(m.origin)) {  	System.out.println(" a orgin match) " ); origins.add(r); }
		
		
		if(r.destinationD.getName().equals(m.destination)){ System.out.println(" a des match) " ); destinations.add(r); }
		
		if(r.destinationD.getName().equals(m.destination) && r.originD.getName().equals(m.origin)) {
			ArrayList<Route> validr = new ArrayList<Route>() ;
					validr.add(r);
			
			return new RouteChain(validr, m.destinationD, m.origin); }
			}
		}
	
	
			if(origins.isEmpty() || destinations.isEmpty()){ System.out.println(" no matches) " ); return null;}

		HashMap<String,RouteChain> PossibleRoutes = new HashMap<String,RouteChain>();
		HashMap<String,RouteChain> PreferableRoutes = new HashMap<String,RouteChain>();
	
		for(Route r : origins){
			int i;
			do {
			i = this.tempPath.size();
			searchRouteChain(r.originD,new ArrayList<Route>(), m.destinationD);
		}
			while(i < destinations.size()); //create Routes for a new route chain
		}
		
		for(ArrayList<Route> l : this.tempPath){
		RouteChain MakeChain = new RouteChain(l,m.destinationD,m.origin);
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
	//	for(RouteChain r1 : PreferableRoutes.values()){r1.PrintAllRoutes();}
		
		System.out.println(" lower cost) "+ Double.toString(lowestCost ) );
		System.out.println(" lower cost orgin + " + PossibleRoutes.get((Double.toString(lowestCost))).origin  );
		
		return PossibleRoutes.get((Double.toString(lowestCost)));
 	}

	private ArrayList<Route> searchRouteChain(Destination d, ArrayList<Route> currentRoutes, Destination finish) {
		for(Route t :d.routes){
			if(t.visited == false){
				t.visited = true;
				currentRoutes.add(t); 
				if(t.destinationD.getName().equals(finish.getName())) {System.out.println("Found Route to Destination From: "+t.originD.getName()); 
				ArrayList<Route> tempRoutes = new ArrayList<Route>();
				for(Route r : currentRoutes) if(r.added == false){ tempRoutes.add(r); r.added = true;}
				tempPath.add(tempRoutes);
				} 
				else currentRoutes = searchRouteChain(t.destinationD, currentRoutes,finish);}
	     	}
		return currentRoutes;
	}	
	
	public ArrayList<Route> findCriticalRoutes(double averageCost){
		ArrayList<Route> criticalRoutes = new ArrayList<Route>();
		for(Route r : this.routes){
			if( r.isCritical(averageCost)) criticalRoutes.add(r);
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

	
}
