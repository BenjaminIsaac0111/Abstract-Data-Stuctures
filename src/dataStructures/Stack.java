package dataStructures;


import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class provides a abstractStructure and its functions, Push, Pop and Peek. It can be extended by a graphics processors class 
 * called abstractStructureGraphics to provide an visual representation of the current items inside the abstractStructure.
 * @author Benjamin Wilson
 */
public class Stack extends dataStructureGraphics{

	protected LinkedList<String> abstractStructure = new LinkedList<String>();

	protected Iterator<String> stringsToPrint;

	/**
	 * removes the last item from the abstractStructure.
	 */
	public boolean pop() {
		try {
			abstractStructure.removeFirst();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * pushes a new item into the abstractStructure.
	 */
	public void push(String newItemToAdd) {		
		abstractStructure.addFirst(newItemToAdd);
	}


	/**
	 * return the last item added to the abstractStructure.
	 */
	public String peek() {
		String firstItem = abstractStructure.peekFirst();
		return firstItem;
	}

	/**
	 * return the size of the abstractStructure.
	 */
	public int getSize() {
		int numberOfItems = abstractStructure.size();
		return numberOfItems;
	}

	/**
	 * builds an iterator and then loops and prints each element.
	 */
	public void printItemsToConsole() {
		buildStrings();
		while(stringsToPrint.hasNext()) {
			String element = stringsToPrint.next();
			System.out.println(element + " ");
		}
	}

	/**
	 * assembles an iterator of strings from the current abstractStructure.
	 */
	public void buildStrings() {
		stringsToPrint = abstractStructure.iterator();
	}

}
