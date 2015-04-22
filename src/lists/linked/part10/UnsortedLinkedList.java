package lists.linked.part10;

import linked_list_node.LinkedListNode;
import lists.ListInterface;
/**
 * ������ ����Ͽ� ��� �������̽� (LinkedList)�� �����Ѵ�.
 * null ��Ҵ� LinkedList�� ������ �ʴ´�.
 * �����ڴ� �󸮽�Ʈ�� �����Ͽ� �����Ѵ�.
 * Unsorted Linked List�� Ư¡: 
 * ArrayList�� ���� ��� ������ ���� ó�� ������ ������ �ʿ䰡 ����.
 * ���ĵ� Linked List���� ���� ������ �� �ִ�.
 * linked List�� �߸� ������ ��� ����� �����͸� ��� ���� �� �ִ�. ������ ���� ������ �Ǽ��� Ư�� �ٿ��� �Ѵ�.
 * �� ���� ����Ʈ(Unsorted Linked List)�� �����Ͱ� ������ ����Ʈ�� ���� ���� ����ǰų� 
 * �� �տ� ���� ����Ǵ� ������ �� ���̴�.
 */
 public class UnsortedLinkedList<T> implements ListInterface<T> {
	private int numberOfElements; // list���� element�� ����
	private LinkedListNode<T> currentPosition; // �ݺ��� ���� ���� ��ġ

	// find method�� ���� ������
	private boolean found; // element ��Ҹ� ã�� ��� true �ƴ� ��� false
	private LinkedListNode<T> location; // ��Ҹ� ã�� ��� ��Ҹ� �����ϴ� ���
	private LinkedListNode<T> previous; // ����� �� ��ġ(���� ��ġ)

	private LinkedListNode<T> list; // list�� ù ��° ���

	public UnsortedLinkedList() {
		numberOfElements = 0;
		currentPosition = null;
		list = null;
	}
	
	/**
	 * target ������ list�� ��带 �ϳ��� �˻��Ͽ� ã�´�.
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
	 * element: LinkedListNode�� data(value)
	 * newNode�� element�� ���� ��带 ���� ��  ������ ����Ʈ�� link�� �����Ѵ�.
	 * newNode�� �ּҰ��� list�� �ִ´�.
	 * ����� �� ���� 1�� �����Ѵ�.
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
	 * ����Ʈ�� �� ������ ��ȯ�Ѵ�.
	 */
	@Override
	public int size() {
		return numberOfElements;
	}

	/**
	 * element�� ���� �ִ� ��带 ã���� true ������ false�� ��ȯ�Ѵ�.
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
	 * ã���� �ϴ� ����� �� 
	 * @return T type element
	 * ã���� �ϴ� ����� ���� ������ �� ���� ��ȯ�ϰ� ������ null�� ��ȯ�Ѵ�.
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
	 * ã���� �ϴ� ����� ��
	 * @return {@link Boolean}
	 * element�� ���� �ִٸ� �����ϰ� true ���ٸ� ���� ���� false ��ȯ
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
	 * Linked List�� �ʱ�ȭ �Ѵ�.
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
