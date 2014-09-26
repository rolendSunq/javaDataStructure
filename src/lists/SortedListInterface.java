package lists;

public interface SortedListInterface<T> extends ListInterface<T> {
	public void add(Comparable<T> element);	// 리스트에 요소(element)를 추가합니다. 그리고 리스트는 정렬된 상태가 됩니다.
}
