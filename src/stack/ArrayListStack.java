package stack;

import java.util.ArrayList;

public class ArrayListStack<T> implements UnboundedStackInterface<T> {

	private ArrayList<T> stack;
	
	public ArrayListStack() {
		stack = new ArrayList<T>();
	}
	
	@Override
	public void pop() throws StackOverflowException {
		if (!isEmpty())
			stack.remove(stack.size() - 1);
		else 
			throw new StackOverflowException("빈 스택에서 pop연산을 시도함");
	}

	@Override
	public T top() throws StackUnderflowException {
		T topOfStack = null;
		
		if (!isEmpty())
			topOfStack = stack.get(stack.size() - 1);
		else
			throw new StackUnderflowException("빈 스택에서 top연산을 시도함");
		
		return topOfStack;
	}

	@Override
	public Boolean isEmpty() {
		return (stack.size() == 0) ? true : false;
	}

	@Override
	public void push(T element) {
		stack.add(element);
	}

}
