package stack;

public class ArrayListStackTestMain {

	public static void main(String[] args) {
		ArrayListStack<Integer> stack = new ArrayListStack<Integer>();
		System.out.println("스택이 비였나? " + stack.isEmpty());
		stack.push(5);
		System.out.println("top: " + stack.top());
		stack.push(8);
		System.out.println("top: " + stack.top());
		stack.push(2);
		System.out.println("top: " + stack.top());
		stack.push(4);
		System.out.println("top: " + stack.top());
		
		System.out.println("");
		
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
