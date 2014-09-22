package queue;

public interface QueueInterface<T> {
	// ť�� �����̸� QueueUnderflowException �߻�
	// ������ �ƴ϶�� ť�κ��� �� �׸��� �����ϰ� �׸��� ������.
	public T dequeue() throws QueueUnderflowException;
	
	// ť�� �����̸� ���� ����, �׷��� ������ ������ ����
	public boolean isEmpty();
}
