package stack.arraystack;

import stack.BoundedStackInterface;
import stack.StackOverflowException;
import stack.StackUnderflowException;


public class ArrayStack<T> implements BoundedStackInterface<T> {
	
	private final int DEFAULTCAPACITY = 100;	// �⺻ �뷮
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
			throw new StackUnderflowException("�� ���ÿ��� pop ������ �õ���.");
	}

	@Override
	public T top() throws StackUnderflowException {
		
		T topOfStack = null;
		
		if (!isEmpty()) topOfStack = stack[topIndex];
		else
			throw new StackUnderflowException("�� ���ÿ��� top ������ �õ���.");
		
		return topOfStack;
		
	}
	
	@Override
	public void push(T element) {
		
		if (!isFull()) {
			topIndex++;
			stack[topIndex] = element;
		} else 
			throw new StackOverflowException("������ ������ ���¿��� push ������ �õ���.");		
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
