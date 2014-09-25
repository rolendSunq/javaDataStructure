package queue.array_queue;

import queue.BoundedQueueInterface;
import queue.QueueOverflowException;
import queue.QueueUnderflowException;

public class SyncArrayBounedQueue<T> implements BoundedQueueInterface<T> {
	private final int DEFAULT_CAPACITY = 100; 	// default capacity
	private T[] queue; 							// array that holds queue elements
	private int numberOfElements = 0; 			// number of elements n the queue
	private int front = 0; 						// index of front of queue
	private int rear;

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
