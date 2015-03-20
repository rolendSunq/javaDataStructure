package lists.linked.part7;

import javax.lang.model.element.TypeElement;

import lists.linked.part4.SortedInterface;

public class SortedListImpl<T> implements SortedInterface<T> {
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

	/**
	 * element 값이 list에 존재하면 true, 존재하지 않으면 false 값을 반환한다.
	 * 
	 * 내부적으로 find 메소드를 사용하여 found 값을 설정한다.
	 * 
	 * @param element
	 * @return true/false
	 */
	@Override
	public boolean contains(T element) {
		find(element);
		return found;
	}

	/**
	 * element가 list에 존재하면 element를 반환하고 존재하지 않으면 null값을 반환한다.
	 * 
	 * 내부에서 find메소드를 사용하며 if 문에서 found 값을 통하여 list[location] 값을 반환하거나 null 값을
	 * 반환한다.
	 * 
	 * @param element
	 * @return T
	 */
	@Override
	public T get(T element) {
		find(element);
		if (found) {
			return list[location];
		} else {
			return null;
		}
	}

	/**
	 * 내부에서 find 메소드를 사용하며 if 문에서 found 값이 true이면 for 문에서 초기화 값은 location을 가지며
	 * 마지막 요소에 이를 때까지 location을 1씩 증가시킨다. 조건문이 일치 하면 list[location] =
	 * list{location++] 값을 넣고 (각요소들이 1칸 씩 <- 앞으로 이동하는 꼴이 된다.) for 문이 끝나면
	 * list[numberOfElements - 1] = null 값을 넣는다. numberOfElement 의 값은 1 감소한다.
	 * found 값을 리턴한다.
	 * 
	 * @param element
	 * @return {@link Boolean}
	 */
	@Override
	public boolean remove(T element) {
		find(element);
		if (found) {
			for (int i = location; i <= numberOfElements - 2; i++) {
				list[i] = list[i + 1];
			}
			list[numberOfElements - 1] = null;
			numberOfElements--;
		}
		return found;
	}

	@Override
	public void reset() {
		currentPosition = 0;
	}

	/**
	 * T next = list[currentPosition] 의 값을 넣고 if 문에서 currentPosition 과
	 * numberOfElements -1 값과 같으면 currentPosition = 0 이고 아니면 currentPosition 1
	 * 증가한다. next 값을 반환한다.
	 * 
	 * @return {@link TypeElement}
	 */
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

	/**
	 *  이진 탐색 알고리즘을 도입하여 target 요소를 list에서 찾는다.
	 *  
	 * @param target
	 */
	@SuppressWarnings("unchecked")
	protected void find(T target) {
		int first = 0;
		int last = numberOfElements - 1;
		int compareResult;
		Comparable<T> targetElement = (Comparable<T>) target;
		found = false;

		while (first <= last) {
			location = (first + last) / 2;
			compareResult = targetElement.compareTo(list[location]);
			if (compareResult == 0) {
				found = true;
				break;
			} else if (compareResult < 0)
				// target element is less than element at location
				last = location - 1;
			else
				// target element is greater than element at location
				first = location + 1;
		}
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

	@SuppressWarnings("unchecked")
	protected void enlarge() {
		T[] larger = (T[]) new Object[originalCapacity + list.length];
		for (int i = 0; i < numberOfElements - 1; i++) {
			larger[i] = list[i];
		}
		list = larger;
	}
}
