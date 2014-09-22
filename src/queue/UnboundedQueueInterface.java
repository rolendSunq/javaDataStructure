package queue;

public interface UnboundedQueueInterface<T> extends QueueInterface<T> {
	// 큐의 뒤에 항목 추가
	public void enqueue(T element);
}
