package dataStructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyList<T> extends dataStructureGraphics implements List<T> {

	
	private LinkedList<T> list = new LinkedList<T>();
	protected Iterator<T> stringsToPrint;
	int currentIndex;
	
	
	@Override
	public boolean add(T e) {	
		return list.add(e);
	}

	@Override
	public void add(int index, T element) {
		list.add(index, element);
	}

	@Override
	public void clear() {
		list.clear();		
	}

	@Override
	public T get(int index) {
		return list.get(index);
	}


	@Override
	public boolean isEmpty() {

		return list.isEmpty();
	}

	@Override
	public ListIterator<T> listIterator() {
		return list.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return list.listIterator(index);
	}

	@Override
	public boolean remove(Object o) {
		return list.remove(o);
	}

	@Override
	public T remove(int index) {
		return list.remove(index);
	}

	@Override
	public T set(int index, T element) {
		return list.set(index, element);
	}

	@Override
	public int size() {
		return size();
	}	
	
	public int getSize(){
		return list.size();
	}
	
	public void buildStrings(){
		stringsToPrint = list.iterator();
	}
		
}
