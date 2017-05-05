package dataStructures;

public class Queue extends StackGraphics {

	
	/**
	 * Removes first Item from Queue.
	 * @return boolean
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
