package dataStructures;

class Node<T> {

	int key;
	T element;

	Node<T> leftChild;
	Node<T> rightChild;

	Node(int key, T element) {

		this.key = key;
		this.element = element;

	}

	public String toString() {

		return element + " has the key " + key;

		/*
		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
		 * "\nRight Child: " + rightChild + "\n";
		 */

	}

}