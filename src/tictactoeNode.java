public class tictactoeNode {

	tictactoeNode next;
	String index;
	boolean value;
	
	
	tictactoeNode(){
		next = null;
		index = null;
		value = false;
	}
	
	tictactoeNode(tictactoeNode n, String i, boolean v){
		next = n;
		index = i;
		value = v;
	}
	
	public void setNext(tictactoeNode n) {
		next = n;
	}
	
	private boolean hasNext() {
		if(next == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public tictactoeNode getNext() {
		return next;
	}
	
	public boolean getValue() {
		return value;
	}

	public void setValue(boolean b) {
		value = b;
	}
	
	
}
