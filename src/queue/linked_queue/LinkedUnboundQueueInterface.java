package queue.linked_queue;

import linked_list_node.LinkedListNode;
import queue.QueueUnderflowException;
import queue.UnboundedQueueInterface;

public class LinkedUnboundQueueInterface<T> implements UnboundedQueueInterface<T>{
	private LinkedListNode<T> front;	// ť�� �Ǿ� ����
	private LinkedListNode<T> rear;		// ť�� �ǵ� ����
	
	public LinkedUnboundQueueInterface() {
		front = null;
		rear = null;
	}
	
	// ť�� �����̸� QueueUnderflowException�� �߻�
	// �ƴϸ� ť���� �� �� �׸��� �����ϰ� �׸� ����
	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) {
			throw new QueueUnderflowException("�� ť���� Dequeue ������ �õ�.");
		} else {
			T element;
			element = front.getInfo();
			front = front.getLink();
			
			if (front == null) {
				rear = null;
			}
			
			return element;
		}
	}

	// ť�� �����̸� �� �׷��� ������ ������ ����
	@Override
	public boolean isEmpty() {
		return (front == null) ? true : false;
	}

	// ť �ڿ� �׸� �߰�
	@Override
	public void enqueue(T element) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(element);
		
		if (rear == null) {
			front = newNode;
		} else {
			rear.setLink(newNode);
			rear = newNode;
		}
	}
 
}
