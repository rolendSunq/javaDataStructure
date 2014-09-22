package queue;

public interface BoundedQueueInterface<T> extends QueueInterface<T> {
	// 큐가 포화이면 QueueOverflowException을 발생
	// 아니면 큐의 뒤에 항목을 추가
	public void enqueue(T element) throws QueueOverflowException;
	
	// 큐가 포화이면 참 아니면 거짓을 리턴ㅇ
	public boolean isFull();
}
