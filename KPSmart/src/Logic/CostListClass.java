package Logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;


/**
 * CostList uses a hashmap.
 * 
 * The keys are strings combined of the origin+priority+destination
 * This is on the assumption that only cost exist for every destination-origin-priority pair.
 * 
 *
 * */


public class CostListClass implements Cloneable{

	public HashMap<String,Cost> costs = new HashMap<String,Cost>() ;

	public CostListClass(){
	}

	public CostListClass(CostListClass clc) {
		costs = new HashMap<String, Cost>(clc.costs);
	}

	
	/**
	 * Add cost always checks if the cost exist before added it to prevent duplicates.
	 * 
	 * Given a cost, it make a key and assign them in the map
	 * */
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

	/**
	 * Add cost always checks if the cost exist before added it to prevent duplicates.
	 * 
	 * It will find the key, delete it from the map and then assign it to the new cost in the map.
	 * */
	
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
/**
 * Will return associated to the string created from the origin destion and priority type
 * of the mail object.
 * 
 * If none exists return null.
 * */

	public Cost findValidCost(Mail m) {
		String query = m.origin+m.priority+m.destination;

		Cost c = costs.get(query);

		if (c == null) return null;
		else return c;
	}

	
	/**
	 * 
	 * Checks a cost does exist by creating the matching key and searching for it.
	 */
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
