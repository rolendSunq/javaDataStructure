package stack.arraystack;

public class ArrayStackTestMain {

	public static void main(String[] args) {
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		stack.push(5);
		stack.push(7);
		stack.push(6);
		stack.push(9);
		System.out.println("������ �����ΰ�? " + stack.isEmpty());
		
		System.out.println("������ top: " + stack.top());
		stack.pop();
		System.out.println("���ÿ��� pop");
		System.out.println("������ top: " + stack.top());
		stack.pop();
		System.out.println("���ÿ��� pop");
		System.out.println("������ top: " + stack.top());
		stack.pop();
		System.out.println("���ÿ��� pop");
		System.out.println("������ top: " + stack.top());
		stack.pop();
		System.out.println("���ÿ��� pop");
		
		System.out.println("������ �����ΰ�? " + stack.isEmpty());
	}

}
