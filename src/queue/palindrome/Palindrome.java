package queue.palindrome;

import queue.BoundedQueueInterface;
import queue.array_queue.ArrayBoundedQueue;
import stack.BoundedStackInterface;
import stack.arraystack.ArrayStack;

public class Palindrome<T> {
	private char 	ch;
	private int 	length;
	private int 	lettersLength;
	private int 	checkCount;
	private char 	fromStack;
	private char 	fromQueue;
	private boolean stillPalindrome;
	BoundedStackInterface<T> stack;
	BoundedQueueInterface<T> queue;
	
	public Palindrome() {}

	public Palindrome(String candidate) {
		length 	= candidate.length();
		stack 	= new ArrayStack<T>();
		queue 	= new ArrayBoundedQueue<T>();
		lettersLength = 0;
	}
	
	
}
