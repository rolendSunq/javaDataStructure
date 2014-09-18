package stack.linkedstack;

public class LinkedStackTestMain {

	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		System.out.println("������ �񿴳�? " + stack.isEmpty());
		System.out.println("Push ���� >>>>>>");
		stack.push(3);
		System.out.println("top: " + stack.top());
		stack.push(6);
		System.out.println("top: " + stack.top());
		stack.push(8);
		System.out.println("top: " + stack.top());
		stack.push(5);
		System.out.println("top: " + stack.top());
		System.out.println("������ �񿴳�? " + stack.isEmpty());
		System.out.println("Pop ���� >>>>>>");
		System.out.println("top: " + stack.top());
		stack.pop();
		System.out.println("top: " + stack.top());
		stack.pop();
		System.out.println("top: " + stack.top());
		stack.pop();
		System.out.println("top: " + stack.top());
		stack.pop();
		System.out.println("������ �񿴳�? " + stack.isEmpty());
	}

}
