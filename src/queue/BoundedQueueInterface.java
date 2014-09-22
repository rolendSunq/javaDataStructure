package queue;

public interface BoundedQueueInterface<T> extends QueueInterface<T> {
	// ť�� ��ȭ�̸� QueueOverflowException�� �߻�
	// �ƴϸ� ť�� �ڿ� �׸��� �߰�
	public void enqueue(T element) throws QueueOverflowException;
	
	// ť�� ��ȭ�̸� �� �ƴϸ� ������ ���Ϥ�
	public boolean isFull();
}
