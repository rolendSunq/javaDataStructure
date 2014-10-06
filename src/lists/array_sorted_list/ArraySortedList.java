package lists.array_sorted_list;

import lists.SortedListInterface;
import lists.array_list.ArrayUnsortedUnboundedList;

public class ArraySortedList<T> extends ArrayUnsortedUnboundedList<T> implements SortedListInterface<T> {

	public ArraySortedList () {
		super();
	}
	
	public ArraySortedList (int originalCapacity) {
		super(originalCapacity);
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T get(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub

	}

	@Override
	public T getNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Comparable<T> element) {
		// TODO Auto-generated method stub

	}

}
