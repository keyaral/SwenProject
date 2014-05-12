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
	public double time;

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
	System.out.println(values[6]);
		this.ID = Integer.parseInt(values[1]);
		this.destination = (values[2]);
		this.origin = (values[3]);
		this.weight = Double.parseDouble(values[4]);
		this.volume = Double.parseDouble(values[5]);
		this.priority = checkpriority(values[6]);
		
		String[] dateA = values[7].split("-");
		int year = Integer.parseInt(dateA[0]); 
		int month= Integer.parseInt(dateA[1]); 
		int day = Integer.parseInt(dateA[2]);
		
		this.date = new Date(year,month, day) ;
		
	    }
	
	private int checkpriority(String string) {
		// TODO Auto-generated method stub
	if ( string.equals("Domestic Air") ) {return 1;} 
	if ( string.equals("Domestic Standard") ) {return 2;}
	if ( string.equals("International Standard Priorityr") ) {return 3;}
	if ( string.equals("International Air") ) {return 4;}
		
		return 0;
	}




	public void addCost(double c){

		this.cost= c;
	}

	public void addShipmentTime(double t) {
		this.time = t;
	}
}
