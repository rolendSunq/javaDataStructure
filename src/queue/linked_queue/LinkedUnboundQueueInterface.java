package queue.linked_queue;

import linked_list_node.LinkedListNode;
import queue.QueueUnderflowException;
import queue.UnboundedQueueInterface;

public class LinkedUnboundQueueInterface<T> implements UnboundedQueueInterface<T>{
	private LinkedListNode<T> front;	// 큐의 맨앞 참조
	private LinkedListNode<T> rear;		// 큐의 맨뒤 참조
	
	public LinkedUnboundQueueInterface() {
		front = null;
		rear = null;
	}
	
	// 큐가 공백이면 QueueUnderflowException을 발생
	// 아니면 큐에서 맨 앞 항목을 삭제하고 항목 리턴
	@Override
	public T dequeue() throws QueueUnderflowException {
		
		if (isEmpty()) {
			throw new QueueUnderflowException("빈 큐에서 Dequeue 연산을 시도.");
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

	// 큐가 공백이면 참 그렇지 않으면 거짓을 리턴
	@Override
	public boolean isEmpty() {
		return (front == null) ? true : false;
	}

	// 큐 뒤에 항목 추가
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
