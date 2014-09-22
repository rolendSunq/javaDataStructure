package queue.array_queue;

public class ArrayBoundedQueueTestMain {

	public static void main(String[] args) {
		ArrayBoundedQueue<Integer> queue = new ArrayBoundedQueue<Integer>(5);
		System.out.println("queue는 지금 비였습니까?: " + queue.isEmpty());
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
		System.out.println("queue는 지금 가득 차 있습니까?: " + queue.isFull());
		
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
		System.out.println("queue는 지금 비였습니까?: " + queue.isEmpty());
	}

}
