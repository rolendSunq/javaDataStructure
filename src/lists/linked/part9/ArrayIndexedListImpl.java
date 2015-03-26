package lists.linked.part9;

import lists.linked.part4.IndexedListInterface;

public class ArrayIndexedListImpl<T> implements IndexedListInterface<T> {
	private final int DEFAULT_CAPACITY = 100;
	private int originalCapacity;
	private T[] list;
	private int numberOfElements;
	private int currentPosition;
	
	//find 메소드에 의해 설정
	private boolean found;
	private int location;
	
	@SuppressWarnings("unchecked")
	public ArrayIndexedListImpl() {
		list = (T[]) new Object[DEFAULT_CAPACITY];
		originalCapacity = DEFAULT_CAPACITY;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayIndexedListImpl(int originalCapacity) {
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
		if (fromLocation > toLocation) {
			found = false;
		} else {
			int compareResult;
			location = (fromLocation + toLocation) / 2;
			compareResult = targetElement.compareTo(list[location]);
			
			if (compareResult == 0) {
				found = true;
			} else if (compareResult < 0) { // targetElement는 list의 element 보다 값이 적다.
				recommandFind(targetElement, fromLocation, location - 1);
			} else {// targetElement는 list의 element 보다 값이 크다.
				recommandFind(targetElement, location + 1, toLocation);
			}
		}
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
		
		return false;
	}

	@Override
	public T get(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		
	}

	@Override
	public T getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(T element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("illegal index of " + index + 
                    " passed to ArrayIndexedList remove method");
		}
		
		T hold = list[index];
		
		for (int i = index; i < numberOfElements; i++) {
			list[i] = list[i + 1];
		}
		
		list[numberOfElements] = null;
		numberOfElements--;
		return hold;
	}

}
