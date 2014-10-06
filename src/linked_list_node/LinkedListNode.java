package linked_list_node;

public class LinkedListNode<T> {
	private LinkedListNode<T> link;
	private T info;
	
	public LinkedListNode() {
		// empty
	}
	
	public LinkedListNode(T info) {
		this.info = info;
		link = null;
	}

	public LinkedListNode<T> getLink() {
		return link;
	}

	public void setLink(LinkedListNode<T> link) {
		this.link = link;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
}
