package stack.linkedstack;

import stack.StackOverflowException;
import stack.StackUnderflowException;
import stack.UnboundedStackInterface;

public class LinkedStack<T> implements UnboundedStackInterface<T> {
	
	private LLNode<T> top;
	
	@Override
	public void pop() throws StackOverflowException {
		if (!isEmpty())
			top = top.getLink();
		else
			throw new StackUnderflowException("�� ���ÿ��� pop������ �õ���.");
	}

	@Override
	public T top() throws StackUnderflowException {
		if (!isEmpty())
			return top.getInfo();
		else 
			throw new StackUnderflowException("�� ���ÿ��� top������ �õ���.");
	}

	@Override
	public Boolean isEmpty() {
		return (top == null);
	}

	/*
	 * push �޼ҵ��� �۾� ������ �߿��ϴ�.
	 * ���ο� ����� link �Ӽ��� �����ϱ� ���� top ������ ���� �ϸ� ���� ��忡 ���� ������ �Ҵ´�.
	 * ���� ������ �ٷ� �� ������ �����ϴµ� ������ ���Ѽ� �ڷῡ ���� ������ ���� �ʵ��� �����Ѵ�.
	 * 
	 */
	@Override
	public void push(T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
	}

}
