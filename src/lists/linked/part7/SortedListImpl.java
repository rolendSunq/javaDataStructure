package lists.linked.part7;

import lists.SortedListInterface;

public class SortedListImpl<T> implements SortedListInterface<T> {
	private final int DEFAULT_CAPACITY = 100;
	private int originalCapacity;
	private T[] list;
	private int numberOfElements = 0;
	private int currentPosition;
	
	// found 메소드에 의해 설정
	private boolean found;
	private int location;
	
	@SuppressWarnings("unchecked")
	public SortedListImpl() {
		list = (T[]) new Object[DEFAULT_CAPACITY];
		originalCapacity = DEFAULT_CAPACITY;
	}
	
	@SuppressWarnings("unchecked")
	public SortedListImpl(int originalCapacity) {
		list = (T[]) new Object[originalCapacity];
		this.originalCapacity = originalCapacity;
	}
	
	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean contains(T element) {
		return false;
	}

	@Override
	public T get(T element) {
		return null;
	}

	@Override
	public boolean remove(T element) {
		return false;
	}

	@Override
	public void reset() {

	}

	@Override
	public T getNext() {
		return null;
	}

	@Override
	public void add(Comparable<T> element) {

	}

}
