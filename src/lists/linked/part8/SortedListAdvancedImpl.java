package lists.linked.part8;

import lists.linked.part4.SortedInterface;

public class SortedListAdvancedImpl<T> implements SortedInterface<T> {
	private final int DEFAULT_CAPACITY = 100;
	private int originalCapacity;
	private T[] list;
	private int numberOfElements;
	private int currentPosition;
	
	// find() 메소드에 의해 설정
	private boolean found;
	private int location;
	
	@SuppressWarnings("unchecked")
	public SortedListAdvancedImpl() {
		originalCapacity = DEFAULT_CAPACITY;
		list = (T[]) new Object[originalCapacity];
	}
	
	@SuppressWarnings("unchecked")
	public SortedListAdvancedImpl(int originalCapacity) {
		list = (T[]) new Object[originalCapacity];
		this.originalCapacity = originalCapacity;
	}
	
	@SuppressWarnings("unchecked")
	protected void find(T element) {
		Comparable<T> targetElement = (Comparable<T>) element;
		found = false;
		recommandFind(targetElement, 0, numberOfElements - 1); 
	}
	
	protected void recommandFind(Comparable<T> targetElement, int fromLocation, int toLocation) {
		
	}
	
	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean contains(T element) {
		find(element);
		return found;
	}


	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public T getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
