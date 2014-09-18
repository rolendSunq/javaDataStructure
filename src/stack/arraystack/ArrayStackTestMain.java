package stack.arraystack;

public class ArrayStackTestMain {

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		stack.push(5);
		stack.push(7);
		stack.push(6);
		stack.push(9);
		System.out.println("스택은 공백인가? " + stack.isEmpty());
		
		System.out.println("스택의 top: " + stack.top());
		stack.pop();
		System.out.println("스택에서 pop");
		System.out.println("스택의 top: " + stack.top());
		stack.pop();
		System.out.println("스택에서 pop");
		System.out.println("스택의 top: " + stack.top());
		stack.pop();
		System.out.println("스택에서 pop");
		System.out.println("스택의 top: " + stack.top());
		stack.pop();
		System.out.println("스택에서 pop");
		
		System.out.println("스택은 공백인가? " + stack.isEmpty());
	}

}
