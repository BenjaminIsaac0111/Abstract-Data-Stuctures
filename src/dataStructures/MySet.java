package dataStructures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class MySet<T> extends dataStructureGraphics implements Set<T> {

	private ArrayList<T> list = new ArrayList<T>();
	
	//This.
	@Override
	public int size() {

		return list.size();
	}

	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}
	//This
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
	//This
	@Override
	public boolean add(T e) {
		
		// since this is a set, ensure the element is NOT already present.
		if ( list.contains(e) )
			return false;	// element already present, so do not add again!
		
		list.add(e);
		
		return true;
	}
	//This
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
		
		for(T element: c ) {
			
			if ( add(element) )
				changed = true;	
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
	//This.
	@Override
	public void clear() {
		
		list.clear();	
		
	}

}