package linked_list_node_II;

public class ListNode<T> {
	public ListNode<T> next;
	public T data;

	// �� ��带 �����.
	public ListNode() {
		next = null;
		data = null;
	}

	// ������ data�� ������ ��带 �����.
	public ListNode(T data) {
		next = null;
		this.data = data;
	}

	// next�� �������ִ� ��带 ��ȯ�Ѵ�.
	public ListNode<T> getNext() {
		return next;
	}

	// ���� ���� ��� node�� ���� ��� next�� node�� �ּҰ��� �����Ѵ�.
	public void setNext(ListNode<T> node) {
		next = node;
	}

	// ���� ����� ����� data ���� ��ȯ�Ѵ�.
	public T getData() {
		return data;
	}

	// ���� ����� data ���� element ���� �����Ѵ�.
	public void setData(T element) {
		data = element;
	}

	// ���� ����� data ���� class�� ����� ������ �����ش�.
	public String toString() {
		String resultData = "[" + data + "]";
		return resultData;
	}
}
