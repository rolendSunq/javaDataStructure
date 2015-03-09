package lists.linked.part5;

import lists.linked.part4.ListInterface;

public class ArrayUnsortedList<T> implements ListInterface<T>{
	private final int DEFAULT_CAPACITY = 100;
	private int originalCapacity;
	private T[] list;
	private int numberOfElements = 0;
	private int currentPosition;
	
	// found 메소드에 의해 설정
	private boolean found;
	private int location;
	
	@SuppressWarnings("unchecked")
	public ArrayUnsortedList() {
		list = (T[]) new Object[DEFAULT_CAPACITY];
		originalCapacity = DEFAULT_CAPACITY;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayUnsortedList(int originalCapacity) {
		list  = (T[]) new Object[originalCapacity];
		this.originalCapacity = originalCapacity;
	}

	
	public int getOriginalCapacity() {
		return originalCapacity;
	}

	public void setOriginalCapacity(int originalCapacity) {
		this.originalCapacity = originalCapacity;
	}

	public T[] getList() {
		return list;
	}

	public void setList(T[] list) {
		this.list = list;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	@SuppressWarnings("unchecked")
	public void enLarge() {
		T[] larger = (T[]) new Object[list.length + originalCapacity];
		for (int i = 0; i < numberOfElements; i++) {
			larger[i] = list[i];
		}
		list = larger;
	}
	
	public void find(T target) {
		boolean moreToSearch;
		location = 0;
		found = false;
		moreToSearch = (location < numberOfElements);
		while (moreToSearch && !found) {
			if (list[location].equals(target)) {
				found = true;
			} else {
				location++;
				moreToSearch = (location < numberOfElements);
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
	public void add(T element) {
		if (numberOfElements == list.length){
			enLarge();
		}
		list[numberOfElements] = element;
		numberOfElements++;
	}
	
	@Override
	public boolean remove(T element) {
		find(element);
		if (found) {
			list[location] = list[numberOfElements - 1];
			list[numberOfElements - 1] = null;
			numberOfElements--;
		}
		return found;
	}

	@Override
	public T get(T element) {
		find(element);
		if (found)
			return list[location];
		else
			return null;
	}

	@Override
	public void reset() {
		currentPosition = 0;
	}

	@Override
	public T getNext() {
		T next = list[currentPosition];
	    if (currentPosition == (numberOfElements - 1))
	      currentPosition = 0;
	    else
	      currentPosition++;
	    return next;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("UnSortedList::::");
		for (int i = 0; i < numberOfElements; i++) {
				sb.append("[" + list[i] + "]");
		}
		sb.append("\r\n");
		return sb.toString();
	}
}
