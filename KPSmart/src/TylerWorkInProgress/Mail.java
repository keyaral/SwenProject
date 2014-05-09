package TylerWorkInProgress;


import java.util.Date;

public class Mail {

	public int ID;
	public Destination destination;
	public String origin;
	public double weight;
	public double volume;
	public int priority;
	public Date date;
	public double cost;
	public String name;
	
	public Mail(int i, String de, String o, double w, double v, int p, Date da){
		this.ID = i;
		this.name = o;
		this.origin = o;
		this.weight = w;
		this.volume = v;
		this.priority = p;
		this.date = da;
		this.destination = new Destination(de, false);		//T added for testing
	}



	public Mail(String details) {
		String[] values = details.split("\t");
		this.ID = Integer.parseInt(values[0]);
		this.destination = new Destination(values[1],false);
		this.origin = (values[2]);
		this.weight = Integer.parseInt(values[3]);
		this.volume = Integer.parseInt(values[4]);
		this.priority = Integer.parseInt(values[5]);
		this.date = new Date();
		this.date.parse(values[6]);
	}
	
	public void addCost(double c){
		
		this.cost= c;
	}
}
