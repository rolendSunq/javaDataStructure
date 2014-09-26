package queue.array_queue;

import queue.BoundedQueueInterface;
import queue.QueueOverflowException;
import queue.QueueUnderflowException;

public class SyncArrayBounedQueue<T> implements BoundedQueueInterface<T> {
	private final int DEFAULT_CAPACITY = 100; 	// �⺻ �뷮
	private T[] queue; 							// ť ���(element)�� �迭 �����̴�.
	private int numberOfElements = 0; 			// ť���� ���(element)�� ��
	private int front = 0; 						// ť���� front�� ��(�迭�� �ε��� ��)
	private int rear;							// ť���� ���� �ϴ��� ���(element) rear�� ��

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
			throw new QueueUnderflowException("�� ť�� Dequeue ������ �õ���.");
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
			throw new QueueOverflowException("������ ť�� Enqueue ������ �õ���.");
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
