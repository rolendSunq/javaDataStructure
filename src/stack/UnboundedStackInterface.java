package stack;

public interface UnboundedStackInterface<T> extends StackInterface<T> {
	// 스택의 top에 항목을 위치 시킴
	public void push(T element);
}
