package Logic;

import java.util.Date;

public class Mail {

	public int ID;
	public String destination;
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
	}



	@SuppressWarnings("deprecation")
	public Mail(String[] values) {
	
		this.ID = Integer.parseInt(values[1]);
		this.destination = (values[2]);
		this.origin = (values[3]);
		this.weight = Integer.parseInt(values[4]);
		this.volume = Integer.parseInt(values[5]);
		this.priority = Integer.parseInt(values[6]);
		
		String[] dateA = values[7].split("-");
		int year = Integer.parseInt(dateA[0]); 
		int month= Integer.parseInt(dateA[1]); 
		int day = Integer.parseInt(dateA[2]);
		
		this.date = new Date(year,month, day) ;
		
	    }
	
	public void addCost(double c){
		
		this.cost= c;
	}
}
