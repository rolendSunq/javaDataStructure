package queue;

public interface UnboundedQueueInterface<T> extends QueueInterface<T> {
	// ť�� �ڿ� �׸� �߰�
	public void enqueue(T element);
}
