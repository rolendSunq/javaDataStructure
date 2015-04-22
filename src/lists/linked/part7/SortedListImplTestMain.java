package lists.linked.part7;

public class SortedListImplTestMain {

	public static void main(String[] args) {
		SortedListImpl<String> ICAOList = new SortedListImpl<String>(10);
		ICAOList.add("RKSI");
		ICAOList.add("RKSS");
		ICAOList.add("RKPC");
		ICAOList.add("RKTN");
		ICAOList.add("LFMM");
		ICAOList.add("RKJI");
		ICAOList.add("RKJN");
		System.out.println(ICAOList.toString());
		System.out.println("RKPC�� �ֳ�? " + ICAOList.contains("RKPC"));
		System.out.println("�������� ���� ��: " + ICAOList.get("LFMM"));
		ICAOList.remove("RKJN");
		System.out.println("����Ÿ ���� ���� " + ICAOList.toString());
		System.out.println("ICAOList ũ��: " + ICAOList.size());
	}

}
