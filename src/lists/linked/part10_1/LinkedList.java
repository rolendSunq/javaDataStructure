package lists.linked.part10_1;

import linked_list_node_II.ListNode;

/**
 * �پ��� ������ �н��ϴ� ������ ������ �˰��� for Java: ���� �ذ������ ����������
 * �� ������ ������ ������.
 * head node�� �߰��� ����� ���忡�� �Ϻ��� ������ ���ٸ� �� Ŭ������ �̿��ϱⰡ
 * ����� ��ٷӴ�.
 * ���ο� node�� �߰��ϰ� ������ �����ϱ� ���� head node�� �����Ͽ���.
 * ����� �ּ�ȭ �Ͽ� �����ϰ� Ŭ������ �����Ͽ����� �ڵ��� ���⵵�� ������ ���� Ư¡�̴�.
 * head node�� ���� data�� �߰��Կ��� �� ���� ����� �ִ�.
 * 1. head node�� ���� ó���� �����Ͽ� data�� �߰��ϴ� ���: ���ο� node�� �׻� �� �տ� �����Ѵ�.
 * 2. head node�� ���� �������� �����Ͽ� data�� �߰��ϴ� ���: ���ο� node�� ���� �������� �����Ѵ�.
 * 3. head node�� ���ϴ� ��忡 ��ġ ��Ű��  data�� �߰��ϴ� ���: node�� ������ ���� head node��
 *    ��ġ���Ѿ� �ϴ� index�� �ʿ��ϸ� index�� �������� ���� node�� �� �� node���̿� ���ο� node�� ����
 *    �Ͽ��� �Ѵ�.
 * @author rolend 
 * @since 2015-04-19 02:20
 * 
 */
public class LinkedList<T> {
	/**
	 * ����Ʈ�� head node�� �����ǰ� ������ head node�� ���� ���ο� ��带 ���� �� �ִ�.
	 * ���� head node�� ��ġ�� ���������ν� ������ �� �� �ִ�.
	 */ 
	ListNode<T> head;
	private int length = 0;	// Linked List�� ����� ����
	
	/**
	 * LinkedList�� �⺻ ������
	 * head node�� �� Linked List������ �ǹ̰� �����Ƿ� �ʱ�ȭ�� �ʿ����.
	 * head node�� ������ node�� ���� �����̴�.
	 */
	public LinkedList() {
		length = 0;
	}


	// head node�� �����ϰ� �ִ� node�� ��ȯ�Ѵ�.
	public synchronized ListNode<T> getHead() {
		return head;
	}

	// ���ο� ��带 �� �տ� �߰��Ѵ�.
	public synchronized void insertAtBegin(ListNode<T> node) {
		node.setNext(head);
		head = node;
		length++;
	}

	// ���ο� ��带 �� �ڿ� �߰��Ѵ�.
	public synchronized void insertAtEnd(ListNode<T> node) {
		if (head == null) {
			head = node;
		} else {
			ListNode<T> p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(node);
		}
		length++;
	}

	// ������ ��ġ�� �� ��带 �߰��Ѵ�.
	// ������ ��ġ�� �������� ���ο� ��带 ���� ������ ����� ���ο� ��带 ��ġ��Ų��.
	public void insert(T data, int position) {
		// ��ġ�� �����Ѵ�.
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}

		// list�� �� ��� ������ ��尡 �� �� �ְ� �Ѵ�.
		if (head == null) {
			head = new ListNode<T>(data);
		} else if (position == 0) { // list�� �� �տ� �߰� �� ���...
			ListNode<T> temp = new ListNode<T>(data);
			temp.next = head;	// ���� head�� ������ ��带 ����Ų��. ���� ���ο� ���� ������ ���� ����ȴ�.
			head = temp;		// ���ο� ��忡 head ��带 ��ġ��Ų��.
		} else { // ��Ȯ�� ��ġ�� ã�� ��带 �߰��Ѵ�.
			ListNode<T> temp = head;
			for (int i = 1; i < position; i += 1) {
				temp = temp.getNext();
			}
			ListNode<T> newNode = new ListNode<T>(data);
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		length += 1; // ���ο� ��� �߰��� ����� ������ �����Ѵ�.
	}

	/**
	 *  
	 * @return ListNode<T>
	 * ����Ʈ�� ��忡 ��ġ�� ��带 �����ϰ� �����Ѵ�.
	 */
	public synchronized ListNode<T> removeFromBegin() {
		ListNode<T> node = head;
		if (node != null) {
			head = node.getNext();
			node.setNext(null);
		}
		return node;
	}

	/**
	 * ����Ʈ�� ���� �ִ� ��带 ��ȯ�Ѵ�.
	 * 
	 * @return ListNode<T>
	 */
	public synchronized ListNode<T> getLast() {
		if (head == null)
			return null;
		if (head.getNext() == null) {
			return head;
		}
		ListNode<T> p = head.getNext();
		while (p.getNext() != null) {
			p = p.getNext();
		}
		return p;
	}

	// Remove and return the node at the end of the list
	/**
	 * ����Ʈ�� �� �����ִ� ��带 ��ȯ�ϰ� �����Ѵ�.
	 * @return ListNode<T>
	 */
	public synchronized ListNode<T> removeFromEnd() {
		if (head == null)
			return null;
		ListNode<T> p = head, q = null, next = head.getNext();
		if (next == null) {
			head = null;
			return p;
		}
		while ((next = p.getNext()) != null) {
			q = p;
			p = next;
		}
		q.setNext(null);
		return p;
	}

	// Remove a node matching the specified node from the list.
	// Use equals() instead of == to test for a matched node.
	/**
	 * 
	 * @param node
	 */
	public synchronized void removeMatched(ListNode<T> node) {
		if (head == null)
			return;
		if (node.equals(head)) {
			head = head.getNext();
			return;
		}
		ListNode<T> p = head, q = null;
		while ((q = p.getNext()) != null) {
			if (node.equals(q)) {
				p.setNext(q.getNext());
				return;
			}
			p = q;
		}
	}

	// Remove the value at a given position.
	// If the position is less than 0, remove the value at position 0.
	// If the position is greater than 0, remove the value at the last position.
	public void remove(int position) {
		// fix position
		if (position < 0) {
			position = 0;
		}

		if (position >= length) {
			position = length - 1;
		}

		// if nothing in the list, do nothing
		if (head == null)
			return;

		// if removing the head element...
		if (position == 0) {
			head = head.getNext();
		}
		// else advance to the correct position and remove
		else {
			ListNode<T> temp = head;
			for (int i = 1; i < position; i += 1) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		// reduce the length of the list
		length -= 1;
	}

	// Return a string representation of this collection, in the form
	// ["str1","str2",...].
	public String toString() {
		String result = "[";
		if (head == null) {
			return result + "]";
		}
		result = result + head.getData();
		ListNode<T> temp = head.getNext();
		while (temp != null) {
			result = result + "," + temp.getData();
			temp = temp.getNext();
		}
		return result + "]";
	}

	// Return the current length of the list.
	public int length() {
		return length;
	}

	// Find the position of the first value that is equal to a given value.
	// The equals method us used to determine equality.
	public int getPosition(T data) {
		// go looking for the data
		ListNode<T> temp = head;
		int pos = 0;
		while (temp != null) {
			if (temp.getData() == data) {
				// return the position if found
				return pos;
			}
			pos += 1;
			temp = temp.getNext();
		}
		// else return -1
		return Integer.MIN_VALUE;
	}

	// Size of the list.
	public boolean isEmpty() {
		return length == 0;
	}

	// Remove everything from the list.
	public void clearList() {
		head = null;
		length = 0;
	}
}
