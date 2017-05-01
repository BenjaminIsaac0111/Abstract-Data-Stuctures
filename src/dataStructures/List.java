package dataStructures;

import java.util.ListIterator;

public interface List<T> {

	public boolean add(T e);

	public void add(int index, T element);

	public void clear();

	public T get(int index);

	public boolean isEmpty();

	public ListIterator<T> listIterator();

	public ListIterator<T> listIterator(int index);

	public boolean remove(Object o);

	public T remove(int index);

	public T set(int index, T element);

	public int size();	
	
}
