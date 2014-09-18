package stack.arraystack;

import stack.BoundedStackInterface;
import stack.StackOverflowException;
import stack.StackUnderflowException;


public class ArrayStack<T> implements BoundedStackInterface<T> {
	
	private final int DEFAULTCAPACITY = 100;	// 기본 용량
	private T[] stack;
	private int topIndex = -1;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		stack = (T[]) new Object[DEFAULTCAPACITY];
	}
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int maxSize) {
		stack = (T[]) new Object[maxSize];
	}
	
	@Override
	public void pop() throws StackOverflowException {
		
		if (!isEmpty()) {
			stack[topIndex] = null;
			topIndex--;
		} else
			throw new StackUnderflowException("빈 스택에서 pop 연산을 시도함.");
	}

	@Override
	public T top() throws StackUnderflowException {
		
		T topOfStack = null;
		
		if (!isEmpty()) topOfStack = stack[topIndex];
		else
			throw new StackUnderflowException("빈 스택에서 top 연산을 시도함.");
		
		return topOfStack;
		
	}
	
	@Override
	public void push(T element) {
		
		if (!isFull()) {
			topIndex++;
			stack[topIndex] = element;
		} else 
			throw new StackOverflowException("스택이 가득찬 상태에서 push 연산을 시도함.");		
	}

	@Override
	public Boolean isEmpty() {
		
		if (topIndex == -1) return true;
		else
			return false;
	}


	@Override
	public boolean isFull() {
		
		if (topIndex == (stack.length - 1)) return true;
		else
			return false;
	}

}
