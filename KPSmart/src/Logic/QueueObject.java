package Logic;

public class QueueObject {

	public QueueObject from;
	public double weight;
	public double maxEstimate;
	public Destination destination;

	public QueueObject(Destination current, QueueObject f, double w, double estimate) {
		destination = current;
		from = f;
		weight = w;
		maxEstimate += estimate;
	}
}
