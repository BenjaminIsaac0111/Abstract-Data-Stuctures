package dataStructures;

/**
 * Represents an element within the {@link MyLinkedStack} class.
 * 
 * @author Benjamin Wilson
 *
 * @param <T> the type for the element.
 */
class LinkElementData<T> {

	/**
	 * The stored element.
	 */
	private final T data;
	
	/**
	 * The previous link element in the linked stack, can be null if no previous link element exists.
	 */
	private final LinkElementData<T> next;
	
	int size = 1;
	
	/** 
	 * @param theElement the stored element.
	 * @param prevElement  the previous element in the linked stack.
	 */
	LinkElementData(T data, LinkElementData<T> next) {		
		this.data = data;
		this.next = next;
		if(next != null){
			size = next.getSize() + 1;
		}
	}
	/**
	 * Gets the stored element.
	 * @return the stored element.
	 */
	public T getElement() {	
		return data;
	}

	/**
	 * Gets the previous link element in the linked stack, can be null if no previous element exists.
	 * @return the previous link element in the linked stack
	 */
	public LinkElementData<T> getPrevLinkElement() {	
		return next;
	}
	/**
	 * @return the size of list.
	 */
	public int getSize() {		
		return size;
	}
	
	

	

}
