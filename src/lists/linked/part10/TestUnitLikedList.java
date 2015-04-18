package lists.linked.part10;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUnitLikedList {
	UnsortedLinkedList<String> list = new UnsortedLinkedList<String>();
	@Test
	public void test() {
		list.add("apple");
		list.add("banana");
		list.add("melon");
		assertEquals("banana", list.get("banana"));
	}
	
	@Test
	public void removeTest() {
		list.add("apple");
		list.add("banana");
		list.add("melon");
		list.remove("banana");
		assertEquals(false, list.contains("banana"));
	}
	
	@Test
	public void sizeMethodTest() {
		list.add("apple");
		list.add("banana");
		list.add("melon");
		assertEquals(3, list.size());
	}

}
