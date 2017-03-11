package dataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Stack{

	protected Deque<String> stack = new ArrayDeque<String>();

	protected Iterator<String> stringsToPrint;

	public boolean pop() {
		try {
			stack.removeFirst();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void push(String newItemToAdd) {		
		stack.addFirst(newItemToAdd);
	}

	public String peek() {
		String firstItemInStack = stack.peekFirst();
		return firstItemInStack;
	}

	public int getStackSize() {
		int numberOfItemsInStack = stack.size();
		return numberOfItemsInStack;
	}

	public void printStackToConsole() {
		buildStrings();
		while (stringsToPrint.hasNext()) {
			String element = stringsToPrint.next();
			System.out.println(element + " ");
		}
	}

	public void buildStrings() {
		stringsToPrint = stack.iterator();
	}

}
