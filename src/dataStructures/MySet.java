package dataStructures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class MySet<T> implements Set<T> {

	private ArrayList<T> list = new ArrayList<T>();
	
	@Override
	public int size() {

		return list.size();
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		
		return list.contains(o);
	}

	@Override
	public Iterator<T> iterator() {

		return list.iterator();
	}

	@Override
	public Object[] toArray() {

		return list.toArray();
	}

	@SuppressWarnings("hiding")
	@Override
	public <T> T[] toArray(T[] a) {

		return list.toArray(a);
	}

	@Override
	public boolean add(T e) {
		
		// since this is a set, ensure the element is NOT already present.
		if ( list.contains(e) )
			return false;	// element already present, so do not add again!
		
		list.add(e);
		
		return true;
	}

	@Override
	public boolean remove(Object o) {
		
		return list.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		
		boolean changed = false;
		
		// iterate over each element in collection and check whether it is actually added.
		for(T element: c ) {
			
			// call own implementation of add, so element only added if not already present.
			if ( add(element) )
				changed = true;	// the element was added, so return a true result
		}
		
		return changed;
	}

	@Override
	public boolean retainAll(Collection<?> c) {

		return list.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		return list.removeAll(c);
	}

	@Override
	public void clear() {
		
		list.clear();	
	}

}