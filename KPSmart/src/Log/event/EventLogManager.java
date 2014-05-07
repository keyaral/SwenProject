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
		KPEvent e = eventProcesser.getEvents().get(index);
		String details = "Event " + index + "/" + maxIndex + "\n\n";
		if (e.object instanceof Route) {
			Route r = (Route)(e.object);
			details += "Route " + r.ID + " ";
		}
		else if (e.object instanceof Cost) {
			Cost c = (Cost)(e.object);
			details += "Cost " + c.ID + " ";
		}
		else if (e.object instanceof Mail) {
			Mail m = (Mail)(e.object);
		}
		return details;
	}

	public String getStats() {
		Statistics s = eventProcesser.getEvents().get(index).statistics;
		String stats = s.revenue() + " " + s.expenditure() + " " + s.events();
		return stats;
	}

	public void next() throws TransitionError {
		if (index == maxIndex)
			throw new TransitionError("Event index already at end!");
		else {
			index++;
		}
	}

	public void previous() throws TransitionError {
		if (index == 0)
			throw new TransitionError("Event index already at start!");
		else {
			index--;
		}
	}

	public void goTo(int num) throws TransitionError {
		if (num < 0 || num > maxIndex)
			throw new TransitionError("Target index out of bounds!");
		else {
			index = num;
		}
	}
}
