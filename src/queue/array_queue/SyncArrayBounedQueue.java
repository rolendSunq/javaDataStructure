package queue.array_queue;

import queue.BoundedQueueInterface;
import queue.QueueOverflowException;
import queue.QueueUnderflowException;

public class SyncArrayBounedQueue<T> implements BoundedQueueInterface<T> {
	private final int DEFAULT_CAPACITY = 100; 	// 기본 용량
	private T[] queue; 							// 큐 요소(element)는 배열 구조이다.
	private int numberOfElements = 0; 			// 큐에서 요소(element)의 수
	private int front = 0; 						// 큐에서 front의 값(배열의 인덱스 값)
	private int rear;							// 큐에서 가장 하단의 요소(element) rear의 값

	@SuppressWarnings("unchecked")
	public SyncArrayBounedQueue() {
		queue = (T[]) new Object[DEFAULT_CAPACITY];
		rear = DEFAULT_CAPACITY - 1;
	}

	@SuppressWarnings("unchecked")
	public SyncArrayBounedQueue(int capacity) {
		queue = (T[]) new Object[capacity];
		rear = capacity - 1;
	}

	@Override
	public synchronized T dequeue() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException("빈 큐에 Dequeue 연산을 시도함.");
		else {
			T toReturn = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
			numberOfElements = numberOfElements - 1;
			return toReturn;
		}
	}

	@Override
	public synchronized boolean isEmpty() {
		return (numberOfElements == 0);
	}

	@Override
	public synchronized void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException("가득찬 큐에 Enqueue 연산을 시도함.");
		else {
			rear = (rear + 1) % queue.length;
			queue[rear] = element;
			numberOfElements = numberOfElements + 1;
		}
	}

	@Override
	public synchronized boolean isFull() {
		return (numberOfElements == queue.length);
	}

}
