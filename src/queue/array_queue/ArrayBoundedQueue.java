package queue.array_queue;

import queue.BoundedQueueInterface;
import queue.QueueOverflowException;
import queue.QueueUnderflowException;

public class ArrayBoundedQueue<T> implements BoundedQueueInterface<T> {

	private final int DEFAULTCAPACITY = 100;
	private T[] queue;
	private int numElements = 0;
	private int front = 0;
	private int rear;
	
	public ArrayBoundedQueue() {
		queue = (T[]) new Object[DEFAULTCAPACITY];
		rear = -1;
	}
	
	public ArrayBoundedQueue(int maxSize) {
		queue = (T[]) new Object[maxSize];
		rear = -1;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException("큐가 가득찬 상태에서 enqueue 연산을 시도함.");
		else {
			rear = (rear + 1) % queue.length;
			queue[rear] = element;
			numElements = numElements + 1;
		}
	}

	@Override
	public boolean isFull() {
		return false;
	}


}
