package queue.array_queue;

public class ArrayBoundedQueueTestMain {

	public static void main(String[] args) {
		ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<Integer>(5);
		System.out.println("queue�� ���� �񿴽��ϱ�?: " + queue.isEmpty());
		queue.enqueue(10);
		System.out.println("queue: " + queue.toString());
		queue.enqueue(3);
		System.out.println("queue: " + queue.toString());
		queue.enqueue(5);
		System.out.println("queue: " + queue.toString());
		queue.enqueue(6);
		System.out.println("queue: " + queue.toString());
		queue.enqueue(9);
		System.out.println("queue: " + queue.toString());
		System.out.println("queue�� ���� ���� �� �ֽ��ϱ�?: " + queue.isFull());
		
		System.out.println("value: " + queue.dequeue());
		System.out.println("queue: " + queue.toString());
		System.out.println("value: " + queue.dequeue());
		System.out.println("queue: " + queue.toString());
		System.out.println("value: " + queue.dequeue());
		System.out.println("queue: " + queue.toString());
		System.out.println("value: " + queue.dequeue());
		System.out.println("queue: " + queue.toString());
		System.out.println("value: " + queue.dequeue());
		System.out.println("queue: " + queue.toString());
		System.out.println("queue�� ���� �񿴽��ϱ�?: " + queue.isEmpty());
	}

}
