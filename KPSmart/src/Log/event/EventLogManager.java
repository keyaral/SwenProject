package Log.event;

import gui.MainWindow;
import Logic.*;

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
		else if (e.type.equals("Delete")) {
			details += "was removed.";
		}
		else if (e.type.equals("Send")) {
			details += "was sent.";
		}
		
		
		return details;
	}

	public String[] getStats() {
		if (eventProcesser.getEvents().isEmpty()) {
			String[] stats = {"0", "0", "0"};
			return stats;
		}
		Statistics s = eventProcesser.getEvents().get(index).statistics;
		String[] stats = {String.valueOf(s.revenue()), String.valueOf(s.expenditure()), String.valueOf(s.events())};
		return stats;
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
	
	public boolean atEnd() {
		return index == maxIndex;
	}

	public void goTo(int num) throws TransitionError {
		if (num < 0 || num > maxIndex)
			throw new TransitionError("Target index out of bounds!");
		else {
			index = num;
		}
	}
}
