package Logic;

public class Route implements Cloneable{

	public int ID;
	public String destination;
	public String origin;
	public double cost;
	public double maxWeight;
	public double maxVolume;
	public int priority;
	public String day;
	public double frequency;
	public double duration;
	public String companyName;
	public double costWeight;
	public double costVolume;


	public Destination destinationD;
	public Destination originD; 
	boolean visited = false;
	public boolean added = false;

	


	public Route(String[] values){


	
	this.ID = Integer.parseInt(values[1]);
	this.destination = (values[2]);
	this.origin = (values[3]);
	this.costWeight = Double.parseDouble(values[4]);
	this.costVolume = Double.parseDouble(values[5]);
	this.maxWeight = Double.parseDouble(values[6]);
	this.maxVolume = Double.parseDouble(values[7]);
	this.priority = checkPriority(values[8]);
	this.day = (values[9]);
	this.frequency = Double.parseDouble(values[10]);
	this.duration = Double.parseDouble(values[11]);
	this.companyName = (values[12]);
}


	private int checkPriority(String string) {
		
		// TODO Auto-generated method stub
		if ( string.equals("Domestic Air") ) {return 1;} 
		if ( string.equals("Domestic Standard") ) {return 2;}
		if ( string.equals("International Standard Priorityr") ) {return 3;}
		if ( string.equals("International Air") ) {return 4;}
			
		else return Integer.parseInt(string);
	}


	public Route(int id, String d, String o, double c1, double c2, double mW, double mV, int p, String da, double f, double du, String cN){
		this.ID = id;
		this.destination = d;	//TODO put false here temporarily
		this.origin = o;	//TODO put false here temporarily
		this.costWeight = c1;
		this.costVolume = c2;
		this.maxWeight = mW;
		this.maxVolume = mV;
		this.priority = p;
		this.day = da;
		this.frequency = f;
		this.duration = du;
		this.companyName = cN;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Route))
			return false;
		else {
			Route other = (Route) obj;
			if (ID != other.ID) return false;
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Route(ID, destination, origin, costWeight, costVolume, maxWeight, maxVolume, priority, day, frequency, duration, companyName);
	}


}
