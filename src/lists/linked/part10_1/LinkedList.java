package lists.linked.part10_1;

import linked_list_node_II.ListNode;

/**
 * 다양한 예제로 학습하는 데이터 구조와 알고리즘 for Java: 문제 해결법부터 개선법까지
 * 의 예제를 가져와 수정함.
 * head node의 추가로 사용자 입장에서 완벽한 개념이 없다면 이 클래스를 이용하기가
 * 상당히 까다롭다.
 * 새로운 node를 추가하고 삭제를 용이하기 위해 head node를 도입하였다.
 * 멤버를 최소화 하여 간략하게 클래스를 구성하였지만 코드의 복잡도가 증가한 것이 특징이다.
 * head node를 통해 data를 추가함에는 세 가지 방법이 있다.
 * 1. head node를 가장 처음에 고정하여 data를 추가하는 방법: 새로운 node는 항상 맨 앞에 존재한다.
 * 2. head node를 가장 마지막에 고정하여 data를 추가하는 방법: 새로운 node는 가장 마지막에 존재한다.
 * 3. head node를 원하는 노드에 위치 시키고  data를 추가하는 방법: node의 개수를 통해 head node가
 *    위치시켜야 하는 index가 필요하며 index를 기준으로 이전 node와 이 후 node사이에 새로운 node를 결합
 *    하여야 한다.
 * @author rolend 
 * @since 2015-04-19 02:20
 * 
 */
public class LinkedList<T> {
	/**
	 * 리스트의 head node를 고정되게 함으로 head node를 통해 새로운 노드를 넣을 수 있다.
	 * 또한 head node의 위치를 변경함으로써 삭제를 할 수 있다.
	 */ 
	ListNode<T> head;
	private int length = 0;	// Linked List의 노드의 개수
	
	/**
	 * LinkedList의 기본 생성자
	 * head node는 빈 Linked List에서는 의미가 없으므로 초기화가 필요없다.
	 * head node가 참조할 node가 없기 때문이다.
	 */
	public LinkedList() {
		length = 0;
	}


	// head node가 참조하고 있는 node를 반환한다.
	public synchronized ListNode<T> getHead() {
		return head;
	}

	// 새로운 노드를 맨 앞에 추가한다.
	public synchronized void insertAtBegin(ListNode<T> node) {
		node.setNext(head);
		head = node;
		length++;
	}

	// 새로운 노드를 맨 뒤에 추가한다.
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

	// 지정된 위치에 새 노드를 추가한다.
	// 지정된 위치를 기준으로 새로운 노드를 위해 공간을 만들고 새로운 노드를 위치시킨다.
	public void insert(T data, int position) {
		// 위치를 고정한다.
		if (position < 0) {
			position = 0;
		}
		if (position > length) {
			position = length;
		}

		// list가 빈 경우 유일한 노드가 될 수 있게 한다.
		if (head == null) {
			head = new ListNode<T>(data);
		} else if (position == 0) { // list의 맨 앞에 추가 할 경우...
			ListNode<T> temp = new ListNode<T>(data);
			temp.next = head;	// 현재 head는 기존의 노드를 가르킨다. 따라서 새로운 노드는 기존의 노드와 연결된다.
			head = temp;		// 새로운 노드에 head 노드를 위치시킨다.
		} else { // 정확한 위치를 찾고 노드를 추가한다.
			ListNode<T> temp = head;
			for (int i = 1; i < position; i += 1) {
				temp = temp.getNext();
			}
			ListNode<T> newNode = new ListNode<T>(data);
			newNode.next = temp.next;
			temp.setNext(newNode);
		}
		length += 1; // 새로운 노드 추가로 노드의 개수는 증가한다.
	}

	/**
	 *  
	 * @return ListNode<T>
	 * 리스트의 헤드에 위치한 노드를 리턴하고 삭제한다.
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
	 * 리스트의 끝에 있는 노드를 반환한다.
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
	 * 리스트의 맨 끝에있는 노드를 반환하고 제거한다.
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
