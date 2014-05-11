package Logic;

public class Route implements Cloneable{

	public int ID;
	public Destination destination;
	public Destination origin;
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

	public boolean visited = false;
	public boolean added = false;
	public Route(String details){

	String[] values = details.split("\t");
	System.out.println(details);
	this.ID = Integer.parseInt(values[0]);
	this.destination = new Destination(values[1],false);	//TODO put false here as not sure what to put
	this.origin =  new Destination(values[2],false);
	this.costWeight = Integer.parseInt(values[3]);
	this.costVolume = Integer.parseInt(values[4]);
	this.maxWeight = Integer.parseInt(values[5]);
	this.maxVolume = Integer.parseInt(values[6]);
	this.priority = Integer.parseInt(values[7]);
	this.day = (values[8]);
	this.frequency = Integer.parseInt(values[9]);
	this.duration = Integer.parseInt(values[10]);
	this.companyName = (values[11]);
	}

	public Route(int id, String d, String o, double c1, double c2, double mW, double mV, int p, String da, double f, double du, String cN){
		this.ID = id;
		this.destination = new Destination(d,false);	//TODO put false here temporarily
		this.origin = new Destination(o,false);	//TODO put false here temporarily
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
		return new Route(ID, destination.getName(), origin.getName(), costWeight, costVolume, maxWeight, maxVolume, priority, day, frequency, duration, companyName);
	}


}
