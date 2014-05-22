package Logic;



/**
 * 
 * Cost is an object the represents a Cost given by the system on how much to charge customers. 
 * 
 * Destinations are the where the mail is traveling to/from
 * Priority is the delivery type
 * Weight/Volume used to calculate the rate / kg that the customer is charged
 * 
 * 
 * Can keep track of priority using an int - string conversion.
 *
 */
public class Cost {

	public int ID;
	public double weight;
	public double volume;
	public String destination;
	public String origin;
	public int priority;
	
	
	
	public Cost(String[] values) {
		
		this.ID = Integer.parseInt(values[1]);
		this.weight = Double.parseDouble(values[2]);
		this.volume = Double.parseDouble(values[3]);
		this.destination = (values[4]);
		this.origin = (values[5]);
		this.priority = priorityCheck(values[6]);
		
		
	}
	
	private int priorityCheck(String string) {
		// TODO Auto-generated method stub
		
		if ( string.equals("Domestic Standard") ) {return 1;}
		if ( string.equals("Domestic Air") ) {return 2;} 
		if ( string.equals("International Standard Priority") ) {return 3;}
		if ( string.equals("International Air") ) {return 4;}
			
		else return Integer.parseInt(string);
	}

	public Cost(int i, double w, double v, String d, String o, int p){
		this.ID = i;
		this.weight = w;
		this.volume = v;
		this.destination = d;
		this.origin = o;
		this.priority = p;
	}

	
	

}
