package lists.linked.part10;

import linked_list_node.LinkedListNode;
import lists.ListInterface;
/**
 * 참조를 사용하여 목록 인터페이스 (LinkedList)를 구현한다.
 * null 요소는 LinkedList에 허용되지 않는다.
 * 생성자는 빈리스트를 생성하여 제공한다.
 * Unsorted Linked List의 특징: 
 * ArrayList에 비해 요소 개수에 대한 처리 로직을 걱정할 필요가 없다.
 * 정렬된 Linked List보다 쉽게 구현할 수 있다.
 * 잘못 설계할 경우 저장된 데이터를 모두 잃을 수 있다. 참조를 통한 구현은 실수를 특히 줄여야 한다.
 */
 public class UnsortedLinkedList<T> implements ListInterface<T> {
	private int numberOfElements; // list에서 element의 개수
	private LinkedListNode<T> currentPosition; // 반복에 대한 현재 위치

	// find method에 의해 설정됨
	private boolean found; // element 요소를 찾을 경우 true 아닐 경우 false
	private LinkedListNode<T> location; // 요소를 찾은 경우 요소를 포함하는 노드
	private LinkedListNode<T> previous; // 노드의 앞 위치(이전 위치)

	private LinkedListNode<T> list; // list의 첫 번째 노드

	public UnsortedLinkedList() {
		numberOfElements = 0;
		currentPosition = null;
		list = null;
	}
	
	/**
	 * 
	 * @param target
	 */
	protected void find(T target) {
		location = list;
		found = false;
		
		while (location != null) {
			if (location.getInfo().equals(target)) {
				found = true;
				return;
			} else {
				previous = location;
				location = location.getLink();
			}
		}
	}
	
	/**
	 * 
	 * @param element
	 */
	public void add(T element) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(element);
		newNode.setLink(list);
		list = newNode;
		numberOfElements++;
	}
	
	@Override
	public int size() {
		return numberOfElements;
	}

	@Override
	public boolean contains(T element) {
		find(element);
		return found;
	}


	@Override
	public T get(T element) {
		find(element);
		
		if (found) {
			return location.getInfo();
		} else {
			return null;
		}
	}

	@Override
	public boolean remove(T element) {
		find(element);
		if (found) {
			if (list == location) {
				list = list.getLink();
			} else {
				previous.setLink(location.getLink());
			}
			numberOfElements--;
		}
		return found;
	}

	@Override
	public void reset() {
		currentPosition = list;
	}

	@Override
	public T getNext() {
		T next = currentPosition.getInfo();
		
		if (currentPosition.getLink() == null) {
			currentPosition = list;
		} else {
			currentPosition = currentPosition.getLink();
		}
		
		return next;
	}

}
