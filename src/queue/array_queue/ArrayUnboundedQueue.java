package queue.array_queue;

import queue.QueueUnderflowException;
import queue.UnboundedQueueInterface;

public class ArrayUnboundedQueue<T> implements UnboundedQueueInterface<T> {
	
	private final int DEFAULTCAPACITY = 100;	// 기본 용량
	private T[] queue;							// 큐 항목을 가지는 배열
	private int originalCapacity;				// 원 용량
	private int numElements = 0;				// 큐에 있는 항목의 개수
	private int front = 0;						// 큐의 앞 지시자 index 
	private int rear = -1;						// 큐의 뒤 지시자 index
	
	@SuppressWarnings("unchecked")
	public ArrayUnboundedQueue() {
		queue = (T[]) new Object[DEFAULTCAPACITY];
		rear = DEFAULTCAPACITY - 1;
		originalCapacity = DEFAULTCAPACITY;
	}
	
	
	@SuppressWarnings("unchecked")
	public ArrayUnboundedQueue(int originalCapacity) {
		queue = (T[]) new Object[originalCapacity];
		rear = originalCapacity - 1;
		this.originalCapacity = originalCapacity;
	}

	// 큐의 용량을 originalCapacity 만큼 증가
	@SuppressWarnings("unchecked")
	private void enlarge() {
		// 더 큰 배열을 생성
		T[] larger = (T[]) new Object[queue.length + originalCapacity];
		
		// 기존 queue에서 larger 배열로 내용을 복사
		int currentSmaller = front;
		for (int currentLarger = 0; currentLarger < numElements; currentLarger++) {
			larger[currentLarger] = queue[currentSmaller];
			currentSmaller = (currentSmaller + 1) % queue.length;
		}
		
		// 인스턴스 변수를 수정
		queue = larger;
		front = 0;
		rear = numElements - 1;
	}
	
	// 큐가 공백이면 QueueUnderflowException을 발생.
	// 아니면 큐로부터 앞 항목을 삭제하고 리턴
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException("비어있는 큐로 부터 dequeue 연산을 시도함.");
		} else {
			T toReturn = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
			numElements = numElements - 1;
			return toReturn;
		}
	}
	
	// 큐가 비어있으면 true, 아니면 false 리턴
	@Override
	public boolean isEmpty() {
		return (numElements == 0);
	}
	
	// 큐의 뒤의 항목 추가
	@Override
	public void enqueue(T element) {
		
		if (numElements == queue.length)
			enlarge();
		
		rear = (rear + 1) % queue.length;
		queue[rear] = element;
		numElements = numElements + 1;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (T data : queue) {
			if (data != null) {
				sb.append(String.valueOf(data) + " ");
			}
		}
		return sb.toString();
	}

}
