package lists.linked.part5;

public class ArrayUnsortedListTestMain {

	public static void main(String[] args) {
		ArrayUnsortedList<String> list = new ArrayUnsortedList<String>();
		list.add("축구");
		list.add("당구");
		list.add("야구");
		list.add("족구");
		list.add("농구");
		list.add("배구");
		list.add("태근아 이제 공부하자.");
		System.out.println(list.toString());
		list.remove("족구");
		System.out.println(list.toString());
		list.add("양궁");
		System.out.println(list.toString());
		System.out.println(list.get("야구"));
	}

}
