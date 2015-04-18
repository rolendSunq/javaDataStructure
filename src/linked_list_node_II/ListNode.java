package linked_list_node_II;

public class ListNode<T> {
	public ListNode<T> next;
	public T data;

	// 빈 노드를 만든다.
	public ListNode() {
		next = null;
		data = null;
	}

	// 지정된 data를 저장한 노드를 만든다.
	public ListNode(T data) {
		next = null;
		this.data = data;
	}

	// next는 다음에있는 노드를 반환한다.
	public ListNode<T> getNext() {
		return next;
	}

	// 새로 만든 노드 node는 현재 노드 next에 node의 주소값을 저장한다.
	public void setNext(ListNode<T> node) {
		next = node;
	}

	// 현재 저장된 노드의 data 값을 반환한다.
	public T getData() {
		return data;
	}

	// 현재 노드의 data 값에 element 값을 설정한다.
	public void setData(T element) {
		data = element;
	}

	// 현재 노드의 data 값을 class의 저장된 값으로 보여준다.
	public String toString() {
		String resultData = "[" + data + "]";
		return resultData;
	}
}
