package recursive.reverse_print;

import stack.linkedstack.LLNode;
import stack.linkedstack.LinkedStack;

public class LinkedStackExp<T> extends LinkedStack<T> {
	public void revPrint(LLNode<T> listRef) {
		
		if (listRef != null) {
			revPrint(listRef.getLink());
			System.out.println(" " +  listRef.getInfo());
		}
	}
	
}
