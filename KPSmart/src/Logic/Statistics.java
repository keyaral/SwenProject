package Logic;
import java.util.*;

public class Statistics implements Cloneable{

	private int revenue = 0;
	private int expenditure = 0;
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

	public int revenue() {
		return revenue;
	}

	public int expenditure() {
		return expenditure;
	}

	public int events() {
		return events;
	}

	public void addRevenue(int change) {
		revenue += change;
	}

	public void addExpenditure(int change) {
		expenditure += change;
	}

	public void incrementEvents() {
		events++;
	}

	public List<String> getMailAmounts() {
		List<String> amounts = new ArrayList<String>();
		for (Mail mail: mails) {
			if (amounts.isEmpty()) {
				amounts.add(mail.origin + " " + mail.destination.getName() + " " + mail.volume + " " + mail.weight + "  1");
			}
			else {
				boolean found = false;
				for (String a: amounts) {
					String[] array = a.split(" ");
					if (array[0].equals(mail.origin) && array[1].equals(mail.destination.getName())) {
						a = array[0] + " " + array[1] + " " +
								(Double.parseDouble(array[2]) + mail.volume) + " " +
								(Double.parseDouble(array[3]) + mail.weight) + " " +
								(Integer.parseInt(array[5]) + 1);
						found = true;
						break;
					}
				}
				if (!found)
					amounts.add(mail.origin + " " + mail.destination.getName() + " " + mail.volume + " " + mail.weight + "  1");
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
