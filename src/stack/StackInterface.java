package stack;

public interface StackInterface<T> {
	// 스택이 공백이면 StackUnderflowException 을 발생 그렇지 않으면 스택의 top항목을 삭제
	public void pop() throws StackOverflowException;
	
	// 스택이 공백이면 StackUnderflowException을 발생 그렇지 않으면 스택의 top항목을 리턴
	public T top() throws StackUnderflowException;
	
	// 스택이 공백이면 true, 그렇지 않으면 false 리턴
	public Boolean isEmpty();
}
