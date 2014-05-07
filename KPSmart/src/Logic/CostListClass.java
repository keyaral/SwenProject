package Logic;

import java.util.HashMap;
import java.util.HashSet;

public class CostListClass {

	public HashMap<String,Cost> costs;
	
	public CostListClass(){
		costs = new HashMap<String, Cost>();
		//costs.addAll();  Add from database
		Cost testCost1 = new Cost(1, 10,15,"Auckland","Wellington",2);
		Cost testCost2 = new Cost(2, 10,15,"Auckland","Wellington",2);
		Cost testCost3 = new Cost(3, 10,15,"Auckland","Wellington",2);
		costs.put("AucklandStndWellington", testCost1);
		costs.put("AucklandStndWellington", testCost2);
		costs.put("AucklandStndWellington", testCost3);
	}
	
	public Boolean addCost(Cost c){
		Boolean exists = false;
		for(Cost a : costs.values()){
			if(a.ID == c.ID) exists = true;	
		}
		if(exists == true){ System.out.println("Already Exists"); return false;}
		else{
			String name = c.origin+c.priority+c.destination;
			costs.put(name, c); return true;}
	}
	
	public Boolean changeCost(Cost c){
		Boolean found = false;
		for(Cost a : costs.values()){
			if(a.ID == c.ID) {found = true;	a = c;}	
		}
		if(found == true){ return true;}
		else return false; 
	}
	
	public Boolean deleteCost(Cost c){
		Boolean found = false;
		for(Cost a : costs.values()){
			if(a.ID == c.ID) {found = true;	costs.remove(a);}	
		}
		if(found == true){ return true;}
		else return false; 
	}

	public Cost findValidCost(Mail m) {
		String query = m.origin+m.priority+m.destination;
		Cost c = costs.get(query);
		System.out.print(c.toString());
		return c;
	}
	
	
}
