package lists.linked.part10_1;

import static org.junit.Assert.*;
import linked_list_node_II.ListNode;

import org.junit.Test;

public class LinkedListTest {
	private LinkedList<Integer> linkedList = new LinkedList<Integer>();
	@Test
	public void testLinkedList() {
		assertSame("index의 값은 0이다", 0, linkedList.length());
	}

	/*@Test
	public void testGetHead() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testInsertAtBegin() {
		ListNode<Integer> listNode = new ListNode<Integer>();
		listNode.setData(12);
		assertEquals((Integer)12, linkedList.getHead().getData());
	}

	/*@Test
	public void testInsertAtEnd() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFromBegin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLast() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveFromEnd() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveMatched() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemove() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testLength() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPosition() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	public void testClearList() {
		fail("Not yet implemented");
	}*/

}
