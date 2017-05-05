package dataStructures;

import java.util.ListIterator;

/**
 * @author Benjamin Wilson
 *
 * @param <T>
 */
public interface List<T> {

	/**
	 * Adds element to the list.
	 * @param e
	 * @return
	 */
	public boolean add(T e);

	/**
	 * Adds element to list at specified index.
	 * @param index
	 * @param element
	 */
	
	public void add(int index, T element);

	/**
	 * Clears the list.
	 */
	public void clear();

	/**
	 * Gets element at specified index.
	 * @param index
	 * @return
	 */
	public T get(int index);

	/**
	 * Checks if empty.
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Returns Iterator.
	 * @return
	 */
	public ListIterator<T> listIterator();

	/**
	 * 
	 * @param index
	 * @return
	 */
	public ListIterator<T> listIterator(int index);

	/**
	 * Removes item by name.
	 * @param o
	 * @return
	 */
	public boolean remove(Object o);

	/**
	 * Remove element at specified Index.
	 * @param index
	 * @return
	 */
	public T remove(int index);

	/**
	 * Set element at index.
	 * @param index
	 * @param element
	 * @return
	 */
	public T set(int index, T element);

	/**
	 * Returns size of the List.
	 * @return
	 */
	public int size();	
	
}
