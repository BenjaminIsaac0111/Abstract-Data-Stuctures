package dataStructures;

public class ListDriver extends dataStructureGraphics {
	
	MyLinkedList<String> list = new MyLinkedList<String>();

	/**
	 *
	 */

		/**
		 * removes the last item from the abstractStructure.
		 */
		public boolean pop(){
			if(list.pop() != null){
				return true;
			}
			return false;
		}

		/**
		 * pushes a new item into the abstractStructure.
		 */
		public void push(String newItemToAdd) {		
			list.push(newItemToAdd);
		}


		/**
		 * return the last item added to the abstractStructure.
		 */
		public String peek() {
			return list.peek();
		}

		/**
		 * return the size of the abstractStructure.
		 */
		public int getSize() {
			return list.getSize();
		}

		/**
		 * builds an iterator and then loops and prints each element.
		 */
		public void printItemsToConsole() {
			String element = list.getHead().getElement();
			while(element != null){
				System.out.println(element);
				element = list.getNext().getElement();
			}
		}

		/**
		 * assembles an iterator of strings from the current abstractStructure.
		 */
		public void buildStrings() {
			
		}

	}
	
	
	
