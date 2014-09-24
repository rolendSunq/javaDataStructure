package queue.palindrome;

import queue.BoundedQueueInterface;
import queue.array_queue.ArrayBoundedQueue;
import stack.BoundedStackInterface;
import stack.arraystack.ArrayStack;

public class Palindrome {
	private char 	ch;
	private String 	candidate;
	private int 	length;
	private int 	lettersLength;
	private int 	checkCount;
	private char 	fromStack;
	private char 	fromQueue;
	private boolean stillPalindrome;
	BoundedStackInterface<Character> stack;
	BoundedQueueInterface<Character> queue;
	
	public Palindrome() {}

	public Palindrome(String candidate) {
		this.candidate = candidate;
		length 	= candidate.length();
		stack 	= new ArrayStack<Character>();
		queue 	= new ArrayBoundedQueue<Character>();
		lettersLength = 0;
		checkCount = 0;
	}
	
	private void checkString() {
		for (int i = 0; i < length; i++) {
			// 문자 하나씩 분리한다.
			ch = candidate.charAt(i);
			setStackNQueue(ch);
		}
		
	}
	
	// 문자 하나씩 stack과 queue에 넣는다.
	private void setStackNQueue(char letter) {
		if (Character.isLetter(letter)) {
			lettersLength++;
			char lowletter = Character.toLowerCase(letter);
			stack.push(lowletter);
			queue.enqueue(lowletter);
		}
	}
	
	// 회문인지 stack과 queue에서 문자를 꺼내 비교하여 true 또는 false를 리턴한다.
	private boolean isPalindrome() {
		stillPalindrome = true;
		while (stillPalindrome && (checkCount < lettersLength)) {
			fromStack = stack.top();
			stack.pop();
			fromQueue = queue.dequeue();
			
			if (fromStack != fromQueue) {
				stillPalindrome = false;
			}
			
			checkCount++;
		}
		
		return stillPalindrome;
	}
	
	public void runPalindrome() {
		checkString();
		System.out.println("문장: " + candidate);
		
		if (isPalindrome())
			System.out.println("결과: 이 문장은 회문입니다.");
		else 
			System.out.println("결과: 이 문장은 회문이 아닙니다.");
		
		init();
	}

	// 새로운 문자열을 받기위해 Palindrome 멤머를 초기화 한다.
	private void init() {
		ch = ' ';             
		candidate = null;      
		length = 0;         
		lettersLength = 0;  
		checkCount = 0;     
		fromStack = ' ';      
		fromQueue = ' ';      
		stillPalindrome = false;
		stack 	= new ArrayStack<Character>();
		queue 	= new ArrayBoundedQueue<Character>();
	}
}
