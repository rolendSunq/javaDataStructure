package lists.array_list;

import lists.UnsrotedListInterface;

public class ArrayUnsortedUnboundedList<T> implements UnsrotedListInterface<T> {
	private final int DEFAULT_CAPACITY = 100;	// �⺻ �뷮
	private int originalCapacity;				// ���� �뷮
	private T[] list;							// �迭 ������ ����Ʈ
	private int numberOfElements = 0;			// ���(element)�� ��
	private int currentPosition;				// ���� ��ġ(�迭�� �ε���) [iteration�� ���� ���� ��ġ]
	// find method ����
	private boolean found;						// ���(element)�� ã���� true, �ƴϸ� false ��
	private int location;						// �˻��� ���(element)�� ã�������� ���(element)�� �ε��� �� 
	
	@SuppressWarnings("unchecked")
	public ArrayUnsortedUnboundedList() {
		list = (T[]) new Object[DEFAULT_CAPACITY];
		originalCapacity = DEFAULT_CAPACITY;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayUnsortedUnboundedList(int maxCapacity) {
		list = (T[]) new Object[maxCapacity];
		originalCapacity = maxCapacity;
	}
	
	@SuppressWarnings("unchecked")
	public void enlarge() {
		T[] larger = (T[]) new Object[list.length + originalCapacity];
		System.arraycopy(list, 0, larger, 0, numberOfElements - 1);
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

	private void find(T target) {
		location = 0;
		found = false;
		
		while(location < numberOfElements && !found) {
			if (list[location].equals(target)) {
				found = true;
			} else {
				location++;
			}
		}
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
		T next = list[currentPosition];
		
		if (currentPosition == (numberOfElements - 1)) {
			currentPosition = 0;
		} else {
			currentPosition++;
		}
		
		return next;
	}

	@Override
	public void add(T element) {
		if (numberOfElements == list.length) {
			enlarge();
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
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		for (T data : list) {
			if (data != null) {
				sb.append(String.valueOf(data) + " ");
			}
		}
		return sb.toString();
	}
}
