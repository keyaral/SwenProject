package Logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class CostListClass implements Cloneable{

	public HashMap<String,Cost> costs = new HashMap<String,Cost>() ;

	public CostListClass(){
//		costs = new HashMap<String, Cost>();
//		Cost testCost1 = new Cost(1, 10,15,"Auckland","Wellington",2);
//
//
//		Cost testCost2 = new Cost(14, 10,15,"Wellington","Auckland",2);
//		Cost testCost3 = new Cost(15, 10,15,"Rotarua","Wellington",2);
//
//		costs.put("Auckland2Wellington", testCost1);
//		costs.put("Wellington2Auckland", testCost2);
//		costs.put("Rotarua2Wellington", testCost3);
//
//		Cost testCost11 = new Cost(9, 10,15,"Auckland","Wellington",1);
//		Cost testCost12 = new Cost(12, 10,15,"Wellington","Auckland",1);
//		Cost testCost13 = new Cost(13, 10,15,"Rotarua","Wellington",1);
//
//
//
//		costs.put("Auckland1Wellington", testCost11);
//		costs.put("Wellington1Auckland", testCost12);
//		costs.put("Rotarua1Wellington", testCost13);



//
//		costs.put("AucklandStndWellington", testCost2);
//		costs.put("AucklandStndWellington", testCost3);
//		Cost testCost4 = new Cost(1, 10,15,"Rotarua","Wellington",2);
//		Cost testCost5 = new Cost(2, 10,15,"Rotarua","Auckland",2);
//		Cost testCost6 = new Cost(3, 10,15,"Wellington","Dunedin",2);
//		Cost testCost7 = new Cost(1, 10,15,"Wellington","Rotarua",2);
//		Cost testCost8 = new Cost(2, 10,15,"Auckland","Rotarua",2);
//		Cost testCost9 = new Cost(3, 10,15,"Dunedin","Wellington",2);
//


	}

	public CostListClass(CostListClass clc) {
		costs = new HashMap<String, Cost>(clc.costs);
	}

	public Boolean addCost(Cost c){
		Boolean exists = false;

		for(Cost a : costs.values()){


			if(a.ID == c.ID) exists = true;
		}
		if(exists == true){ return false;}
		else{
			String name = c.origin+c.priority+c.destination;
			costs.put(name, c); return true;}
	}

	public Boolean changeCost(Cost c){
		Boolean found = false;
		for(String a : costs.keySet() ) {
			if(costs.get(a).ID == c.ID) {found = true;


			costs.remove(a);
			costs.put(a, c);
			}
		}
		if(found == true){ return true;}
		else return false;
	}


	public Cost findValidCost(Mail m) {
		String query = m.origin+m.priority+m.destination;

		Cost c = costs.get(query);

		if (c == null) return null;
		else return c;
	}

	public boolean contains( Cost c) {

		if ( costs.containsKey(c.origin+c.priority+c.destination) ) return true;
		else return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new CostListClass(this);
	}


}
