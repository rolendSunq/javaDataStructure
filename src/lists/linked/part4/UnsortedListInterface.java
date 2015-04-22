package lists.linked.part4;
/**
 * ListInterface�� element�� �߰��ϴ� add method�� ����.
 * �� ������ ����϶�.
 * 
 * @author rolendSunq
 *
 */
public interface UnsortedListInterface<T> extends ListInterface<T> {
	/**
	 * ����Ʈ�� element�� �߰��Ѵ�.
	 * @param element
	 */
	public void add(T element);
}
