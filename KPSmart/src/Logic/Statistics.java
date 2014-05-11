package Logic;
import java.util.*;

public class Statistics implements Cloneable{

	private double revenue = 0;
	private double expenditure = 0;
	private int events = 0;
	public final Set<Mail> mails;
	public final Set<Route> routes;

	public Statistics() {
		mails = new HashSet<Mail>();
		routes = new HashSet<Route>();
	}

	public Statistics(Statistics s) {
		revenue = s.revenue;
		expenditure = s.expenditure;
		events = s.events;
		mails = s.mails;
		routes = s.routes;
	}

	public double revenue() {
		return revenue;
	}

	public double expenditure() {
		return expenditure;
	}

	public int events() {
		return events;
	}

	public void setRevenue(double r) {
		revenue = r;
	}

	public void setExpenditure(double e) {
		expenditure = e;
	}

	public void incrementEvents() {
		events++;
	}

	public List<String[]> getMailAmounts() {
		List<String[]> amounts = new ArrayList<String[]>();
		for (Mail mail: mails) {
			if (amounts.isEmpty()) {
				String[] s = {mail.origin, mail.destination, String.valueOf(mail.volume), String.valueOf(mail.weight), "1"};
				amounts.add(s);
			}
			else {
				boolean found = false;
				for (String[] a: amounts) {
					if (a[0].equals(mail.origin) && a[1].equals(mail.destination)) {
						a[2] = String.valueOf(Double.parseDouble(a[2]) + mail.volume);
						a[3] = String.valueOf(Double.parseDouble(a[3]) + mail.weight);
						a[4] = String.valueOf(Integer.parseInt(a[4]) + 1);
						found = true;
						break;
					}
				}
				if (!found) {
					String[] s = {mail.origin, mail.destination, String.valueOf(mail.volume), String.valueOf(mail.weight), "1"};
					amounts.add(s);
				}
			}
		}
		return amounts;
	}

	public List<String> getDeliveryTimes() {
		List<String> times = new ArrayList<String>();
		// TODO
		return times;
	}

	public List<String> getCriticalRoutes() {
		List<String> routes = new ArrayList<String>();
		// TODO
		return routes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new Statistics(this);
	}



}
