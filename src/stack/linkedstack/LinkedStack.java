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
			throw new StackUnderflowException("빈 스택에서 pop연산을 시도함.");
	}

	@Override
	public T top() throws StackUnderflowException {
		if (!isEmpty())
			return top.getInfo();
		else 
			throw new StackUnderflowException("빈 스택에서 top연산을 시도함.");
	}

	@Override
	public Boolean isEmpty() {
		return (top == null);
	}

	/*
	 * push 메소드의 작업 순서가 중요하다.
	 * 새로운 노드의 link 속성을 지정하기 전에 top 변수를 리셋 하면 스택 노드에 대한 접근을 잃는다.
	 * 연결 구조를 다룰 때 참조를 변경하는데 순서를 지켜서 자료에 대한 접근을 잃지 않도록 주의한다.
	 * 
	 */
	@Override
	public void push(T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(top);
		top = newNode;
	}

}
