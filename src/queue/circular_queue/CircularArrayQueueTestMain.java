package queue.circular_queue;

public class CircularArrayQueueTestMain {

	public static void main(String[] args) {
		CircularArrayQueue<String> queue = new CircularArrayQueue<String>();
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		// queue.enqueue("E");
		System.out.println("큐의 크기: " + queue.size());
		System.out.println("circalr queue: " + queue.toString());
		System.out.println(queue.dequeue());
		queue.enqueue("E");
		System.out.println("circalr queue: " + queue.toString());
		System.out.println("큐의 크기: " + queue.size());
		// queue.enqueue("F");
		System.out.println(queue.dequeue());
		System.out.println("circalr queue: " + queue.toString());
		System.out.println("큐의 크기: " + queue.size());
	}

}
