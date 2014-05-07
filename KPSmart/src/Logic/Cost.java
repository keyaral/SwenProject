package Logic;

public class Cost {

	public int ID;
	public double weight;
	public double volume;
	public String destination;
	public String origin;
	public int priority;
	
	
	
	public Cost(String[] values) {
	
		this.ID = Integer.parseInt(values[0]);
		this.weight = Integer.parseInt(values[1]);
		this.volume = Integer.parseInt(values[2]);
		this.destination = (values[3]);
		this.origin = (values[4]);
		this.priority = Integer.parseInt(values[5]);
		
		
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
