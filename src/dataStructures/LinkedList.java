package dataStructures;

/**
 * @author Benjamin Wilson
 *
 * @param <T> Generic type for the element.
 */
class MyLinkedList<T> implements AbstractDataStructureInteface<T>{

	
	public LinkElementSegment<T> head;
	public LinkElementSegment<T> next;
	
	
	protected T getHeadType() {
		return head.getData();
	}

	protected T getNextType() {
		return next.getPrevSegmentData();
	}
	
	protected LinkElementSegment<T> getHead() {
		return head;
	}

	protected LinkElementSegment<T> getNext() {
		return next;
	}



	@Override
	public void push(T element) {
		head = new LinkElementSegment<T>(element, head);
		next = head.getPrevSegment();
	}

	@Override
	public T pop() {
		if ( head != null )	{
			T element = head.getData();
			head = head.getPrevSegment();
			
			return element;
		}
		
		return null;
	}

	@Override
	public T peek() {
		if ( head != null ){
			return head.getData();
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
