package lists.linked.part8;

import java.util.Random;

public class RunTestingClass {
	SortedListAdvancedImpl<Integer> advancedSortedList;
	
	public RunTestingClass() {
		// TODO list�� �ʱ�ȭ �Ѵ�.
		// TODO ������ ���ÿ� �ڵ����� ���ڸ� ����Ʈ�� �ʱ�ȭ �Ѵ�.
		advancedSortedList = new SortedListAdvancedImpl<Integer>();
		addRandomNumberList();
		scenarioTest();
	}

	private void addRandomNumberList() {
		// TODO ���ڰ� ���� �� �⺻������ 30���� ���ڸ� list�� �������� �߰��Ѵ�.
		Random random = new Random();
		int addCount = 0;
		int randomNumber = 0;
		while (addCount < 30) {
			randomNumber = random.nextInt(101);
			if (!advancedSortedList.contains(randomNumber)) {
				advancedSortedList.add(randomNumber);
				addCount++;
			}
		}
		System.out.println(advancedSortedList.toString());
	}
	
	private void scenarioTest() {
		addList(12);
		removeListElement(12);
		addList(2);
		removeListElement(2);
	}

	private void removeListElement(int removeOfNumber) {
		// TODO number�� ���� ��ŭ list ��Ҹ� ���� ����
		Random random = new Random();
		int removeCount = 0;
		int randomNumber = 0;
		while (removeCount < removeOfNumber) {
			randomNumber = random.nextInt(101);
			if (advancedSortedList.contains(randomNumber)) {
				advancedSortedList.remove(randomNumber);
				removeCount++;
			}
		}
		System.out.println(advancedSortedList.toString());
	}

	private void addList(int addOfNumber) {
		// TODO number�� ���� ��ŭ list ��Ҹ� �߰�
		Random random = new Random();
		int addCount = 0;
		int randomNumber = 0;
		while (addCount < addOfNumber) {
			randomNumber = random.nextInt(101);
			if (!advancedSortedList.contains(randomNumber)) {
				advancedSortedList.add(randomNumber);
				addCount++;
			}
		}
		System.out.println(advancedSortedList.toString());
	}
}
