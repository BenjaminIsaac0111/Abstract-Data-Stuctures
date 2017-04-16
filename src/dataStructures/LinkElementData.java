package dataStructures;

/**
 * Represents an element within the {@link MyLinkedStack} class.
 * 
 * @author Benjamin Wilson
 *
 * @param <T> the type for the element.
 */
class LinkElementSegment<T> {

	/**
	 * The stored element.
	 */
	private final T data;
	
	/**
	 * The previous link element in the linked stack, can be null if no previous link element exists.
	 */
	private final LinkElementSegment<T> next;
	
	int size = 0;
	
	/** 
	 * @param theElement the stored element.
	 * @param prevElement  the previous element in the linked stack.
	 */
	LinkElementSegment(T data, LinkElementSegment<T> next) {		
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
	public T getData() {	
		return data;
	}

	/**
	 * Gets the previous link element reference in the linked stack, can be null if no previous element exists.
	 * @return the previous link element in the linked stack
	 */
	public LinkElementSegment<T> getPrevSegment() {	
		return next;
	}
	
	/**
	 * Returns the previous link element in its specified type, can be null if no previous element exists.
	 * @return the previous link element in the linked stack
	 */
	public T getPrevSegmentData() {	
		return next.getData();
	}
	/**
	 * @return the size of list.
	 */
	public int getSize() {		
		return size;
	}
	
	

	

}
