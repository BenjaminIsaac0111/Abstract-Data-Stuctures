package dataStructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyList<T> extends dataStructureGraphics implements List<T> {

	
	private LinkedList<T> list = new LinkedList<T>();
	protected Iterator<T> stringsToPrint;
	int currentIndex;
	
	
	/* (non-Javadoc)
	 * @see dataStructures.List#add(java.lang.Object)
	 */
	@Override
	public boolean add(T e) {	
		return list.add(e);
	}

	/* (non-Javadoc)
	 * @see dataStructures.List#add(int, java.lang.Object)
	 */
	@Override
	public void add(int index, T element) {
		list.add(index, element);
	}

	/* (non-Javadoc)
	 * @see dataStructures.List#clear()
	 */
	@Override
	public void clear() {
		list.clear();		
	}

	/* (non-Javadoc)
	 * @see dataStructures.List#get(int)
	 */
	@Override
	public T get(int index) {
		return list.get(index);
	}


	/* (non-Javadoc)
	 * @see dataStructures.List#isEmpty()
	 */
	@Override
	public boolean isEmpty() {

		return list.isEmpty();
	}

	/* (non-Javadoc)
	 * @see dataStructures.List#listIterator()
	 */
	@Override
	public ListIterator<T> listIterator() {
		return list.listIterator();
	}

	/* (non-Javadoc)
	 * @see dataStructures.List#listIterator(int)
	 */
	@Override
	public ListIterator<T> listIterator(int index) {
		return list.listIterator(index);
	}

	/* (non-Javadoc)
	 * @see dataStructures.List#remove(java.lang.Object)
	 */
	@Override
	public boolean remove(Object o) {
		return list.remove(o);
	}

	/* (non-Javadoc)
	 * @see dataStructures.List#remove(int)
	 */
	@Override
	public T remove(int index) {
		return list.remove(index);
	}

	/* (non-Javadoc)
	 * @see dataStructures.List#set(int, java.lang.Object)
	 */
	@Override
	public T set(int index, T element) {
		return list.set(index, element);
	}

	/* (non-Javadoc)
	 * @see dataStructures.List#size()
	 */
	@Override
	public int size() {
		return size();
	}	
	
	/**
	 * Returns Size.
	 * @return
	 */
	public int getSize(){
		return list.size();
	}
	
	public void buildStrings(){
		stringsToPrint = list.iterator();
	}
		
}
