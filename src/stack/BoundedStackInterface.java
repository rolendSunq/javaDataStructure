package stack;

public interface BoundedStackInterface<T> extends StackInterface<T> {
	
	// 스택이 포화 상태이면 StackOverflowException을 발생시킴
	public void push(T element) throws StackOverflowException;
	
	// 스택이 포화상태이면 true 리턴, 아니라면 false 리턴
	public boolean isFull();
}
