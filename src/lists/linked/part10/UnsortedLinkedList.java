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
 * linked List는 잘못 설계할 경우 저장된 데이터를 모두 잃을 수 있다. 참조를 통한 구현은 실수를 특히 줄여야 한다.
 * 무 정렬 리스트(Unsorted Linked List)는 데이터가 들어오면 리스트의 가장 끝에 연결되거나 
 * 맨 앞에 들어와 연결되는 구조가 될 것이다.
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
	 * target 값으로 list의 노드를 하나씩 검사하여 찾는다.
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
	 * element: LinkedListNode의 data(value)
	 * newNode로 element를 갖는 노드를 만든 후  기존의 리스트와 link를 연결한다.
	 * newNode의 주소값을 list에 넣는다.
	 * 노드의 총 개수 1을 증가한다.
	 * 
	 * @param element
	 */
	public void add(T element) {
		LinkedListNode<T> newNode = new LinkedListNode<T>(element);
		newNode.setLink(list);
		list = newNode;
		numberOfElements++;
	}
	
	/**
	 * 리스트의 총 개수를 반환한다.
	 */
	@Override
	public int size() {
		return numberOfElements;
	}

	/**
	 * element의 값이 있는 노드를 찾으면 true 없으면 false를 반환한다.
	 * 
	 * @param element
	 * 
	 * @return {@link Boolean}
	 */
	@Override
	public boolean contains(T element) {
		find(element);
		return found;
	}

	/**
	 * @param element
	 * 찾고자 하는 노드의 값 
	 * @return T type element
	 * 찾고자 하는 노드의 값이 있으면 그 값을 반환하고 없으면 null을 반환한다.
	 */
	@Override
	public T get(T element) {
		find(element);
		
		if (found) {
			return location.getInfo();
		} else {
			return null;
		}
	}

	/**
	 * @param element
	 * 찾고자 하는 노드의 값
	 * @return {@link Boolean}
	 * element의 값이 있다면 삭제하고 true 없다면 삭제 없이 false 반환
	 */
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

	/**
	 * Linked List를 초기화 한다.
	 */
	@Override
	public void reset() {
		currentPosition = list;
	}

	/**
	 * @return T type
	 */
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
