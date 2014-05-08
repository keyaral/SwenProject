package TylerWorkInProgress;
import java.util.ArrayList;


public class RouteChain {

	public String origin;
	public Destination destination;
	public ArrayList<Route> routes;
	
	public RouteChain(ArrayList<Route> r, Destination d, String o){
		origin = o;
		destination = d;
		routes = r;
	}
	
	public double calculateCost(Mail m){
		return Math.random()*10;				//TODO remove
//		double cost = 0;
//		for(Route r : routes){
//			cost = r.cost*m.cost;
//		}
//		return cost;
	}
	
	public Boolean checkViable(Mail m){
		return true;
//		for(Route r : routes){
//			if(r.priority != m.priority) return false; 
//		}
//		return true;
	}
	
	public void PrintAllRoutes(){		//Testing Purposes
		System.out.println("Route Option");
		int count = 1;
		for(Route r : routes){
		System.out.println("Step "+count+": "+r.origin.getName()+" to: "+r.destination.getName());
		count++;
		}
	}
}
