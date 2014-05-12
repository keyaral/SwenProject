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
	public void addRevenue(int change) {
		revenue += change;

	}


	
		public void setExpenditure(double e) {
				expenditure = e;
		 	}
		
	public void addExpenditure(int change) {
		expenditure += change;

	}

	public void incrementEvents() {
		events++;
	}

	public List<String[]> getMailAmounts() {
		List<String[]> amounts = new ArrayList<String[]>();
		for (Mail mail: mails) {
			if (amounts.isEmpty()) {

				String[] string = {mail.origin, mail.destination, String.valueOf(mail.volume), String.valueOf(mail.weight), "1"};
				amounts.add(string);

			}
			else {
				boolean found = false;
				for (String[] a: amounts) {
					if (a[0].equals(mail.origin) && a[1].equals(mail.destination)) {
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

					String[] string = {mail.origin, mail.destination, String.valueOf(mail.volume), String.valueOf(mail.weight), "1"};
					amounts.add(string);

					String[] s = {mail.origin, mail.destination, String.valueOf(mail.volume), String.valueOf(mail.weight), "1"};
					amounts.add(s);

				}
			}
		}
		return amounts;
	}

	public List<String[]> getDeliveryTimes() {
		List<String[]> times = new ArrayList<String[]>();
		List<double[]> data = new ArrayList<double[]>();
		for (Mail mail: mails) {
			boolean found = false;
			if (times.isEmpty()) {
				String[] s = {mail.origin, mail.destination, String.valueOf(mail.priority), ""};
				double[] d = {mail.time, 1};
				times.add(s);
				data.add(d);
			}
			else {
				for (int i = 0; i < times.size(); i++) {
					if (mail.origin.equals(times.get(i)[0]) &&
							mail.destination.equals(times.get(i)[1]) &&
							mail.priority == Integer.parseInt(times.get(i)[2])) {
						data.get(i)[0] += mail.time;
						data.get(i)[1]++;
						found = true;
						break;
					}
				}
				if (!found) {
					String[] s = {mail.origin, mail.destination, String.valueOf(mail.priority), ""};
					double[] d = {mail.time, 1};
					times.add(s);
					data.add(d);
				}
			}

		}
		for (int i = 0; i < times.size(); i++) {
			times.get(i)[3] = String.valueOf(data.get(i)[0]/data.get(i)[1]);
		}
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
