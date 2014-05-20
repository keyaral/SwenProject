package Logic;
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
		double cost = 0;
		for(Route r : routes){
			cost = r.cost*m.cost;
		}
		return cost;
	}
	
	public Boolean checkViable(Mail m){
		for(Route r : routes){
			if(r.priority != m.priority) return false; 
		}
		return true;
	}
	
	
	public Boolean isCritical(Mail m){
		double cost = calculateCost(m);
		if(cost >= (m.cost*3)) return true;
		else return false;
	}
	

	
	public double gettotalduration(){
  double totalduration = 0;
		
		for ( Route r : routes ){
		
			totalduration = totalduration + 	r.duration;
			
		}
    return totalduration;
	}
}
