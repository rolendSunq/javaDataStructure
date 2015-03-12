package lists.linked.part6;

public class ArraySortedListTestMain {

	public static void main(String[] args) {
		ArraySortedList<Integer> numberSortedList = new ArraySortedList<Integer>();
		numberSortedList.add(15);
		numberSortedList.add(30);
		numberSortedList.add(20);
		numberSortedList.add(7);
		numberSortedList.add(22);
		numberSortedList.add(33);
		numberSortedList.add(5);
		System.out.println(numberSortedList.toString());
		numberSortedList.remove(22);
		System.out.println(numberSortedList.toString());
	}

}
