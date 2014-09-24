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
			// ���� �ϳ��� �и��Ѵ�.
			ch = candidate.charAt(i);
			setStackNQueue(ch);
		}
		
	}
	
	// ���� �ϳ��� stack�� queue�� �ִ´�.
	private void setStackNQueue(char letter) {
		if (Character.isLetter(letter)) {
			lettersLength++;
			char lowletter = Character.toLowerCase(letter);
			stack.push(lowletter);
			queue.enqueue(lowletter);
		}
	}
	
	// ȸ������ stack�� queue���� ���ڸ� ���� ���Ͽ� true �Ǵ� false�� �����Ѵ�.
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
		System.out.println("����: " + candidate);
		
		if (isPalindrome())
			System.out.println("���: �� ������ ȸ���Դϴ�.");
		else 
			System.out.println("���: �� ������ ȸ���� �ƴմϴ�.");
		
		init();
	}

	// ���ο� ���ڿ��� �ޱ����� Palindrome ��Ӹ� �ʱ�ȭ �Ѵ�.
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
