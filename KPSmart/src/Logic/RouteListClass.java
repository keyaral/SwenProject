package Logic;

import java.util.HashSet;

public class RouteListClass {

	public HashSet<Route> routes;

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

	public Route findValidRoute(Mail m) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
