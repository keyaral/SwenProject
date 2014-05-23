package Log.event;

/**
 * This error signal an illegal index transition caused by trying to move
 * to an index that is out of bounds.
 * @author Busy Bees
 *
 */
public class TransitionError extends Exception {
	public TransitionError(String e) {
		super(e);
	}
}
