package stack;

public interface BoundedStackInterface<T> extends StackInterface<T> {
	
	// ������ ��ȭ �����̸� StackOverflowException�� �߻���Ŵ
	public void push(T element) throws StackOverflowException;
	
	// ������ ��ȭ�����̸� true ����, �ƴ϶�� false ����
	public boolean isFull();
}
