package dataStructures;

class Node<T> {

	int key;
	T element;

	Node<T> leftChild;
	Node<T> rightChild;

	/**
	 * Builds a node for the Tree.
	 * @param key
	 * @param element
	 */
	Node(int key, T element) {

		this.key = key;
		this.element = element;

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		return element + " has the key " + key;

	}

}