package dataStructures;

public class ListDriver extends dataStructureGraphics {
	
	MyLinkedList<String> list = new MyLinkedList<String>();


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
		
		protected String getHeadType() {
			try {
				return list.getHeadType();
			} catch (Exception e) {}
			return "Null Pointer";
		}

		protected String getNextType() {
			try {
				return list.getNextType();
			} catch (Exception e) {}
			return "Null Pointer";
		}
		

		/**
		 * Output all items to the terminal.
		 */
		public void printItemsToConsole() {
			LinkElementSegment<String> segment = list.getHead();
			
			try {
				while (segment != null){
					System.out.println("Data: "+segment.getData() + " Next:" +segment.getPrevSegmentData());
					segment = segment.getPrevSegment();
				}
			} catch (Exception e) {}
		}
		
		
	}
	
	
	
