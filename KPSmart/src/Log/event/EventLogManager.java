package Log.event;

import Logic.*;

public class EventLogManager {

	private int index;
	private int maxIndex;
	private EventProcesser eventProcesser;

	public EventLogManager() {
		eventProcesser = new EventProcesser();
		index = 0;
		maxIndex = eventProcesser.getEvents().size()-1;
	}

	public String getDetails() {
		// TODO Need to determine detail arangement
		return "";
	}

	public String getStats() {
		// eventProcesser.get(index).Statistics;
		return "";
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
