package dataStructures;

import java.util.Iterator;

public class Set extends dataStructureGraphics {
	
	private MySet<String> set = new MySet<String>();
	
	protected Iterator<String> stringsToPrint;
	
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
	
	
	
	public void clear(){
		set.clear();
	}
	
	public int getSize(){
		return set.size();
	}
	
	public void buildStrings(){
		stringsToPrint = set.iterator();
	}
}
