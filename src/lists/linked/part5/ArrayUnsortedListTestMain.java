package lists.linked.part5;

public class ArrayUnsortedListTestMain {

	public static void main(String[] args) {
		ArrayUnsortedList<String> list = new ArrayUnsortedList<String>();
		list.add("�౸");
		list.add("�籸");
		list.add("�߱�");
		list.add("����");
		list.add("��");
		list.add("�豸");
		list.add("�±پ� ���� ��������.");
		System.out.println(list.toString());
		list.remove("����");
		System.out.println(list.toString());
		list.add("���");
		System.out.println(list.toString());
		System.out.println(list.get("�߱�"));
	}

}
