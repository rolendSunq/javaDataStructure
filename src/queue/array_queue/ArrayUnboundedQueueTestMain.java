package queue.array_queue;

public class ArrayUnboundedQueueTestMain {

	public static void main(String[] args) {
		ArrayUnboundedQueue<Integer> queue = new ArrayUnboundedQueue<Integer>(5);
		System.out.println("ť�� ������ϱ�? " + queue.isEmpty());
		queue.enqueue(4);
		System.out.println(queue.toString());
		queue.enqueue(6);
		System.out.println(queue.toString());
		queue.enqueue(8);
		System.out.println(queue.toString());
		queue.enqueue(2);
		System.out.println(queue.toString());
		queue.enqueue(3);
		System.out.println(queue.toString());
		System.out.println("\nť�� ������ϱ�? " + queue.isEmpty() + "\n");
		
		queue.dequeue();
		System.out.println(queue.toString());
		queue.dequeue();
		System.out.println(queue.toString());
		queue.dequeue();
		System.out.println(queue.toString());
		queue.dequeue();
		System.out.println(queue.toString());
		queue.dequeue();
		System.out.println(queue.toString());
		System.out.println("ť�� ������ϱ�? " + queue.isEmpty());
	}

}
