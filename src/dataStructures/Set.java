package dataStructures;

import java.util.Iterator;

public class Set extends dataStructureGraphics {
	
	private MySet<String> set = new MySet<String>();
	
	protected Iterator<String> stringsToPrint;
	
	/**
	 * Add Item to the Set.
	 * @param o
	 * @return
	 */
	public boolean add(String o){
		try {
			if(set.add(o)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Remove item from Set.
	 * @param o
	 * @return
	 */
	public boolean remove(String o){
		try {
			if(set.remove(o)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	
	
	/**
	 * Empty the Set.
	 */
	public void clear(){
		set.clear();
	}
	
	/**
	 * Returns size of set.
	 * @return
	 */
	public int getSize(){
		return set.size();
	}
	
	public void buildStrings(){
		stringsToPrint = set.iterator();
	}
}
