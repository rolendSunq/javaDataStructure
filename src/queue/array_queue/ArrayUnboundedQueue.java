package queue.array_queue;

import queue.QueueUnderflowException;
import queue.UnboundedQueueInterface;

public class ArrayUnboundedQueue<T> implements UnboundedQueueInterface<T> {
	
	private final int DEFAULTCAPACITY = 100;	// �⺻ �뷮
	private T[] queue;							// ť �׸��� ������ �迭
	private int originalCapacity;				// �� �뷮
	private int numElements = 0;				// ť�� �ִ� �׸��� ����
	private int front = 0;						// ť�� �� ������ index 
	private int rear = -1;						// ť�� �� ������ index
	
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

	// ť�� �뷮�� originalCapacity ��ŭ ����
	@SuppressWarnings("unchecked")
	private void enlarge() {
		// �� ū �迭�� ����
		T[] larger = (T[]) new Object[queue.length + originalCapacity];
		
		// ���� queue���� larger �迭�� ������ ����
		int currentSmaller = front;
		for (int currentLarger = 0; currentLarger < numElements; currentLarger++) {
			larger[currentLarger] = queue[currentSmaller];
			currentSmaller = (currentSmaller + 1) % queue.length;
		}
		
		// �ν��Ͻ� ������ ����
		queue = larger;
		front = 0;
		rear = numElements - 1;
	}
	
	// ť�� �����̸� QueueUnderflowException�� �߻�.
	// �ƴϸ� ť�κ��� �� �׸��� �����ϰ� ����
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException("����ִ� ť�� ���� dequeue ������ �õ���.");
		} else {
			T toReturn = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
			numElements = numElements - 1;
			return toReturn;
		}
	}
	
	// ť�� ��������� true, �ƴϸ� false ����
	@Override
	public boolean isEmpty() {
		return (numElements == 0);
	}
	
	// ť�� ���� �׸� �߰�
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
