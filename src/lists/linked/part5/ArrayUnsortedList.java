package lists.linked.part5;

import javax.lang.model.element.TypeElement;

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
	
	/**
	 * moreToSearch : while 문에서 found 변수와 함께 target 요소를 찾을때 까지
	 * while문을 동작하게 한다.
	 * location 값과 numberOfElements 값과 대소 비교를 한 결과 값을 가진다.
	 * true/false 값을 가진다.
	 * 
	 * location: Array의 인덱스역활을 하며 list의 인덱스값을 한다.
	 * 
	 * found: list에서 target 요소를 찾으면 true 값을 가진다.
	 * 
	 * list[location].equals(target): find의 핵심 구문이며 if 문에서 target
	 * 요소를 찾으면 true/false 값을 갖게 한다.
	 * @param target
	 */
	protected void find(T target) {
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

	/**
	 * element 값이 list에 존재하면 true,
	 * 존재하지 않으면 false 값을 반환한다.
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

	public void add(T element) {
		if (numberOfElements == list.length){
			enLarge();
		}
		list[numberOfElements] = element;
		numberOfElements++;
	}
	
	/**
	 * 내부에서 find 메소드를 사용하며 
	 * if 문에 found 값으로 true 일 때 현재 요소에 마지막 요소의 값을 넣고
	 * 마지막 요소는 null 값을 넣는다.
	 * numberOfElement의 값은 1 감소 시킨다.
	 * 그리고 found 값을 리턴한다.
	 * 
	 * @param element
	 * @return true/false
	 */
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

	/**
	 * element가 list에 존재하면 element를 반환하고
	 * 존재하지 않으면 null값을 반환한다.
	 * 
	 * 내부에서 find메소드를 사용하며
	 * if 문에서 found 값을 통하여 list[location] 값을 반환하거나
	 * null 값을 반환한다.
	 * 
	 * @param element
	 * @return T
	 */
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

	/**
	 * T next = list[currentPosition] 의 값을 넣고
	 * if 문에서 currentPosition 과 numberOfElements -1 값과 같으면 
	 * currentPosition = 0 이고 아니면
	 * currentPosition 1 증가한다.
	 * next 값을 반환한다.
	 * 
	 * @return {@link TypeElement}
	 */
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
		for (int i = 0; i < numberOfElements; i++) {
				sb.append("[" + list[i] + "]");
		}
		sb.append("\r\n");
		return sb.toString();
	}
}
