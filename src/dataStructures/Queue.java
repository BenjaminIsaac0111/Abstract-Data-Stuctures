package dataStructures;

public class Queue extends StackGraphics {

	/**
	 * removes the last item from the Queue.
	 */
	public boolean remove() {
		try {
			abstractStructure.removeLast();
			return true;
		} catch (Exception e) {
			return false;
		}
	}


}
