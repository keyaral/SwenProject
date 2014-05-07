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
	
	public Route(String[] values){
		

	System.out.println(values);
	this.ID = Integer.parseInt(values[0]);
	this.destination = (values[1]);
	this.origin = (values[2]);
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
