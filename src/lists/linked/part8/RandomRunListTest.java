package lists.linked.part8;

import java.util.Random;

public class RandomRunListTest {
	SortedListAdvancedImpl<Integer> list;
	Random random;
	private int count;
	private int element;
	public RandomRunListTest() {
		list = new SortedListAdvancedImpl<Integer>();
		randomInit();
		scenarioList();
	}
	
	public RandomRunListTest(int listSize) {
		randomInit(listSize);
		scenarioList();
	}
	
	private void scenarioList() {
		randomAdd(12);
		randomRemove(12);
		randomAdd(5);
		randomRemove(3);
	}
	
	private void randomRemove(int removeOfNumber) {
		count = 0;
		element = 0;
		random = new Random();
		while (count < removeOfNumber) {
			element = random.nextInt(101);
			if (list.contains(element)) {
				list.remove(element);
				count++;
			}
		}
		System.out.println(list.toString());
	}
	
	private void randomAdd(int addOfNumber) {
		count = 0;
		element = 0;
		random = new Random();
		while (count < addOfNumber) {
			element = random.nextInt(101);
			if (!list.contains(element)) {
				list.add(element);
				count++;
			}
		}
		System.out.println(list.toString());
	}
	
	private void randomInit() {
		count = 0;
		element = 0;
		random = new Random();
		while (count < 30) {
			element = random.nextInt(101);
			if (!list.contains(element)) {
				list.add(element);
				count++;
			}
		}
		System.out.println(list.toString());
	}
	
	private void randomInit(int listSize) {
		count = 0;
		element = 0;
		random = new Random();
		while (count < listSize) {
			element = random.nextInt(101);
			if (!list.contains(element)) {
				list.add(element);
				count++;
			}
		}
		System.out.println(list.toString());
	}
}
