package Logic;

import java.util.Date;
/**
 * 
 * 
 * @author BusyBees
 *
 *
 *Mail class represents a mail event.
 *
 *Contains all the details require to send mail
 *
 *Destination/Origin are where the customer sent the parcel and where to
 *Weight/Volume is the details of the customer parcel
 *
 *priority is the type of delivery, this class keeps track between string and ints.
 *time and date are when the parcel was brought in.
 *
 *
 *The Destination parameters must be set up after it is created, methods are included to do so.
 *
 */
public class Mail {

	public int ID;
	public String destination;
	public String origin;
	public double weight;
	public double volume;
	public int priority;
	public Date date;
	public double income;
	public double cost;
	public String name;
	public double time;

	public Destination destinationD;

	public Destination originD;

	public Mail(int i, String de, String o, double w, double v, int p, Date da,
			Double t) {
		this.ID = i;
		this.name = o;
		this.destination = de;
		this.origin = o;
		this.weight = w;
		this.volume = v;
		this.priority = p;
		this.date = da;
		this.time = t;
	}

	@SuppressWarnings("deprecation")
	public Mail(String[] values) {

		this.ID = Integer.parseInt(values[1]);
		this.destination = (values[2]);
		this.origin = (values[3]);
		this.weight = Double.parseDouble(values[4]);
		this.volume = Double.parseDouble(values[5]);
		this.priority = checkpriority(values[6]);

		String[] dateA = values[7].split("-");
		int year = Integer.parseInt(dateA[0]);
		int month = Integer.parseInt(dateA[1]);
		int day = Integer.parseInt(dateA[2]);

		this.date = new Date(year, month, day);

	}

	private int checkpriority(String string) {
		// TODO Auto-generated method stub
		if (string.equals("Domestic Standard")) {
			return 1;
		}
		if (string.equals("Domestic Air")) {
			return 2;
		}
		if (string.equals("International Standard Priority")) {
			return 3;
		}
		if (string.equals("International Air")) {
			return 4;
		}

		else
			return Integer.parseInt(string);
	}

	public void addCost(double c) {

		this.cost = c;
	}

	public void addShipmentTime(double t) {
		this.time = t;
	}

	public synchronized Destination getDestinationD() {
		return destinationD;
	}

	public synchronized void setDestinationD(Destination destinationD) {
		this.destinationD = destinationD;
	}

	public synchronized Destination getOriginD() {
		return originD;
	}

	public synchronized void setOriginD(Destination originD) {
		this.originD = originD;
	}

	
	
}
