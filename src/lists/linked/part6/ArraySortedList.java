package lists.linked.part6;

import lists.ListInterface;
import lists.linked.part5.ArrayUnsortedList;

public class ArraySortedList<T> extends ArrayUnsortedList<T> implements ListInterface<T> {
	public ArraySortedList() {
		super();
	}

	public ArraySortedList(int originalCapacity) {
		super(originalCapacity);
	}

	/**
	 * ���� ����: ��Ҹ� ���Ѵ�.
	 * 
	 * ��Ҹ� �߰��Ѵ�.
	 * 
	 * @param element
	 * 
	 * list�� ��Ҹ� ���ϱ� ���� list element type�� ������ �����Ѵ�. ���� ��� ���� list��
	 * ������ �ʱ�ȭ�ϴ� ������ ����� �ʱ�ȭ�Ѵ�. �����ǿ��� ����� element�� ���� �� ���ִ� ����
	 * location�� �����ϰ� �ʱ�ȭ �Ѵ�. list�� ����� ���� ������ �뷮�� ���� ���� ��� enLarge()
	 * �޼ҵ带 ȣ���Ѵ�. while�� location ���� numberOfElements �� ���� �ٸ� ������
	 * loop���� ������. list�� ó�� ��� ���� compareTo �޼ҵ�� �߰��ϴ� element��ҿ�
	 * ��Һ񱳸� �����Ѵ�. ���� ��Ұ� �� ��� ���� ���� ��� location ���� �����Ѵ�. �ƴ� ��� ����
	 * ���� Ż���Ѵ�. for���� ��Ұ����� �ʱ�ȭ �ϰ� location�� index���� Ŭ������ index��
	 * �����ϸ鼭 list[index] = list[index-1] �� �ʱ�ȭ �Ѵ�. list[location] =
	 * element �� �ʱ�ȭ �Ѵ�. numberOfElement + 1 �߰��� ����Ʈ�� ����� ���� list ��ü��
	 * �ʱ�ȭ �Ѵ�.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(T element) {
		T[] listElement;
		T[] originalListElement = getList();
		int location = 0;

		if (getNumberOfElements() == getList().length) {
			enLarge();
		}

		while (location < getNumberOfElements()) {
			listElement = (T[]) getList()[location];
			if (((Comparable<T>) listElement[location]).compareTo(element) < 0) {
				location++;
			} else {
				break;
			}
		}

		for (int index = getNumberOfElements(); index > location; index--) {
			originalListElement[index] = getList()[index - 1];
		}

		setNumberOfElements(getNumberOfElements() + 1);
		setList(originalListElement);
	}

	/**
	 * e.equals(element)�� ����� ���� ��Ҹ� �����Ѵ�.
	 * 
	 * @param element
	 * 
	 *            ����� ������ �����ϸ� true, false�� element�� list�� ���ٴ� ����̴�.
	 * @return true, false
	 * 
	 * 
	 */
	@Override
	public boolean remove(T element) {
		T[] sourceList = getList();
		find(element);
		if (isFound()) {
			for (int i = getLocation(); i <= getNumberOfElements() - 2; i++)
				sourceList[i] = getList()[i + 1];
			sourceList[getNumberOfElements() - 1] = null;
			setNumberOfElements(getNumberOfElements() - 1);
			setList(sourceList);
		}
		return isFound();
	}

}
