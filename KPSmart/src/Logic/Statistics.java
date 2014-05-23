package Logic;
import java.util.*;

/**
 * Keeps track of all the business figures to see how the system is doing
 * so far. This is updated each time an event is processed and it is used
 * in events for referencing the changes when an event is fired.
 * @author BusyBees
 * 
 */
public class Statistics implements Cloneable{
	
	
	private double revenue = 0;
	private double expenditure = 0;
	private int events = 0;
	public final Set<Mail> mails;
	private RouteListClass routes;
	private CostListClass costs;
	
	/**
	 * Creates a new Statistics object .
	 */
	public Statistics() {
		mails = new HashSet<Mail>();
	}
	
	/**
	 * Creates a new Statistics object from an existing Statistics object.
	 * @param The existing Statistics object to be created from
	 */
	public Statistics(Statistics s) {
		// Copy the fields from the object into the new one
		revenue = s.revenue;
		expenditure = s.expenditure;
		events = s.events;
		mails = s.mails;
		try {
			// Clone the Route List and Cost List Objects
			routes = (RouteListClass) s.routes.clone();
			costs = (CostListClass) s.costs.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Returns the revenue.
	 * @return Revenue
	 */
	public double revenue() {
		return revenue;
	}

	/**
	 * Returns the expenditure.
	 * @return Expenditure
	 */
	public double expenditure() {
		return expenditure;
	}
	
	/**
	 * Returns the number of events that are processed.
	 * @return Number of events processed
	 */
	public int events() {
		return events;
	}
	
	/**
	 * Sets the revenue to field the new value for the Revenue.
	 * @param New value for the Revenue
	 */
	public void setRevenue(double r) {
		revenue = r;
 	}
	
	/**
	 * Sets the expenditure field to the new value for the expenditure.
	 * @param New value for the Expenditure
	 */
	public void setExpenditure(double e) {
		expenditure = e;
	}
	
	/**
	 * Increments the number of events processed by 1.
	 */
	public void incrementEvents() {
		events++;
	}
	
	/**
	 * Assigns the given Route List Class(RLC) to the RLC field.
	 * @param The RLC to be assigned
	 */
	public void setRouteList(RouteListClass rlc) {
		routes = rlc;
	}
	
	/**
	 * Assigns the given Cost List Class(CLC) to the CLC field.
	 * @param The CLC to be assigned
	 */
	public void setCostList(CostListClass clc) {
		costs = clc;
	}
	
	/**
	 * Returns a list of string arrays that represent how much mail has
	 * been sent from each origin to each destination by volume, weight
	 * and quantity. If no mail has been sent, a null object will be
	 * returned.
	 * 
	 * String array: {Origin, Destination, Volume, Weight, Quantity}
	 * 
	 * @return A list of string arrays or null if no mail is sent yet
	 */
	public List<String[]> getMailAmounts() {
		if (mails.isEmpty()) // No mail has been sent yet
			return null;
		
		List<String[]> amounts = new ArrayList<String[]>();
		// Look through each mail
		for (Mail mail: mails) { 
			if (amounts.isEmpty()) {
				// No amounts have been added in the list yet so add a new one in
				String[] string = {mail.origin, mail.destination, String.valueOf(mail.volume), String.valueOf(mail.weight), "1"};
				amounts.add(string);
			}
			else {
				boolean found = false;
				// Attempt to find the amount in the list that matches the mail's origin and destination
				for (String[] a: amounts) {
					if (a[0].equals(mail.origin) && a[1].equals(mail.destination)) {
						// Amount found, add the mail's volume and weight to that amount and increment it's quantity
						a[2] = String.valueOf(Double.parseDouble(a[2]) + mail.volume);

						a[2] = String.valueOf(Double.parseDouble(a[3]) + mail.weight);
						a[2] = String.valueOf(Integer.parseInt(a[4]) + 1);

						a[3] = String.valueOf(Double.parseDouble(a[3]) + mail.weight);
						a[4] = String.valueOf(Integer.parseInt(a[4]) + 1);

						found = true;
						break;
					}
				}
				if (!found) {
					// Amount doesn't exist in the list so add a new one in
					String[] string = {mail.origin, mail.destination, String.valueOf(mail.volume), String.valueOf(mail.weight), "1"};
					amounts.add(string);
				}
			}
		}
		return amounts;
	}
	
	/**
	 * Return a list of string arrays representing the average time taken
	 * to deliver mail for each type (Priority, Origin, Destination) of
	 * mail. Should there be mail sent, null will be returned.
	 * 
	 * String array: {Priority, Origin, Destination, Average Duration}
	 * 
	 * @return A list of string arrays or null if no mail is sent yet
	 */
	public List<String[]> getDeliveryTimes() {
		if (mails.isEmpty()) // No mail has been sent yet
			return null;
		// Create lists for the string of triples (destination, origin and priority ) and data pairs (total time, quantity)
		List<String[]> times = new ArrayList<String[]>();
		List<double[]> data = new ArrayList<double[]>();
		for (Mail mail: mails) {
			boolean found = false;
			if (times.isEmpty()) {
				// List of average times is empty, add in a new triple and data pair
				String[] s = {String.valueOf(mail.priority), mail.origin, mail.destination, ""};
				double[] d = {mail.time, 1};
				times.add(s);
				data.add(d);
			}
			else {
				// Attempt to find the triple that matches the mail's destination, origin and priority
				for (int i = 0; i < times.size(); i++) {
					if (mail.origin.equals(times.get(i)[0]) &&
							mail.destination.equals(times.get(i)[1]) &&
							mail.priority == Integer.parseInt(times.get(i)[2])) {
						// Triple found, update the data pair associated with the triple
						data.get(i)[0] += mail.time;
						data.get(i)[1]++;
						found = true;
						break;
					}
				}
				if (!found) {
					// No triple found, add a new one in and data pair
					String[] s = {String.valueOf(mail.priority), mail.origin, mail.destination, ""};
					double[] d = {mail.time, 1};
					times.add(s);
					data.add(d);
				}
			}

		}
		// Use the data pairs to find the average delivery time for each triple
		for (int i = 0; i < times.size(); i++) {
			times.get(i)[3] = String.valueOf(data.get(i)[0]/data.get(i)[1]);
		}
		return times;
	}
	
	/**
	 * Return a list of string arrays that represent routes by triples
	 * (Destination, Origin, Priority) which are critical. If there are no
	 * costs created yet, null will be returned.
	 * 
	 * String array: {Destination, Origin, Priority}
	 * 
	 * @return A list of string array or null is the list of costs is empty
	 */
	public List<String[]> getCriticalRoutes() {
		if(costs == null) return new ArrayList<String[]>();
		ArrayList<Cost> costs = new ArrayList<Cost>(this.costs.costs.values());
		HashMap<Route,Double> criticalRoutes = routes.findCriticalRoutes(costs);
		List<String[]> finalRoutes = new ArrayList<String[]>();
		String[] initial = new String[] {"Critical" , "Route", "Search"};
		finalRoutes.add(initial);
		for (Route cr: criticalRoutes.keySet()) {
			finalRoutes.add(new String[] {cr.destination, cr.origin, String.valueOf(cr.priority)});

		}
		return finalRoutes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Statistics(this);
	}
	
	/**
	 * Prints out the statistics's revenue, expenditure and number of
	 * events.
	 */
	public void printAll() {
		System.out.println ( revenue + " " + expenditure + " " + events);


	}



}
