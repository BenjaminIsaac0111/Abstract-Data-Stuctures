package dataStructures;

/**
 * @author Benjamin Wilson
 *
 * @param <T>
 *            Generic type for the element.
 */
class MyLinkedList<T> implements AbstractDataStructureInteface<T> {

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
		if (head != null) {
			T element = head.getData();
			head = head.getPrevSegment();

			return element;
		}

		return null;
	}

	@Override
	public T peek() {
		if (head != null) {
			return head.getData();
		}
		return null;
	}

	@Override
	public boolean isEmpty() { 
		return (head == null);
	}

	@Override
	public int getSize() {
		try {
			return head.getSize();
		} catch (Exception e) {
			return 0;
		}

	}

	@Override
	public void buildIterator() {

	}

	public T findDataByIndex(int index) {
		LinkElementSegment<T> segment = head;

		for (int i = 0; i < getSize(); i++) {
			if (index == segment.getSize()) {
				return segment.getData();
			}
			segment = segment.getPrevSegment();

		}
		return null;

	}

	public T findNextByIndex(int index) {
		LinkElementSegment<T> segment = head;

		for (int i = 0; i < getSize(); i++) {
			if (index == segment.getSize() && segment.getPrevSegmentData() != null) {
				return segment.getPrevSegmentData();
			}
			segment = segment.getPrevSegment();

		}
		return null;
	}

}
