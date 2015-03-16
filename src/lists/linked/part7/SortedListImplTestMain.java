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
		System.out.println("RKPC가 있냐? " + ICAOList.contains("RKPC"));
		System.out.println("마르세유 공항 값: " + ICAOList.get("LFMM"));
		ICAOList.remove("RKJN");
		System.out.println("나리타 공항 제거 " + ICAOList.toString());
		System.out.println("ICAOList 크기: " + ICAOList.size());
	}

}
