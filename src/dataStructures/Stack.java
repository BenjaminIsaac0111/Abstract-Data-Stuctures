package dataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * This class provides a stack and its functions, Push, Pop and Peek. It can be extended by a graphics processors class 
 * called StackGraphics to provide an visual representation of the current items inside the stack.
 * @author Benjamin Wilson
 */
public class Stack extends dataStructureGraphics{

	protected Deque<String> stack = new ArrayDeque<String>();

	protected Iterator<String> stringsToPrint;

	/**
	 * removes the last item from the stack.
	 */
	public boolean pop() {
		try {
			stack.removeFirst();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * pushes a new item into the stack.
	 */
	public void push(String newItemToAdd) {		
		stack.addFirst(newItemToAdd);
	}

	/**
	 * return the last item added to the stack.
	 */
	public String peek() {
		String firstItemInStack = stack.peekFirst();
		return firstItemInStack;
	}

	/**
	 * return the size of the stack.
	 */
	public int getStackSize() {
		int numberOfItemsInStack = stack.size();
		return numberOfItemsInStack;
	}

	/**
	 * builds an iterator and then loops and prints each element.
	 */
	public void printStackToConsole() {
		buildStrings();
		while (stringsToPrint.hasNext()) {
			String element = stringsToPrint.next();
			System.out.println(element + " ");
		}
	}

	/**
	 * assembles an iterator of strings from the current stack.
	 */
	public void buildStrings() {
		stringsToPrint = stack.iterator();
	}

}
