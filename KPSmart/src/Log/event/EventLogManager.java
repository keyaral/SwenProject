package Log.event;

import gui.MainWindow;
import Logic.*;

import java.util.*;

/**
 * The logic part for the Event Logger and Business Monitor. It updates and
 * displays events and business figures on the Event Logger and Business
 * Monitor.
 * @author BusyBees
 *
 */
public class EventLogManager {

	private int index;
	private int maxIndex;
	private EventProcesser eventProcesser;

	/**
	 * Creates a new Event Log Manager.
	 */
	public EventLogManager() {
		eventProcesser = MainWindow.logic.eventProcessor;
		index = 0;
		maxIndex = eventProcesser.getEvents().size()-1;
	}

	/**
	 * Get details from the event depending on what index the user is at.
	 * @return Resulting details of the event
	 */
	public String getDetails() {
		return getDetails(index);
	}
	
	/**
	 * Get details from the latest event.
	 * @return Resulting details of the latest event
	 */
	public String getLatestDetails() {
		return getDetails(maxIndex);
	}
	
	/**
	 * Returns the details of event based on what the type of object
	 * involved and the event's type.
	 * 
	 * @param The specified index of the event
	 * @return A string of details of the event
	 */
	private String getDetails(int index) {
		// If no events have processed. A message is returned
		if (eventProcesser.getEvents().isEmpty()) return "No events processed yet.";
		
		// Get the event
		KPEvent e = eventProcesser.getEvents().get(index);
		
		// The first line of details shows what index the user is currently at over how many event have been processed so far.
		String details = "Event " + (index+1) + "/" + (maxIndex+1) + "\n\n";
		
		// The first part of the event's description is the type of object involved in this event plus it's ID
		if (e.object instanceof Log.Log.KPEvents.Event.Route) {
			Log.Log.KPEvents.Event.Route r = (Log.Log.KPEvents.Event.Route)(e.object);
			details += "Route no. " + r.getId() + " ";
		}
		else if (e.object instanceof Log.Log.KPEvents.Event.Cost) {
			Log.Log.KPEvents.Event.Cost c = (Log.Log.KPEvents.Event.Cost)(e.object);
			details += "Cost no. " + c.getId() + " ";
		}
		else if (e.object instanceof Log.Log.KPEvents.Event.Mail) {
			Log.Log.KPEvents.Event.Mail m = (Log.Log.KPEvents.Event.Mail)(e.object);
			details += "Mail no. " + m.getId() + " ";
		}else if (e.object instanceof Cost) {
			Cost c = (Cost)(e.object);
			details += "Cost no. " + c.ID + " ";
		}else if (e.object instanceof Route) {
			Route r = (Route)(e.object);
			details += "Route no. " + r.ID + " ";
		}else if (e.object instanceof Mail) {
			Mail m = (Mail)(e.object);
			details += "Mail no. " + m.ID + " ";
		}
		
		// The second part is the event action with the object.
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
	
	/**
	 * Get statistics from the event depending on what index the user is at.
	 * @return A string array of stats: {Revenue, Expenditure, Events}
	 */
	public String[] getStats() {
		return getStats(index);
	}
	
	
	/**
	 * Get statistics from the latest event.
	 * @return A string array of stats: {Revenue, Expenditure, Profit,
	 * 		   Average Time, Average Weight, Average Volume}
	 */
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
	
	/**
	 * Get statistics from the event at the specified index
	 * 
	 * @param The specified index of the event
	 * @return A string array: {Revenue, Expenditure, Events}
	 */
	private String[] getStats(int index) {
		if (eventProcesser.getEvents().isEmpty()) {
			return new String[] {"0","0","0"};
		}
		Statistics s = eventProcesser.getEvents().get(index).statistics;
		String[] stats = {String.valueOf(s.revenue()), String.valueOf(s.expenditure()), String.valueOf(s.events())};
		return stats;
	}
	
	/**
	 * Sorts the list of amounts by destination. Note that for each list
	 * of string arrays in the list, the first array is how much mail that
	 * destination received while the others by origin represent how much
	 * mail came from that origin. The amount of mail is determined by
	 * weight, volume and quantity.
	 * 
	 * @param The list of amounts to be processed.
	 * @return Lists of String arrays lists or null if the list is null
	 */
	public List<List<String[]>> processMailAmounts(List<String[]> list) {
		// If the list provided is null, return null.
		if (list == null) return null;
		
		List<List<String[]>> amounts = new ArrayList<List<String[]>>();
		
		// Look at each string array in the list
		for (String[] s: list) {
			boolean found = false;
			if (amounts.isEmpty()) {
				// No processed list of amounts by destination is added yet so add a new list in
				List<String[]> newList = new ArrayList<String[]>();
				newList.add(new String[]{s[1],s[2],s[3],s[4]}); // First array
				newList.add(new String[]{s[0],s[2],s[3],s[4]}); // Other array
				amounts.add(newList);
			}
			else {
				for (List<String[]> amount: amounts) {
					// Attempt to find the list where the first array's destination matches the amount's destination
					if (s[1].equals(amount.get(0)[1])) {
						found = true;
						// Add in the array
						amount.add(new String[]{s[0],s[2],s[3],s[4]});
						// Update the first array's totals
						amount.set(0, new String[]{s[1],
								String.valueOf(Double.parseDouble(s[2])+Double.parseDouble(amount.get(0)[2])),
								String.valueOf(Double.parseDouble(s[3])+Double.parseDouble(amount.get(0)[3])),
								String.valueOf(Integer.parseInt(s[4])+Integer.parseInt(amount.get(0)[4]))});
					}
				}
				if (!found) {
					// No list found so add in a new list
					List<String[]> newList = new ArrayList<String[]>();
					newList.add(new String[]{s[1],s[2],s[3],s[4]}); // First array
					newList.add(new String[]{s[0],s[2],s[3],s[4]}); // Other array
					amounts.add(newList);
				}
			}
		}
		return amounts;
	}
	
	/**
	 * Processes the list of string arrays into triples. The first 3
	 * strings of the array will be inside parentheses separated by a comma
	 * while the rest are separated by a dash.
	 * 
	 * @param The list to process
	 * @return The processed list of Triples
	 */
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
	
	/**
	 * Returns the event at the current index.
	 * @return An event
	 */
	public KPEvent getEvent() {
		return eventProcesser.getEvents().get(index);
	}
	
	/**
	 * Increments the current index by 1.
	 */
	public void next()  {
		index++;
	}

	/**
	 * Decrements the current index by 1.
	 */
	public void previous() {
		index--;
	}
	
	/**
	 * Checks if the index is at 0.
	 * @return True if it is at 0. False otherwise.
	 */
	public boolean atStart() {
		return index == 0;
	}
	
	/**
	 * Checks if no events are processed yet.
	 * @return True if no events are processed yet. Flase otherwise.
	 */
	public boolean hasNoEvents() {
		return eventProcesser.getEvents().isEmpty();
	}
	
	/**
	 * Check if the index is at the end.
	 * @return True if the index is at the end. False otherwise
	 */
	public boolean atEnd() {
		return index == maxIndex;
	}
	
	/**
	 * Updates the event counter.
	 */
	public void update() {
		maxIndex = eventProcesser.getEvents().size()-1;
	}
	
	/**
	 * Sets the current index to the index specified.
	 * 
	 * @param The index to go to.
	 * @throws TransitionError if the index is outside the index boundaries
	 * 		   which is 1 and the max index.
	 */
	public void goTo(int num) throws TransitionError {
		if (num < 1 || num > maxIndex+1)
			throw new TransitionError("Target index out of bounds!");
		else {
			index = num-1;
		}
	}
}
