package stack;

public interface StackInterface<T> {
	// ������ �����̸� StackUnderflowException �� �߻� �׷��� ������ ������ top�׸��� ����
	public void pop() throws StackOverflowException;
	
	// ������ �����̸� StackUnderflowException�� �߻� �׷��� ������ ������ top�׸��� ����
	public T top() throws StackUnderflowException;
	
	// ������ �����̸� true, �׷��� ������ false ����
	public Boolean isEmpty();
}
