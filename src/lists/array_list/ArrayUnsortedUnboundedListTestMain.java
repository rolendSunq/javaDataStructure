package lists.array_list;

public class ArrayUnsortedUnboundedListTestMain {

	public static void main(String[] args) {
		ArrayUnsortedUnboundedList<Integer> list = new ArrayUnsortedUnboundedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		System.out.println("List: " + list.toString());
		System.out.println("Remove: 10");
		list.remove(10);
		System.out.println("List: " + list.toString());
		System.out.println("Remove: 40");
		list.remove(40);
		System.out.println("List: " + list.toString());
	}

}
