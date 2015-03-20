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

	protected void recommandFind(Comparable<T> target, int fromLocation,	int toLocation) {
		if (fromLocation > toLocation) // Base case 1
			found = false;
		else {
			int compareResult;
			location = (fromLocation + toLocation) / 2;
			compareResult = target.compareTo(list[location]);

			if (compareResult == 0) // Base case 2
				found = true;
			else if (compareResult < 0) // target is less than element at
										// location
				recommandFind(target, fromLocation, location - 1);
			else
				// target is greater than element at location
				recommandFind(target, location + 1, toLocation);
		}
	}
	
	protected void enlarge() {
		@SuppressWarnings("unchecked")
		T[] larger = (T[]) new Object[list.length + originalCapacity];
		
		for(int i = 0; i < numberOfElements -1; i++) {
			larger[i] = list[i];
		}
		list = larger;
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
		find(element);
		
		if (found) {
			for (int i = location; i <= numberOfElements - 2; location++) {
				list[i] = list[i + 1];
			}
			list[numberOfElements - 1] = null;
			numberOfElements--;
		}
		return found;
	}

	@Override
	public T get(T element) {
		find(element);
		
		if (found) {
			return list[location];
		} else {
			return null;
		}
	}

	@Override
	public void reset() {
		currentPosition = 0;
	}

	@Override
	public T getNext() {
		T next = list[location];
		
		if (currentPosition == (numberOfElements - 1)) {
			currentPosition = 0;
		} else {
			currentPosition++;
		}
		return next;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(T element) {
		T listElement;
		int location = 0;

		if (numberOfElements == list.length)
			enlarge();

		while (location < numberOfElements) {
			listElement = (T) list[location];
			if (((Comparable<T>) listElement).compareTo(element) < 0) // list element < add element
				location++;
			else
				break; // list element >= add element
		}

		for (int index = numberOfElements; index > location; index--)
			list[index] = list[index - 1];

		list[location] = element;
		numberOfElements++;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("list==> ");
		for (int i = 0; i < numberOfElements; i++) {
			sb.append("[" + list[i] + "]");
		}
		return sb.toString();
	}
}
