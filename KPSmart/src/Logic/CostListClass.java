package Logic;

import java.util.HashSet;

public class CostListClass {

	public HashSet<Cost> costs;
	
	public CostListClass(){
		costs = new HashSet<Cost>();
		//costs.addAll();  Add from database
		Cost testCost1 = new Cost(1, 10,15,"Auckland","Wellington",2);
		Cost testCost2 = new Cost(2, 10,15,"Auckland","Wellington",2);
		Cost testCost3 = new Cost(3, 10,15,"Auckland","Wellington",2);
		costs.add(testCost1);
		costs.add(testCost2);
		costs.add(testCost3);
	}
	
	public Boolean addCost(Cost c){
		Boolean exists = false;
		for(Cost a : costs){
			if(a.ID == c.ID) exists = true;	
		}
		if(exists == true){ System.out.println("Already Exists"); return false;}
		else{costs.add(c); return true;}
	}
	
	public Boolean changeCost(Cost c){
		Boolean found = false;
		for(Cost a : costs){
			if(a.ID == c.ID) {found = true;	a = c;}	
		}
		if(found == true){ return true;}
		else return false; 
	}
	
	public Boolean deleteCost(Cost c){
		Boolean found = false;
		for(Cost a : costs){
			if(a.ID == c.ID) {found = true;	costs.remove(a);}	
		}
		if(found == true){ return true;}
		else return false; 
	}

	public Cost findValidCost(Mail m) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
