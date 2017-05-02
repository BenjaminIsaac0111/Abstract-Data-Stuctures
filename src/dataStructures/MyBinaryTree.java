package dataStructures;

public class MyBinaryTree<T> {

	Node<T> root;

	public void addNode(int key, T element) {

		Node<T> newNode = new Node<T>(key, element);

		if (root == null) {
			root = newNode;
		} else {
			Node<T> focusNode = root;
			Node<T> parent;

			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}

				}

			}
		}

	}

	public void inOrderTraverseTree(Node<?> focusNode) {

		if (focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			inOrderTraverseTree(focusNode.rightChild);
		}

	}

	public void preorderTraverseTree(Node<?> focusNode) {

		if (focusNode != null) {
			preorderTraverseTree(focusNode.leftChild);
			preorderTraverseTree(focusNode.rightChild);

		}

	}

	public void postOrderTraverseTree(Node<?> focusNode) {

		if (focusNode != null) {
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
		}

	}

	public Node<T> findNode(int key) {

		Node<T> focusNode = root;

		while (focusNode.key != key) {
			if (key < focusNode.key) {
				focusNode = focusNode.leftChild;
			} else {
				focusNode = focusNode.rightChild;
			}
			
			if (focusNode == null)
				return null;
		}
		return focusNode;
	}

}
