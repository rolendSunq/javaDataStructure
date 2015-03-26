package lists.linked.part8;

import java.util.Random;

public class RunTestingClass {
	SortedListAdvancedImpl<Integer> advancedSortedList;
	
	public RunTestingClass() {
		// TODO list를 초기화 한다.
		// TODO 생성과 동시에 자동으로 숫자를 리스트에 초기화 한다.
		advancedSortedList = new SortedListAdvancedImpl<Integer>();
		addRandomNumberList();
		scenarioTest();
	}

	private void addRandomNumberList() {
		// TODO 인자가 없을 때 기본적으로 30개의 숫자를 list에 랜덤으로 추가한다.
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
		// TODO number의 개수 만큼 list 요소를 랜덤 삭제
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
		// TODO number의 개수 만큼 list 요소를 추가
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
