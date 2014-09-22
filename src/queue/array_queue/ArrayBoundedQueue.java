package queue.array_queue;

import queue.BoundedQueueInterface;
import queue.QueueOverflowException;
import queue.QueueUnderflowException;

public class ArrayBoundedQueue<T> implements BoundedQueueInterface<T> {

	private final int DEFAULTCAPACITY = 100;
	private T[] queue;
	private int numElements = 0;
	private int front = 0;
	private int rear = -1;
	
	@SuppressWarnings("unchecked")
	public ArrayBoundedQueue() {
		queue = (T[]) new Object[DEFAULTCAPACITY];
		rear = - 1;
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayBoundedQueue(int originalCapacity) {
		queue = (T[]) new Object[originalCapacity];
		rear = - 1;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException("ť�� ����ִ� ���¿��� Dequeue ������ �õ���.");
		} else {
			T toReturn = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
			numElements = numElements - 1;
			return toReturn;
		}
	}

	@Override
	public boolean isEmpty() {
		return (numElements == 0);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull())
			throw new QueueOverflowException("ť�� ������ ���¿��� enqueue ������ �õ���.");
		else {
			rear = (rear + 1) % queue.length;
			queue[rear] = element;
			numElements = numElements + 1;
		}
	}

	@Override
	public boolean isFull() {
		return (numElements == queue.length);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (T data : queue) {
			if (data != null)
				sb.append(String.valueOf(data) + " ");
		}
		
		return sb.toString();
	}

}
