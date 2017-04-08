package dataStructures;

/**
 * @author Benjamin Wilson
 *
 * @param <T> Generic type for the element.
 */
class MyLinkedList<T> implements AbstractDataStructureInteface<T>{

	
	public LinkElementData<T> head;
	public LinkElementData<T> next;
	
	
	protected LinkElementData<T> getHead() {
		return head;
	}

	protected LinkElementData<T> getNext() {
		return next;
	}



	@Override
	public void push(T element) {
		head = new LinkElementData<T>(element, head);
		next = head.getPrevLinkElement();
	}

	@Override
	public T pop() {
		if ( head != null )	{
			T element = head.getElement();
			head = head.getPrevLinkElement();
			
			return element;
		}
		
		return null;
	}

	@Override
	public T peek() {
		if ( head != null ){
			return head.getElement();
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return ( head == null);
	}	
	
	public int getSize(){
		return head.getSize();
	}

	@Override
	public void buildIterator() {
		
	}
	
}
