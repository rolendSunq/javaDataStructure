package queue.circular_queue;

import queue.BoundedQueueInterface;
import queue.QueueOverflowException;
import queue.QueueUnderflowException;

public class CircularArrayQueue<T> implements BoundedQueueInterface<T> {
	private static final int DEFAULT_CAPACITY = 5;
    private T[] queue;
    private final int CAPACITY; // capacity
    private int front = 0;
    private int rear  = 0;
     
    @SuppressWarnings("unchecked")
	public CircularArrayQueue(){
        CAPACITY = DEFAULT_CAPACITY;
        queue = (T[]) new Object[CAPACITY];
    }
     
    @SuppressWarnings("unchecked")
	public CircularArrayQueue(int capacity){
        CAPACITY = capacity;
        queue = (T[]) new Object[CAPACITY];
    }
 
    public int size() {
        if(rear > front)
            return rear - front;
        return CAPACITY - front + rear;
    }
 
    public boolean isEmpty() {
        return (rear == front) ? true : false;
    }
 
    public boolean isFull() {
        int diff = rear - front; 
        if(diff == -1 || diff == (CAPACITY -1))
            return true;
        return false;
    }
 
    public void enqueue(T obj) throws QueueOverflowException {
        if(isFull()){
            throw new QueueOverflowException("가득찬 큐에 Enqueue 연산을 시도함.");
        }else{
            queue[rear] = obj;
            rear = (rear + 1) % CAPACITY;
        }
    }
 
    public T dequeue() throws QueueUnderflowException {
        T item; 
        if(isEmpty()){
            throw new QueueUnderflowException("빈 큐에 Dequeue 연산을 시도함.");
        }else{
            item = queue[front];
            queue[front] = null;
            front = (front + 1) % CAPACITY;
        }
       return item;
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
