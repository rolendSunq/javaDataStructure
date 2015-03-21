package lists.linked.part7;

import javax.lang.model.element.TypeElement;

import lists.linked.part4.SortedInterface;

public class SortedListImpl<T> implements SortedInterface<T> {
	private final int DEFAULT_CAPACITY = 100;
	private int originalCapacity;
	private T[] list;
	private int numberOfElements = 0;
	private int currentPosition;

	// found �޼ҵ忡 ���� ����
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
	 * element ���� list�� �����ϸ� true, �������� ������ false ���� ��ȯ�Ѵ�.
	 * 
	 * ���������� find �޼ҵ带 ����Ͽ� found ���� �����Ѵ�.
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
	 * element�� list�� �����ϸ� element�� ��ȯ�ϰ� �������� ������ null���� ��ȯ�Ѵ�.
	 * 
	 * ���ο��� find�޼ҵ带 ����ϸ� if ������ found ���� ���Ͽ� list[location] ���� ��ȯ�ϰų� null ����
	 * ��ȯ�Ѵ�.
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
	 * ���ο��� find �޼ҵ带 ����ϸ� if ������ found ���� true�̸� for ������ �ʱ�ȭ ���� location�� ������
	 * ������ ��ҿ� �̸� ������ location�� 1�� ������Ų��. ���ǹ��� ��ġ �ϸ� list[location] =
	 * list{location++] ���� �ְ� (����ҵ��� 1ĭ �� <- ������ �̵��ϴ� ���� �ȴ�.) for ���� ������
	 * list[numberOfElements - 1] = null ���� �ִ´�. numberOfElement �� ���� 1 �����Ѵ�.
	 * found ���� �����Ѵ�.
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
	 * T next = list[currentPosition] �� ���� �ְ� if ������ currentPosition ��
	 * numberOfElements -1 ���� ������ currentPosition = 0 �̰� �ƴϸ� currentPosition 1
	 * �����Ѵ�. next ���� ��ȯ�Ѵ�.
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
	 *  ���� Ž�� �˰����� �����Ͽ� target ��Ҹ� list���� ã�´�.
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
