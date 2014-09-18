package stack.linkedstack;

public class LinkedStackTestMain {

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		System.out.println("스택이 비였나? " + stack.isEmpty());
		System.out.println("Push 연산 >>>>>>");
		stack.push(3);
		System.out.println("top: " + stack.top());
		stack.push(6);
		System.out.println("top: " + stack.top());
		stack.push(8);
		System.out.println("top: " + stack.top());
		stack.push(5);
		System.out.println("top: " + stack.top());
		System.out.println("스택이 비였나? " + stack.isEmpty());
		System.out.println("Pop 연산 >>>>>>");
		System.out.println("top: " + stack.top());
		stack.pop();
		System.out.println("top: " + stack.top());
		stack.pop();
		System.out.println("top: " + stack.top());
		stack.pop();
		System.out.println("top: " + stack.top());
		stack.pop();
		System.out.println("스택이 비였나? " + stack.isEmpty());
	}

}
