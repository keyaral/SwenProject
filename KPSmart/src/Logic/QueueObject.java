package Logic;

import java.util.Comparator;

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

	 public static Comparator<QueueObject> desComparator = new Comparator<QueueObject>(){
		 	        @Override
		 	        public int compare(QueueObject a, QueueObject b) {
		 	            if(a.destination.GeographicalY > b.destination.GeographicalY) return 1;
		 	            else return 0;
		 	        }
		 	    };
}
