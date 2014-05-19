package Log.event;

import gui.MainWindow;
import Logic.*;

import java.util.*;

public class EventLogManager {

	private int index;
	private int maxIndex;
	private EventProcesser eventProcesser;

	public EventLogManager() {
		eventProcesser = MainWindow.logic.eventProcessor;
		index = 0;
		maxIndex = eventProcesser.getEvents().size()-1;
	}

	public String getDetails() {
		return getDetails(index);
	}
	
	public String getLatestDetails() {
		return getDetails(maxIndex);
	}
	
	private String getDetails(int index) {
		if (eventProcesser.getEvents().isEmpty()) return "No events processed yet.";
		KPEvent e = eventProcesser.getEvents().get(index);
		String details = "Event " + index + "/" + maxIndex + "\n\n";

		if (e.object instanceof Route) {
			Route r = (Route)(e.object);
			details += "Route no. " + r.ID + " ";
		}
		else if (e.object instanceof Cost) {
			Cost c = (Cost)(e.object);
			details += "Cost no. " + c.ID + " ";
		}
		else if (e.object instanceof Mail) {
			Mail m = (Mail)(e.object);
			details += "Mail no. " + m.ID + " ";
		}

		if (e.type.equals("Add")) {
			details += "was added.";
		}
		else if (e.type.equals("Change")) {
			details += "was modified.";
		}
		else if (e.type.equals("Remove")) {
			details += "was removed.";
		}
		else if (e.type.equals("Send")) {
			details += "was sent.";
		}


		return details;
	}
	
	public String[] getStats() {
		return getStats(index);
	}
	
	public String[] getLatestStats() {
		if (eventProcesser.getEvents().isEmpty() || eventProcesser.getEvents().get(maxIndex).statistics.mails.isEmpty())
			return new String[]{"0","0","0","0","0","0"};
		String[] firstStats = getStats(maxIndex);
		String[] stats = new String[6];
		stats[0] = firstStats[0];
		stats[1] = firstStats[1];
		stats[2] = String.valueOf(Double.parseDouble(firstStats[0])-Double.parseDouble(firstStats[1]));
		
		Set<Mail> mails = eventProcesser.getEvents().get(maxIndex).statistics.mails;
		
		double totalTime = 0;
		double totalWeight = 0;
		double totalVolume = 0;
		for (Mail mail: mails) {
			totalTime += mail.time;
			totalWeight += mail.weight;
			totalVolume += mail.volume;
		}
		stats[3] = String.valueOf(totalTime/mails.size());
		stats[4] = String.valueOf(totalWeight/mails.size());
		stats[5] = String.valueOf(totalVolume/mails.size());
		
		return stats;
	}
	
	private String[] getStats(int index) {
		if (eventProcesser.getEvents().isEmpty()) {
			return new String[] {"0","0","0"};
		}
		Statistics s = eventProcesser.getEvents().get(index).statistics;
		String[] stats = {String.valueOf(s.revenue()), String.valueOf(s.expenditure()), String.valueOf(s.events())};
		return stats;
	}
	
	public List<List<String[]>> processMailAmounts(List<String[]> list) {
		if (list == null) return null;
		List<List<String[]>> amounts = new ArrayList<List<String[]>>();
		for (String[] s: list) {
			boolean found = false;
			if (amounts.isEmpty()) {
				List<String[]> newList = new ArrayList<String[]>();
				newList.add(new String[]{s[1],s[2],s[3],s[4]});
				newList.add(new String[]{s[0],s[2],s[3],s[4]});
				amounts.add(newList);
			}
			else {
				for (List<String[]> amount: amounts) {
					if (s[1].equals(amount.get(0)[1])) {
						found = true;
						amount.add(new String[]{s[0],s[2],s[3],s[4]});
						amount.set(0, new String[]{s[1],
								String.valueOf(Double.parseDouble(s[2])+Double.parseDouble(amount.get(0)[2])),
								String.valueOf(Double.parseDouble(s[3])+Double.parseDouble(amount.get(0)[3])),
								String.valueOf(Integer.parseInt(s[4])+Integer.parseInt(amount.get(0)[4]))});
					}
				}
				if (!found) {
					List<String[]> newList = new ArrayList<String[]>();
					newList.add(new String[]{s[1],s[2],s[3],s[4]});
					newList.add(new String[]{s[0],s[2],s[3],s[4]});
					amounts.add(newList);
				}
			}
		}
		return amounts;
	}

	public List<String> getTriplesList(List<String[]> list) {
		if (list==null) return null;
		List<String> processedList = new ArrayList<String>();
		for (String[] string: list) {
			String s = "(";
			for (int i = 0; i < string.length; i++) {
				if (i < 3) {
					if (i == 2) s += string[i] + ")";
					else s += string[i] + ", ";
				}
				else s += " - " + string[i];
			}
			processedList.add(s);
		}
		return processedList;
	}

	public KPEvent getEvent() {
		return eventProcesser.getEvents().get(index);
	}

	public void next()  {
		index++;
	}

	public void previous() {
		index--;
	}

	public boolean atStart() {
		return index == 0;
	}
	
	public boolean hasNoEvents() {
		return eventProcesser.getEvents().isEmpty();
	}

	public boolean atEnd() {
		return index == maxIndex;
	}
	
	public void update() {
		maxIndex = eventProcesser.getEvents().size()-1;
	}

	public void goTo(int num) throws TransitionError {
		if (num < 0 || num > maxIndex)
			throw new TransitionError("Target index out of bounds!");
		else {
			index = num;
		}
	}
}
