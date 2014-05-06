package Logic;
import java.util.*;

public class Statistics {
	
	private int revenue;
	private int expenditure;
	private int events;
	private Set<Mail> mails = new HashSet<Mail>();
	private Set<Route> routes = new HashSet<Route>();
	
	public Statistics() {
		
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
		// TODO
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
	
}
