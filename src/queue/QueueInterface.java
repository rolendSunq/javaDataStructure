package queue;

public interface QueueInterface<T> {
	// 큐가 공백이면 QueueUnderflowException 발생
	// 공백이 아니라면 큐로부터 앞 항목을 제거하고 항목을 리턴함.
	public T dequeue() throws QueueUnderflowException;
	
	// 큐가 공백이면 참을 리턴, 그렇지 않으면 거짓을 리턴
	public boolean isEmpty();
}
