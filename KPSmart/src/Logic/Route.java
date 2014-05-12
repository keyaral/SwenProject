package Logic;

public class Route {

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
		

	System.out.println(values);
	this.ID = Integer.parseInt(values[1]);
	this.destination = (values[2]);
	this.origin = (values[3]);
	this.costWeight = Integer.parseInt(values[4]);
	this.costVolume = Integer.parseInt(values[5]);
	this.maxWeight = Integer.parseInt(values[6]);
	this.maxVolume = Integer.parseInt(values[7]);
	this.priority = checkPriority(values[8]);
	this.day = (values[9]);
	this.frequency = Integer.parseInt(values[10]);
	this.duration = Integer.parseInt(values[11]);
	this.companyName = (values[12]);
	}
	
	private int checkPriority(String string) {
		// TODO Auto-generated method stub
		if ( string.equals("Domestic Air") ) {return 1;} 
		if ( string.equals("Domestic Standard") ) {return 2;}
		if ( string.equals("International Standard Priorityr") ) {return 3;}
		if ( string.equals("International Air") ) {return 4;}
			
			return 0;
	}

	public Route(int id, String d, String o, double c1, double c2, double mW, double mV, int p, String da, double f, double du, String cN){
		this.ID = id;
		this.destination = d;
		this.origin = o;
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
}
